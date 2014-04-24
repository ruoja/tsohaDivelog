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

                    <form action="updatespotlist" method="POST" class="form-horizontal" role="form">

                        <input type="hidden" name="spotSelection" value="${spot.spot_id}">
                        <div class="form-group">
                            <label for="Name" class="col-md-2 control-label">Nimi</label>
                            <div class="col-md-6">
                                <input required type="text" class="form-control" name="name" placeholder="Kohteen nimi" value="${spot.name}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Location" class="col-md-2 control-label">Sijainti</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" name="location" placeholder="Kohteen sijainti" value="${spot.location}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="spotOptions" class="col-md-2 control-label">Kohdetyyppi</label>
                            <div class="col-md-4">
                                <div class="radio-inline pull-left">
                                    <label>
                                        <input required type="radio" name="spottype" id="wreck" value="wreck">
                                        Hylky
                                    </label>
                                </div>
                                <div class="radio-inline pull-left">
                                    <label>
                                        <input required type="radio" name="spottype" id="bio" value="bio">
                                        Bio
                                    </label>
                                </div>
                                <div class="radio-inline pull-left">
                                    <label>
                                        <input required type="radio" name="spottype" id="mine" value="mine">
                                        Kaivos
                                    </label>
                                </div>
                                <div class="col-md-4">
                                    <span class="help-block"><b>${spot.spottype}</b></span>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Mindepth" class="col-md-2 control-label">Minimisyvyys</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="mindepth" placeholder="Minimisyvyys kohteella" value="${spot.mindepth}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Description" class="col-md-2 control-label">kuvaus</label>
                            <div class="col-md-6">
                                <textarea class="form-control" name="spotDescription" placeholder="Kohteen kuvaus" rows="8">${spot.description}</textarea>
                            </div>
                        </div>
                        <div class="btn-toolbar pull-right">
                            <button type="submit" formaction="removespot" formmethod="GET" class="btn btn-primary">Poista</button>
                            <a href="spotlist" class="btn btn-primary">Peruuta</a>
                            <button type="submit" class="btn btn-primary">Tallenna</button>
                        </div>

                    </form>
                    <c:if test="${errorMessage != null}">
                        <div class="alert alert-danger col-md-4 text-center">${errorMessage}</div>
                    </c:if>
                    <c:if test="${errors != null}">
                        <div class="alert alert-danger col-md-4 text-center">${errors}</div>
                    </c:if> 
                </div>
            </div>
        </div>
    </body>
</html>
