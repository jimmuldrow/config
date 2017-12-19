package com.test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) {
		new Main();
	}

	String json = " {\"id\": \"123\", " + "  \"name\": \"Olaf\", " + "  \"ignore1\": \"ig1\", " + "  \"ignore2\": \"ig2\", "
			+ "  \"colors\": [\"red\", \"green\", \"blue\"], \"ignore\": \"thisValue\",  \"foo\": \"bar\", \"baz\": \"naz\"}";

	Main() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Bean bean = mapper.readValue(json, Bean.class);
			String json1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
			System.out.println(json1);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
