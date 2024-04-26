package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dto.Task;



@WebServlet("/edit")
public class EditTask extends HttpServlet {
   
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	int id=Integer.parseInt(req.getParameter("taskid"));
	
	DAO dao=new DAO();
	try {
	Task task=dao.findtaskById(id);
	req.setAttribute("task",task);
	RequestDispatcher dispatcher=req.getRequestDispatcher("edittask.jsp");
	dispatcher.include(req, resp);
	}
  catch(ClassNotFoundException e) {
	  e.printStackTrace();
  }
	
	catch( SQLException e) {
	e.printStackTrace();
	}
	}
	
}
