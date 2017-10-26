<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Add User</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>

<body>
<div class="container">
	<form:form method="POST" commandName="userInfo">
        <fieldset>
            <form:label path="name">User Name:</form:label>
            <form:input path="name" type="text" required="required"/>
        </fieldset>
		<button type="submit" class="btn btn-success">Create</button>
	</form:form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>