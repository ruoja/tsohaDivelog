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
            <div class="panel-heading text-center">Kohde</div>
            <div class="panel-body">

                <form action="spot" method="POST" class="form-horizontal" role="form">
                    
                    <div class="form-group">
                        <label for="inputNimi" class="col-md-2 control-label">Nimi</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="inputSukelluksenNumero" placeholder="Kohteen nimi">
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="inputSijainti" class="col-md-2 control-label">Sijainti</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="inputSukelluksenNumero" placeholder="Kohteen sijainti">
                        </div>
                    </div>
                    
                    <label for="kohdeOptions" class="col-md-2 control-label">Kohdetyyppi</label>
                    <div class="radio-inline">
                        <label>
                            <input type="radio" name="kohdeOptions" id="hylky" value="hylky" checked>
                            Hylky
                        </label>
                    </div>
                    <div class="radio-inline">
                        <label>
                            <input type="radio" name="kohdeOptions" id="bio" value="bio">
                            Bio
                        </label>
                    </div>
                    <div class="radio-inline">
                        <label>
                            <input type="radio" name="kohdeOptions" id="kaivos" value="kaivos">
                            Kaivos
                        </label>
                    </div>

                    <div class="form-group">
                        <label for="inputMinimisyvyys" class="col-md-2 control-label">Minimisyvyys</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputSukelluksenNumero" placeholder="Minimisyvyys">
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="inputkuvaus" class="col-md-2 control-label">kuvaus</label>
                        <div class="col-md-6">
                            <textarea type="text" class="form-control" id="inputSukelluksenNumero" placeholder="Kuvaus" rows="8"></textarea>
                        </div>
                    </div>
                    
                </form>
            </div>
        </div>
        
        <div class="btn-toolbar pull-right">
            <button type="submit" class="btn btn-primary">Poista</button>
            <a href="spotlist" class="btn btn-primary">Peruuta</a>
            <button type="submit" class="btn btn-primary">Tallenna</button>
        </div>
    </body>
</html>
