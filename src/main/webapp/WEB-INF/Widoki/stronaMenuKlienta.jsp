	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	<!DOCTYPE html>
	<html lang="en">
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insurance Group</title>
		<link href="<c:url value='/zrodla/CSS/bootstrap.css' />" rel="stylesheet"></link>
		<link href="<c:url value='/zrodla/CSS/style.css' />" rel="stylesheet"></link>
	</head>
	<body>

	<header>
	      <nav class="navbar navbar-expand-md navbar-dark fixed-top menu-nawigacyjne">
	        <a class="navbar-brand" href="#">Insurance Group</a>
	        <div class="login-form">
	            <a href="<c:url value='/wyloguj' />" class="btn wyloguj btn-primary">Wyloguj</a>
	          </div>
	      </nav>
	    </header>
	    
	 <sec:authorize access="hasRole('KLIENT')">
		<div class="jumbotron vertical-center">
	    	<div class="container marketing">
	 
	 			<div class="panel-heading"><h1 class="naglowek-napis">Dane zawartego ubezpieczenia</h1>
	 			</div>
	 			
				<div class="panel-heading panel">
					<span class="lead">Dane osobowe</span>
				</div>
	
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="imie">Imię:</label>
						<div class="col-md-4"> ${uzytkownik.imie} </div>
				 	</div>
				</div>
					
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="nazwisko">Nazwisko:</label>
						<div class="col-md-4"> ${uzytkownik.nazwisko} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="dzienUrodzenia">Dzień urodzenia urodzenia:</label>
						<div class="col-md-4"> ${uzytkownik.dzienUrodzenia} </div>
					</div>
				</div>
					
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="miesiacUrodzenia">Miesiąc urodzenia urodzenia:</label>
						<div class="col-md-4"> ${uzytkownik.miesiacUrodzenia} </div>
					</div>
				</div>
					
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="rokUrodzenia">Rok urodzenia urodzenia:</label>
						<div class="col-md-4"> ${uzytkownik.rokUrodzenia} </div>
					</div>
			  	</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="ulica">Ulica</label>
						<div class="col-md-4"> ${uzytkownik.ulica} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="numerDomuMieszkania">Numer domu / mieszkania</label>
						<div class="col-md-4"> ${uzytkownik.numerDomuMieszkania} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="login">Login (adres e-mail)</label>
						<div class="col-md-4"> ${uzytkownik.login} </div>
					</div>
				</div>
					
				<div class="panel-heading panel">
					<span class="lead">Dane pojazdu</span>
				</div>
	
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="rokProdukcji">Rok produkcji pojazdu:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.rokProdukcjiPojazdu} </div>
					</div>
				</div>
	
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="marka">Marka:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.marka} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="model">Model:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.model} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
					<label class="col-md-3 control-lable" for="pojemnoscSilnika">Pojemność silnika [cm3]:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.pojemnoscSilnika} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="wersjaNadwozia">Wersja nadwozia:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.wersjaNadwozia} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="sredniRocznyPrzebieg">Średni roczny przebieg:</label>
					<div class="col-md-4"> ${ubezpieczenieSamochodu.sredniRocznyPrzebieg} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="zakresUbezpieczenia">Zakres ubezpieczenia:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.zakresUbezpieczenia} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="wartoscSkladkiUbezpieczenia">Wartość składki ubezpieczenia:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.wartoscSkladkiUbezpieczenia} złotych </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="czasTrwaniaUbezpieczenia">Czas trwania ubezpieczenia:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.czasTrwaniaUbezpieczenia} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="dzienWyboruRozpoczeciaUbezpieczenia">Dzień rozpoczęcia ubezpieczenia:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.dzienWyboruRozpoczeciaUbezpieczenia} </div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="miesiacWyboruRozpoczeciaUbezpieczenia">Miesiąc rozpoczęcia ubezpieczenia:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.miesiacWyboruRozpoczeciaUbezpieczenia} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="dzienWyboruRozpoczeciaUbezpieczenia">Dzień zakończenia ubezpieczenia:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.dzienWyboruRozpoczeciaUbezpieczenia} </div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="miesiacWyboruRozpoczeciaUbezpieczenia">Miesiąc zakończenia ubezpieczenia:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.miesiacWyboruRozpoczeciaUbezpieczenia} </div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="rokZakonczeniaUbezpieczenia">Rok zakończenia ubezpieczenia:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.rokZakonczeniaUbezpieczenia} </div>
					</div>
				</div>
		
			<div class="panel-heading panel">
					<span class="lead">Sczegółowe dane pojazdu</span>
				</div>
		
			<div class="row">
				<div class="form-group formularz col-md-12">
					<label class="col-md-3 control-lable" for="numerRejestracyjnyPojazdu">Numer rejestracyjny pojazdu:</label>
					<div class="col-md-4"> ${ubezpieczenieSamochodu.numerRejestracyjnyPojazdu} </div>
				</div>
			</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="numerVinPojazdu">Numer VIN pojazdu:</label>
						<div class="col-md-4"> ${ubezpieczenieSamochodu.numerVinPojazdu} </div>
					</div>
			 	</div>
	
				<div class="panel-heading panel">
					<span class="lead">Dane transakcji</span>
				</div>
	
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for="wartoscSkladkiUbezpieczeniaSamochodu">Wartość kwoty transakcji:</label>
						<div class="col-md-4"> ${transakcja.wartoscSkladkiUbezpieczeniaSamochodu} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for=dataWplaty>Data wpłaty:</label>
						<div class="col-md-4"> ${transakcja.dataWplaty} </div>
					</div>
				</div>
						
				<div class="row">
					<div class="form-group formularz col-md-12">
						<label class="col-md-3 control-lable" for=statusTransakcji>Status transakcji</label>
						<div class="col-md-4"> ${transakcja.statusTransakcji} </div>
					</div>
				</div>
			</div>	
		</div>	
	 </sec:authorize> 
	</body>
</html>