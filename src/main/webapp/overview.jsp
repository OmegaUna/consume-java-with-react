<jsp:include page="components/core/head.jsp"/>
<body>
	<h1>News items</h1>
	<table>
		<thead>
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Text</th>
		</thead>
		<tbody>
		<c:forEach var="newsitem" items="${newsitems}">
			<tr>
				<td>${newsitem.title}</td>
				<td>${newsitem.author}</td>
				<td>${newsitem.text}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>