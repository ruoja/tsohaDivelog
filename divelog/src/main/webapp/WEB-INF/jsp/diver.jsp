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
                        <label for="inputEtunimi" class="col-md-2 control-label">Etunimi</label>
                        <div class="col-md-6">
                            <input required type="text" class="form-control" id="Etunimi" value="${firstName}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputSukunimi" class="col-md-2 control-label">Sukunimi</label>
                        <div class="col-md-6">
                            <input required type="text" class="form-control" id="Sukunimi" value="${lastName}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputLuokitus" class="col-md-2 control-label">Luokitus</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="Luokitus" value="${classification}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputPuhelin" class="col-md-2 control-label">Puhelinnumero</label>
                        <div class="col-md-6">
                            <input type="tel" class="form-control" id="Puhelin" value="${phonenumber}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputEmail" class="col-md-2 control-label">Email</label>
                        <div class="col-md-6">
                            <input required type="email" class="form-control" id="Email" value="${email}">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputSalasana" class="col-md-2 control-label">Salasana</label>
                        <div class="col-md-6">
                            <input required type="password" class="form-control" id="Salasana" placeholder="Salasana">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputUusiSalasana" class="col-md-2 control-label">Uusi salasana</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="UusiSalasana" placeholder="Uusi salasana">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputVahvistaUusiSalasana" class="col-md-2 control-label">Vahvista salasanan vaihto</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="VahvistaUusiSalasana" placeholder="Vahvista uusi salasana">
                        </div>
                    </div>

                    <div class="btn-toolbar pull-right">
                        <button type="submit" formaction="removediver" formmethod="POST" class="btn btn-primary">Poista</button>
                        <a href="divestats" class="btn btn-primary">Peruuta</a>
                        <button type="submit" class="btn btn-primary">Tallenna</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
