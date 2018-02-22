	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
	<html lang="en">
	<head>
	<title>Insurance Group</title>
	  	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  	<link href="<c:url value='/zrodla/CSS/bootstrap.css' />"  rel="stylesheet"></link> 
		<link href="<c:url value='/zrodla/CSS/bootstrap.min.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/zrodla/JS/bootstrap.min.js' />"  rel="stylesheet"></link>  
	  	<link href="<c:url value='/zrodla/CSS/carousel.css' />"  rel="stylesheet"></link>  
		<link href="<c:url value='/zrodla/CSS/style.css' />"  rel="stylesheet"></link> 
		<link href="<c:url value='/zrodla/CSS/mobile.css' />"  rel="stylesheet"></link> 
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
		
		<div id="myCarousel" class="carousel slide container" data-ride="carousel">
	        <ol class="carousel-indicators">
	          <li data-target="#myCarousel" data-slide-to="0" class="active" ></li>
	          <li data-target="#myCarousel" data-slide-to="1"></li>
	          <li data-target="#myCarousel" data-slide-to="2"></li>
	        </ol>
	        <div class="carousel-inner">
	          <div class="carousel-item active">
	            <img class="zdjecie-karuzela" src="zrodla/zdjecia/baner-reklamowy.jpg" alt="First slide" style="width:100%;">
	              <div class="carousel-caption text-right">
	                <h1 class="tekst-karuzela-1">Ubezpieczenie OC i AC samochodu</h1>
	                <p class="tekst-karuzela-2">Czas wyruszyć w drogę..</p>
	              </div>
	          </div>
	          <div class="carousel-item">
	            <img class="zdjecie-karuzela" src="zrodla/zdjecia/baner2.jpg" alt="Second slide" style="width:100%;">
	              <div class="carousel-caption text-right">
	                <h1 class="tekst-karuzela-1" >Życie to najcenniejszy dar</h1>
	                <p class="tekst-karuzela-2">Zadbaj o nie</p>
	              </div>
	          </div>
	          <div class="carousel-item">
	            <img class="zdjecie-karuzela" src="zrodla/zdjecia/baner3.jpg" alt="Third slide" style="width:100%;">
	              <div class="carousel-caption text-right">
	                <h1 class="tekst-karuzela-1">Wszędzie dobrze ale w domu najlepiej </h1>
	                <p class="tekst-karuzela-2">Pakiet majątkowy z pewnością spełni twoje oczekiwania</p>
	              </div>
	          </div>
	        </div>
	        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
	          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	          <span class="sr-only">Previous</span>
	        </a>
	        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
	          <span class="carousel-control-next-icon" aria-hidden="true"></span>
	          <span class="sr-only">Next</span>
	        </a>
	      </div> 
	      
	    <div class="container marketing tekst-szczegoly-ubezpieczenia">
	      <div class="row">
	        <div class="col-lg-4">
	          <img class="img-circle" src="zrodla/zdjecia/samochod.jpg" alt="Generic placeholder image" width="140" height="140">
	          <h2>Samochód</h2>
	          <p>Pakiet ubezpieczenia OC I AC lub wymagane OC. Samochód to jeden z najpopularniejszych środków transportu. Oblicz składkę już dziś!</p>
	          <p>
	          <a class="btn btn-primary" href="<c:url value='/przegladajUbezpieczenia' />" role="button">Dowiedz się więcej</a>
	          <a class="btn przycisk btn-light" href="<c:url value='/noweUbezpieczenie' />" role="button">Oblicz składkę &raquo;</a>
	          </p>
	        </div>
	        <div class="col-lg-4">
	          <img class="img-circle" src="zrodla/zdjecia/dom.jpg" alt="Generic placeholder image" width="140" height="140">
	          <h2>Dom / Mieszkanie</h2>
	          <p>Ubezpieczenie domu lub mieszkania. Dowiedz się więcej lub zamów kontakt a my oddzwonimy.</p>
	          <p>
	          <a class="btn btn-primary" href="<c:url value='/przegladajUbezpieczenia' />" role="button">Dowiedz się więcej</a>
	          <a class="btn przycisk btn-light" href="<c:url value='/kontakt' />" role="button">Zamów kontakt &raquo;</a>
	          </p>
	        </div>
	        <div class="col-lg-4">
	          <img class="img-circle" src="zrodla/zdjecia/zycie.jpg" width="140" height="140">
	          <h2>Życie</h2>
	          <p>Ubezpieczenie na życie. Ochrona siebie i najbliższych. Dowiedz się więcej lub zamów kontakt a my oddzwonimy.</p>
	          <p>
	          <a class="btn btn-primary" href="<c:url value='/przegladajUbezpieczenia' />" role="button">Dowiedz się więcej</a>
	          <a class="btn przycisk btn-light" href="<c:url value='/kontakt' />" role="button">Zamów kontakt &raquo;</a>
	          </p>
	        </div>
	      </div>
	
	      <hr class="featurette-divider">
	      <div class="row featurette">
	        <div class="col-md-7">
	          <h2 class="featurette-heading">Misja <span class="text-muted"></span></h2>
	          <p> Naszą Misją  jest wzmocnić w  klientach poczucie spokoju i bezpieczeństwa poprzez dostarczenie rozwiązań, 
	          które chronią przed skutkami wydarzeń zagrażających życiu, zdrowiu, mieniu i dorobkowi.</p>
	        </div>
	        <div class="col-md-5">
	          <img class="featurette-image img-responsive center-block" src="zrodla/zdjecia/misja.jpg" alt="Generic placeholder image">
	        </div>
	      </div>
	
	      <hr class="featurette-divider">
	      <div class="row featurette">
	        <div class="col-md-7 col-md-push-5">
	          <h2 class="featurette-heading">Odpowiedzialność <span class="text-muted"></span></h2>
	          <p>Czujemy się zobowiązani do zdobywania i dzielenia się naszymi umiejętnościami, aby w ten sposób pomagać naszym klientom zrozumieć zagrożenia dla życia i zdrowia ich samych oraz ich rodzin.
	           Oferując klientom nasze produkty i usługi, dajemy im możliwość minimalizowania skutków finansowych tych zagrożeń.</p>
	        </div>
	        <div class="col-md-5 col-md-pull-7">
	          <img class="featurette-image img-responsive center-block" src="zrodla/zdjecia/odpowiedzialnosc.jpg" alt="Generic placeholder image">
	        </div>
	      </div>
	
	      <hr class="featurette-divider">
	      <div class="row featurette">
	        <div class="col-md-7">
	          <h2 class="featurette-heading">Wiedza i doświadczenie <span class="text-muted"></span></h2>
	          <p>Posiadamy szeroką wiedzę związaną z rynkiem ubezpieczeń, dzięki umiejętnemu śledzeniu rynku potrafimy wychodzić na przeciw zmieniąjącym się standardom.
	           Doświadczenie zdobyte przez naszych pracowników pozwala na efektywną i szybką pomoc naszym klientom. </p>
	        </div>
	        <div class="col-md-5">
	          <img class="featurette-image img-responsive center-block" src="zrodla/zdjecia/doswiadczenie.jpg" alt="Generic placeholder image">
	        </div>
	      </div>
	
	      <hr class="featurette-divider">
	      <footer>
	        <p class="pull-right"><a href="#">Powrót do góry</a></p>
	        <p>&copy; 2018</p>
	      </footer>
	    </div>
	</body>
</html>