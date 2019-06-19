<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login/Reg</title>
</head>
<body>
<section>
   <h1>Register!</h1>
    
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user" autocomplete="off">
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email" required="true"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password" required="true" />
        </p>
        <p>
            <form:label path="confirmationPassword">Password Confirmation:</form:label>
            <form:password path="confirmationPassword" required="true"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
</section>

<section>
 <h1>Login</h1>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/login">
        <p>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="submit" value="Login!"/>
    </form>    

</section>
</body>
</html>