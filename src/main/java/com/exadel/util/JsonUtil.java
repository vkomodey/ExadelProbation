package com.exadel.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper om;
	public static final TypeReference<List<Long>> listOfLongTypeRef;
	static {
		om=new ObjectMapper();
		listOfLongTypeRef = new TypeReference<List<Long>>() {
		};
	}

	/**
	 * Reads Belskiy Id Object Array from JSON and converts it to List<Long>.
	 * <br>
	 * <b>Belskiy Id Object</b> is a POJO with <i>long id</i> being the only field.
	 * @param json - JSON string to parse
	 * @return List<Long> of id
	 * @throws JsonProcessingException 
	 * @throws IOException
	 */
	public static List<Long> readBelskiyIdObject(String json) throws JsonProcessingException, IOException{
		List<Long> list=new ArrayList<Long>();
		JsonNode jn=om.readTree(json);
		if(jn.isArray()){
			for(JsonNode el:jn){
				list.add(el.get("id").asLong());
			}
		}
		return list;
	}
	public static void writeJSONStringObjectArray(JsonGenerator jg,
			List<String> list) throws IOException {
		jg.writeStartArray();
		if (list != null) {
			for (String val : list) {
				if (val == null) {
					val = "";
				}
				jg.writeStartObject();
				jg.writeStringField("name", val);
				jg.writeEndObject();
			}

		}
		jg.writeEndArray();
	}

}
