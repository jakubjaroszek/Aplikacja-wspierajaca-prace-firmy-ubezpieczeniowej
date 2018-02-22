	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<link href="<c:url value='/zrodla/CSS/mobile.css' />"  rel="stylesheet"></link> 
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="zrodla/JS/bootstrap.min.js"></script>
	</head>
	<body>
	  <header>
	      <nav class="navbar navbar-expand-xl navbar-dark fixed-top menu-nawigacyjne">
	        <a class="navbar-brand" href="#">Insurance Group</a>
	         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	         <div class="collapse navbar-collapse" id="navbar">
	          <ul class="navbar-nav  mr-auto">
	            <li class="nav-item active">
	              <a class="p-2 text-white"  href="/stronaGlowna">Strona Główna </a>
	            </li>
	             <li class="nav-item active">
              		<a class="p-2 text-white" href="<c:url value='/informacje' />">Informacje </a>
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
	
	 <div class="container marketing">
	    <div class="panel-heading panel-opis"><h1 class="naglowek-napis">Rodzaje ubezpieczeń</h1></div>
	    
			<hr class="featurette-divider">
	     	 <div class="row featurette">
	       	 	<div class="col-md-7">
		          <h2 class="featurette-heading">Ubezpieczenie samochodu <span class="text-muted"></span></h2>
		          <p class=""> <span class="przegladaj-ubezpieczenia-napis">Co otrzymasz dzięki naszemu ubezpieczeniu:</span>
		          <span class="przegladaj-ubezpieczenia-dane"><i class="fa fa-check przegladaj-ubezpieczenia-znak-wyboru" aria-hidden="true">
		          </i> Holowanie, pojazd zastępczy i inne usługi</span>
		          <span class="przegladaj-ubezpieczenia-dane"><i class="fa fa-check przegladaj-ubezpieczenia-znak-wyboru" aria-hidden="true">
		          </i>Szybka naprawa uszkodzonego samochodu. Zgłoś szkodę i zapomnij o kłopocie</span>
		          <span class="przegladaj-ubezpieczenia-dane"><i class="fa fa-check przegladaj-ubezpieczenia-znak-wyboru" aria-hidden="true">
		          </i> W razie wypadku, stłuczki, kradzieży, zniszczenia karoserii przez grad pomoże Ci  nasze ubezpieczenie AC</span>
	          	  <a class="btn przycisk btn-light" href="<c:url value='/noweUbezpieczenie' />" role="button">Oblicz składkę &raquo;</a>
	          	</p>
	        </div>
	        <div class="col-md-5">
	          <img class="featurette-image img-responsive center-block" src="zrodla/zdjecia/przegladajSamochod.jpg" alt="Generic placeholder image">
	        </div>
	      </div>
	
	      <hr class="featurette-divider">
	      	<div class="row featurette">
		        <div class="col-md-7 col-md-push-5">
		          <h2 class="featurette-heading">Ubezpieczenie domu / mieszkania <span class="text-muted"></span></h2>
		          <p class=""> <span class="przegladaj-ubezpieczenia-napis">Co otrzymasz dzięki naszemu ubezpieczeniu:</span>
		          <span class="przegladaj-ubezpieczenia-dane"><i class="fa fa-check przegladaj-ubezpieczenia-znak-wyboru" aria-hidden="true"></i> Odszkodowanie za uszkodzone, zniszczone, skradzione wyposażenie domu lub mieszkania</span>
		           <span class="przegladaj-ubezpieczenia-dane"><i class="fa fa-check przegladaj-ubezpieczenia-znak-wyboru" aria-hidden="true"></i> Odszkodowanie za zniszczenie, uszkodzenie domu w budowie.</span>
		           <a class="btn przycisk btn-light" href="<c:url value='/kontakt' />" role="button">Zamów kontakt &raquo;</a>
		           </p>
		       </div>
	        <div class="col-md-5 col-md-pull-7">
	          <img class="featurette-image img-responsive center-block" src="zrodla/zdjecia/przegladajDom.jpg" alt="Generic placeholder image">
	        </div>
	     </div>
	
	      <hr class="featurette-divider">
	      <div class="row featurette">
	        <div class="col-md-7">
	          <h2 class="featurette-heading">Ubezpieczenie na życie <span class="text-muted"></span></h2>
	          <p class=""><span class="przegladaj-ubezpieczenia-napis">Co otrzymasz dzięki naszemu ubezpieczeniu:</span>
	          	<span class="przegladaj-ubezpieczenia-dane"><i class="fa fa-check przegladaj-ubezpieczenia-znak-wyboru" aria-hidden="true"></i> Wsparcie finansowe po nieszczęśliwym wypadku</span>
	         	<span class="przegladaj-ubezpieczenia-dane"><i class="fa fa-check przegladaj-ubezpieczenia-znak-wyboru" aria-hidden="true"></i> Pieniądze z ubezpieczenia są zwolnione z podatku od spadków i darowizn oraz od zysków kapitałowych</span>
	         	<span class="przegladaj-ubezpieczenia-dane"><i class="fa fa-check przegladaj-ubezpieczenia-znak-wyboru" aria-hidden="true"></i> Składka już od złotówki dziennie</span>
	          	<a class="btn przycisk btn-light" href="<c:url value='/kontakt' />" role="button">Zamów kontakt &raquo;</a>
	          </p>
	        </div>
	        <div class="col-md-5">
	          <img class="featurette-image img-responsive center-block" src="zrodla/zdjecia/przegladajZycie.jpg" alt="Generic placeholder image">
	        </div>
	      </div>
	  </div>
	</body>
</html>