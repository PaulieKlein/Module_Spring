<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compte Courant</title>
</head>
<body style="width :50%;margin:0 auto">
<span style="float:right">
	<a href="?lang=fr">fr</a>
	|
	<a href="?lang=en">en</a>
</span>
<h1>
	<spring:message code ="label.titleC"/> 
</h1>
<%-- <form:form method="POST" action="/BankonetSpringMVC/saveCompte" modelAttribute="compte">
	
	<fieldset>
	<legend><spring:message code="label.account" /> :</legend>
	<table class="table table-striped">
	<tr>
		<td><form:label path="identifiant"><spring:message code="label.accountid" /> : </form:label></td>
		<td>${compte.identifiant}<form:hidden path="identifiant"/></td>
	</tr>
	<tr>
		<td><form:label path="libelle"><spring:message code="label.libelle" /> </form:label></td>
		<td><form:input path="libelle"></form:input></td>
		<td><form:errors path="libelle" style="color:red"> </form:errors></td>
	</tr>
	<tr>
		<td><form:label path="solde"><spring:message code="label.solde" /> </form:label></td>
		<td><form:input path="solde"></form:input></td>
		<td><form:errors path="solde" style="color:red"> </form:errors></td>
	</tr>
	<tr>
		<td><form:label path="decouvertAutorise"><spring:message code="label.decouvert" /> </form:label></td>
		<td><form:input path="decouvertAutorise"></form:input></td>
		<td><form:errors path="decouvertAutorise" style="color:red"> </form:errors></td>
	</tr>
		
	</table>
	<br>
	 <input type="submit" value="<spring:message code="label.add2" />" class="btn" />
</fieldset>
</form:form>
<br>
	<p style="color:green">${result}</p>
<br>
<fieldset>
<legend><spring:message code="label.list2" /> :</legend>
<table  class="table table-bordered">
	<thead style="background-color:lightblue">
		<tr>
			<th><spring:message code="label.accountid" /> </th>
			<th><spring:message code="label.libelle" /> </th>
			<th><spring:message code="label.solde" /> </th>
			<th><spring:message code="label.decouvert" /> </th>
			<th colspan="2"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${liste}" var="compte">
			<tr>
				<td><c:out value="${compte.identifiant}"></c:out></td>
				<td><c:out value="${compte.libelle}"></c:out></td>
				<td><c:out value="${compte.solde}"></c:out></td>
				<td><c:out value="${compte.decouvertAutorise}"></c:out></td>
				<td>
                   <c:url value="/deleteCompte" var="url">
                                <c:param name="id" value="${compte.id}"/>
                    </c:url>
                    <a href="${url}">
                            	<spring:message code="label.delete" /> 
                     </a>
               </td>
               <td>
                   <c:url value="/editCompte/${compte.id}" var="url1">
                    </c:url>
                    <a href="${url1}">
                            	
                           <spring:message code="label.edit" /> 
                     </a>
               </td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</fieldset> --%>
</body>
</html>