<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
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

                <form action="register" method="POST" class="form-horizontal">
                    <div class="form-group">
                        <label for="inputEtunimi" class="col-md-2 control-label">Etunimi</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="inputEtunimi" placeholder="Etunimi">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputSukunimi" class="col-md-2 control-label">Sukunimi</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="inputSukunimi" placeholder="Sukunimi">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputLuokitus" class="col-md-2 control-label">Luokitus</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="inputLuokitus" placeholder="Sukeltajaluokka">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputPuhelin" class="col-md-2 control-label">Puhelinnumero</label>
                        <div class="col-md-6">
                            <input type="tel" class="form-control" name="inputPuhelin" placeholder="Puhelinnumero">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputEmail" class="col-md-2 control-label">Email</label>
                        <div class="col-md-6">
                            <input type="email" class="form-control" name="inputEmail" placeholder="Email">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputSalasana" class="col-md-2 control-label">Salasana</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" name="inputSalasana" placeholder="Salasana">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputVahvistaSalasana" class="col-md-2 control-label">Vahvista salasana</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" name="inputVahvistaSalasana" placeholder="Salasana uudelleen">
                        </div>
                    </div>

                    <div class="btn-toolbar pull-right">
                        <button type="submit" formaction="login" formmethod="GET" class="btn btn-primary">Peruuta</button>
                        <button type="submit" class="btn btn-primary">Tallenna</button>

                    </div>
                </form>
            </div>
        </div>
        <c:if test="${errorMessage != null}">
            <div class="alert alert-danger">${errorMessage}</div>
        </c:if>
    </body>
</html>
