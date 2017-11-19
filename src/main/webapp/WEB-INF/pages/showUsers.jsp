<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<font color="blue">${userAddedConfirmationMessage }</font>
		<font color="red">${userDetailsMessage }</font>
		<table class="table table-striped">
			<thead><tr>
				<th>User ID</th>
				<th>Name</th>
				<th>Role</th>
				<th>Password</th>
				<th>Valid Till</th>
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
					<td><fmt:formatDate value="${userInfo.validTill }" pattern="dd/MM/yyyy"/></td>
					<td><a type="button" class="btn btn-success" href="/updateUserInfo?id=${userInfo.id }">Update</a></td>
					<td><a type="button" class="btn btn-success" href="/deleteUserInfo?id=${userInfo.id }">Delete</a></td>
					<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div><a class="button" href="/addUserInfo">Add User</a></div>
	</div>
<%@ include file="common/footer.jspf" %>
    