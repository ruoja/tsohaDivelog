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
            <div class="panel-heading text-center">Sukellus</div>
            <div class="panel-body">

                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="inputSukelluksenNumero" class="col-md-2 control-label">Sukellus no.</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputSukelluksenNumero" placeholder="Sukellus no.">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPvm" class="col-md-2 control-label">Päivämäärä</label>
                        <div class="col-md-6">
                            <input type="date" class="form-control" id="inputpvm" placeholder="Päivämäärä">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputAika" class="col-md-2 control-label">Sukellusaika</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputEtunimi" placeholder="Sukellusaika minuutteina">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPohja-aika" class="col-md-2 control-label">Pohja-aika</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputEtunimi" placeholder="Pohja-aika minuutteina">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputMaxSyvyys" class="col-md-2 control-label">Suurin syvyys</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputEtunimi" placeholder="Maksimisyvyys metreinä">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNäkyvyys" class="col-md-2 control-label">Näkyvyys</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputEtunimi" placeholder="Näkyvyys metreinä">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputIlmanLämpö" class="col-md-2 control-label">Ilman lämpötila</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputIlmanLämpö" placeholder="Ilman lämpötila">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputVedenLämpö" class="col-md-2 control-label">Veden lämpötila</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputEtunimi" placeholder="Veden lämpötila">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputLaite" class="col-md-2 control-label">Laitteen koko</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputEtunimi" placeholder="Laitteen koko">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputAlkupaine" class="col-md-2 control-label">Alkupaine</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputEtunimi" placeholder="Alkupaine bar">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputLoppupaine" class="col-md-2 control-label">Loppupaine</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputEtunimi" placeholder="Loppupaine">
                        </div>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="kaasuOptions" id="nitrox" value="nitrox" checked>
                            Nitrox
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="kaasuOptions" id="ilma" value="ilma">
                            Ilma
                        </label>
                    </div>
                    <div class="form-group">
                        <label for="inputHappiprosentti" class="col-md-2 control-label">Happiprosentti</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="inputEtunimi" placeholder="Happiprosentti">
                        </div>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="pukuOptions" id="kuivapuku" value="kuivapuku" checked>
                            Kuivapuku
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="pukuOptions" id="märkäpuku" value="märkäpuku">
                            Märkäpuku
                        </label>
                    </div>
                    <div class="form-group">
                        <label for="inputKuvaus" class="col-md-2 control-label">Kuvaus</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="inputKuvaus" placeholder="Kuvaus">
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="btn-toolbar pull-right">
            <button type="button" class="btn btn-primary">Poista</button>
            <a href="divestats" class="btn btn-primary">Peruuta</a>
            <button type="button" class="btn btn-primary">Tallenna</button>
        </div>
    </body>
</html>
