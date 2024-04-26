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



	

@WebServlet("/updatetask")
public class UpdateTask extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int taskid = Integer.parseInt(req.getParameter("taskid"));
		String tasktitle = req.getParameter("tasktitle");
		String taskdescription = req.getParameter("taskdescription");
		String taskpriority = req.getParameter("taskpriority");
		String taskduedate = req.getParameter("taskduedate");
		String taskstatus = req.getParameter("taskstatus");

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		DAO dao = new DAO();
		try {
			Task dbtask = dao.findtaskById(taskid);

			if (taskpriority == null) {
				taskpriority = dbtask.getTaskpriority();
			}

			Task task = new Task(taskid, tasktitle, taskdescription, taskpriority, taskduedate, taskstatus,
					user.getUserid());

			System.out.println("------------>" + task + "<--------------");

			dao.updateTask(task);

//			resp.sendRedirect("Home.jsp");
			

    	  
    	  req.setAttribute("tasks",dao.getalltasksById(user.getUserid()));
    	  RequestDispatcher dispatcher=req.getRequestDispatcher("Home.jsp");
    	  dispatcher.include(req,resp);
			
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

