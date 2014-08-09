package com.exadel.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;

public class JsonUtil {

	public static final TypeReference<List<Long>> listOfLongTypeRef;
	static {
		listOfLongTypeRef = new TypeReference<List<Long>>() {
		};
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
