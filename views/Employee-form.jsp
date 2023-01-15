<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Employee</title>
</head>

<body>

	<div class="container">

		<h3>Employee Management</h3>
		<hr>

		<p class="h4 mb-4">Employee Management</p>

		<form action="/EmployeeManagement/employees/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Employee.id}" />

			<div class="form-inline">
				<input type="text" name="fname" value="${Employee.fname}"
					class="form-control mb-4 col-4" placeholder="firstName">



			</div>

			<div class="form-inline">

				<input type="text" name="lname" value="${Employee.lname}"
					class="form-control mb-4 col-4" placeholder="lastName">



			</div>

			<div class="form-inline">

				<input type="text" name="email" value="${Employee.email}"
					class="form-control mb-4 col-4" placeholder="email">



			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/EmployeeManagement/employee/list">Back to Customer List</a>

	</div>
</body>

</html>










