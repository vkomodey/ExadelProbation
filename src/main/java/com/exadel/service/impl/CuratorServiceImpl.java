package com.exadel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.CuratorDao;
import com.exadel.model.entity.government.Curator;
import com.exadel.model.entity.student.Student;
import com.exadel.model.view.StudentView;
import com.exadel.service.CuratorService;
import com.exadel.util.LazyUtil;

@Service
public class CuratorServiceImpl extends GenericLivingServiceImpl<Curator> implements CuratorService {
    @Autowired
    CuratorDao curatorDao;

    @Transactional
    public Curator find(String login) {
        return curatorDao.find(login);
    }

    @Transactional
    public List<StudentView> getSupervised(long curatorId){
        List<Student>list = curatorDao.getSupervised(curatorId);
        List<StudentView> viewlist=new ArrayList<>();
        for(Student s:list){
        	LazyUtil.lazyTouch(s);
            viewlist.add(s.toView());
        }
        return viewlist;
    }
	@Transactional
	public Curator findById(long id) {
		return curatorDao.find(id);
	}
	@Transactional
	public Curator findByLogin(String name) {
		return curatorDao.find(name);
	}
	@Transactional
	public void save(Curator entity) {
		curatorDao.save(entity);
	}

	@Override
	public List<Curator> getAll() {
		return curatorDao.getAll();
	}
}
