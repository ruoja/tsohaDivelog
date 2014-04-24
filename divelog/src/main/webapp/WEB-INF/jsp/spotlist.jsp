<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="bootstrap-3.0.0/dist/css/bootstrap-theme.css" rel="stylesheet">
        <link href="bootstrap-3.0.0/dist/css/main.css" rel="stylesheet">
        <title>Divelog</title>
    </head>

    <body>
        <div class="container text-center">
            <ul class="nav nav-tabs">
                <li><a href="divestats">Yhteenveto</a></li>
                <li><a href="divelist">Sukellukset</a></li>
                <li class="active"><a href="#">Kohteet</a></li>
                <li><a href="diver">Omat tiedot</a></li>

                <form action="logout">
                    <button type="submit" class="btn btn-primary pull-right" >Kirjaudu ulos</button>
                </form>

            </ul>

            <form action="selectspot" method="GET">

                <div class="panel panel-default">
                    <p></p>
                    <div class="panel-heading text-primary">Kohteet</div>
                    <div class="panel-body text-info">
                        <p>Valitse kohde nähdäksesi tarkemmat tiedot ja muokataksesi kohdetta</p>
                    </div>

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Valitse</th>
                                <th class="text-center">Nimi</th>
                                <th class="text-center">Sijainti</th>
                                <th class="text-center">Tyyppi</th>
                                <th class="text-center">Minimisyvyys</th>
                            </tr>

                            <c:forEach var="spot" items="${allSpots}">
                                <tr>
                                    <td><div class="radio"><input type="radio" name="spotSelection" value="${spot.spot_id}"></div></td>
                                    <td><c:out value="${spot.name}"></c:out></td>
                                    <td><c:out value="${spot.location}"></c:out></td>
                                    <td><c:out value="${spot.spottype}"></c:out></td>
                                    <td><c:out value="${spot.mindepth}"></c:out></td>
                                </tr>
                            </c:forEach>
                        </thead>
                    </table>
                </div>

                <div class="btn-toolbar pull-right">
                    <button type="submit" class="btn btn-primary">Näytä valittu</button>
                    <button type="submit" formaction="removespot" formmethod="GET" class="btn btn-primary">Poista valittu</button>
                    <a href="spot" class="btn btn-primary">Lisää uusi</a>
                </div>
            </form>
            <c:if test="${message != null}">
                <div class="alert alert-success col-md-4 text-center">${message}</div>
            </c:if>
            <c:if test="${errorMessage != null}">
                <div class="alert alert-danger col-md-4 text-center">${errorMessage}</div>
            </c:if>
        </div>
    </body>
</html>
