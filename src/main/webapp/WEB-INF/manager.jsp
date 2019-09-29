<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Manager Page</title>
	<link rel = "stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<style>
		#wrapper {
			background-color: lightgrey;
		}
		#main {
			padding: 25px;
			padding-left: 230px;
		}
		h1 {
			text-align: center;
			padding-right: 230px;
		}
		table {
			border: 1px solid black;
			border-collapse: collapse;
			margin-top: 30px;
			width: 800px;
		}
		th {
			text-align: left;
			border: 1px solid black;
			border-collapse: collapse;
			padding: 5px;
			padding-left: 10px;
			padding-right: 100px;
			background-color: rgb(116, 162, 237);
			font-size: 18px;
		}
		tr td {
			border: 1px solid black;
			border-collapse: collapse;
			padding: 10px;
			background-color: rgb(237, 241, 248);
			font-size: 18px;
		}
	</style>
</head>
<body>
	<div id = "wrapper">
		<div id = "main">
			<h1>Manager: ${m.first_name} ${m.last_name}</h1>
			<table>
				<thead>
					<tr>
						<th>ID</th>
			            <th>First Name</th>
			            <th>Last Name</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items = "${employees}" var = "e">
			        <tr>
			        	<td>${e.id}</td>
			            <td>${e.first_name}</td>
			            <td>${e.last_name}</td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
	</div>
</body>
</html>