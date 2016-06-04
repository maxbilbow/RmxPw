<#global pageTitle = "Welcome" urlLink="welcome" urlGroup="">
<#import "/layout/layout.ftl" as layout/>
<@layout.mainLayout urlLink urlGroup>

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
</@layout.mainLayout>