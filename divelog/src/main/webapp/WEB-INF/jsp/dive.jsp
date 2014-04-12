<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="bootstrap-3.0.0/dist/css/bootstrap-theme.css" rel="stylesheet">
        <link href="bootstrap-3.0.0/dist/css/main.css" rel="stylesheet">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="bootstrap-3.0.0/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/divelog.js"></script>
        <title>Divelog</title>
    </head>

    <body>
        <div class="container text-center">
            <div class="panel panel-default">
                <div class="panel-heading">Sukellus</div>
                <div class="panel-body">

                    <form class="form-horizontal" action="updatedivelist" method="POST" role="form">

                        <div class="form-group">
                            <label for="Divenumber" class="col-md-2 control-label">Sukellus no.</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="divenumber" placeholder="${defaultDiveNumber}" value="${dive.diveNumber}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Date" class="col-md-2 control-label">Päivämäärä</label>
                            <div class="col-md-6">
                                <input required type="date" class="form-control" name="date" placeholder="Päivämäärä *" value="${dive.divedate}">
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="Spot" class="col-md-2 control-label">Sukelluskohde</label>
                            <div class="col-md-6">
                                <div class="input-group">
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-default" tabindex="-1" data-toggle="collapse" data-target="#newSpot">Uusi</button>
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" tabindex="-1">
                                            <span class="caret"></span>
                                            <span class="sr-only">Toggle Dropdown</span>
                                        </button>

                                        <ul class="dropdown-menu" role="menu">
                                            <c:forEach var="spot" items="${allSpots}">
                                                <li><a href="#" data-target="#spotSelect" hidden="${spot.spot_id}">${spot.name}</a></li>
                                                </c:forEach>
                                        </ul>
                                    </div>
                                    <input type="text" class="form-control" id="spotSelect" name="spotSelect" placeholder="Sukelluskohde *" value="${spot.spot_id}" readonly>
                                </div>
                            </div>
                        </div>

                        <div class="panel-collapse collapse" id="newSpot">
                            <%@include file="newspot.jsp"%>
                        </div>


                        <div class="form-group">
                            <label for="Divetime" class="col-md-2 control-label">Sukellusaika</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="divetime" placeholder="Sukellusaika minuutteina *" value="${dive.divetimeInMinutes}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Bottomtime" class="col-md-2 control-label">Pohja-aika</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="bottomtime" placeholder="Pohja-aika minuutteina *" value="${dive.bottomtimeInMinutes}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Maxdepth" class="col-md-2 control-label">Suurin syvyys</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="maxdepth" placeholder="Maksimisyvyys metreinä *" value="${dive.maxdepth}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Visibility" class="col-md-2 control-label">Näkyvyys</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="visibility" placeholder="Näkyvyys metreinä *" value="${dive.visibility}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Airtemp" class="col-md-2 control-label">Ilman lämpötila</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="airtemp" placeholder="Ilman lämpötila *" value="${dive.airtemp}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Watertemp" class="col-md-2 control-label">Veden lämpötila</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="watertemp" placeholder="Veden lämpötila *" value="${dive.watertemp}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Tanksize" class="col-md-2 control-label">Laitteen koko</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="tanksize" placeholder="Laitteen koko *" value="${dive.tanksize}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Startpressure" class="col-md-2 control-label">Alkupaine</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="startpressure" placeholder="Alkupaine bar *" value="${dive.startpressure}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Endpressure" class="col-md-2 control-label">Loppupaine</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="endpressure" placeholder="Loppupaine *" value="${dive.endpressure}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="gasOptions" class="col-md-2 control-label">Kaasutyyppi</label>
                            <div class="col-md-4">
                                <div class="radio-inline pull-left">
                                    <label>
                                        <input required type="radio" name="gasOptions" value="nitrox" checked="${dive.gastype}">
                                        Nitrox
                                    </label>
                                </div>
                                <div class="radio-inline pull-left">
                                    <label>
                                        <input required type="radio" name="gasOptions" value="air" checked="${dive.gastype}">
                                        Ilma
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="OxygenPercentage" class="col-md-2 control-label">Happiprosentti</label>
                            <div class="col-md-6">
                                <input required type="number" class="form-control" name="oxygenPercentage" value="${dive.oxygenPercentage}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="suitOptions" class="col-md-2 control-label">Pukutyyppi</label>
                            <div class="col-md-4">
                                <div class="radio-inline pull-left">
                                    <label>
                                        <input required type="radio" name="suitOptions" value="drysuit" checked ="${dive.suittype}">
                                        Kuivapuku
                                    </label>
                                </div>
                                <div class="radio-inline pull-left">
                                    <label>
                                        <input required type="radio" name="suitOptions" value="wetsuit" checked="${dive.suittype}">
                                        Märkäpuku
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Description" class="col-md-2 control-label">Kuvaus</label>
                            <div class="col-md-6">
                                <textarea class="form-control" name="diveDescription" placeholder="Sukelluksen kuvaus" rows="8">${dive.description}</textarea>                          
                            </div>
                        </div>

                        <div class="btn-toolbar pull-right">
                            <button type="submit" formaction="removedive" formmethod="GET" class="btn btn-primary">Poista</button>
                            <a href="divelist" class="btn btn-primary">Peruuta</a>
                            <button type="submit" class="btn btn-primary">Tallenna</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
