<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insurance Group</title>
<link href="<c:url value='/zrodla/CSS/bootstrap.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/zrodla/CSS/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/zrodla/CSS/style.css' />" rel="stylesheet"></link>
</head>
<body>
	<header>
		<nav
			class="navbar navbar-expand-md navbar-dark fixed-top menu-nawigacyjne">
			<a class="navbar-brand" href="#">Insurance Group</a>
		</nav>
	</header>

	<div class="jumbotron vertical-center">
		<div class="container">
			<div class="generic-container">

				<div class="panel-heading panel">
					<span class="naglowek-napis">Formularz kontaktowy</span>
				</div>
				<form:form method="POST" modelAttribute="kontakt" class="form-horizontal">
					<form:input type="hidden" path="identyfikator" id="identyfikator" />

					<div class="row">
						<div class="form-group formularz col-md-12">
							<label class="col-md-3 control-lable" for="rodzajUbezpieczenia">Rodzaj ubezpieczenia:</label>
							<div class="col-md-3">
								<form:select path="rodzajUbezpieczenia" class="form-control">
									<form:option value="NONE" label="--- Wybierz ---" />
									<form:options items="${rodzajUbezpieczenia}" />
								</form:select>
							<div class="has-error">
								<form:errors path="rodzajUbezpieczenia" class="control-label" />
							</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group formularz col-md-12">
							<label class="col-md-3 control-lable" for="imie">Imię:</label>
							<div class="col-md-3">
								<form:input type="text" path="imie" id="imie"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="imie" class="help-inline" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group formularz col-md-12">
							<label class="col-md-3 control-lable" for="nazwisko">Nazwisko:</label>
							<div class="col-md-3">
								<form:input type="text" path="nazwisko" id="nazwisko"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="nazwisko" class="help-inline" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group formularz col-md-12">
							<label class="col-md-3 control-lable" for="numerTelefonu">Telefon:</label>
							<div class="col-md-3">
								<form:input type="text" path="numerTelefonu" id="numerTelefonu"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="numerTelefonu" class="help-inline" />
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group formularz col-md-12">
							<label class="col-md-3 control-lable" for="adresEmail">Adres
								email:</label>
							<div class="col-md-3">
								<form:input type="text" path="adresEmail" id="adresEmail"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="adresEmail" class="help-inline" />
								</div>
							</div>
						</div>
					</div>
				
					<div class="col-mg-4 text-center">
						<a class="btn btn-lg przyciskAnuluj btn-light" href="<c:url   value='/' />">Anuluj</a> 
						<input type="submit" value="Prześlij" class="btn btn-lg przycisk btn-light" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>