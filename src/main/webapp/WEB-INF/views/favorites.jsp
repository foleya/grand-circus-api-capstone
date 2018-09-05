<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Event Search</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/darkly/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<!-- With boostrap, pages should generally be surrounded with a container element. -->
	<main class="container">
		<h1 class="page-header mt-4 mb-4">Favorite Events</h1>
		<p>${message}</p>
		<table class="table">
			<thead>
			<tr>
				<th>Name</th><th>Category</th><th>Location</th><th>Date</th><th>Details</th><th>Favorite</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="event" items="${ results }">
				<tr>
					<td><a href="${ event.url }">${ event.name }</a></td>
					<td>${ event.category }</td>
					<td>${ event.city }, ${ event.state }</td>
					<td>${ event.date }</td>
					<td><a href="/details/${ event.eventId }">Details</a></td>
					<td><a href="/delete-favorite?id=${event.id}">Remove</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<c:if test="${ empty results }">
			<h4>Sorry, you don't have any favorites yet :(</h4>
		</c:if>
		<p><a href="/">Back</a></p>

	</main>
</body>