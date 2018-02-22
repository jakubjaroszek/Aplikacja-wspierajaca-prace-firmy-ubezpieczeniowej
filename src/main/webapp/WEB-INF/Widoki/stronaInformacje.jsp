<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Insurance Group</title>
  	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<link href="<c:url value='/zrodla/CSS/mobile.css' />"  rel="stylesheet"></link> 
  	<link href="<c:url value='/zrodla/CSS/bootstrap.css' />"  rel="stylesheet"></link> 
	<link href="<c:url value='/zrodla/CSS/bootstrap.min.css' />"  rel="stylesheet"></link> 
  	<link href="<c:url value='/zrodla/CSS/carousel.css' />"  rel="stylesheet"></link>  
	<link href="<c:url value='/zrodla/CSS/style.css' />"  rel="stylesheet"></link> 
	<link href="<c:url value='/zrodla/CSS/bootstrap-datepicker3.css' />"  rel="stylesheet"></link> 
	<link href="<c:url value='/zrodla/CSS/jquery-ui.css' />"  rel="stylesheet"></link> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="zrodla/JS/bootstrap.min.js"></script>	
	</head>
	<body>
	     <header>
	      <nav class="navbar navbar-expand-xl navbar-dark fixed-top menu-nawigacyjne">
	        <a class="navbar-brand" href="#">Insurance Group</a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
	          Menu<span class="navbar-toggler-icon"></span>
	        </button>
	        
	        <div class="collapse navbar-collapse" id="navbar">
	          <ul class="navbar-nav  mr-auto">
	            <li class="nav-item active">
	              <a class="p-2 text-white"  href="<c:url value='/stronaGlowna' />">Strona Główna </a>
	            </li>
	                <li class="nav-item active">
	              <a class="p-2 text-white" href="<c:url value='/przegladajUbezpieczenia' />">Ubezpieczenia </a>
	            </li>
	          </ul>
	            <div class="login-form">
	          	<c:url var="adresLogowania" value="/stronaGlowna"/>
	          	<form action ="${adresLogowania}" method = "post" class="form-inline mt-2 mt-md-0">
	          	<c:if test="${param.error != null}">
									<div class="alert alert-danger">
										<p>Niepoprawny login lub hasło.</p>
									</div>
								</c:if>
								<c:if test="${param.logout != null}">
									<div class="alert alert-success">
										<p>Zostałeś wylogowany pomyślnie</p>
									</div>
								</c:if>
			            <input class="form-control mr-sm-2" type="text" id ="login" name = "login" placeholder="Adres e-mail" required >
			            <input class="form-control mr-sm-2" type="password" id = "haslo" name = "haslo" placeholder="Hasło" required >
			            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" /> 
			            <button class="btn btn-success custom-width" type="submit">Zaloguj się</button>
			            <a class="p-2 text-white" href="<c:url value='/przypomnijHaslo' />">Nie pamiętam hasła </a>
	          		</form>
	          </div>
	          </div>
	      </nav>
	    </header>  
	    
	           <div class="container informacje">
	        <div class="row">
	          <div class="col-lg-12 text-center">
	            <h2 class="section-heading text-uppercase">Informacje</h2>
	          </div>
	        </div>
	        <div class="row text-center">
	          <div class="col-md-4">
	            <span class="fa-stack fa-4x">
	              <i class="fa fa-circle fa-stack-2x text-primary"></i>
	              <i class="fa fa-shopping-cart fa-stack-1x fa-inverse"></i>
	            </span>
	            <h4 class="service-heading">Autor</h4>
	             <img class="img-circle" src="<c:url value='zrodla/zdjecia/autor.jpg' />" alt="Generic placeholder image" width="140" height="140">
	             <p class="text-right">Jakub Jaroszek, jakub-jaroszek@wp.pl</p>
	          </div>
	          <div class="col-md-4">
	            <span class="fa-stack fa-4x">
	              <i class="fa fa-circle fa-stack-2x text-primary"></i>
	              <i class="fa fa-laptop fa-stack-1x fa-inverse"></i>
	            </span>
	            <h4 class="service-heading">Uczelnia</h4>
	             <img class="img-circle" src="<c:url value='zrodla/zdjecia/uczelnia.jpg' />" width="190" height="140">
	            <p class="text">Uniwersytet Technologiczno-Humanistyczny im. Kazimierza Pułaskiego w Radomiu</p>
	          </div>
	          <div class="col-md-4">
	          <h4 class="service-heading">Wydział</h4>
	           <img class="img-circle" src="<c:url value='zrodla/zdjecia/wydzial.jpg' />" width="190" height="140">
	           <p class="text">Wydział Informatyki i Matematyki</p>
	            <span class="fa-stack fa-4x">
	              <i class="fa fa-circle fa-stack-2x text-primary"></i>
	              <i class="fa fa-lock fa-stack-1x fa-inverse"></i>
	            </span>
	          </div>
	        </div>
	      </div>

	           <div class="container">
	       		 <div class="row">
	         		 <div class="col-lg-12 text-center">
	           			 <h2 class="section-heading text-uppercase">Technologie i narzędzia wykorzystane w projekcie</h2>
	         		 </div>
	        	</div>
	        	<div class="row text-center">
	          		<div class="col-md-4">
	           		 	<span class="fa-stack fa-4x">
	              	 	 <i class="fa fa-circle fa-stack-2x text-primary"></i>
	                     <i class="fa fa-shopping-cart fa-stack-1x fa-inverse"></i>
	                    </span>
	            		<h4 class="service-heading">Spring MVC</h4>
	            		<img class="img-circle" src="<c:url value='zrodla/zdjecia/technologia1.jpg' />" alt="Generic placeholder image" width="180" height="140">
	            		<p class="text">Szkielet twprzenia aplikacji</p>
	          	  </div>
	          		<div class="col-md-4">
	            		<span class="fa-stack fa-4x">
	              		<i class="fa fa-circle fa-stack-2x text-primary"></i>
	              		<i class="fa fa-laptop fa-stack-1x fa-inverse"></i>
	            		</span>
	            		<h4 class="service-heading">Hibernate</h4>
	             		<img class="img-circle" src="<c:url value='zrodla/zdjecia/technologia2.jpg' />" width="180" height="140">
	            		<p class="text">Warstwa dostępu do danych</p>
	          		</div>
	          		<div class="col-md-4">
	          			<h4 class="service-heading">Spring Security</h4>
	           			<img class="img-circle" src="<c:url value='zrodla/zdjecia/technologia3.jpg' />" width="180" height="140">
	           			<p class="text">Bezpieczeństwo</p>
	            		<span class="fa-stack fa-4x">
	              		<i class="fa fa-circle fa-stack-2x text-primary"></i>
	              		<i class="fa fa-lock fa-stack-1x fa-inverse"></i>
	            		</span>
	          		</div>
	        	</div>
	      </div>
	      
	        <div class="container">
	       	 <div class="row text-center">
	          <div class="col-md-4">
	            <span class="fa-stack fa-4x">
	              <i class="fa fa-circle fa-stack-2x text-primary"></i>
	              <i class="fa fa-shopping-cart fa-stack-1x fa-inverse"></i>
	            </span>
	            <h4 class="service-heading">Amazon Web Services</h4>
	              <img class="img-circle" src="<c:url value='zrodla/zdjecia/technologia4.jpg' />" alt="Generic placeholder image" width="180" height="140">
	            <p class="text">Hosting</p>
	          </div>
	          <div class="col-md-4">
	            <span class="fa-stack fa-4x">
	              <i class="fa fa-circle fa-stack-2x text-primary"></i>
	              <i class="fa fa-laptop fa-stack-1x fa-inverse"></i>
	            </span>
	            <h4 class="service-heading">PayPal</h4>
	            <img class="img-circle" src="<c:url value='zrodla/zdjecia/technologia5.jpg' />" alt="Generic placeholder image" width="180" height="140">
	            <p class="text">Realizacja płatności internetowych</p>
	          </div>
	          <div class="col-md-4">
	           <h4 class="service-heading">Bootstrap</h4>
	              <img class="img-circle" src="<c:url value='zrodla/zdjecia/technologia6.jpg' />" width="180" height="140">
	               <p class="text">Interfejs graficzny</p>
	            <span class="fa-stack fa-4x">
	              <i class="fa fa-circle fa-stack-2x text-primary"></i>
	              <i class="fa fa-lock fa-stack-1x fa-inverse"></i>
	            </span>
	          </div>
	        </div>
	      </div>
	      
	       <div class="container">
	        <div class="row text-center">
	          <div class="col-md-4">
	            <span class="fa-stack fa-4x">
	              <i class="fa fa-circle fa-stack-2x text-primary"></i>
	              <i class="fa fa-shopping-cart fa-stack-1x fa-inverse"></i>
	            </span>
	            <h4 class="service-heading">Eclipse</h4>
	              <img class="img-circle" src="<c:url value='zrodla/zdjecia/technologia7.jpg' />" alt="Generic placeholder image" width="180" height="140">
	            <p class="text">Środowisko programistyczne</p>
	          </div>
	          <div class="col-md-4">
	            <span class="fa-stack fa-4x">
	              <i class="fa fa-circle fa-stack-2x text-primary"></i>
	              <i class="fa fa-laptop fa-stack-1x fa-inverse"></i>
	            </span>
	            <h4 class="service-heading">Apache Maven</h4>
	            <img class="img-circle" src="<c:url value='zrodla/zdjecia/technologia8.jpg' />" alt="Generic placeholder image" width="180" height="140">
	            <p class="text">Automatyzacja budowy projektu</p>
	          </div>
	          <div class="col-md-4">
	           <h4 class="service-heading">Apache Tomcat</h4>
	              <img class="img-circle" src="<c:url value='zrodla/zdjecia/technologia9.jpg' />" width="180" height="140">
	               <p class="text">Kontener aplikacji</p>
	            <span class="fa-stack fa-4x">
	              <i class="fa fa-circle fa-stack-2x text-primary"></i>
	              <i class="fa fa-lock fa-stack-1x fa-inverse"></i>
	            </span>
	          </div>
	        </div>
	      </div>
	      
	      <div class="container">
	       	<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
	      		<h1 class="display-8 text-uppercase informacje-kolor-opis">Opis</h1>
	     			 <p class="lead">Prototyp aplikacji ma za zdanie wspierać pracę potencjalnej firmy ubezpieczeniowej. 
	      			 Aplikacja oferuję obliczenie składki ubezpieczenia samochodu, jego internetowy zakup  oraz  przegląd który wymaga zalogowania do systemu aplikacji.
	     		     W przypadku pozostałych ubezpieczeń możliwa jest opcja kontaktu za pomocą formularza. Występuje walidacja danych. 
	                 Płatność testowa jest realizowana za pomocą serwisu PayPal i interfejsu programistycznego REST API.
	                 Utworzona została również część systemu dostepna dla użyztkownika z uprawnieniami pracownika i administratora. 
	      			 </p>
	        		 <p class="leadP"> <span class="informacje-napis">Dane  sprawdzające część funkcjonalności systemu:</span>
	          			 <span class="informacje-dane"> Login oraz hasło służące do wykonania testowej płatności w serwisie PayPal:</span>
	         			 <span class="informacje-dane">-klient@aplikacja.pl / 12345678 </span>
	        			 <span class="informacje-dane">Login oraz hasło służące do zalogowania się przykładowego klienta firmy: </span>
	         			 <span class="informacje-dane">-uzytkownik@aplikacja.pl / 123</span>
	         			 <span class="informacje-dane">Login oraz hasło umożliwiające zalogowanie się jako pracownik firmy: </span>
	         			 <span class="informacje-dane">-konsultant@aplikacja.pl / 123 </span>
	         			 <span class="informacje-dane">Kod źródłowy aplikacji jest dostępny w serwisie GitHub: </span>
	          			 <span class="informacje-dane"> </span>
	   		 </div>
	     </div>
	</body>
 </html>