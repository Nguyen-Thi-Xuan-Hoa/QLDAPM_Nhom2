<%@ page import="bean.User" %>
<%@ page import="java.util.List" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width>, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">

</head>

<body>
    <div class="page page_playnow">
        <header class=" header_login header_playnow">
            <div class="logo"></div>
            <div class="title"> GUESS THE SONG</div>
            <div class="link_login_singup"><a href="login.jsp">Login</a><a>/</a><a href="signup.jsp">Signup</a></div>
        </header>
        <div class="container">
            <div class="content">
<%--                <% List<User> user= (List<User>) session.getAttribute("listuser");--%>
<%--                for (User u:user){--%>
<%--                %>--%>
                <form>
                    <div class="input input_playnow">
                        <label for="email">Name:</label>
                        <input type="email" id="email" name="email"  value="" required>
                    </div>
                    <div class="button_login_signup">
                        <button class="input button_login" type="submit">Multiplayer(2-20)</button></br>
                        <button class="input button_login" type="submit">Join</button>
                    </div>
                </form>
<%--                <%}%>--%>
            </div>
            <div class="image_playnow">
                <img src="./Image/spanishMusic.png">
            </div>
        </div>
    </div>

</body>

</html>