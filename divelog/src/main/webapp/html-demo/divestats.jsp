<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="../bootstrap-3.0.0/dist/css/bootstrap-theme.css" rel="stylesheet">
        <link href="../bootstrap-3.0.0/dist/css/main.css" rel="stylesheet">
        <title>Divelog</title>
    </head>

    <body>
        <ul class="nav nav-tabs">
            <li class="active"><a href="#">Yhteenveto</a></li>
            <li><a href="/divelog/html-demo/divelist.jsp">Sukellukset</a></li>
            <li><a href="/divelog/html-demo/divespots.jsp">Kohteet</a></li>
            <li><a href="/divelog/html-demo/editdiver.jsp">Omat tiedot</a></li>
        </ul>
        <div class="container">
            <h1>Yhteenveto sukelluksistasi</h1>
            <p>Erkki Esimerkki sinulla on yhteensä ### sukellusta</p>
            <p>Tähän tuodaan dynaamisesti tietokannasta kirjautuneen käyttäjän tekemien sukellusten yhteenveto<br/>
                Tämä toimii käyttäjän etusivuna.
            </p>
        </div>   
    </body>
</html>
