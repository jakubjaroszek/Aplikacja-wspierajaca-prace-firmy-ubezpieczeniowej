	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html  lang="en">
	<head>
	<title>Insurance Group</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 	<link href="<c:url value='/zrodla/CSS/bootstrap.css' />"  rel="stylesheet"></link> 
	 	<link href="<c:url value='/zrodla/CSS/bootstrap.min.css' />"  rel="stylesheet"></link> 
	  	 <link href="<c:url value='/zrodla/CSS/carousel.css' />"  rel="stylesheet"></link>  
		<link href="<c:url value='/zrodla/CSS/style.css' />"  rel="stylesheet"></link> 
		<link href="<c:url value='/zrodla/CSS/bootstrap-datepicker3.css' />"  rel="stylesheet"></link> 
		<link href="<c:url value='/zrodla/CSS/jquery-ui.css' />"  rel="stylesheet"></link> 
	</head>
	<body>
	
	  <header>
	      <nav class="navbar navbar-expand-md navbar-dark fixed-top menu-nawigacyjne">
	        <a class="navbar-brand" href="#">Insurance Group</a>
	         <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	         <div class="collapse navbar-collapse" id="navbar">
	          <ul class="navbar-nav  mr-auto">
	            <li class="nav-item active">
	              <a class="p-2 text-white"  href="<c:url value='/stronaGlowna' />">Strona Główna </a>
	            </li>
	            </ul>
	         </div>
	      </nav>
	    </header>  
	
	<div class="jumbotron vertical-center">
	   <div class="panel-heading panel"><span class="naglowek-napis">Zresetuj hasło</span></div>
		<form:form method="POST" modelAttribute="resetowanieHaslaDaneDto" class="form-horizontal">	
		<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="password">Nowe hasło:</label>
						<div class="col-md-3">
							<form:input type="password" path="haslo" id="password" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="haslo" class="control-label"/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="powtorzHaslo">Powtórz nowe hasło:</label>
						<div class="col-md-3">
							<form:input type="password" path="powtorzHaslo" id="powtorzHaslo" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="powtorzHaslo" class="control-label"/>
							</div>
						</div>
					</div>
				</div>
			<div class="col-mg-4 text-center">
				<a class="btn btn-lg przyciskAnuluj btn-light" href="<c:url   value='/' />">Anuluj</a> 
				<input type="submit" value="Dalej" class="btn btn-lg przycisk btn-light" />
			</div>
			</form:form>	
	     </div>
	</body>
	</html>