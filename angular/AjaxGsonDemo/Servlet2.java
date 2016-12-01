package com.war;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.*;




@WebServlet("/serv2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("******************* Got here");
		
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = new Customer();
		customer.setFirstName("Al");
		customer.setMi("D");
		customer.setLastName("Time");
		customer.setId(1);
		customers.add(customer);
		
		customer = new Customer();
		customer.setFirstName("Simon");
		customer.setMi("");
		customer.setLastName("Nee");
		customer.setId(2);
		customers.add(customer);		
		
		customer = new Customer();
		customer.setFirstName("Helen");
		customer.setMi("");
		customer.setLastName("Wheels");
		customer.setId(3);
		customers.add(customer);		
		
		Gson gson = new Gson();
		String s = gson.toJson(customers);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(s);
	}
}
