<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/divelog/bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="/divelog/bootstrap-3.0.0/dist/css/bootstrap-theme.css" rel="stylesheet">
        <link href="/divelog/bootstrap-3.0.0/dist/css/main.css" rel="stylesheet">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="/divelog/bootstrap-3.0.0/dist/js/bootstrap.min.js"></script>

        <title>Divelog</title>
    </head>

    <body>
        <ul class="nav nav-tabs">
            <li><a href="divestats">Yhteenveto</a></li>
            <li class="active"><a href="#">Sukellukset</a></li>
            <li><a href="spotlist">Kohteet</a></li>
            <li><a href="diver">Omat tiedot</a></li>

            <form action="logout">
                <button type="submit" class="btn btn-primary pull-right" >Kirjaudu ulos</button>
            </form>

        </ul>

        <div class="panel panel-default">
            <p></p>
            <div class="panel-heading text-center text-primary">Sukellukset</div>

            <div class="panel-body text-center text-info">
                <p>Valitse sukellus nähdäksesi tarkemmat tiedot ja muokataksesi sukellusta</p>
            </div>

            <table class="table">
                <thead>
                    <tr>
                        <th>Valitse</th>
                        <th>Sukelluksen no.</th>
                        <th>Pvm</th>
                        <th>Kohde</th>
                        <th>Aika</th>
                        <th>Syvyys</th>
                    </tr>

                    <c:forEach var="dive" items="${diveList}">
                        <tr>
                            <td><div class="checkbox"><input type="checkbox" value=""></div></td>
                            <td>${dive.diveNumber}</td>
                            <td>${dive.divedate}</td>
                            <td>${dive.spotNameById}</td>
                            <td>${dive.divetimeInMinutes}</td>
                            <td>${dive.maxdepth}</td>
                        </tr>
                    </c:forEach>
                </thead>
            </table>
        </div>

        <c:if test="${message != null}">
            <div class="alert alert-success">${message}</div>
        </c:if>

        <c:if test="${warningMessage != null}">
            <div class="alert alert-warning">${warningMessage}</div>
        </c:if>

        <div class="btn-toolbar pull-right">
            <button type="button" class="btn btn-primary">Näytä valittu</button>
            <button type="button" class="btn btn-primary">Poista valitut</button>
            <a href="dive" class="btn btn-primary">Lisää uusi</a>
        </div>

    </body>
</html>