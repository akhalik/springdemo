<%@page contentType="text/html" pageEncoding="windows-1258"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1258">
        <title>Welcome to Spring Web MVC project</title>
      
        <script type="text/javascript" src="<c:url value="/resources/twitter-bootstrap/fonts/jquery/jquery.js"/>"></script>
          <link type="text/css" rel="stylesheet" href="./resources/twitter-bootstrap/fonts/twitter-bootstrap/css/bootstrap.css"></link>
         <script type="text/javascript" src="./resources/twitter-bootstrap/fonts/twitter-bootstrap/js/bootstrap.js"></script>
        
    </head>

    <body>
    <container>
        
        <h1>Please Login!</h1>
       <c:if test="${not empty error}">
			    <%--default message
                     <div class="error">${error}</div>
                     --%>
                     <%-- message resources--%>
                     <spring:message code="login.invalid.credentials"></spring:message>
		</c:if>
                 <c:if test="${not empty logout}">
                     <%--default message
                     <div class="error">${logout}</div>
                     --%>
                     <%-- message resources--%>
                     <spring:message code="logout.message"></spring:message>
                     
		</c:if>
		<c:if test="${not empty msg}">
			<div class="error">${msg}</div>
		</c:if>
        <form method="POST" action="./j_spring_security_check">
            <sec:csrfInput/>
              
            <input type="text" name="user" value="" placeholder="Enter a user name" required=""/>
            <input type="password" name="password" value="" placeholder="Enter Password" required=""/>
            <input type="submit" value="Login" /><input type="reset" value="reset" />
         </form>
    </container>
    </body>
</html>
