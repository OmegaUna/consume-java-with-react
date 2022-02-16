<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add a News Item</title>
</head>
<body>
	<h1>News items</h1>
	<section id="container"></section>
	<div>
		<p>
			<label>Title</label>
			<input type="text" id="newsitemTitle"/>
		</p>
		<p>
			<label>Author</label>
			<input type="text" id="newsitemAuthor"/>
		</p>
		<p>
			<label>Content</label>
			<input type="text" id="newsitemText"/>
		</p>
		<p>
			<input type="button" id="addnewsitembutton" value="Add item" />
		</p>
	</div>
	<script type="text/javascript" src="js/newsitem.js"></script>
</body>
</html>