package com.exadel.service.impl;

import java.util.*;
import java.util.Map.Entry;

import com.exadel.model.entity.StudentLog;
import com.exadel.model.view.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.CuratorDao;
import com.exadel.dao.FeedbackableDao;
import com.exadel.dao.SkillTypeDao;
import com.exadel.dao.StudCuratorJoinDao;
import com.exadel.dao.StudentDao;
import com.exadel.dao.UserDao;
import com.exadel.model.constants.SpringSecurityRole;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.government.Feedbackable;
import com.exadel.model.entity.join.StudentCuratorJoin;
import com.exadel.model.entity.student.Skill;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.student.StudentExams;
import com.exadel.service.StudentService;
import com.exadel.util.LazyUtil;

@Service
public class StudentServiceImpl extends GenericLivingServiceImpl<Student>
		implements StudentService {
	@Autowired
	CuratorDao curatorDao;
	@Autowired
	UserDao userDao;
	@Autowired
	StudentDao studentDao;
	@Autowired
	FeedbackableDao feedbackableDao;

	@Autowired
	StudCuratorJoinDao studCuratorJoinDao;
	@Autowired
	SkillTypeDao skillTypeDao;

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
	public List<FeedbackView> getFeedbacksForStudentByStudId(long id) {
		Student stud = studentDao.find(id);
		List<Feedback> fblist = studentDao.findAllForStud(stud);
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
		Set<String> skillnames = skillTypeDao.getSkillNames();
		Iterator<Skill> it = view.getSkillSet().iterator();
		while (it.hasNext()) {
			Skill s = it.next();
			s.setId(null);
			try {
				String skillname = s.getType().getName();
				if (skillname == null
						|| !skillnames.contains(s.getType().getName())) {
					it.remove();
				} else {
					s.setType(skillTypeDao.find(skillname)); //get rid of id problem
					skillnames.remove(skillname); //allow no two skills with same name for student
				}
			} catch (NullPointerException x) {
				it.remove();
			}
		}
        st.getStudy().getExams().clear();
        studentDao.flush();
        st.getStudy().fromView(view.getStudy());
		st.fromView(view);
		studentDao.updateByMerge(st);
	}

	@Transactional
	public void save(Student entity) {
		studentDao.save(entity);
	}

	@Transactional
	public CompositeStudentFeedbackView generateStudentViewForUser(
			long stud_id, String role) {
		Student stud = studentDao.find(stud_id);
		LazyUtil.lazyTouchWithTechs(stud);
		CompositeStudentFeedbackView view = new CompositeStudentFeedbackView();
		if (role.equals(SpringSecurityRole.ADMIN)) {
			view.setFeedbacks(this.getFeedbacksForStudentByStudId(stud_id));
			view.setInfo(stud.toView());
		} else {
			switch (role) {
			case SpringSecurityRole.CURATOR:
			case SpringSecurityRole.FEEDBACKER:
				view.setFeedbacks(this.getFeedbacksForStudentByStudId(stud_id));
				break;
			case SpringSecurityRole.PERSONNEL_DEPARTMENT:
			case SpringSecurityRole.GOVERNMENT:
				view.setFeedbacks(this.getFeedbacksForStudentByStudId(stud_id));
				break;
			}
		}

		return view;
	}

	@Transactional
	public List<Student> getAll(List<Long> ids) {
		List<Student> list = new ArrayList<>();
		for(Long id:ids){
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
    public void attachStudentsToCurators(List<Long> students_id, List<Long> curators_id){
        for(long id: students_id){
            for(long curId:curators_id){
                if(!isStudentAttachedToThisCurator(id, curId)){
                    attachStudentToCurator(id, curId);
                }
            }
        }
    }
    @Transactional
    public List<String> getAllEmailAddressesOfStudents(List<Long> students_id){
        return studentDao.getEmails(students_id);
    }

    @Transactional
    public boolean isStudentAttachedToThisCurator(long id, long curId){
        Student student = studentDao.find(id);
        Curator curator = curatorDao.find(curId);
        Set<StudentCuratorJoin> list = student.getCurator();
        for(StudentCuratorJoin studentCuratorJoin: list){
            if(studentCuratorJoin.getStudent().getId() == curId){
                return true;
            }
        }
        return false;
    }
}
