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
	<p>${aantalFilms} film(s) voor ${klantNaam}</p>
	
	<form action='/rapport' method='get' id='form'>
		<input type='submit' name='teVerwijderenFilmIds' value='${filmInMandje.id}'/></td>
	</form>
	<script>
		document.getElementById('form').onsubmit = function() {
			document.getElementById('verwijderknop').disabled = true;
		}
	</script>
</body>
</html>