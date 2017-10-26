<!DOCTYPE HTML>
<html>
<head>
    <title>login page</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>

<body>
	<form method="POST">
        <fieldset>
            <label>User ID:</label>
            <input type="text" name="userId" required="required"/>
            <label>Password:</label>
            <input type="password" name="password" required="required"/>
        </fieldset>
		<button type="submit" class="btn btn-success">login</button>
	</form>
	<font color="red">${error_message}</font>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>