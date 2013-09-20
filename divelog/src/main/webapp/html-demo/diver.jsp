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
            <li><a href="/divelog/html-demo/divestats.jsp">Yhteenveto</a></li>
            <li><a href="/divelog/html-demo/divelist.jsp">Sukellukset</a></li>
            <li><a href="/divelog/html-demo/spotslist.jsp">Kohteet</a></li>
            <li class="active"><a href="#">Omat tiedot</a></li>
        </ul>

        <div class="panel panel-default">
            <div class="panel-heading text-center">Omat Tiedot</div>
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
                        <label for="inputUusiSalasana" class="col-md-2 control-label">Uusi salasana</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="inputUusiSalasana" placeholder="Uusi salasana">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputVahvistaUusiSalasana" class="col-md-2 control-label">Vahvista salasanan vaihto</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="inputVahvistaUusiSalasana" placeholder="Uusi salasana uudelleen">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="btn-toolbar pull-right">
            <a href="/divelog/html-demo/divestats.jsp"class="btn btn-primary">Peruuta</a>
            <button type="button" class="btn btn-primary">Tallenna</button>
        </div>
    </body>
</html>