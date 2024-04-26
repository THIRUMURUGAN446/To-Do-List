





<%@page import="dto.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-image:url("https://cdn.pixabay.com/photo/2016/07/31/11/52/notepad-1558811_1280.jpg");
background-size:cover;


height:80vh;
width:80vh;
backgroun-repeat:no-repeat;
}
div{

height:50vh;
width:70vh;
position:absolute;
left:90vh;
top:50vh;
font-family:segoe print;

}
div:hover{
transform:rotateX(360deg);}
input{
text-align:justify;
font-size:15px;
font-family:segoe print;

}
button{
background-color:#75787c;
font-family:segoe print;
width:15vh;
height:5vh;
position:absolute;
left:15vh;
}
button:hover
{
color:white;
background-color:black;
}

</style>
</head>
<body>
<div>
<% Task task=(Task)request.getAttribute("task"); %>
<form action="updatetask" method="post">

<label>taskid:</label><input type="text" name="taskid" hidden="" value="<%= task.getTaskid()%>">
<label>tasktitle:</label><input type="text" name="tasktitle"  value="<%= task.getTasktitle()%>"><br>
<label>taskdescription:</label><input type="text" name="taskdescription" value="<%= task.getTaskdescription()%>"><br>
Current task Priority:<h4><%= task.getTaskpriority() %> value="<%= task.getTaskpriority() %>"</h4>
Option:<label for="option1">
<input type="radio" id="option1" value="low" name="taskpriorty">Low
</label>
<label for="option2">
<input type="radio" id="option2" value="medium" name="taskpriorty">Medium
</label>
<label for="option3">
<input type="radio" id="option3" value="high" name="taskpriorty">High
</label>
<br>
Taskduedate:<input type="date" name="taskduedate" value="<%= task.getTaskduedate() %>"><br>
Taskstatus:<input type="text" name="taskstatus" value="<%= task.getTaskstatus()%>"><br>

<button>Submit</button>


</form>

</div>
</body>
</html>