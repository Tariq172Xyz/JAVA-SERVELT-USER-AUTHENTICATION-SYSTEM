<%@page import="Web_project_UserAuth.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(120deg, #667eea, #764ba2);
            color: black;
        }
        .content {
            text-align: center;
            font-size: 50px;
            font-weight: bold;
        }
        .sub {
            margin-top: 10px;
            font-size:30px;
            opacity: 0.9;
        }
        button {
                    padding: 10px 25px;
                    font-size: 1rem;
                    background: #ff4b5c;
                    border: none;
                    border-radius: 6px;
                    cursor: pointer;
                    color: white;

        }

        button:hover {
                    background: #e63b4d;

        }
    </style>
</head>
<body>


   <%
  User user =(User)session.getAttribute("user");
   %>
<div class="content">
    <div class="sub">

       <%=
        user.getName()
        %>
      <h2> Welcome to the world of Backend Development</h2>
      <br>
      <br>
       <form action="logout" method="post">
                  <button type="submit">logout</button>
          </form>
    </div>
</div>

</body>
</html>
