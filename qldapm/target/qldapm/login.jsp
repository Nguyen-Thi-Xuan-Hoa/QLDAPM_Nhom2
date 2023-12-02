<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width>, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="style.css">

</head>

<body>
<% String error = (String) request.getAttribute("error");%>
    <div class="page">
        <header class=" header_login" >
            <div class="logo"></div>
            <div class="title"> GUESS THE SONG</div>
        </header>
        <div class="container">
            <div class="content">
                <p>Login</p>
                <form method="post" action="/Login">
                    <% if (error != null) { %>
                    <div class="form-group">
                        <label for="exampleInputName1" style="color: #CC3636"><%=error%>
                        </label>
                    </div>
                    <%}%>
                    <div class="input input1">
                        <label for="exampleInputName1">Email:</label>
                        <input type="email" id="exampleInputName1" name="email" required>
                    </div>
                    <div class=" input input2">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" value="" required>
                    </div>
                    <div class="button_login_signup">
                        <button class="input button_login" type="submit">Login</button></br>
                        <button class="input button_login" type="submit">Signup</button>
                    </div>
                </form>
            </div>
            <div class="image"></div>
        </div>
    </div>

</body>

</html>