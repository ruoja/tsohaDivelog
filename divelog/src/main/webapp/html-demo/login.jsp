<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Divelog</title>
    </head>

    <body>
        <h1>Divelog - Sukelluspäiväkirja</h1>
    </body>

    <p>Tähän lyhyt, muutaman rivin esittelyteksti ohjelmasta ja sen käytöstä.</br>
        Pidä kirjaa sukelluksistasi ja sukelluskohteistasi. Aloita jo tänään!</p>
    <a href="/divelog/html-demo/register.jsp"> Rekisteröidy käyttäjäksi</a>

    <p>Kirjaudu sisään:</p>
    <p>
    <form>
        <label>Käyttäjätunnus: <input type="text" name="tunnus" /></label></br>
        <label>Salasana: <input type="password" name="salasana" /></label></br>
        <input type="submit" value="kirjaudu" />
    </form>
</p>
</html>
