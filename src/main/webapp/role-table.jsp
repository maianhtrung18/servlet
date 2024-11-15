<!DOCTYPE html>
<%@page import="crm.model.Roles"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<script src="js/roles.js"></script>

</head>

<body>
	<div>
		<h2>List of Roles</h2>
		<%
		List<Roles> list = (List<Roles>) request.getAttribute("roles");
		%>
		<table>
			<tr>
				<th>Id</th>
				<th>Role Name</th>
				<th>Role Description</th>
				<th>Action</th>
			</tr>
			<%
			for (Roles role : list) {
			%>
			<tr>
				<td><%=role.getId()%></td>
				<td><%=role.getRoleName()%></td>
				<td><%=role.getDescription()%></td>
				<td>
					<button class="btn_sua" id-role=<%=role.getId()%>>Edit</button>
					<button class="btn_xoa" id-role=<%=role.getId()%>>Delete</button>
				</td>
			</tr>
			<%
			}
			%>
			<c:forEach items="${roles}" var="role">
				<tr>
					<td>${role.getId()}</td>
					<td>${role.getRoleName()}</td>
					<td>${role.getDescription()}</td>
					<td>
						<button class="btn_sua" id-role=${role.getId()}>Edit</button>
						<button class="btn_xoa" id-role=${role.getId()}>Delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>

</html>