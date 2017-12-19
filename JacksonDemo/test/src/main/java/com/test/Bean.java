package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonPropertyOrder({ "colors", "name", "id" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bean {
	@JsonProperty
	private String id;
	
	@JsonProperty
	private String name;

	@JsonIgnore
	private String ignore1;

	@JsonIgnore
	private String ignore2;
	
	@JsonProperty
	private List<String> colors;
	
	/*
	 * JsonAnySetter and JsonAnyGetter will override JsonIgnore and JsonIgnoreProperties
	 * 
	private Map<String, Object> properties = new HashMap<>();

	@JsonAnySetter
	public void add(String key, String value) {
		properties.put(key, value);
	}

	@JsonAnyGetter
	public Map<String, Object> getProperties() {
		return properties;
	}
	*/
	

}
