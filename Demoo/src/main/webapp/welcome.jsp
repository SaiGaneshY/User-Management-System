<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>

<%
HttpSession session1 = request.getSession(false);

if (session1 == null || session1.getAttribute("username") == null) {

	response.sendRedirect("login.jsp");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">


</head>
<body class="bg-light">
	<div
		class="container-fluid d-flex justify-content-center align-items-center vh-100">

		<div class="col-md-6">

			<div class="card shadow">

				<div class="card-header bg-success text-white text-center">


					<h2>Welcome</h2>
				</div>

				<div class="card-body text-center">

					<h3>
						Hello, <span class="text-primary"> <%=session1.getAttribute("username")%>
						</span>
					</h3>
					<p class="text-muted">Welcome to the User Management System</p>

					<br> <a href="display" class="btn btn-primary me-2">
						Display Users </a> <a href="logout" class="btn btn-danger"> Logout
					</a>

				</div>
			</div>
		</div>
	</div>


</body>
</html>
