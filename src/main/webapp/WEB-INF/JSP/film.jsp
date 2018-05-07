<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>


<!DOCTYPE html>
<html lang='nl'>
<vdab:head title="Reserveren" />
<body>
	<vdab:menuIndex />
	<h1>${film.titel}</h1>
	<img class="filmFiguur" src='/images/${film.id}.jpg' alt='${film.titel}'>
</body>
</html>