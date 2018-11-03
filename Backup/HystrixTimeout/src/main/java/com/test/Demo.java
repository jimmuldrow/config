package com.test;

public class Demo {
	public static void main(String[] args) {
		RemoteService<String> remoteService = new RemoteService<String>();
		remoteService.remoteServiceStart(6000, "RemoteServiceGroup1");
		System.out.println("apiTimedout = " + remoteService.getApiTimedout());
		System.out.println("result = " + remoteService.getResult());
	}
}
