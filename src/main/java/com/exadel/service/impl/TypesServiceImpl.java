package com.exadel.service.impl;

import java.util.*;
import java.util.Map.Entry;

import com.exadel.model.NamedEntity;
import com.exadel.model.entity.student.Faculty;
import com.exadel.model.entity.student.Technology;
import com.exadel.model.entity.student.University;
import com.exadel.util.LazyUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exadel.dao.GenericNamedDao;
import com.exadel.dao.StudentDao;
import com.exadel.dao.TechDao;
import com.exadel.service.TypesService;
@Service
public class TypesServiceImpl implements TypesService {
	@Autowired
	GenericNamedDao<University> universityDao;
	@Autowired
	StudentDao studentDao;
	@Autowired
	TechDao techDao;
	@Autowired
	GenericNamedDao<Faculty> facultyDao;
	
	private List<String> getNamesFromNamed(List<? extends NamedEntity> list){
		List<String> res=new ArrayList<String>(list.size());
		for(NamedEntity u:list){
			res.add(u.getName());
		}
		return res;
	}
	
    @Transactional
	public List<Technology> getAllTechs() {
		return techDao.getAll();
	}
    
    @Transactional
	public List<String> getActiveTechs() {
    	List<Technology> list=techDao.getAllCurrentUsedByStudents();
		return getNamesFromNamed(list);
	}
    @Transactional
	public List<University> getAllUniversities() {
		return universityDao.getAll();
	}
    @Transactional
	public List<String> getActiveUniversities() {
		List<University> list=studentDao.getActiveUniversities();
		return getNamesFromNamed(list);
	}
    @Transactional
	public List<Faculty> getAllFaculties() {
		return facultyDao.getAll();
	}
    @Transactional
	public List<String> getActiveFaculties() {
		List<Faculty> list=studentDao.getActiveFaculties();
		return getNamesFromNamed(list);
	}
    @Transactional
	public void push(University university) {
		universityDao.save(university);
		
	}
    @Transactional
	public void push(Faculty faculty) {
    	University university=universityDao.find(faculty.getUniversity().getName());
    	faculty.setUniversity(university);
		facultyDao.save(faculty);
	}
    @Transactional
	@Override
	public void removeUniversity(Long id) {
		universityDao.delete(id);
	}
    @Transactional
	@Override
	public void removeFaculty(Long id) {
		facultyDao.delete(id);		
	}
    @Transactional
	@Override
	public void push(Technology technology) {
		techDao.save(technology);
		
	}
    @Transactional
     @Override
     public void removeTechnology(Long id) {
        techDao.delete(id);
    }
    @Transactional
    public Map<String,Set<Faculty>> getMapFaculties() {
        Map<String,Set<Faculty>> map= new HashMap<String,Set<Faculty>>();
        List<University> univers=universityDao.getAll();
        for(University item : univers){
            LazyUtil.lazyTouchFaculties(item);
            map.put(item.getName(),item.getFaculties());
        }
        return map;
    }


	@Override
	@Transactional
	public void addAllTech(Set<Technology> techs) {
		for(Technology tech:techs){
			techDao.save(tech);
		}
	}

	@Override
	@Transactional
	public void addAllUniversity(Set<University> uni,Map<String,Set<Faculty>> facset) {
		for(University u:uni){
			u.setFaculties(facset.get(u.getName()));
			universityDao.save(u);
		}
		
	}
	
	@Override
	@Transactional
	public void replaceAllFaculty(Map<String,Set<Faculty>> facmap){
		for(Entry<String, Set<Faculty>> e:facmap.entrySet()){
			University uni=universityDao.find(e.getKey());
			Set<Faculty> orig_facset=uni.getFaculties();
			for(Faculty fac:e.getValue()){
				fac.setUniversity(uni);
				if(!orig_facset.contains(fac)){
					facultyDao.save(fac);
				}else{
					orig_facset.remove(fac);
				}
			}
			for(Faculty todelfac:orig_facset){
				facultyDao.delete(todelfac);
			}
		}
	}
	
	@Override
	@Transactional
	public void replaceAllUniversity(Set<University> uni){
		Set<University> orig_uniset=new LinkedHashSet<University>(universityDao.getAll());
		for(University u:uni){
			if(!orig_uniset.contains(u)){
				universityDao.save(u);
			}
			else{
				orig_uniset.remove(u);
			}
		}
		for(University u:orig_uniset){
			universityDao.delete(u);
		}
	}
	
	@Override
	@Transactional
	public void replaceAllTech(Set<Technology> techs){
		Set<Technology> orig_techset=new LinkedHashSet<Technology>(techDao.getAll());
		for(Technology tech:techs){
			if(!orig_techset.contains(tech)){
				techDao.save(tech);
			}else{
				orig_techset.remove(tech);
			}
		}
		for(Technology tech:orig_techset){
			techDao.delete(tech);
		}
	}
}
