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
        <div class="panel panel-default">
            <div class="panel-heading text-center">Rekisteröidy syöttämällä tietosi</div>
            <div class="panel-body">

                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="inputEtunimi" class="col-md-2 control-label">Etunimi</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="inputEtunimi" placeholder="Etunimi">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputSukunimi" class="col-md-2 control-label">Sukunimi</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="inputSukunimi" placeholder="Sukunimi">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputLuokitus" class="col-md-2 control-label">Luokitus</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="inputLuokitus" placeholder="Sukeltajaluokka">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPuhelin" class="col-md-2 control-label">Puhelinnumero</label>
                        <div class="col-md-6">
                            <input type="tel" class="form-control" id="inputPuhelin" placeholder="Puhelinnumero">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-md-2 control-label">Email</label>
                        <div class="col-md-6">
                            <input type="email" class="form-control" id="inputEmail" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputSalasana" class="col-md-2 control-label">Salasana</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="inputSalasana" placeholder="Salasana">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputVahvistaSalasana" class="col-md-2 control-label">Vahvista salasana</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="inputVahvistaSalasana" placeholder="Salasana uudelleen">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="btn-toolbar pull-right">
            <a href="/divelog/WEB-INF/jsp/login.jsp" class="btn btn-primary">Peruuta</a>
            <a href="/divelog/WEB-INF/jsp/divestats.jsp" class="btn btn-primary">Tallenna</a>
        </div>
    </body>
</html>
