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
            <li><a href="/divelog/WEB-INF/jsp/divestats.jsp">Yhteenveto</a></li>
            <li class="active"><a href="#">Sukellukset</a></li>
            <li><a href="/divelog/WEB-INF/jsp/spotslist.jsp">Kohteet</a></li>
            <li><a href="/divelog/WEB-INF/jsp/diver.jsp">Omat tiedot</a></li>
        </ul>

        <div class="panel panel-default">
            <p></p>
            <div class="panel-heading">Sukellukset</div>
            <div class="panel-body">
                <p>Valitse sukellus nähdäksesi tarkemmat tiedot ja muokataksesi sukellusta</p>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>pvm</th>
                        <th>Kohde</th>
                        <th>Aika</th>
                        <th>Syvyys</th>
                    </tr>
                </thead>
            </table>
        </div>

        <a href="/divelog/WEB-INF/jsp/dive.jsp" class="btn btn-primary">Lisää uusi</a>
    </body>
</html>
