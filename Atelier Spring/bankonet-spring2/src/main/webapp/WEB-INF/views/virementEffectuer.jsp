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
<title><spring:message code="label.virement"/></title>
</head>
<body style="width: 50%; margin: 0 auto">
<h1>Virement effectué</h1>
<table class="table table-bordered">
<thead style="background-color:lightblue">
	<tr>
		<th></th>
		<th>Libellé</th>
		<th>Solde</th>
	
	</tr>
</thead>
	<tr>
		<td>Compte Source</td>
       <td>${compteSource.libelle}</td>
       <td>${compteSource.solde}</td>
   </tr>
   <tr>
   		<td>Compte Destination</td>
       <td>${compteDestination.libelle}</td>
       <td>${compteDestination.solde}</td>
   </tr>
</table>
</body>
</html>