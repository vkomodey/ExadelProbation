package com.exadel.controller.json;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exadel.controller.json.constants.FilterURI;
import com.exadel.model.entity.User;
import com.exadel.model.entity.student.Technology;
import com.exadel.model.view.IdNameSurnamePersonView;
import com.exadel.service.FilterService;
import com.exadel.service.TypesService;
import com.exadel.util.JsonUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FilterController {
	@Autowired
	FilterService service;

	JsonGenerator jg;
	@Autowired
	TypesService typesService;
	@RequestMapping(value = FilterURI.GET_ALL_UNIVERSITIES, method = RequestMethod.GET)
	public List<String> getAllUniversities() {
		return service.getAllUniversities();
	}

	@RequestMapping(value = FilterURI.GET_ALL_FACULTIES, method = RequestMethod.GET)
	public List<String> getAllFaculties() {
		return service.getAllFaculties();
	}

	@RequestMapping(value = FilterURI.GET_ALL_STUDY_END_YEARS, method = RequestMethod.GET)
	public List<String> getAllStudyEndYears() {
		List<Integer> intlist = service.getAllStudyEndYears();
        List<String> list = new ArrayList<String>(intlist.size());
		for (Integer l : intlist) {
            if(l==null) {
                list.add(null);
            }
            else{
                list.add(l.toString());
            }
		}
		return list;
	}

	@RequestMapping(value = FilterURI.GET_ALL_USED_CURATORS, method = RequestMethod.GET)
	public List<IdNameSurnamePersonView> getAllUsedCurators() {
		List<IdNameSurnamePersonView> list = new ArrayList<>();
		for (User u : service.getAllUsedCurators()) {
			list.add(new IdNameSurnamePersonView(u));
		}
		return list;
	}

	@RequestMapping(value = FilterURI.GET_ALL_CURRENT_USED_TECHNOLOGIES, method = RequestMethod.GET)
	public Set<String> getAllCurrentUsedTechnologies() {
		Set<Technology> techs = service.getCurrentStudUsedTech();
		Set<String> technames = new HashSet<>();
		for (Technology tech : techs) {
			technames.add(tech.getName());
		}
		return technames;
	}
	@RequestMapping(value = FilterURI.GET_EVERYTHING, method = RequestMethod.GET)
	public String getEverything(ObjectMapper objectMapper) throws IOException {
		StringWriter sw = new StringWriter();
		//jsonFactory.setCodec(new ObjectMapper());
		jg =objectMapper.getFactory().createGenerator(sw);
		jg.writeStartObject();
		writeJSONStringObjectArray(new ArrayList<String>(getAllCurrentUsedTechnologies()), "technames");
		writeJSONStringObjectArray(getAllUsedSkillNames(), "skillnames");
		writeJSONStringObjectArray(getAllStudyEndYears(), "study_end_years");
		writeJSONStringObjectArray(getAllUniversities(), "universities");
		writeJSONStringObjectArray(getAllFaculties(), "faculties");
		List<IdNameSurnamePersonView> curators=getAllUsedCurators();
		IdNameSurnamePersonView v=new IdNameSurnamePersonView();
		v.setSurname("Show All");
		curators.add(v);
		jg.writeObjectField("curators", curators);
		jg.writeEndObject();
		jg.close();
		return sw.toString();
	}

	private List<String> getAllUsedSkillNames() {
		return typesService.getActiveSkillTypes();
	}

	private void writeJSONStringObjectArray(List<String> list, String name)
	throws IOException {
		
		list.add("Show All");
		jg.writeFieldName(name);
		JsonUtil.writeJSONStringObjectArray(jg, list);
	}
}
