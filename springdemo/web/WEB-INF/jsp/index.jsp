<%@page contentType="text/html" pageEncoding="windows-1258"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1258">
        <title>Welcome to Spring Web MVC project 
          </title>
      
        <script type="text/javascript" src="<c:url value="${webappRoot}/resources/twitter-bootstrap/fonts/jquery/jquery.js"/>"></script>
          <link type="text/css" rel="stylesheet" href="<c:url value="${webappRoot}/resources/twitter-bootstrap/fonts/twitter-bootstrap/css/bootstrap.css"/>"></link>
         <script type="text/javascript" src="<c:url value="${webappRoot}/resources/twitter-bootstrap/fonts/twitter-bootstrap/js/bootstrap.js"/>"></script>
        
    </head>

    <body>
    <container>
        <c:url value="/j_spring_security_logout" var="logoutUrl" />
         <form action="${logoutUrl}" method="POST" id="logoutForm">
	  <input type="hidden" 
		name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	</form>
 
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>
 
        <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
        <p><i>To display a different welcome page for this project, modify</i>
            <tt>index.jsp</tt> <i>, or create your own welcome page then change
                the redirection in</i> <tt>redirect.jsp</tt> <i>to point to the new
                welcome page and also update the welcome-file setting in</i>
            <tt>web.xml</tt>.</p>
    
   
    </container>
    </body>
</html>
