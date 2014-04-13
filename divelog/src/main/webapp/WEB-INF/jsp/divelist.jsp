<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="bootstrap-3.0.0/dist/css/bootstrap-theme.css" rel="stylesheet">
        <link href="bootstrap-3.0.0/dist/css/main.css" rel="stylesheet">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="bootstrap-3.0.0/dist/js/bootstrap.min.js"></script>
        <title>Divelog</title>
    </head>

    <body>
        <div class="container text-center">
            <ul class="nav nav-tabs">
                <li><a href="divestats">Yhteenveto</a></li>
                <li class="active"><a href="#">Sukellukset</a></li>
                <li><a href="spotlist">Kohteet</a></li>
                <li><a href="diver">Omat tiedot</a></li>

                <form action="logout">
                    <button type="submit" class="btn btn-primary pull-right" >Kirjaudu ulos</button>
                </form>
            </ul>

            <form action="selectdive" method="GET">
                <div class="panel panel-default">
                    <p></p>
                    <div class="panel-heading text-primary">Sukellukset</div>

                    <div class="panel-body text-info">
                        <p>Valitse sukellus nähdäksesi tarkemmat tiedot ja muokataksesi sukellusta</p>
                    </div>

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Valitse</th>
                                <th class="text-center">Sukelluksen no.</th>
                                <th class="text-center">Pvm</th>
                                <th class="text-center">Kohde</th>
                                <th class="text-center">Aika</th>
                                <th class="text-center">Syvyys</th>
                            </tr>

                            <c:forEach var="dive" items="${diveList}">
                                <tr>
                                    <td><div class="radio"><input type="radio" name="diveSelection" value="${dive.dive_id}"></div></td>
                                    <td>${dive.diveNumber}</td>
                                    <td>${dive.divedate}</td>
                                    <td>${dive.spotNameById}</td>
                                    <td>${dive.divetimeInMinutes}</td>
                                    <td>${dive.maxdepth}</td>
                                </tr>
                            </c:forEach>
                        </thead>
                    </table>

                    <div class="btn-toolbar pull-right">
                        <button type="submit" class="btn btn-primary">Näytä valittu</button>
                        <button type="submit" formaction="removedive" formmethod="GET" class="btn btn-primary">Poista valittu</button>
                        <a href="dive" class="btn btn-primary">Lisää uusi</a>
                    </div>
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
