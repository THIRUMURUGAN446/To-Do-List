package controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import dto.Task;
import dto.User;
@WebServlet("/delete")
public class DeleteTask extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int taskid=Integer.parseInt(req.getParameter("taskid"));
	       DAO dao=new DAO();
	       
	      
	       
	       
	       try {
			
			HttpSession session=req.getSession();
			User u=(User)session.getAttribute("user");
			
			if(u!=null) {
			Task dbtask=dao.findtaskById(taskid);
			if(dbtask.getUserid()==u.getUserid()) {
				dao.deleteTaskById(taskid);
			
			dao.deleteTaskById(taskid);
				
				
			req.setAttribute("tasks",dao.getalltasksById(u.getUserid()));
			RequestDispatcher dispatcher=req.getRequestDispatcher("Home.jsp");
	    	  dispatcher.include(req,resp);
			}
			
			}else {
				resp.sendRedirect("Login.jsp");
			}
	    	  
	    	  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	       
	}
}













