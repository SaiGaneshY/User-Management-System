<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container-fluid d-flex justify-content-center align-items-center vh-100">
		<div class="row w-100 justify-content-center">
			<div class="col-md-5">
				<div class="card shadow">
					<div class="card-header bg-primary text-white text-center">

						<h3>User Login</h3>

					</div>

					<div class="card-body">
						<%
	String success = request.getParameter("success");

	if ("1".equals(success)) {
	%>

						<div class="alert alert-success">User Registered
							Successfully!</div>

						<%
						}
						%>

						<%
						String error = request.getParameter("error");

						if ("1".equals(error)) {
						%>

						<div class="alert alert-danger">Invalid Username or
							Password!</div>

						<%
						}
						%>

						<%
						String logout = request.getParameter("logout");

						if ("1".equals(logout)) {
						%>

						<div class="alert alert-info">Logout Successful!</div>

						<%
						}
						%>

						<form action="login" method="post">

							<div class="mb-3">

								<label class="form-label">Username</label> <input type="text"
									name="username" class="form-control" required>

							</div>

							<div class="mb-3">

								<label class="form-label">Password</label> <input
									type="password" name="password" class="form-control" required>

							</div>

							<div class="d-grid">

								<input type="submit" value="Login" class="btn btn-primary">

							</div>

						</form>

						<br>

						<div class="text-center">

							New User? <a href="register.jsp">Register Here</a>

						</div>

					</div>

				</div>

			</div>

		</div>

	</div>


</body>
</html>