package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import dto.Task;
import dto.User;




@WebServlet("/userlogin")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
		String email =req.getParameter("email");
		String password=req.getParameter("password");
		
		DAO dao=new DAO();
		
		try {
			User u=dao.findByEmail(email);
			if(u!=null) {
				//verify the password
				if(u.getUserpassword().equals(password)) {
					//login success
					//create session and set the data
					//get all the tasks related to user id from user
					
					List<Task>tasks=dao.getalltasksById(u.getUserid());
					req.setAttribute("tasks",tasks);
					
					HttpSession session=req.getSession();
					session.setAttribute("user",u);
					
					req.getRequestDispatcher("Home.jsp").include(req, resp);
					
				}else {
					//password wrong 
					//
					req.setAttribute("message","password word");
					req.getRequestDispatcher("login.jsp").include(req,resp);
					
				}
			}else {
				//email is wrong
				req.getRequestDispatcher("login.jsp").include(req, resp);
			}}
		
	
	catch(Exception e) {
		
	}
	
	}
	}




	
      
	
	
	

