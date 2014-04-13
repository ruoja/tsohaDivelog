<div class="form-group">
    <label for="Name" class="col-md-2 control-label">Nimi</label>
    <div class="col-md-6">
        <input required="" type="text" class="form-control" name="name" placeholder="Kohteen nimi" value="${spot.name}">
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
                <input type="radio" name="spottype" id="wreck" value="wreck">
                Hylky
            </label>
        </div>
        <div class="radio-inline pull-left">
            <label>
                <input type="radio" name="spottype" id="bio" value="bio">
                Bio
            </label>
        </div>
        <div class="radio-inline pull-left">
            <label>
                <input type="radio" name="spottype" id="mine" value="mine">
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
        <input required="" type="number" class="form-control" name="mindepth" placeholder="Minimisyvyys kohteella" value="${spot.mindepth}">
    </div>
</div>

<div class="form-group">
    <label for="Description" class="col-md-2 control-label">kuvaus</label>
    <div class="col-md-6">
        <textarea class="form-control" name="spotDescription" placeholder="Kohteen kuvaus" rows="8">${spot.description}</textarea>
    </div>
</div>




