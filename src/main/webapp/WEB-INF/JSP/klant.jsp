<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>


<!DOCTYPE html>
<html lang='nl'>
<vdab:head title='klant'/>
<body>
	<vdab:menuMandje/>
	<h1>Klanten</h1>
	<c:url value='/klant' var='url'/>   
	<form:form action='${url}' modelAttribute='klantForm' method='get' id='zoekKlantenform'>
		<form:label path='letters'>Familienaam bevat: <form:errors path='letters'/></form:label>
		<form:input path='letters' autofocus='autofocus' required='required' type='text'/>
		<input type='submit' value='Zoeken' id='knop'>
		<form:errors/>
	</form:form>
	<script>
		document.getElementById('zoekKlantenform').onsubmit = function() {
			document.getElementById('knop').disabled = true;
		}
	</script>
	<c:if test='${not empty klanten}'>
		<table id="gevondenKlanten">
			<tr>
				<th>Naam</th>
				<th>Adres</th>
				<th>Postcode</th>
				<th>Gemeente</th>
			</tr>
			<c:forEach var='klant' items='${klanten}'>
				<tr>
					<spring:url value='/bestelling/bevestigen/{klantId}' var='url'>   
						<spring:param name='klantId' value='${klant.id}'/>
					</spring:url>
					<td><a href='${url}'>${klant.naam}</a></td>
					<td>${klant.straatNummer}</td>
					<td>${klant.postnummer}</td>
					<td>${klant.gemeente}</td>
				</tr>	
			</c:forEach>
		</table>
	</c:if>	
</body>
</html>