<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/divelog/bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="/divelog/bootstrap-3.0.0/dist/css/bootstrap-theme.css" rel="stylesheet">
        <link href="/divelog/bootstrap-3.0.0/dist/css/main.css" rel="stylesheet">
        <title>Divelog</title>
    </head>

    <body>
        <ul class="nav nav-tabs">
            <li><a href="divestats">Yhteenveto</a></li>
            <li><a href="divelist">Sukellukset</a></li>
            <li class="active"><a href="#">Kohteet</a></li>
            <li><a href="diver">Omat tiedot</a></li>

            <form action="logout">
                <button type="submit" class="btn btn-primary pull-right" >Kirjaudu ulos</button>
            </form>

        </ul>

        <div class="panel panel-default">
            <p></p>
            <div class="panel-heading text-center text-primary">Kohteet</div>
            <div class="panel-body text-center text-info">
                <p>Valitse kohde nähdäksesi tarkemmat tiedot ja muokataksesi kohdetta</p>
            </div>

            <table class="table">
                <thead>
                    <tr>
                        <th>Valitse</th>
                        <th>Nimi</th>
                        <th>Sijainti</th>
                        <th>Tyyppi</th>
                        <th>Minimisyvyys</th>
                    </tr>

                    <c:forEach var="spot" items="${allSpots}">
                        <tr>
                            <td><div class="checkbox"><input type="checkbox" name="spotSelection" id="selectedSpot" value="${spot.name}"></div>
                            <td>${spot.name}</td>
                            <td>${spot.location}</td>
                            <td>${spot.spottype}</td>
                            <td>${spot.mindepth}</td>
                        </tr>
                    </c:forEach>
                </thead>
            </table>
        </div>

        <div class="btn-toolbar pull-right">
            <button type="button" class="btn btn-primary">Näytä valittu</button>
            <button type="button" class="btn btn-primary">Poista valitut</button>
            <a href="spot" class="btn btn-primary">Lisää uusi</a>
        </div>

    </body>

</html>