<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>login page</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>

<body>
<font color="blue">${userAddedConfirmationMessage }</font>
<font color="red">${userDetailsMessage }</font>
	<div class="container">
		<table class="table table-striped">
			<thead><tr>
				<th>User ID</th>
				<th>Name</th>
				<th>Role</th>
				<th>Password</th>
				<th></th>
				<th></th>
			</tr></thead>
			<tbody>
				<c:forEach items="${userInfoIterable}" var="userInfo" >
					<tr>
					<td>${userInfo.userId }</td>
					<td>${userInfo.name }</td>
					<td>${userInfo.role }</td>
					<td>${userInfo.password }</td>
					<td><a type="button" class="btn btn-success" href="/updateUserInfo?id=${userInfo.id }">Update</a></td>
					<td><a type="button" class="btn btn-success" href="/deleteUserInfo?id=${userInfo.id }">Delete</a></td>
					<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div><a class="button" href="/addUserInfo">Add User</a></div>
	</div>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>