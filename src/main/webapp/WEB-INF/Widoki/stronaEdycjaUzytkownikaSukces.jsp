	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insurance group</title>
		<link href="<c:url value='/zrodla/CSS/bootstrap.min.css' />"  rel="stylesheet"></link> 
		<link href="<c:url value='/zrodla/CSS/bootstrap.css' />" rel="stylesheet"></link>
		<link href="<c:url value='/zrodla/CSS/style.css' />"  rel="stylesheet"></link> 
	</head>
	
	<body>
		<header>
	      <nav class="navbar navbar-expand-md navbar-dark fixed-top menu-nawigacyjne">
	        <a class="navbar-brand" href="#">Insurance Group</a>
	      </nav>
	    </header>  
	    
	    <div class="jumbotron vertical-center">
	  	     <div class="panel-heading"><h1 class="naglowek-napis">Użytkownik został pomyślnie zaktualizowany</h1>
	  	     <div class="col-mg-4 text-center">
	  	     </div>
	  	     <a class="btn przycisk btn-lg btn-light" href="<c:url  value='/system' />">Wróć do panelu</a>
	 	  	</div>
	 	 </div>
	</body>
</html>