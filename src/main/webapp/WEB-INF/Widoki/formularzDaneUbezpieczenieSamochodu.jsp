<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Nowe Ubezpieczenie</title>
	<link href="<c:url value='/zrodla/CSS/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/zrodla/CSS/style.css' />"  rel="stylesheet"></link> 
</head>

<body>
<header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top menu-nawigacyjne">
        <a class="navbar-brand" href="#">Insurance Group</a>
      </nav>
    </header>  
	<div class="jumbotron vertical-center">
	<div class ="container">
 	<div class="generic-container">

	<div class="panel-heading panel"><span class="naglowek-napis">Szczegółowe dane pojazdu</span></div>
	 	<form:form method="POST" modelAttribute="ubezpieczenieSamochodu" class="form-horizontal">
			<div class="row">
				<div class="form-group formularz col-md-12">
					<label class="col-md-3 control-lable" for="numerRejestracyjnyPojazdu">Numer rejestracyjny pojazdu:</label>
					<div class="col-md-3">
						<form:input type="text" path="numerRejestracyjnyPojazdu" id="numerRejestracyjnyPojazdu" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="numerRejestracyjnyPojazdu" class="control-label"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group formularz col-md-12">
					<label class="col-md-3 control-lable" for="numerVinPojazdu">Numer VIN pojazdu:</label>
					<div class="col-md-3">
						<form:input type="text" path="numerVinPojazdu" id="numerVinPojazdu" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="numerVinPojazdu" class="control-label"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="col-mg-4 text-center">
           		<a class="btn btn-lg przyciskAnuluj btn-light" href="<c:url   value='/anulujUbezpieczenie' />">Anuluj</a>	
           		<input type="submit" value="Dalej" class="btn btn-lg przycisk btn-light"/>  
           </div>
		</form:form>
	</div>
	</div>
	</div>
</body>
</html>