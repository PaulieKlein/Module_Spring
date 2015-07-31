<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<title><spring:message code="label.virement" /></title>
</head>
<body style="width: 50%; margin: 0 auto">
	<span style="float: right"> <a href="?lang=fr">fr</a> 
	| <a href="?lang=en">en</a>
	| <a href="/BankonetSpringMVC/"><spring:message code="page.home.title" /></a>
	</span>
	<h1>
		<spring:message code="label.titleV" />
	</h1>

	<form:form action="/BankonetSpringMVC/${client.id}/traiterVirement" method="post" modelAttribute="virement">
		<table class="table table-bordered">
		<thead style="background-color:lightblue">
			
			<tr>
				<td>Compte source</td>
				<td>Compte destinataire</td>
				<td>Montant à virer</td>
			</tr>
		</thead>
			<tr>
				<td><select name="compteSource">
						<c:forEach items="${liste}" var="compte">
							<option value="<c:out value="${compte.identifiant}"/>"><c:out
									value="${compte.libelle}" /></option>
						</c:forEach>
				</select></td>
				<td><select name="compteDestination">
						<c:forEach items="${liste}" var="compte">
							<option value="<c:out value="${compte.identifiant}"/>"><c:out
									value="${compte.libelle}" /></option>
						</c:forEach>
				</select></td>
				<td><input type="text" name="montant" maxlength="20" size="20"
					value=""></td>
			</tr>
			<tr>
				<td align="right"><input type="reset" value="Reinitialiser">
				</td>
				<td align="right"><input type="submit" value="virer"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>