<!DOCTYPE HTML>
<html>
<head>
    <title>User Info</title>
</head>

<body>
	<font color="blue">Welcome ${userId}!!</font>
	<form method="POST">
		User Name*:<input type="text" name="name"/>
		Role*:<input type="text" name="role"/>
		Password*:<input type="password" name="password"/>
		<button type="submit">Add User</button>
	</form>
</body>
</html>