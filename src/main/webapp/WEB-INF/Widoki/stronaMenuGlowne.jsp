	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
	<html lang="en">
		<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insurance Group</title>
		<link href="<c:url value='/zrodla/CSS/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/zrodla/CSS/bootstrap.min.css' />"  rel="stylesheet"></link>
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
	    
	    <div class="generic-container">
			<div class="panel panel-default">
				  <!-- Default panel contents -->
				<sec:authorize access="hasRole('KLIENT')">
				
	     <div class="jumbotron vertical-center">
				<div class="panel-heading"><h1 class="naglowek-napis">Witamy w systemie</h1>
		 	</div>
			<div class="col-mg-4 text-center">
		        <a class="przycisk-system-klient" href="<c:url value='/menu' />" role="button">Przejrzyj zawarte ubezpieczenie</a> 
		      </div>
	  	 </div>
	     
				 </sec:authorize>
				  <sec:authorize access="hasRole('ADMINISTRATOR')">
				  <div class="starter-template panel-administracyjny">
	        <h1>Panel administracyjny</h1>
				   </div>
				   </sec:authorize>
				   
				    <sec:authorize access="hasRole('KONSULTANT')">
				    <div class="starter-template panel-konsultanta">
	        <h1>Panel konsultanta</h1>
				   </div>
				   </sec:authorize>
				   
				  <sec:authorize access="hasRole('ADMINISTRATOR') or hasRole('KONSULTANT')">
			  		<div class="panel-heading"><span class="naglowek-napis">Klienci systemu </span></div>
					<table class="table tabelaDanych table-responsive">
			    		<thead>
				      		<tr>
				      			<th>Identyfikator ubezpieczenia</th>	
				      			<th>Identyfikator użytkownika</th>			        
						        <th>Login (adres e-mail)</th>
						        <th>Imię</th>
						        <th>Nazwisko</th>
						        <th>Dzień urodzenia</th>
						        <th>Miesiąc urodzenia</th>
						        <th>Rok urodzenia</th>
						        <th>Ulica</th>
						        <th>Numer domu / mieszkania</th>
						        <th>Kod pocztowy</th>
						   		<th>Numer telefonu:</th>
						        <th></th>
						        <sec:authorize access="hasRole('ADMINISTRATOR') or hasRole('KONSULTANT')">
						        	<th width="100"></th>
						        </sec:authorize>
						        <sec:authorize access="hasRole('ADMINISTRATOR')">
						        	<th width="100"></th>
						        </sec:authorize>
							</tr>
				    	</thead>
		    		<tbody>
					<c:forEach items="${uzytkownicy}" var="uzytkownik">
						<tr>
							<td>${uzytkownik.ubezpieczenieSamochodu.identyfikator}</td>
							<td>${uzytkownik.identyfikator}</td>
							<td>${uzytkownik.login}</td>
							<td>${uzytkownik.imie}</td>
							<td>${uzytkownik.nazwisko}</td>
							<td>${uzytkownik.dzienUrodzenia}</td>
							<td>${uzytkownik.miesiacUrodzenia}</td>
							<td>${uzytkownik.rokUrodzenia}</td>
							<td>${uzytkownik.ulica}</td>
							<td>${uzytkownik.numerDomuMieszkania}</td>
							<td>${uzytkownik.kodPocztowy}</td>
							<td>${uzytkownik.numerTelefonu}</td>
	 					    <sec:authorize access="hasRole('ADMINISTRATOR')">
								<td><a href="<c:url value='/edytujUzytkownika${uzytkownik.login}' />" class="btn btn-success custom-width">Edytuj</a></td>
	 				        </sec:authorize> 
					        <sec:authorize access="hasRole('ADMINISTRATOR')">
								<td><a href="<c:url value='/usunUzytkownika${uzytkownik.identyfikator}-${uzytkownik.ubezpieczenieSamochodu.identyfikator}' />" class="btn btn-danger custom-width">Usuń</a></td>
	        				</sec:authorize>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    	
		    	 </sec:authorize>
			</div>
	   	</div>
	   	
	   	  <sec:authorize access="hasRole('ADMINISTRATOR')">
			  		<div class="panel-heading"><span class="naglowek-napis">Pracownicy systemu </span></div>
			  	<a href="<c:url value='nowyUzytkownik' />" class="btn btn-success">Dodaj nowego użytkownika</a>
				<table class="table tabelaDanych table-responsive">
		    		<thead>
			      		<tr>	
			      			<th>Identyfikator użytkownika</th>			        
					        <th>Login (adres e-mail)</th>
					        <th>Imię</th>
					        <th>Nazwisko</th>
					        <th>Dzień urodzenia</th>
					        <th>Miesiąc urodzenia</th>
					        <th>Rok urodzenia</th>
					        <th>Ulica</th>
					        <th>Numer domu / mieszkania</th>
					        <th>Kod pocztowy</th>
					   		<th>Numer telefonu:</th>
					        <th></th>
					        <sec:authorize access="hasRole('ADMINISTRATOR')">
					        	<th width="100"></th>
					        </sec:authorize>
					        <sec:authorize access="hasRole('ADMINISTRATOR')">
					        	<th width="100"></th>
					        </sec:authorize>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${pracownicy}" var="uzytkownik">
						<tr>
							<td>${uzytkownik.identyfikator}</td>
							<td>${uzytkownik.login}</td>
							<td>${uzytkownik.imie}</td>
							<td>${uzytkownik.nazwisko}</td>
							<td>${uzytkownik.dzienUrodzenia}</td>
							<td>${uzytkownik.miesiacUrodzenia}</td>
							<td>${uzytkownik.rokUrodzenia}</td>
							<td>${uzytkownik.ulica}</td>
							<td>${uzytkownik.numerDomuMieszkania}</td>
							<td>${uzytkownik.kodPocztowy}</td>
							<td>${uzytkownik.numerTelefonu}</td>
	 					    <sec:authorize access="hasRole('ADMINISTRATOR')">
								<td><a href="<c:url value='/edytujUzytkownika${uzytkownik.login}' />" class="btn btn-success custom-width">Edytuj</a></td>
	 				        </sec:authorize> 
					        <sec:authorize access="hasRole('ADMINISTRATOR')">
								<td><a href="<c:url value='/usunPracownika${uzytkownik.identyfikator}' />" class="btn btn-danger custom-width">Usuń</a></td>
	        				</sec:authorize>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    	
		    	 </sec:authorize>
	   	
	   	<sec:authorize access="hasRole('ADMINISTRATOR') or hasRole('KONSULTANT')">
	   	<div class="panel-heading"><span class="naglowek-napis">Transakcje systemu </span></div>
				<table class="table table-responsive">
		    		<thead>
			      		<tr>
					        <th>Identyfikator transakcji</th>
					        <th>Identyfikator Ubezpieczenia</th>
					        <th>Wartość składki ubezpieczenia samochodu</th>
					        <th>Data wpłaty</th>
					        <th>Status transakcji</th>
					        <th></th>
					        <sec:authorize access="hasRole('ADMINISTRATOR')">
					        	<th width="100"></th>
					        </sec:authorize>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${transakcje}" var="transakcja">
						<tr>
							<td>${transakcja.identyfikator}</td>
							<td>${transakcja.ubezpieczenieSamochodu.identyfikator}</td>
							<td>${transakcja.wartoscSkladkiUbezpieczeniaSamochodu}</td>
							<td>${transakcja.dataWplaty}</td>
							<td>${transakcja.statusTransakcji}</td>
					        <sec:authorize access="hasRole('ADMINISTRATOR')">
								<td><a href="<c:url value='/usunTransakcje${transakcja.identyfikator}' />" class="btn btn-danger custom-width">Usuń</a></td>
	        				</sec:authorize>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    	 </sec:authorize>
	 
	 <sec:authorize access="hasRole('ADMINISTRATOR') or hasRole('KONSULTANT')">
	   	<div class="panel-heading"><span class="naglowek-napis">Formularze kontaktowe</span></div>
				<table class="table table-responsive">
		    		<thead>
			      		<tr>
			      			<th>Identyfikator formularza</th>
					        <th>Rodzaj ubezpieczenia</th>
					        <th>Imię</th>
					        <th>Nazwisko</th>
					        <th>Numer telefonu</th>
					        <th>Adres e-mail</th>
					        <th></th>
					        <sec:authorize access="hasRole('ADMINISTRATOR')">
					        	<th width="100"></th>
					        </sec:authorize>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${kontakty}" var="kontakt">
						<tr>
							<td>${kontakt.identyfikator}</td>
							<td>${kontakt.rodzajUbezpieczenia}</td>
							<td>${kontakt.imie}</td>
							<td>${kontakt.nazwisko}</td>
							<td>${kontakt.numerTelefonu}</td>
							<td>${kontakt.adresEmail}</td>
					        <sec:authorize access="hasRole('ADMINISTRATOR')">
								<td><a href="<c:url value='/usunFormularzKontaktowy${kontakt.identyfikator}' />" class="btn btn-danger custom-width">Usuń</a></td>
	        				</sec:authorize>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
	</sec:authorize>  
	</body>
</html>