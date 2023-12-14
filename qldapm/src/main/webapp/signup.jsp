<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width>, initial-scale=1.0">
    <title>Signup</title>
    <link rel="stylesheet" href="style.css">

</head>

<body>
<%
    String errorAcc= (String) request.getAttribute("errorAcc");
%>
    <div class="page">
        <header class="header_login">
            <div class="logo"></div>
            <div class="title"> GUESS THE SONG</div>
        </header>
        <div class="container">
            <div class="content">
                <p>Signup</p>
                <form action="/Signup" method="post">
                    <% if (errorAcc != null) { %>
                    <div class="form-group">
                        <label  style="color: #CC3636"><%=errorAcc%>
                        </label>
                    </div>
                    <%}%>
                    <div class="input input1">
                        <label for="name">Name:</label>
                        <input type="name" id="name" name="name" value="<%=request.getParameter("name")!=null?request.getParameter("name"):""%>" required>
                    </div>
                    <div class="input input1">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" value="<%=request.getParameter("email")!=null?request.getParameter("email"):""%>" required>
                    </div>
                    <div class=" input input2">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required>
                    </div>
                    <div class="button_login_signup">
                        <button class="input button_login" type="submit">Signup</button>
                    </div>
                </form>
            </div>
            <div class="image"></div>
        </div>
    </div>
</body>

</html>