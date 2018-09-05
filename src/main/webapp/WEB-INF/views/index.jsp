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
		<h1 class="page-header mt-4 mb-4">Events List</h1>
		<p><a href="/favorites">View Your Favorites</a></p>
		<p>${message}</p>
		
		<form class="form-inline" autocomplete="off">
		  
		  <label class="sr-only" for="keyword">Keyword</label>
		  <input type="text" value="${param.keyword}" class="form-control mb-2 mr-sm-2" id="keyword" name="keyword" placeholder="Keyword">
		  
		  <label class="sr-only" for="city">City</label>
		  <input type="text" value="${param.city}" class="form-control mb-2 mr-sm-2" id="city" name="city" placeholder="City">
		  
		  <label class="sr-only" for="category">Category</label>
		  <select class="form-control mb-2 mr-1 sm-2" id="category" name="category">
		  	<option value="">Select a Category</option>
		  	<c:forEach items="${ categories }" var="category">
		  		<option <c:if test="${ category eq param.category }">selected</c:if>>${ category }</option>
		  	</c:forEach>
		  </select>
		  
		  <button type="submit" class="btn btn-primary mb-2 mr-2">Search</button>
		  
		  <c:if test="${not empty param.keyword or not empty param.category or not empty param.city}">
		  	<a href="/" class="btn btn-secondary mb-2">Clear</a>
	  	  </c:if>
	  	  
		</form>
	
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
					<td>${ event.classifications.get(0).primaryCategory.name }</td>
					<td>${ event.venueShell.venues.get(0).city.name }, ${ event.venueShell.venues.get(0).state.stateCode }</td>
					<td>${ event.dates.dateShell.localDate }</td>
					<td><a href="/details/${ event.id }">Details</a></td>
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
		<p><a href="">Previous 20 Results</a> -- <a href="">Next 20 Results</a><p>

	</main>
</body>