<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>


<!DOCTYPE html>
<html lang='nl'>
<vdab:head title="Reserveren" />
<body>
	<vdab:menuIndex />
	<h1>${film.titel}</h1>
	<img id="filmfiguur" src='/images/${film.id}.jpg' alt='${film.titel}'>
	<dl>
		<dt>Prijs</dt>
		<dd>€ ${film.prijs}</dd>
		<dt>Voorraad</dt>
		<dd>${film.voorraad}</dd>
		<dt>Gereserveerd</dt>
		<dd>${film.gereserveerd}</dd>
		<dt>Beschikbaar</dt>
		<dd>${film.voorraad-film.gereserveerd}</dd>
	</dl>
	<c:if test='${(film.voorraad-filmgereserveerd)>0}'>
		<form:form action='/film' method='post' id='filmform'>
			<button id='toevoegknop' name='filmId' type='submit' value='${film.id}'>In Mandje</button>
		</form:form>
		<script>
			document.getElementById('filmform').onsubmit = function() {
				document.getElementById('toevoegknop').disabled = true;
			}
		</script>
	</c:if>
</body>
</html>