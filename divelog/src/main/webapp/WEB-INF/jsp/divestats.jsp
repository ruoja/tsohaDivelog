<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="bootstrap-3.0.0/dist/css/bootstrap-theme.css" rel="stylesheet">
        <link href="bootstrap-3.0.0/dist/css/main.css" rel="stylesheet">
        <link href="bootstrap-3.0.0/examples/grid/grid.css" rel="stylesheet">
        <title>Divelog</title>
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

        <div class="container">
            <div class="page-header">
                <h1>Tervetuloa <c:out value="${loggedInDiver.diverFirstName} ${loggedInDiver.diverLastName}!"></c:out></h1>
                <h2>Statistiikkaa sukelluksistasi:</h2>
            </div>
            <div class="row">
                <div class="col-md-4">Sukelluksia yhteensä: <c:out value="${loggedInDiver.totalDives}"></c:out></div>
            <div class="col-md-4">Viimeisin sukellus: <c:out value="${loggedInDiver.lastDiveDate}"></c:out></div>
            </div>

            <div class="row">
                <div class="col-md-4">Pisin sukellus: <c:out value="${loggedInDiver.longestDive} min"></c:out></div>
            <div class="col-md-4">Sukellusaika yhteensä: <c:out value="${loggedInDiver.totalDivetime} min"></c:out></div>
            </div>

            <div class="row">
                <div class="col-md-4">Suosikkikohde: <c:out value="${loggedInDiver.favoriteSpot}"></c:out></div>
            <div class="col-md-4">Suurin syvyys: <c:out value="${loggedInDiver.maxDepth} m"></c:out></div>
            </div>

            <div class="row">
                <div class="col-md-4">Sukelluksia Nitroxilla: <c:out value="${loggedInDiver.nitroxDives}"></c:out></div>
            <div class="col-md-4">Sukelluksia ilmalla: <c:out value="${loggedInDiver.airDives}"></c:out></div>
            </div>
        </div>
    </body>
</html>
