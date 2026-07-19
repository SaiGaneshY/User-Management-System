<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.demo.model.User"%>

<%
User user = (User) request.getAttribute("user");

if (user == null) {
	System.out.println("User object is null");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body class="bg=light">

	<div
		class="container-fluid d-flex justify-content-center align-items-center vh-100">

		<div class="col-md-5">

			<div class="card shadow">

				<div class="card-header bg-warning text-dark text-center">


					<h3>Edit User</h3>
				</div>
				<div class="card-body">

					<form action="update" method="post">
						<input type="hidden" name="id" value="<%=user.getId()%>">
						<div class="mb-3">

							<!-- username -->
							<label class="form-label">Username</label> <input type="text"
								name="username" value="<%=user.getUsername()%>"
								class="form-control">
						</div>

						<div class="mb-3">


							<!-- password -->
							<label class="form-label">Password</label> <input type="text"
								name="password" value="<%=user.getPassword()%>" class=btnbtn-warning">
						</div>

						<div class="d-grid">


							<input type="submit" value="Update User" class="btn btn-warning">
						</div>
						<br> <a href="display" class="btn btn-secondary w-100">Back</a>

					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>