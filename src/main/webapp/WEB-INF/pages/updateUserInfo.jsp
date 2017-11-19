<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<form:form method="POST" commandName="userInfo">
        <fieldset class="form-group">
            <form:label path="name">User Name:</form:label>
            <form:input path="name" class="form-control" type="text" required="required"/>
            <form:errors path="name" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="form-group">
            <form:label path="userId">User ID:</form:label>
            <form:input path="userId" class="form-control" type="text" required="required"/>
        </fieldset>
        <fieldset class="form-group">
            <form:label path="password">Password:</form:label>
            <form:input path="password" class="form-control" type="text" required="required"/>
        </fieldset>
        <fieldset class="form-group">
            <form:label path="validTill">Valid Till:</form:label>
            <form:input path="validTill" class="form-control" type="text" required="required"/>
        </fieldset>
		<button type="submit" class="btn btn-success">Update</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>
