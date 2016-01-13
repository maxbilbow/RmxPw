
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p>
    hello, Mr World.
</p>

<div>
    <#--modelAttribute="user"-->
<form id="user" name="user" method="post">
    Username<input type="text" name="username"><br/>
    Password<input type="password" name="password"><br/>
    <input type="submit" value="Log in" formaction="/login">
    <input type="submit" value="Register" formaction="/register">
</form>

</div>
</body>
</html>