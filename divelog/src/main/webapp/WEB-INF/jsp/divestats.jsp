<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/divelog/bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="/divelog/bootstrap-3.0.0/dist/css/bootstrap-theme.css" rel="stylesheet">
        <link href="/divelog/bootstrap-3.0.0/dist/css/main.css" rel="stylesheet">
        <link href="/divelog/bootstrap-3.0.0/examples/grid/grid.css" rel="stylesheet">
    </head>

    <body>
        <ul class="nav nav-tabs">
            <li class="active"><a href="#">Yhteenveto</a></li>
            <li><a href="divelist">Sukellukset</a></li>
            <li><a href="spotslist">Kohteet</a></li>
            <li><a href="diver">Omat tiedot</a></li>
            
            <form action="logout">
            <button type="submit" class="btn btn-primary pull-right" >Kirjaudu ulos</button>
            </form>
            
        </ul>
        
        <div class="page-header">
            <h1>Tervetuloa ${diver.diverFirstName} ${diver.diverLastName} !</h1>
            <h2>Statistiikkaa sukellukelluksistasi</h2>
        </div>
            
        <div class="row">
            <div class="col-md-4">Sukelluksia yhteensä: ${totalDives}</div>
            <div class="col-md-4">Viimeisin sukellus: ${lastDive}</div>
        </div>
            
        <div class="row">
            <div class="col-md-4">Pisin sukellus: ${longestDive}</div>
            <div class="col-md-4">Sukellusaika yhteensä: ${totalDivetime}</div>
        </div>
            
        <div class="row">
            <div class="col-md-4">Suosikkikohde: ${favoriteSpot}</div>
            <div class="col-md-4">Suurin syvyys: ${maxDepth}</div>
        </div>
            
        <div class="row">
            <div class="col-md-4">Sukelluksia Nitroxilla: ${nitroxDives}</div>
            <div class="col-md-4">Sukelluksia ilmalla: ${airDives}</div>
        </div>
            
    </body>
</html>
