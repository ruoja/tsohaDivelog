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
            <div class="panel panel-default">
                <div class="panel-heading">Kohde</div>
                <div class="panel-body">

                    <form action="addspot" method="GET" class="form-horizontal" role="form">

                        <div class="form-group">
                            <label for="Name" class="col-md-2 control-label">Nimi</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" name="inputName" placeholder="Kohteen nimi">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Location" class="col-md-2 control-label">Sijainti</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" name="inputLocation" placeholder="Kohteen sijainti">
                            </div>
                        </div>

                        <label for="spotOptions" class="col-md-2 control-label">Kohdetyyppi</label>
                        <div class="radio-inline">
                            <label>
                                <input type="radio" name="inputSpottype" id="inputWreck" value="wreck" checked>
                                Hylky
                            </label>
                        </div>
                        <div class="radio-inline">
                            <label>
                                <input type="radio" name="inputSpottype" id="inputBio" value="bio">
                                Bio
                            </label>
                        </div>
                        <div class="radio-inline">
                            <label>
                                <input type="radio" name="inputSpottype" id="inputmine" value="mine">
                                Kaivos
                            </label>
                        </div>

                        <div class="form-group">
                            <label for="Mindepth" class="col-md-2 control-label">Minimisyvyys</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" name="inputMindepth" placeholder="Minimisyvyys">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Description" class="col-md-2 control-label">kuvaus</label>
                            <div class="col-md-6">
                                <textarea type="text" class="form-control" name="inputDescription" placeholder="Kuvaus" rows="8"></textarea>
                            </div>
                        </div>
                        <div class="btn-toolbar pull-right">
                            <button type="submit" formaction="removespot" formmethod="POST" class="btn btn-primary">Poista</button>
                            <a href="spotlist" class="btn btn-primary">Peruuta</a>
                            <button type="submit" class="btn btn-primary">Tallenna</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
