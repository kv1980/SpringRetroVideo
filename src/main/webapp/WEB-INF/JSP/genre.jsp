<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>


<!DOCTYPE html>
<html lang='nl'>
<vdab:head title='genre'/>
<body>
	<vdab:menuIndex />
	<h1>Reserveren</h1>
	<nav>
		<ul>
			<c:forEach var='genre' items='${genres}'>
				<c:choose>
					<c:when test='${genreId==genre.id}'>
						<li>${genre.naam}</li>
					</c:when>
					<c:otherwise>
						<spring:url var='url' value='/genre/{genreId}'>
							<spring:param name='genreId' value='${genre.id}' />
						</spring:url>
						<li><a href='<spring:url value='${url}'/>'>${genre.naam}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul>
	</nav>
	<c:choose>
		<c:when test='${not empty films}'>
			<ul id="filmfiguren">
				<c:forEach var='film' items='${films}'>
					<spring:url var='url' value='/film/{filmId}'>
						<spring:param name='filmId' value='${film.id}' />
					</spring:url>
					<li><a href='<spring:url value='${url}'/>'> 
						<c:choose>
							<c:when test='${film.gereserveerd<film.voorraad}'>
								<img class="filmFiguur" src='/images/${film.id}.jpg' alt='${film.titel}' title='reservatie mogelijk'>
							</c:when>
							<c:otherwise>
								<img class="filmFiguur" src='/images/${film.id}.jpg' alt='${film.titel}' title='reservatie niet mogelijk'>
							</c:otherwise>
						</c:choose>
					</a></li>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<p id="geenFilmfiguren">Er zijn geen films in dit genre.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>