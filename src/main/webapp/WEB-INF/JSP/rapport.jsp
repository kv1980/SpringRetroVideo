<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>


<!DOCTYPE html>
<html lang='nl'>
<vdab:head title='rapport'/>
<body>
	<vdab:menuIndex/>
	<h1>Rapport</h1>
	<c:choose>
		<c:when test='${empty nietGereserveerdeFilms}'>
			<p>De reservatie is OK.</p>
		</c:when>
		<c:otherwise>
			<p>De volgende films zijn niet gereserveerd:</p>
			<ul>
				<c:forEach var='film' items='${nietGereserveerdeFilms}'>
					<li>${film.titel}</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
</body>
</html>