package com.test;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import java.io.File;

public class TestJava {
	public static void main(String[] args) {
		try {
			GroovyClassLoader classLoader = new GroovyClassLoader();
			Class groovy = classLoader.parseClass(new File(
					"C:\\a1\\eclipseOxygen\\Workspaces\\Groovy\\test\\src\\main\\groovy\\com\\test\\TestGroovy.groovy"));
			GroovyObject groovyObj = (GroovyObject) groovy.newInstance();
			String output = (String) groovyObj.invokeMethod("combine", new Object[] { "aaa", "bbb" });
			System.out.println(output);
			classLoader.close();
		} catch (Exception e) {			
		}
	}
}
