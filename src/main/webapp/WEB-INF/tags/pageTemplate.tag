<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="titulo" required="true"%>
<%@attribute name="extraScripts" fragment="true"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html>
<head>
<title>${titulo}-ReportsAdmin</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="<c:url value='/resources/css/w3.css'/>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="<c:url value='/resources/js/w3.js'/>"></script>


<style>
html, body, h1, h2, h3, h4, h5 {
	font-family:  "Raleway", sans-serif
}
</style>

</head>

<body class="w3-light-gray">
	<%@include file="/WEB-INF/header.jsp"%>
	<%@include file="/WEB-INF/sidebar.jsp"%>
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">
		<jsp:doBody />
	</div>
	<%@include file="/WEB-INF/footer.jsp"%>
	
	<jsp:invoke fragment="extraScripts"/>
</body>

</html>


