<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home JSP</title>
</head>
<head>
    <title>Your Web Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 1em;
        }

        main {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        footer {
            text-align: center;
            padding: 1em;
            background-color: #333;
            color: #fff;
        }

        div {
            text-align: center;
        }

        h2 {
            text-align: center;
        }
    </style>
</head>
<body>
<header>
    <h1>Welcome Web Application</h1>
</header>

<main>
    <h2>Welcome to Our Homepage</h2>
    <p>This is the main content of your homepage. You can add text, images, and links to provide information about your
        web application.</p>
    <p>Consider including navigation links to other pages, features, or sections of your site.</p>

    <div>
        <p><a href="/login">User login</a></p>
        <p><a href="/user/list">User list</a></p>
        <p><a href="/group/list">Group list</a></p>
        <p><a href="/student/list">Student list</a></p>
    </div>
</main>

<footer>
    <p>&copy; 2024 Your Web Application</p>
</footer>
</body>
</html>
