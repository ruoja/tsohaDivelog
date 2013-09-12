<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="../bootstrap-3.0.0/examples/signin/signin.css" rel="stylesheet">
        <title>Divelog</title>
    </head>

    <body>
        <h1 class="text-center">Divelog - Sukelluspäiväkirja</h1>

        <p class="text-center lead">Tähän lyhyt, muutaman rivin esittelyteksti ohjelmasta ja sen käytöstä.</br>
            Pidä kirjaa sukelluksistasi ja sukelluskohteistasi. Aloita jo tänään!</p>

        <div class="container">

            <form class="form-signin">
                <h2 class="form-signin-heading">Kirjaudu sisään</h2>
                <input type="text" class="form-control" placeholder="sähköposti" autofocus>
                <input type="password" class="form-control" placeholder="salasana">
                <a href="/divelog/html-demo/divestats.jsp" class="btn btn-lg btn-primary btn-block">Kirjaudu</a>
                <a href="/divelog/html-demo/register.jsp" class="btn btn-lg btn-primary btn-block">Rekisteröidy</a>
            </form>

        </div>
    </body>
</html>
