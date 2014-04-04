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
        <title>Divelog</title>
    </head>

    <body>
        <div class="container text-center">
            <div class="panel panel-default">
                <div class="panel-heading">Sukellus</div>
                <div class="panel-body">

                    <form class="form-horizontal" action="dive" method="GET" role="form">

                        <div class="form-group">
                            <label for="Divenumber" class="col-md-2 control-label">Sukellus no.</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputDivenumber" placeholder="Sukelluksen no.">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Date" class="col-md-2 control-label">Päivämäärä</label>
                            <div class="col-md-6">
                                <input type="date" class="form-control" id="inputDate" placeholder="Päivämäärä">
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="Date" class="col-md-2 control-label">Sukelluskohde</label>
                            <div class="col-md-6">
                                <div class="input-group">
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-default" tabindex="-1" data-toggle="collapse" data-target="#add" onclick="changeContent()">Uusi</button>
                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" tabindex="-1">
                                            <span class="caret"></span>
                                            <span class="sr-only">Toggle Dropdown</span>
                                        </button>

                                        <ul class="dropdown-menu" role="menu">
                                            <c:forEach var="spot" items="${allSpots}">
                                                <li><a href="#">${spot.name}</a></li>
                                                </c:forEach>
                                        </ul>

                                    </div>
                                    <input type="text" class="form-control" id="spotname" placeholder="Sukelluskohde">
                                </div>
                                <div class="panel-collapse collapse" id="add">
                                    <div class="panel-body" id="addBody" >
                                        <script> function changeContent() {
                                                $('#addSpot').load('spot.jsp');
                                            }
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="Divetime" class="col-md-2 control-label">Sukellusaika</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputDivetime" placeholder="Sukellusaika minuutteina">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Bottomtime" class="col-md-2 control-label">Pohja-aika</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputBottomtime" placeholder="Pohja-aika minuutteina">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Maxdepth" class="col-md-2 control-label">Suurin syvyys</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputMaxdepth" placeholder="Maksimisyvyys metreinä">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Visibility" class="col-md-2 control-label">Näkyvyys</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputVisibility" placeholder="Näkyvyys metreinä">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Airtemp" class="col-md-2 control-label">Ilman lämpötila</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputAirtemp" placeholder="Ilman lämpötila">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Watertemp" class="col-md-2 control-label">Veden lämpötila</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputWatertemp" placeholder="Veden lämpötila">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Tanksize" class="col-md-2 control-label">Laitteen koko</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputTanksize" placeholder="Laitteen koko">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Startpressure" class="col-md-2 control-label">Alkupaine</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputStartpressure" placeholder="Alkupaine bar">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Endpressure" class="col-md-2 control-label">Loppupaine</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputEndpressure" placeholder="Loppupaine">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="gasOptions" class="col-md-2 control-label">Kaasutyyppi</label>
                            <div class="col-md-4">
                                <div class="radio-inline pull-left">
                                    <label>
                                        <input type="radio" name="gasOptions" id="nitrox" value="nitrox">
                                        Nitrox
                                    </label>
                                </div>
                                <div class="radio-inline pull-left">
                                    <label>
                                        <input type="radio" name="gasOptions" id="air" value="air" checked>
                                        Ilma
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="OxygenPercentage" class="col-md-2 control-label">Happiprosentti</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputOxygenPercentage" value="21">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="suitOptions" class="col-md-2 control-label">Pukutyyppi</label>
                            <div class="col-md-4">
                                <div class="radio-inline pull-left">
                                    <label>
                                        <input type="radio" name="suitOptions" id="kuivapuku" value="drysuit" checked>
                                        Kuivapuku
                                    </label>
                                </div>
                                <div class="radio-inline pull-left">
                                    <label>
                                        <input type="radio" name="suitOptions" id="wetsuit" value="wetsuit">
                                        Märkäpuku
                                    </label>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="Description" class="col-md-2 control-label">Kuvaus</label>
                            <div class="col-md-6">
                                <textarea class="form-control" id="inputDescription" placeholder="Kuvaus" rows="8"></textarea>                          
                            </div>
                        </div>

                        <div class="btn-toolbar pull-right">
                            <button type="submit" formaction="removedive" formmethod="POST" class="btn btn-primary">Poista</button>
                            <a href="divelist" class="btn btn-primary">Peruuta</a>
                            <button type="submit" class="btn btn-primary">Tallenna</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
