<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/divelog/bootstrap-3.0.0/dist/css/bootstrap.css" rel="stylesheet">
        <link href="/divelog/bootstrap-3.0.0/dist/css/bootstrap-theme.css" rel="stylesheet">
        <link href="/divelog/bootstrap-3.0.0/dist/css/main.css" rel="stylesheet">
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script type="text/javascript" src="/divelog/bootstrap-3.0.0/dist/js/bootstrap.min.js"></script>

        <title>Divelog</title>
    </head>

    <body>
        <div class="panel panel-default">
            <div class="panel-heading text-center">Sukellus</div>
            <div class="panel-body ">

                <div class="panel-body">

                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label for="inputDivenumber" class="col-md-2 control-label">Sukellus no.</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputDivenumber" placeholder="Sukelluksen no.">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputDate" class="col-md-2 control-label">Päivämäärä</label>
                            <div class="col-md-6">
                                <input type="date" class="form-control" id="inputDate" placeholder="Päivämäärä">
                            </div>
                        </div>

                        <div class="btn-group">
                            <button type="button" class="btn-default">Lisää uusi kohde</button>

                            <div class="btn-group">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                    Valitse kohde
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <c:forEach var="spot" items="${allSpots}">
                                        <li><a href="#">${spot.name}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputDivetime" class="col-md-2 control-label">Sukellusaika</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputDivetime" placeholder="Sukellusaika minuutteina">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputBottomtime" class="col-md-2 control-label">Pohja-aika</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputBottomtime" placeholder="Pohja-aika minuutteina">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputMaxdepth" class="col-md-2 control-label">Suurin syvyys</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputMaxdepth" placeholder="Maksimisyvyys metreinä">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputVisibility" class="col-md-2 control-label">Näkyvyys</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputVisibility" placeholder="Näkyvyys metreinä">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputAirtemp" class="col-md-2 control-label">Ilman lämpötila</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputAirtemp" placeholder="Ilman lämpötila">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputWatertemp" class="col-md-2 control-label">Veden lämpötila</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputWatertemp" placeholder="Veden lämpötila">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputTanksize" class="col-md-2 control-label">Laitteen koko</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputTanksize" placeholder="Laitteen koko">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputStartpressure" class="col-md-2 control-label">Alkupaine</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputStartpressure" placeholder="Alkupaine bar">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputEndpressure" class="col-md-2 control-label">Loppupaine</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputEndpressure" placeholder="Loppupaine">
                            </div>
                        </div>

                        <label for="gasOptions" class="col-md-2 control-label">Kaasutyyppi</label>
                        <div class="radio-inline">
                            <label>
                                <input type="radio" name="gasOptions" id="nitrox" value="nitrox" checked>
                                Nitrox
                            </label>
                        </div>
                        <div class="radio-inline">
                            <label>
                                <input type="radio" name="gasOptions" id="air" value="air">
                                Ilma
                            </label>
                        </div>

                        <div class="form-group">
                            <label for="inputOxygenPercentage" class="col-md-2 control-label">Happiprosentti</label>
                            <div class="col-md-6">
                                <input type="number" class="form-control" id="inputOxygenPercentage" placeholder="Happiprosentti">
                            </div>
                        </div>

                        <label for="suitOptions" class="col-md-2 control-label">Pukutyyppi</label>
                        <div class="radio-inline">
                            <label>
                                <input type="radio" name="suitOptions" id="kuivapuku" value="drysuit" checked>
                                Kuivapuku
                            </label>
                        </div>
                        <div class="radio-inline">
                            <label>
                                <input type="radio" name="suitOptions" id="wetsuit" value="wetsuit">
                                Märkäpuku
                            </label>
                        </div>

                        <div class="form-group">
                            <label for="inputDescription" class="col-md-2 control-label">Kuvaus</label>
                            <div class="col-md-6">
                                <textarea class="form-control" id="inputDescription" placeholder="Kuvaus" rows="8"></textarea>                          
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <form action="adddive" method="POST" class="btn-toolbar pull-right">
                <button type="submit" formaction="removedive" formmethod="POST" class="btn btn-primary">Poista</button>
                <a href="divelist" class="btn btn-primary">Peruuta</a>
                <button type="submit" class="btn btn-primary">Tallenna</button>
            </form>
    </body>
</html>
