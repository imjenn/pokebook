<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>PokeBook</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/index2.css">
</head>
<body>
	<div id="container">
		<div>
			<h2>PokeBook</h2>
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col">Expense</th>
						<th scope="col">Vendor</th>
						<th scope="col">Amount</th>
						<th scope="col">Description</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="expenses" items="${expenses}">
					<tr> 
						<td class="align-middle"><a href="/expenses/${expenses.id}"><c:out value="${expenses.expense}"></c:out></a></td>
						<td class="align-middle"><c:out value="${expenses.vendor}"></c:out></td>
						<td class="align-middle">$<c:out value="${expenses.amount}"></c:out></td>
						<td class="align-middle"><c:out value="${expenses.description}"></c:out></td>
						<td class="align-middle">
							<a class="middle" href="/expenses/${expenses.id}/edit">edit</a>
							<form action="/expenses/${expenses.id}/delete" method="post">
    							<input type="hidden" name="_method" value="delete">
    							<input type="submit" class="btn btn-danger" value="Delete">
							</form>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
		<div>
			<h2>Track an expense:</h2>
			<form:form class="form" action="/expenses" method="post" modelAttribute="ex">
	   	 		<form:errors class="alert alert-danger" role="alert" path="expense"/>
	   	 		<p>
	        		<form:label path="expense">Expense Name: </form:label>
	        		<form:input class="form-control" type="text" name="expense" path="expense"/>
	    		</p>
	    		<form:errors class="alert alert-danger" role="alert" path="vendor"/>
	    		<p>
			        <form:label path="vendor">Vendor: </form:label>
			        <form:input class="form-control" type="text" path="vendor"/>
			    </p>
			    <form:errors class="alert alert-danger" role="alert" path="amount"/><br/>
			    <p>
			        <form:label path="amount">Amount: </form:label>
			        <form:input class="form-control" type="number" step="0.01" path="amount"/>
			    </p> 
			    <form:errors class="alert alert-danger" role="alert" path="description"/>
			    <p class="form-group">
			        <form:label for="exampleFormControlTextarea1" path="description">Description: </form:label><br/>
			        <form:textarea path="description" class="form-control" id="exampleFormControlTextarea1" rows="3"/>
			    </p> 
			    <input type="submit" class="btn btn-primary" value="Submit"/>
			</form:form>   
		</div>
	</div>
</body>
</html>