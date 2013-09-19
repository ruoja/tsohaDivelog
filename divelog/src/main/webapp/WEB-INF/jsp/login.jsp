<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/divelog/bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="/divelog/bootstrap-3.0.0/examples/signin/signin.css" rel="stylesheet">
        <title>Divelog</title>
    </head>

    <body>
        <h1 class="text-center">Divelog - Sukelluspäiväkirja</h1>

        <p class="text-center lead">${appDescription}</p>

        <div class="container">

            <form class="form-signin">
                <h2 class="form-signin-heading text-center">Kirjaudu sisään</h2>
                <input type="text" class="form-control" placeholder="sähköposti" autofocus>
                <input type="password" class="form-control" placeholder="salasana">
                <a href="/divelog/divestats" class="btn btn-lg btn-primary btn-block">Kirjaudu</a>
                <a href="/divelog/register" class="btn btn-lg btn-primary btn-block">Rekisteröidy</a>
            </form>

            <c:if test="${loginError != null}">
                <div class="alert alert-danger">Virhe! ${loginError}</div>
            </c:if>

        </div>
    </body>
</html>
