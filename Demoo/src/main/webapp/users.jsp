<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="com.demo.model.User"%>
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
<title>User Management</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body class="bg-light">
	<div class="container mt-5">

		<div class="card shadow">

			<div
				class="card-header bg-primary text-white d-flex justify-content-between align-items-center">

				<h3>User Management System</h3>

				<a href="logout" class="btn btn- danger">Logout</a>
			</div>

			<div class="card-body">

				<%
				String update = (String) request.getAttribute("update");

				if ("success".equals(update)) {
				%>


				<div class="alert alert-success">User Updated Successfully!</div>

				<%
				} else if ("failed".equals(update)) {
				%>

				<div class="alert alert-danger">user update Failed!</div>


				<%
				}
				%>


				<%
				String delete = (String) request.getAttribute("delete");

				if ("success".equals(delete)) {
				%>

				<div class="alert alert-success">User Deleted Successfully!</div>

				<%
				} else if ("failed".equals(delete)) {
				%>


				<div class="alert alert-danger">User Deleted Failed!</div>


				<%
				}
				%>


				<form action="search" method="get" class="row mb-4">

					<div class="col-md-8">

						<input type="text" name="username" class="form-control"
							placeholder="Search Username">

					</div>

					<div class="col-md-4">

						<input type="submit" value="Search" class="btn btn-primary">

					</div>

				</form>

				<table class="table table-bordered table-hover table-striped">

					<thead class="table-dark">

						<tr>

							<th>ID</th>
							<th>Username</th>
							<th>Password</th>
							<th>Action</th>

						</tr>

					</thead>

					<tbody>

						<%
						ArrayList<User> list = (ArrayList<User>) request.getAttribute("users");

						if (list != null && !list.isEmpty()) {

							for (User user : list) {
						%>

						<tr>

							<td><%=user.getId()%></td>

							<td><%=user.getUsername()%></td>

							<td><%=user.getPassword()%></td>

							<td><a href="edit?id=<%=user.getId()%>"
								class="btn btn-warning btn-sm"> Edit </a> <a
								href="delete?id=<%=user.getId()%>" class="btn btn-danger btn-sm"
								onclick="return confirm('Are you sure you want to delete this user?')">

									Delete </a></td>

						</tr>

						<%
						}

						} else {
						%>

						<tr>

							<td colspan="4" class="text-center text-danger">No Records
								Found</td>

						</tr>

						<%
						}
						%>

					</tbody>

				</table>

			</div>
		</div>
	</div>


</body>
</html>