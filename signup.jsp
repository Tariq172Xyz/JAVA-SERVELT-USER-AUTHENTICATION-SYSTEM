<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Signup</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #eef2f3;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .card {
            background: white;
            padding: 30px;
            width: 340px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
        }
        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
        }
        button {
            width: 100%;
            padding: 10px;
            background: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background: #218838;
        }
        .link {
            text-align: center;
            margin-top: 10px;
        }
        .error {
                    color: red;
                    text-align: center;
                }
    </style>
</head>
<body>

<div class="card">
    <h2>Signup</h2>
    <% if (request.getAttribute("Error") != null) { %>
            <div class="error"><%= request.getAttribute("Error") %></div>
        <% } %>

    <form action="signup" method="post">
        <input type="text" name="name" placeholder="Full Name" required />
        <input type="email" name="email" placeholder="Email" required />
        <input type="password" name="password" placeholder="Password" required />
        <button type="submit">Register</button>
    </form>

    <div class="link">
        <a href="login">Already have an account?</a>
    </div>
</div>

</body>
</html>
