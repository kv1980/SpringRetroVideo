<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>

<!DOCTYPE html>
<html lang='nl'>
<vdab:head title='bevestigen' />
<body>
	<vdab:menuMandje />
	<h1>Bevestigen</h1>
	<p>${aantalFilms} film(s) voor ${klant.naam}</p>
	<spring:url value='/bestelling/rapport/{klantId}' var='url'>
		<spring:param name='klantId' value='${klant.id}' />
	</spring:url>
	<form action='${url}' method='get' id='form'>
		<input type='submit' value='Bevestig' id='knop'>
	</form>
	<script>
		document.getElementById('form').onsubmit = function() {
			document.getElementById('knop').disabled = true;
		}
	</script>
</body>
</html>