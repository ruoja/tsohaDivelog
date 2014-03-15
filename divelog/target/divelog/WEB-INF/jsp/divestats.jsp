<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
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
            <li><a href="spotlist">Kohteet</a></li>
            <li><a href="diver">Omat tiedot</a></li>

            <form action="logout">
                <button type="submit" class="btn btn-primary pull-right" >Kirjaudu ulos</button>
            </form>
        </ul>

        <div class="page-header">
            <h1>Tervetuloa ${loggedInDiver.diverFirstName} ${loggedInDiver.diverLastName} !</h1>
            <h2>Statistiikkaa sukellukelluksistasi:</h2>
        </div>

        <div class="row">
            <div class="col-md-4">Sukelluksia yhteensä: ${loggedInDiver.totalDives}</div>
            <div class="col-md-4">Viimeisin sukellus: ${loggedInDiver.lastDiveDate}</div>
        </div>

        <div class="row">
            <div class="col-md-4">Pisin sukellus: ${loggedInDiver.longestDive} min</div>
            <div class="col-md-4">Sukellusaika yhteensä: ${loggedInDiver.totalDivetime} min</div>
        </div>

        <div class="row">
            <div class="col-md-4">Suosikkikohde: ${loggedInDiver.favoriteSpot}</div>
            <div class="col-md-4">Suurin syvyys: ${loggedInDiver.maxDepth} m</div>
        </div>

        <div class="row">
            <div class="col-md-4">Sukelluksia Nitroxilla: ${loggedInDiver.nitroxDives}</div>
            <div class="col-md-4">Sukelluksia ilmalla: ${loggedInDiver.airDives}</div>
        </div>

    </body>
</html>
