<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nowe Ubezpieczenie</title>
<link href="<c:url value='/zrodla/CSS/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/zrodla/CSS/bootstrap.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
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
			<div class="panel-heading panel">
				<span class="naglowek-napis">Dane osobowe</span>
			</div>

			<form:form method="POST" modelAttribute="uzytkownik" class="form-horizontal">
				<form:input type="hidden" path="identyfikator" id="identyfikator" />

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="firstName">Imię:</label>
						<div class="col-md-3">
							<form:input type="text" path="imie" id="firstName"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="imie" class="control-label" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="lastName">Nazwisko:</label>
						<div class="col-md-3">
							<form:input type="text" path="nazwisko" id="lastName"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="nazwisko" class="control-label" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable dataUrodzeniaLabel"
							for="dataUrodzenia">Dzień urodzenia:</label>
						<div class="col-md-2 dataUrodzenia ">
							<form:select path="dzienUrodzenia" class="form-control">
								<form:option value="NONE" label="Dzień" />
								<form:options items="${dzienUrodzenia}" />
							</form:select>
							<div class="has-error">
								<form:errors path="dzienUrodzenia" class="control-label" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable dataUrodzeniaLabel"
							for="dataUrodzenia">Miesiąc urodzenia:</label>
						<div class="col-md-2 dataUrodzenia ">
							<form:select path="miesiacUrodzenia" class="form-control">
								<form:option value="NONE" label="Miesiąc" />
								<form:options items="${miesiacUrodzenia}" />
							</form:select>
							<div class="has-error">
								<form:errors path="miesiacUrodzenia" class="control-label" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable dataUrodzeniaLabel"
							for="dataUrodzenia">Rok urodzenia:</label>
						<div class="col-md-2 dataUrodzenia ">
							<form:select path="rokUrodzenia" class="form-control">
								<form:option value="NONE" label="Rok" />
								<form:options items="${rokUrodzenia}" />
							</form:select>
							<div class="has-error">
								<form:errors path="rokUrodzenia" class="control-label" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="ulica">Ulica:</label>
						<div class="col-md-3">
							<form:input type="text" path="ulica" id="ulica"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="ulica" class="control-label" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="numerDomuMieszkania">Numer
							domu / mieszkania:</label>
						<div class="col-md-3">
							<form:input type="text" path="numerDomuMieszkania"
								id="numerDomuMieszkania" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="numerDomuMieszkania" class="control-label" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="kodPocztowy">Kod
							pocztowy</label>
						<div class="col-md-3">
							<form:input type="text" path="kodPocztowy" id="kodPocztowy"
								class="form-control input-sm" placeholder="nn-nnn" />
							<div class="has-error">
								<form:errors path="kodPocztowy" class="control-label" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="numerTelefonu">Numer
							telefonu:</label>
						<div class="col-md-3">
							<form:input type="text" path="numerTelefonu" id="numerTelefonu"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="numerTelefonu" class="control-label" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="ssoId">Login
							(adres e-mail):</label>
						<div class="col-md-3">
							<c:choose>
								<c:when test="${edycja}">
									<form:input type="text" path="login" id="ssoId"
										class="form-control input-sm" disabled="true" />
								</c:when>
								<c:otherwise>
									<form:input type="text" path="login" id="ssoId"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="login" class="control-label" />
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="password">Hasło:</label>
						<div class="col-md-3">
							<form:input type="password" path="haslo" id="password"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="haslo" class="control-label" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="powtorzHaslo">Powtórz
							hasło:</label>
						<div class="col-md-3">
							<form:input type="password" path="powtorzHaslo" id="powtorzHaslo"
								class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="powtorzHaslo" class="control-label" />
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group formularz texbox col-md-12">
						<label class="col-md-3  control-lable" for="uprawnienia">Uprawnienia:</label>
						<div class="col-md-7 texbox ">
							<form:select path="uprawnienia" class="form-control">
								<form:option value="1" label="KLIENT" />
							</form:select>
							<form:errors path="uprawnienia" class="control-label" />
						</div>
					</div>
				</div>

				<div class="col-mg-4 text-center">
					<a class="btn btn-lg przyciskAnuluj btn-light" href="<c:url   value='/anulujUbezpieczenie' />">Anuluj</a> 
					<input type="submit" value="Dalej" class="btn btn-lg przycisk btn-light" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>