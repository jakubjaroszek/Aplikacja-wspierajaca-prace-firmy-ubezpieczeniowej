<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insurance Group</title>
<link href="<c:url value='/zrodla/CSS/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/zrodla/CSS/bootstrap.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/zrodla/CSS/carousel.css' />" rel="stylesheet"></link>
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
		<div class="panel-heading panel">
			<span class="naglowek-napis">Formularz obliczenia składki ubezpieczenia</span>
		</div>

		<form:form method="POST" modelAttribute="ubezpieczenieSamochodu" class="form-horizontal">
			<form:input type="hidden" path="identyfikator" id="identyfikator" />

			<div class="row">
				<div class="form-group formularz col-md-12">
						<label class="col-md-3 wyrownanie-pola-rok-produkcji-pojazdu control-lable"
						for="rokProdukcji">Rok produkcji pojazdu:</label>
					<div class="col-md-2">
						<form:select path="rokProdukcjiPojazdu" class="form-control">
							<form:option value="NONE" label="--- Wybierz ---" />
							<form:options items="${rokProdukcjiPojazdu}" />
						</form:select>
						<div class="has-error">
							<form:errors path="rokProdukcjiPojazdu" class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group formularz col-md-12">
					<label class="col-md-3 wyrownanie-pola-marka control-lable"
						for="marka">Marka:</label>
					<div class="col-md-2">
						<form:select path="marka" class="form-control">
							<form:option value="NONE" label="--- Wybierz ---" />
							<form:options items="${marka}" />
						</form:select>
						<div class="has-error">
							<form:errors path="marka" class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group formularz col-md-12">
					<label class="col-md-3 wyrownanie-pola-model control-lable"
						for="model">Model:</label>
					<div class="col-md-2">
						<form:input type="text" path="model" id="model"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="model" class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group formularz col-md-12">
					<label
						class="col-md-3 wyrownanie-pola-pojemnosc-silnika control-lable"
						for="pojemnoscSilnika">Pojemność silnika [cm3]:</label>
					<div class="col-md-2">
						<form:select path="pojemnoscSilnika" class="form-control">
							<form:option value="NONE" label="--- Wybierz ---" />
							<form:options items="${pojemnoscSilnika}" />
						</form:select>
						<div class="has-error">
							<form:errors path="pojemnoscSilnika" class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group formularz col-md-12">
					<label
						class="col-md-3 wyrownanie-pola-wersja-nadwozia control-lable"
						for="wersjaNadwozia">Wersja nadwozia</label>
					<div class="col-md-2">
						<form:select path="wersjaNadwozia" class="form-control">
							<form:option value="NONE" label="--- Wybierz ---" />
							<form:options items="${wersjaNadwozia}" />
						</form:select>
						<div class="has-error">
							<form:errors path="wersjaNadwozia" class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group formularz col-md-12">
					<label
						class="col-md-3 wyrownanie-pola-sredni-roczny-przebieg control-lable"
						for="sredniRocznyPrzebieg">Średni roczny przebieg [km]:</label>
					<div class="col-md-2">
						<form:select path="sredniRocznyPrzebieg" class="form-control">
							<form:option value="NONE" label="--- Wybierz ---" />
							<form:options items="${sredniRocznyPrzebiegKm}" />
						</form:select>
						<div class="has-error">
							<form:errors path="sredniRocznyPrzebieg" class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group formularz col-md-12">
					<label
						class="col-md-3 wyrownanie-pola-rok-wydania-prawa-jazdy control-lable"
						for="rokWydaniaPrawaJazdy">Rok wydania prawa jazdy:</label>
					<div class="col-md-2">
						<form:select path="rokWydaniaPrawaJazdy" class="form-control">
							<form:option value="NONE" label="--- Wybierz ---" />
							<form:options items="${rokWydaniaPrawaJazdy}" />
						</form:select>
						<div class="has-error">
							<form:errors path="rokWydaniaPrawaJazdy" class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group formularz col-md-12">
					<label
						class="col-md-3 wyrownanie-pola-kier-pon-26-roku-zycia control-lable"
						for="kierowcyPonizej26RokuZycia">Kierowcy poniżej 26 roku
						życia:</label>
					<div class="col-md-2">
						<form:select path="kierowcyPonizej26RokuZycia"
							class="form-control">
							<form:option value="NONE" label="--- Wybierz ---" />
							<form:options items="${kierowcyPonizej26RokuZycia}" />
						</form:select>
						<div class="has-error">
							<form:errors path="kierowcyPonizej26RokuZycia"
								class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group formularz col-md-12">
					<label
						class="col-md-3 wyrownanie-pola-liczba-lat-jazd-bezszkod control-lable"
						for="liczbaLatJazdyBezszkodowej">Liczba lat jazdy
						bezszkodowej:</label>
					<div class="col-md-2">
						<form:select path="liczbaLatJazdyBezszkodowej"
							class="form-control">
							<form:option value="NONE" label="--- Wybierz ---" />
							<form:options items="${liczbaLatJazdyBezszkod}" />
						</form:select>
						<div class="has-error">
							<form:errors path="liczbaLatJazdyBezszkodowej"
								class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group formularz col-md-12">
					<label
						class="col-md-3 wyrownanie-pola-zakres-ubezpieczenia control-lable"
						for="liczbaLatJazdyBezszkodowej">Zakres Ubezpieczenia:</label>
					<div class="col-md-2">
						<form:select path="zakresUbezpieczenia" class="form-control">
							<form:option value="NONE" label="--- Wybierz ---" />
							<form:options items="${zakresUbezpieczenia}" />
						</form:select>
						<div class="has-error">
							<form:errors path="zakresUbezpieczenia" class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="row ">
				<div class="form-group formularz col-md-12">
					<label
						class="col-md-3 wyrownanie-pola-data-rozp-ubezpieczenia control-lable"
						for="dataRozpoczeciaUbezpieczenia">Miesiąc rozpoczęcia
						ubezpieczenia:</label>
					<div class="col-md-2 ">
						<form:select path="miesiacWyboruRozpoczeciaUbezpieczenia"
							class="form-control">
							<form:option value="0" label="Miesiąc" />
							<form:options items="${miesiacWyboruRozpoczeciaUbezpieczenia}" />
						</form:select>
						<div class="has-error">
							<form:errors path="miesiacWyboruRozpoczeciaUbezpieczenia"
								class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="row ">
				<div class="form-group formularz col-md-12">
					<label
						class="col-md-3 wyrownanie-pola-data-rozp-ubezpieczenia control-lable"
						for="dataRozpoczeciaUbezpieczenia">Dzień rozpoczęcia
						ubezpieczenia:</label>
					<div class="col-md-2">
						<form:select path="dzienWyboruRozpoczeciaUbezpieczenia"
							class="form-control">
							<form:option value="0" label="Dzień" class="dzien" />
							<form:options items="${dzienWyboruRozpoczeciaUbezpieczenia}" />
						</form:select>
						<div class="has-error">
							<form:errors path="dzienWyboruRozpoczeciaUbezpieczenia"
							class="control-label" />
						</div>
					</div>
				</div>
			</div>

			<div class="col-mg-4 text-center">
				<a class="btn btn-lg przyciskAnuluj btn-light" href="<c:url   value='/' />">Anuluj</a> 
				<input type="submit" value="Oblicz składkę" class="btn btn-lg przycisk btn-light" />
			</div>
		</form:form>
	</div>
</body>
</html>