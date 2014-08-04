
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <!--<link rel="stylesheet" href="../css/logStyle.css">-->
    <link rel="stylesheet" href="../css/ExadelProbationStyle.css">
    <title>Login form</title>
</head>
<body>
<div class="popup-show" style="background: url('../img/mooning.png');">
    <h2 class="login-h2">Sign in</h2>
    <form action="/do_login" method="post" class="login-popup">
        <p><input type="text" name="j_username" placeholder="Login"></p>
        <p><input type="password" name="j_password" placeholder="Password" ></p>
        <button type="submit" class="modern">Sign In</button>
    </form>
</div>
</body>
</html>