package com.exadel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.FeedbackDao;
import com.exadel.dao.FeedbackableDao;
import com.exadel.dao.StudentDao;
import com.exadel.dao.UserDao;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.government.Feedbackable;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.view.FeedbackView;
import com.exadel.model.entity.view.StudentView;
import com.exadel.service.StudentService;
@Service
public class StudentServiceImpl extends GenericLivingServiceImpl<Student> implements StudentService{
	@Autowired
	UserDao userDao;
	@Autowired
	FeedbackDao feedbackDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    FeedbackableDao feedbackableDao;
	//wake up all students, they so laaaazy. denis - glazier//
	private void lazyTouch(Student student){
		student.getStudy().getExams().size();
		student.getSkillSet().size();
	}
	
	@Transactional
	public Student findById(long id){
		Student student=studentDao.find(id);
		//laaaazy
		lazyTouch(student);
		return student;
	}
	
	@Transactional
	public Student findByLogin(String login){
		Student student=studentDao.find(login);
		//laaaazy
		lazyTouch(student);
		return student;
	}
	@Transactional
	public List<FeedbackView> getFeedbacksForStudentByStudId(long id) {
		Student stud=studentDao.find(id);
		List<Feedback> fblist=feedbackDao.findAllForStud(stud);
		ArrayList<FeedbackView> result=new ArrayList<FeedbackView>();
		for(Feedback fb:fblist){
			result.add(fb.toView());
		}
		return result;
	}


	@Transactional
    @Secured({"ROLE_FEEDBACKER","ROLE_CURATOR"})
	public void saveNewFeedbackForStudentByStudId(FeedbackView feedback, long id,String author) {
		Student stud=studentDao.find(id);
		Feedbackable feedbackOwner= feedbackableDao.find(author);
		Feedback fb=new Feedback(feedback,feedbackOwner,stud);
		feedbackDao.save(fb);
	}
	
	@Transactional
	public List<Student> getAll() {
		List<Student> list= studentDao.getAll();

        //have some....lazy
        for(Student s : list){
            lazyTouch(s);
            if(s.getCurator() != null) {
                for (Feedback feedback : s.getCurator().getFeedback()) {
                    feedback.getBillableNow();
                }
            }
        }
		return list;
	}

    @Transactional
    public List<Student> getSupervised(long curatorId){
        List<Student> list = studentDao.getSupervised(curatorId);
        for(Student s : list){
            lazyTouch(s);
            for(Feedback feedback: s.getCurator().getFeedback()){
                feedback.getBillableNow();
            }
        }
        return list;
    }
    @Transactional
	public void modify(StudentView view,long id) {
		Student stud=studentDao.find(id);
		stud.setFirstName(view.getFirstName());
		stud.setSecondName(view.getSecondName());
		stud.setSurname(view.getSurname());
		
		stud.setEmail(view.getEmail());
		stud.setPhone(view.getPhone());
		stud.setSkype(view.getSkype());
		
		stud.setEnglish(view.getEnglishLevel());
		stud.setSkillSet(view.getSkillSet());
		stud.setStudy(view.getStudy());
	}

    @Transactional
	public void save(Student entity) {
			studentDao.save(entity);
	}
}
