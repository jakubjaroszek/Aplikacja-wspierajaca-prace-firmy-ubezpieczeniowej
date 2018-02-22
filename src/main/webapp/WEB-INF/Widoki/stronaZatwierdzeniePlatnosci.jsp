	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-2"%>
	<%@ page isELIgnored="false"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
 <html lang="en">
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insurance Group</title>
	<link href="<c:url value='/zrodla/CSS/bootstrap.css' />"rel="stylesheet"></link>
	<link href="<c:url value='/zrodla/CSS/bootstrap.min.css' />"rel="stylesheet"></link>
	<link href="<c:url value='/zrodla/CSS/carousel.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/zrodla/CSS/style.css' />"  rel="stylesheet"></link> 
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-md navbar-dark fixed-top menu-nawigacyjne">
				<a class="navbar-brand" href="#">Insurance Group</a>
			</nav>
		</header>
		 <div class="jumbotron vertical-center">
	  	   <div class="panel-heading"><h1 class="naglowek-napis">P³atno¶æ siê powiod³a, dziêkujemy!</h1>
	  	     <div class="col-mg-4 text-center">
	  	     <span class="naglowek-napis">Mo¿esz siê zalogowaæ do systemu aby przejrzeæ zakupion± ofertê</span>
	  	     <a class="btn przycisk btn-lg btn-light" href="<c:url  value='/' />">Przejd¼ na stronê g³ówn±</a>
	 	  	</div>
	 	 </div>
	  </div>
	</body>
</html>