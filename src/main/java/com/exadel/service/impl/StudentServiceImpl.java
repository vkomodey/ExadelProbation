package com.exadel.service.impl;

import java.util.*;

import com.exadel.dao.impl.StudCuratorJoinDaoImpl;
import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.entity.Project;
import com.exadel.model.entity.StudentLog;
import com.exadel.model.view.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.CuratorDao;
import com.exadel.dao.FeedbackableDao;
import com.exadel.dao.GenericDao;
import com.exadel.dao.GenericNamedDao;
import com.exadel.dao.ProjectDao;
import com.exadel.dao.TechDao;
import com.exadel.dao.StudCuratorJoinDao;
import com.exadel.dao.StudentDao;
import com.exadel.dao.UserDao;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.government.Feedbackable;
import com.exadel.model.entity.join.StudentCuratorJoin;
import com.exadel.model.entity.student.Faculty;
import com.exadel.model.entity.student.Skill;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.student.University;
import com.exadel.service.StudentService;
import com.exadel.util.LazyUtil;

@Service
public class StudentServiceImpl extends GenericLivingServiceImpl<Student>
		implements StudentService {
	Logger logger=LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	CuratorDao curatorDao;
	@Autowired
	UserDao userDao;
	@Autowired
	StudentDao studentDao;
	@Autowired
	FeedbackableDao feedbackableDao;
	@Autowired
	ProjectDao projectDao;
	@Autowired
	StudCuratorJoinDao studCuratorJoinDao;
	@Autowired
	TechDao techDao;
	@Autowired
	GenericNamedDao<Faculty> facultyDao;
	@Autowired
	GenericNamedDao<University> universityDao;
	@Autowired
	GenericDao<Feedback> feedbackDao;

	@Transactional
	public Student findById(long id) {
		Student student = studentDao.find(id);
		// laaaazy
		LazyUtil.lazyTouchWithTechs(student);
		return student;
	}

	@Transactional
	public Student findByLogin(String login) {
		Student student = studentDao.find(login);
		// laaaazy
		LazyUtil.lazyTouchWithTechs(student);
		return student;
	}

	@Transactional
	public List<FeedbackView> getFeedbacksForStudent(long id) {
		Student stud = studentDao.find(id);
		List<Feedback> fblist = studentDao.findAllFeedback(stud);
		ArrayList<FeedbackView> result = new ArrayList<FeedbackView>();
		for (Feedback fb : fblist) {
			result.add(fb.toView());
		}
		return result;
	}

	@Transactional
	public List<StudentStateView> getStudentStateList(long id) {
		Student stud = studentDao.find(id);
		List<StudentLog> logList = studentDao.findLogsForStud(stud);
		ArrayList<StudentStateView> result = new ArrayList<StudentStateView>();
		for (StudentLog log : logList) {
			result.add(log.toView());
		}
		return result;
	}

	@Transactional
	@Secured({ "ROLE_FEEDBACKER", "ROLE_CURATOR" })
	public void saveNewFeedbackForStudentByStudId(FeedbackView feedback,
			long id, String author) {
		Student stud = studentDao.find(id);
		Feedbackable feedbackOwner = feedbackableDao.find(author);
		Feedback fb = new Feedback(feedback, feedbackOwner, stud);
		studentDao.saveEntity(fb);
	}

	@Transactional
	public List<StudentView> getAll() {
		List<Student> list = studentDao.getAll();
		List<StudentView> vlist = new ArrayList<StudentView>();
		for (Student s : list) {
			LazyUtil.lazyTouch(s);
			vlist.add(s.toView());
		}
		return vlist;
	}

	@Transactional
	public void modify(StudentView view, long id) {
		Student st = studentDao.find(id);
		Set<String> names = techDao.getNames();
		Iterator<Skill> it = view.getSkillSet().iterator();
		while (it.hasNext()) {
			Skill s = it.next();
			s.setId(null);
			try {
				String techname = s.getType().getName();
				if (techname == null || !names.contains(s.getType().getName())) {
					it.remove();
				} else {
					s.setType(techDao.find(techname)); // get rid of id problem
					names.remove(techname); // allow no two skills with same
											// name for student
				}
			} catch (NullPointerException x) {
				it.remove();
			}
		}
		st.getStudy().getExams().clear();
		Set<Project> projectSet = st.getWork().getCurrentProjects();
		studentDao.flush();
		for (Project proj : view.getCurrentProjects()) {
			Project actual_proj = projectDao.find(proj.getId());
			actual_proj.getStudents().add(st);
			projectSet.remove(actual_proj);
		}
		for (Project discarded : projectSet) {
			discarded.getStudents().remove(st);
		}
		st.getStudy().fromView(view.getStudy());
		st.fromView(view);
		st.getStudy().setFaculty(facultyDao.find(view.getStudy().getFaculty()));
		st.getStudy().setUniversity(
				universityDao.find(view.getStudy().getUniversity()));
		updateStudentCurators(view, st);
		studentDao.updateByMerge(st);
	}

	@Transactional
	public void updateStudentCurators(StudentView view, Student student) {
		List<IdNameSurnamePersonView> newCurators = view.getCurator();
		Set<StudentCuratorJoin> oldCurators = student.getCurator();
		for (IdNameSurnamePersonView personView : newCurators) {
			if (!isStudentAttachedToThisCurator(student.getId(),
					personView.getId())) {
				attachStudentToCurator(student.getId(), personView.getId());
			}
		}
		// work around
		boolean flag = false;
		for (StudentCuratorJoin old : oldCurators) {
			for (IdNameSurnamePersonView new_ : newCurators) {
				if (old.getCurator().getId() == new_.getId()) {
					flag = true;
					continue;
				}
			}
			if (!flag) {
				detachStudentFromCurator(student.getId(), old.getCurator()
						.getId());
			} else
				flag = false;
		}
	}

	@Transactional
	public void save(Student entity) {
		studentDao.save(entity);
	}

	/*
	 * @Transactional public CompositeStudentFeedbackView
	 * generateStudentViewForUser( long stud_id, String role) { Student stud =
	 * studentDao.find(stud_id); LazyUtil.lazyTouchWithTechs(stud);
	 * CompositeStudentFeedbackView view = new CompositeStudentFeedbackView();
	 * if (role.equals(SpringSecurityRole.ADMIN)) {
	 * view.setFeedbacks(this.getFeedbacksForStudentByStudId(stud_id));
	 * view.setInfo(stud.toView()); } else { switch (role) { case
	 * SpringSecurityRole.CURATOR: case SpringSecurityRole.FEEDBACKER:
	 * view.setFeedbacks(this.getFeedbacksForStudentByStudId(stud_id)); break;
	 * case SpringSecurityRole.PERSONNEL_DEPARTMENT: case
	 * SpringSecurityRole.GOVERNMENT:
	 * view.setFeedbacks(this.getFeedbacksForStudentByStudId(stud_id)); break; }
	 * }
	 * 
	 * return view; }
	 */

	@Transactional
	public List<Student> getAll(List<Long> ids) {
		List<Student> list = new ArrayList<>();
		for (Long id : ids) {
			list.add(this.findById(id));
		}
		return list;
	}

	@Transactional
	public void attachStudentToCurator(long id, long curator_id) {
		Student student = studentDao.find(id);
		Curator curator = curatorDao.find(curator_id);
		StudentCuratorJoin scj = new StudentCuratorJoin();
		scj.setStudent(student);
		scj.setCurator(curator);
		scj.setAssignmentDate(Calendar.getInstance());

		studCuratorJoinDao.save(scj);
	}

	@Transactional
	public void attachStudentsToCurators(List<Long> students_id,
			List<Long> curators_id) {
		for (long id : students_id) {
			for (long curId : curators_id) {
				if (!isStudentAttachedToThisCurator(id, curId)) {
					attachStudentToCurator(id, curId);
				}
			}
		}
	}

	@Transactional
	public void detachStudentFromCurator(long id, long curator_id) {
		Student student = studentDao.find(id);
		Curator curator = curatorDao.find(curator_id);
		for (StudentCuratorJoin join : student.getCurator()) {
			Curator temp = join.getCurator();
			if (temp.getId() == curator_id) {
				// student.getCurator().remove(join);
				((StudCuratorJoinDaoImpl) studCuratorJoinDao).delete(join);
				System.out.println(student.getCurator());
				break;
			}
		}
	}

	@Transactional
	public List<String> getAllEmailAddressesOfStudents(List<Long> students_id) {
		return studentDao.getEmails(students_id);
	}

	@Transactional
	public boolean isStudentAttachedToThisCurator(long id, long curId) {
		Student student = studentDao.find(id);
		student.getCurator();
		Set<StudentCuratorJoin> list = student.getCurator();
		for (StudentCuratorJoin studentCuratorJoin : list) {
			if (studentCuratorJoin.getCurator().getId() == curId) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	public List<FeedbackView> getFeedbacksForStudentByCurator(long studId,
			String curatorName) {
		List<Feedback> fblist = feedbackableDao.findForStudBy(curatorName,
				studId);
		ArrayList<FeedbackView> result = new ArrayList<FeedbackView>();
		for (Feedback fb : fblist) {
			result.add(fb.toView());
		}
		return result;
	}

	@Override
	@Transactional
	public void modifyFeedbackByFbId(FeedbackView feedback, long feedbackId,
			String name) throws Exception {
		Feedback orig_fb=feedbackDao.find(feedback.getId());
		Feedbackable orig_author=orig_fb.getAuthor();
		Feedbackable new_author=feedbackableDao.find(name);
		if(new_author.getRole().equals(SpringSecurityRole.ADMIN)||new_author==orig_author){
			logger.info("new author:"+new_author.getName()+"/"+new_author.getRole());
			orig_fb.setAuthor(new_author);
			orig_fb.fromView(feedback);
		}else{
			throw new Exception("not authorized to perform feedback modify");
		}
	}
}
