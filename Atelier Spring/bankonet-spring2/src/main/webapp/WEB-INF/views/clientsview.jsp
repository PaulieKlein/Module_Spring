<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<title>ClientsView</title>
</head>
<body style="width :50%;margin:0 auto">
<span style="float:right">
	<a href="?lang=fr">fr</a>
	|
	<a href="?lang=en">en</a>
</span>
<h1>
	<spring:message code ="page.home.hello"/> 
</h1>
<form:form method="POST" action="/BankonetSpringMVC/saveClient" modelAttribute="client">
	
	<fieldset>
	<legend><spring:message code="label.customer" /> :</legend>
	<table class="table table-striped">
	<tr>
		<td><form:label path="id"><spring:message code="label.id" /> : </form:label></td>
		<td>${client.id}<form:hidden path="id"/></td>
	</tr>
	<tr>
		<td><form:label path="nom"><spring:message code="label.lname" /> </form:label></td>
		<td><form:input path="nom"></form:input></td>
		<td><form:errors path="nom" style="color:red"> </form:errors></td>
	</tr>
	<tr>
		<td><form:label path="prenom"><spring:message code="label.fname" /> </form:label></td>
		<td><form:input path="prenom"></form:input></td>
		<td><form:errors path="prenom" style="color:red"> </form:errors></td>
	</tr>
	<tr>
		<td><form:label path="login"><spring:message code="label.login" /> </form:label></td>
		<td><form:input path="login"></form:input></td>
		<td><form:errors path="login" style="color:red"> </form:errors></td>
	</tr>
	<tr>
		<td><form:label path="motdepasse"><spring:message code="label.password" /> </form:label></td>
		<td><form:input path="motdepasse"></form:input></td>
		<td><form:errors path="motdepasse" style="color:red"> </form:errors></td>
	</tr>
		
	</table>
	<br>
	 <input type="submit" value="<spring:message code="label.add" />" class="btn" />
</fieldset>
</form:form>
<br>
	<p style="color:green">${result}</p>
<br>
<fieldset>
<legend><spring:message code="label.list" /> :</legend>
<table  class="table table-bordered">
	<thead style="background-color:lightblue">
		<tr>
			<th><spring:message code="label.id" /> </th>
			<th><spring:message code="label.lname" /> </th>
			<th><spring:message code="label.fname" /> </th>
			<th><spring:message code="label.login" /> </th>
			<th><spring:message code="label.password" /> </th>
			<th colspan="4"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${liste}" var="client">
			<tr>
				<td><c:out value="${client.id}"></c:out></td>
				<td><c:out value="${client.nom}"></c:out></td>
				<td><c:out value="${client.prenom}"></c:out></td>
				<td><c:out value="${client.login}"></c:out></td>
				<td><i>(<spring:message code="label.conf" />)</i></td>
				<td>
                   <c:url value="/deleteClient" var="url">
                                <c:param name="id" value="${client.id}"/>
                    </c:url>
                    <a href="${url}">
                            	<spring:message code="label.delete" /> 
                     </a>
               </td>
               <td>
                   <c:url value="/editClient/${client.id}" var="url1">
                    </c:url>
                    <a href="${url1}">
                            	
                           <spring:message code="label.edit" /> 
                     </a>
               </td>
               <td>
                <c:url value="/GererCC/${client.id}" var="cc">
                </c:url>
                    <a href="${cc}">
                            	
                           <spring:message code="label.cc" /> 
                     </a>
               </td>
               <td>
                    <c:url value="/GererCE/${client.id}" var="ce">
                    </c:url>
                    <a href="${ce}">
                            	
                           <spring:message code="label.ce" /> 
                     </a>
               </td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</fieldset>
</body>
</html>