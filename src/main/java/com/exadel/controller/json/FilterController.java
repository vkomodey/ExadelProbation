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

	@Autowired
	TypesService typesService;
	@RequestMapping(value = FilterURI.GET_ALL_UNIVERSITIES, method = RequestMethod.GET)
	public List<String> getAllUniversities() {
		return typesService.getActiveUniversities();
	}

	@RequestMapping(value = FilterURI.GET_ALL_FACULTIES, method = RequestMethod.GET)
	public List<String> getAllFaculties() {
		return typesService.getActiveFaculties();
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
		JsonGenerator jg = objectMapper.getFactory().createGenerator(sw);
		jg.writeStartObject();
		writeJSONStringObjectArray(getAllUsedTechs(), "skillnames", jg);
		writeJSONStringObjectArray(getAllStudyEndYears(), "study_end_years", jg);
		writeJSONStringObjectArray(getAllUniversities(), "universities", jg);
		writeJSONStringObjectArray(getAllFaculties(), "faculties", jg);
		writeJSONStringObjectArray(getAllDistinctWorkHours(), "hours_current", jg);
		List<IdNameSurnamePersonView> curators=getAllUsedCurators();
		IdNameSurnamePersonView v=new IdNameSurnamePersonView();
		v.setSurname("Show All");
		curators.add(v);
		jg.writeObjectField("curators", curators);
		jg.writeEndObject();
		jg.close();
		return sw.toString();
	}

	private List<String> getAllDistinctWorkHours() {
		List<String> list=new ArrayList<String>();
		for(Integer hour:service.getAllWorkHours()){
			if(hour==null) {
                list.add(null);
            }
            else{
                list.add(hour.toString());
            }
		}
		return list;
	}

	private List<String> getAllUsedTechs() {
		return typesService.getActiveTechs();
	}

	private static void writeJSONStringObjectArray(List<String> list, String name,JsonGenerator jg)
	throws IOException {
		
		list.add("Show All");
		jg.writeFieldName(name);
		JsonUtil.writeJSONStringObjectArray(jg, list);
	}
}
