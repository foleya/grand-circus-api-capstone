<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Event Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/darkly/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<!-- With boostrap, pages should generally be surrounded with a container element. -->
	<main class="container">
		<h1 class="page-header mt-4 mb-4">${ results.get(0).name }</h1>
		<p><a href="/favorites">View Your Favorites</a></p>
		<p>${message}</p>
	
		<table class="table">
			<thead>
			<tr>
				<th>Category</th><th>Sub-Category</th><th>Location</th><th>Date</th><th>Start Time</th><th>Favorite</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="event" items="${ results }">
				<p><a href="${ event.url }">TicketMaster Link</a></p>
				<tr>
					<td>${ event.classifications.get(0).primaryCategory.name }</td>
					<td>${ event.classifications.get(0).subCategory.name }</td>
					<td>${ event.venueShell.venues.get(0).city.name }, ${ event.venueShell.venues.get(0).state.stateCode }</td>
					<td>${ event.dates.dateShell.localDate }</td>
					<td>${ event.dates.dateShell.localTime }</td>
					<td><a href="/add-favorite?
								name=${event.name}
								&url=${event.url}
								&city=${event.venueShell.venues.get(0).city.name}
								&state=${results.get(0).venueShell.venues.get(0).state.stateCode}
								&date=${event.dates.dateShell.localDate}
								&eventId=${event.id}
								&category=${event.classifications.get(0).primaryCategory.name}">Add Favorite</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<c:if test="${ empty results }">
			<h4>Sorry, your search did not return any results :(</h4>
		</c:if>
		<p><a href="/">Back</a></p>

	</main>
</body>