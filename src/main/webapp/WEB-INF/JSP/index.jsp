<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>


<!DOCTYPE html>
<html lang='nl'>
<vdab:head title='index' />
<body>
	<vdab:menuIndex />
	<h1>Reserveren</h1>
	<nav>
		<ul>
			<c:forEach var='genre' items='${genres}'>
				<spring:url var='url' value='/genre/{genreId}'>
					<spring:param name='genreId' value='${genre.id}' />
				</spring:url>
				<li><a href='<spring:url value='${url}'/>'>${genre.naam}</a></li>
			</c:forEach>
		</ul>
	</nav>
</body>
</html>