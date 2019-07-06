package com.test.tests;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.HttpClient;

public abstract class TemplateSetup {
	public RestTemplate getRestTemplate() {
        RestTemplate rt = new RestTemplate();
        HttpClient httpClient = HttpClientBuilder.create().build();
        rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory(httpClient));
        return rt;
	}		
}
