<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body class="bg-light">

	<div
		class="container d-flex justify-content-center align-items-center vh-100">

		<div class="row w-100 justify-content-center">

			<div class="col-md-6">

				<div class="card shadow">

					<div class="card-header bg-success text-white text-center">

						<h3>User Registration</h3>

					</div>

					<div class="card-body">

						<form action="register" method="post">

							<div class="mb-3">

								<label class="form-label">Username</label> <input type="text"
									name="username" class="form-control" required>

							</div>

							<div class="mb-3">

								<label class="form-label">Password</label> <input
									type="password" name="password" class="form-control" required>

							</div>

							<div class="d-grid">

								<input type="submit" value="Register" class="btn btn-success">

							</div>

						</form>

						<br>

						<div class="text-center">

							Already Registered? <a href="login.jsp">Login Here</a>

						</div>

					</div>

				</div>

			</div>

		</div>

	</div>

</body>
</html>