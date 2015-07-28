<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page session="false" %>
<html>
<head>
	<title><spring:message code ="page.home.title"/></title>
</head>
<body>
<span style="float:right">
	<a href="?lang=fr">fr</a>
	|
	<a href="?lang=en">en</a>
</span>
<h1>
	<spring:message code ="page.home.hello"/> 
</h1>

<P>  <spring:message code ="page.home.timeOnServer"/> ${serverTime}. </P>
</body>
</html>
