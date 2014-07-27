package com.exadel.service.impl;

import com.exadel.dao.FeedbackDao;
import com.exadel.dao.UserDao;
import com.exadel.model.entity.Feedback;
import com.exadel.model.entity.government.FeedbackAble;
import com.exadel.model.entity.student.Student;
import com.exadel.model.entity.view.FeedbackView;
import com.exadel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImpl extends GenericLivingServiceImpl<Student> implements StudentService{
	@Autowired
	UserDao userDao;
	@Autowired
	FeedbackDao feedbackDao;
	
	@Transactional
	public Student findById(long id){
		Student student=mainDao.find(id);
		//laaaazy
		student.getStudy().getExams().size();
		student.getSkillSet().size();
		return student;
	}
	@Transactional
	public List<FeedbackView> getFeedbacksForStudentByStudId(long id) {
		Student stud=mainDao.find(id);
		List<Feedback> fblist=feedbackDao.findAllForStud(stud);
		ArrayList<FeedbackView> result=new ArrayList<FeedbackView>();
		for(Feedback fb:fblist){
			result.add(fb.toView());
		}
		return result;
	}

	@Transactional
	public void saveNewFeedbackForStudentByStudId(FeedbackView feedback, long id,String author) {
		Student stud=mainDao.find(id);
		FeedbackAble feedbackOwner=(FeedbackAble) userDao.find(author);
		Feedback fb=new Feedback(feedback,feedbackOwner,stud);
		feedbackDao.save(fb);
	}
}
