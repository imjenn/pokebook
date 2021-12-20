<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- additional tags to add -->
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/css/edit.css">
</head>
<body>
	<nav>
		<h1>Edit Expense</h1>
		<a href="/expenses">Go back</a>
	</nav>
	<form:form class="form" action="/expenses/${expense.id}" method="post" modelAttribute="expense">
	    <input type="hidden" name="_method" value="put">
	    <p>
	        <form:label path="expense">Expense Name: </form:label>
	        <form:errors path="expense" class="alert alert-danger" role="alert" />
	        <form:input path="expense" class="form-control" type="text" name="expense"/>
	    </p>
	    <p>
	        <form:label path="vendor">Vendor: </form:label>
	        <form:errors path="vendor" class="alert alert-danger" role="alert"/>
			<form:input path="vendor" class="form-control" type="text"/>
	    </p>
	    <p>
	        <form:label path="amount">Amount: </form:label>
	        <form:errors path="amount" class="alert alert-danger" role="alert"/>
	        <form:input path="amount" class="form-control" type="number" step="0.01"/>
	    </p>
	    <p>
	        <form:label path="description">Description: </form:label>
	        <form:errors path="description" class="alert alert-danger" role="alert"/>     
	        <form:textarea path="description" class="form-control" id="exampleFormControlTextarea1" rows="3"/>
	    </p>    
	    <input type="submit" class="btn btn-primary" value="Submit"/>
	</form:form>

</body>
</html>