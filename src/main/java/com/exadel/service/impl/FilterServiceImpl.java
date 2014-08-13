package com.exadel.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.CuratorDao;
import com.exadel.dao.StudentDao;
import com.exadel.dao.TechDao;
import com.exadel.model.entity.User;
import com.exadel.model.entity.student.Technology;
import com.exadel.service.FilterService;
@Service
public class FilterServiceImpl implements FilterService {
	@Autowired
	StudentDao studentDao;
	@Autowired
	CuratorDao curatorDao;
	@Autowired
	TechDao techDao;
	
    @Transactional
    public Set<Technology> getCurrentProjUsedTech(long projectId) {
        return new HashSet<Technology>(techDao.getAllCurrentUsedByProjects(projectId));
    }
	@Transactional
	public Set<Technology> getCurrentStudUsedTech() {
		return new HashSet<Technology>(techDao.getAllCurrentUsedByStudents());
		/*List<Student> list=studentDao.getAll();
		Set<Technology> technologies=new HashSet<>();
		for(Student stud:list){
			if(stud.getWork()!=null){
			technologies.addAll(stud.getWork().getCurrentUsedTechnologies());
			}
		}
		return technologies;*/
	}

	@Transactional
	public List<Integer> getAllStudyEndYears() {
        List<Integer> l=studentDao.getStudyEndYears();
        if(l==null){
            l=new ArrayList<Integer>();
        }
        return l;
	}
	@Transactional
	public Set<User> getAllUsedCurators() {
		return new HashSet<User>(curatorDao.getActive());
	}
	@Override
	@Transactional
	public List<Integer> getAllWorkHours() {
		List<Integer> list=studentDao.getWorkhours();
/*		if(list==null){
			list=new ArrayList<Integer>();
		}*/
		return list;
	}

}
