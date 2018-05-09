<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>


<!DOCTYPE html>
<html lang='nl'>
<vdab:head title="bevestigen"/>
<body>
	<vdab:menuMandje/>
	<h1>Bevestigen</h1>
	<p>${aantalFilms} film(s) voor ${naamKlant}</p>
	<c:url value='/klant' var='url'>   
		<c:param name='id' value='${klant.id}'/>
		<c:param name='bevestigd' value='true'/>
	</c:url>
	<form:form action='/klant/rapport' modelAttribute='mandjeForm' method='post' id='form'>
			<input type='hidden' name='filmId' value='${film.id}'>
			<input type='submit' value='Bevestigen' id='toevoegknop'>
		</form:form>
		<script>
			document.getElementById('form').onsubmit = function() {
				document.getElementById('toevoegknop').disabled = true;
			}
		</script>
</body>
</html>