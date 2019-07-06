package hello;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		List<Course> aList = studentService.retrieveCourses("Student1");
		System.out.println("**** aList = " + aList);
	}
}
