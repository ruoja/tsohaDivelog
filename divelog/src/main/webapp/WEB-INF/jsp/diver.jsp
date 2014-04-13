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
                <li><a href="spotlist">Kohteet</a></li>
                <li class="active"><a href="#">Omat tiedot</a></li>

                <form action="logout">
                    <button type="submit" class="btn btn-primary pull-right" >Kirjaudu ulos</button>
                </form>
            </ul>

            <div class="panel panel-default">
                <div class="panel-heading">Omat tiedot</div>
                <div class="panel-body text-info">
                    <p>Muokkaa omia tietojasi.</p>
                </div>

                <form action="diver" method="POST" class="form-horizontal">
                    <div class="form-group">
                        <label for="Etunimi" class="col-md-2 control-label">Etunimi</label>
                        <div class="col-md-6">
                            <input required type="text" class="form-control" name="firstName" value="${firstName}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="Sukunimi" class="col-md-2 control-label">Sukunimi</label>
                        <div class="col-md-6">
                            <input required type="text" class="form-control" name="lastName" value="${lastName}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="Luokitus" class="col-md-2 control-label">Luokitus</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="classification" value="${classification}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="Puhelin" class="col-md-2 control-label">Puhelinnumero</label>
                        <div class="col-md-6">
                            <input type="tel" class="form-control" name="phonenumber" value="${phonenumber}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="Email" class="col-md-2 control-label">Email</label>
                        <div class="col-md-6">
                            <input required type="email" class="form-control" name="email" value="${email}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="Salasana" class="col-md-2 control-label">Salasana</label>
                        <div class="col-md-6">
                            <input required type="password" class="form-control" name="password" placeholder="Salasana">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="UusiSalasana" class="col-md-2 control-label">Uusi salasana</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" name="newPassword" placeholder="Uusi salasana">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="VahvistaUusiSalasana" class="col-md-2 control-label">Vahvista salasanan vaihto</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" name="newPasswordAgain" placeholder="Vahvista uusi salasana">
                        </div>
                    </div>

                    <div class="btn-toolbar pull-right">
                        <button type="submit" formaction="removediver" formmethod="GET" class="btn btn-primary">Poista</button>
                        <a href="divestats" class="btn btn-primary">Peruuta</a>
                        <button type="submit" class="btn btn-primary">Tallenna</button>
                    </div>
                </form>
                <c:if test="${message != null}">
                    <div class="alert alert-success col-md-4 text-center">${message}</div>
                </c:if>
                <c:if test="${errorMessage != null}">
                    <div class="alert alert-danger col-md-4 text-center">${errorMessage}</div>
                </c:if>
            </div>
        </div>
    </body>
</html>
