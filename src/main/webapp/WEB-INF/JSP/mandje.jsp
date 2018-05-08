<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>


<!DOCTYPE html>
<html lang='nl'>
<vdab:head title="Reserveren"/>
<body>
	<vdab:menuMandje/>
	<h1>Mandje</h1>
	<form action='/mandje' method='post' id='form'>
	<table id="filmsInMandje">
		<tr>
			<th>Film</th>
			<th>Prijs</th>
			<th><input type='submit' value='Verwijder' id='verwijderknop'></th>	
		</tr>
		<c:forEach var='filmInMandje' items='${filmsInMandje}'>
			<tr>
				<td>${filmInMandje.titel}</td>
				<td><spring:eval expression='filmInMandje.prijs'/></td>
				<td><input type='checkbox' name='teVerwijderenFilmIds' value='${filmInMandje.id}'/></td>
			</tr>	
		</c:forEach>
		<tr>
			<td>Totaal:</td>
			<td><spring:eval expression='totaalprijs.waarde'/></td>
			<td></td>
		</tr>
	</table>
	</form>
	<script>
		document.getElementById('form').onsubmit = function() {
			document.getElementById('verwijderknop').disabled = true;
		}
	</script>
</body>
</html>