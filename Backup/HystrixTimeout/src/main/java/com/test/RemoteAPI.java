package com.test;

public class RemoteAPI {
	protected String someAPI() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}

		return "Success";
	}
}
