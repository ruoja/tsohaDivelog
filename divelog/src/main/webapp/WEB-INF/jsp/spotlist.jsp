<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        </ul>

        <div class="panel panel-default">
            <p></p>
            <div class="panel-heading">Kohteet</div>
            <div class="panel-body">
                <p>Valitse kohde nähdäksesi tarkemmat tiedot ja muokataksesi kohdetta</p>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Nimi</th>
                        <th>Sijainti</th>
                        <th>Tyyppi</th>
                        <th>Minimisyvyys</th>
                    </tr>
                </thead>
            </table>
        </div>

        <a href="spot" class="btn btn-primary">Lisää uusi</a>
    </body>
</html>
