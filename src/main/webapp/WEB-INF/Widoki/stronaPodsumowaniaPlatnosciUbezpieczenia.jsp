	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ page session="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
	<html lang="en">
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
		<div class="container marketing">
			<div class="panel-heading panel-wartosc-skladki"><h1 class="naglowek-napis">Podsumowanie</h1></div>
	    
			<form:form method="POST" modelAttribute="ubezpieczenieSamochodu"  class="form-horizontal">
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
						
						<div class="panel-heading panel">
							<span class="lead">Dane ubezpieczenia</span>
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
						<div class="col-md-4"> ${ubezpieczenieSamochodu.czasTrwaniaUbezpieczenia} miesięcy </div>
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
							<span class="lead">Szczegółowe dane pojazdu</span>
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
				
				<div class="form-group formularz col-md-12 ">
					<label class="col-md-3 control-label"></label>
						<div class="col-md-3">
							<div class="checkbox">
								<form:checkbox path="akceptacjaZawarciaUbezpieczenia" value="null" id="akceptacjaZawarciaUbezpieczenia" required="true" /> Zobowiązuje się do zawarcia ubezpieczenia i jego zapłaty.
							<div class="has-error">
								<form:errors path="akceptacjaZawarciaUbezpieczenia" class="control-label" />
							</div>
						</div>
					</div>
				</div>
					
					<div class="col-mg-4 text-center">
			           		<a class="btn btn-lg przyciskAnuluj btn-light" href="<c:url   value='/anulujUbezpieczenie' />">Anuluj</a>	
			           		<input type="submit" value="Zakup" class="btn btn-lg przycisk btn-light"/>  
			           </div>
				</form:form>
				</div>
			</div>
		</body>
	</html>