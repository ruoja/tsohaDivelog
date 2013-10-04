package tsoha.divelog.model;

import java.sql.Date;

/**
 *
 * @author jani
 */
public class Dive {

    private int dive_id;
    private int diver_id;
    private int spot_id;
    private int diveNumber;
    private Date divedate;
    private int divetimeInMinutes;
    private int bottomtimeInMinutes;
    private int maxdepth;
    private int visibility;
    private int airtemp;
    private int watertemp;
    private String suittype;
    private int tanksize;
    private int startpressure;
    private int endpressure;
    private String gastype;
    private int oxygenPercentage;
    private String description;

    public int getDive_id() {
        return dive_id;
    }

    public int getDiver_id() {
        return diver_id;
    }

    public int getSpot_id() {
        return spot_id;
    }

    public int getDiveNumber() {
        return diveNumber;
    }

    public Date getDivedate() {
        return divedate;
    }

    public int getDivetimeInMinutes() {
        return divetimeInMinutes;
    }

    public int getBottomtimeInMinutes() {
        return bottomtimeInMinutes;
    }

    public int getMaxdepth() {
        return maxdepth;
    }

    public int getVisibility() {
        return visibility;
    }

    public int getAirtemp() {
        return airtemp;
    }

    public int getWatertemp() {
        return watertemp;
    }

    public String getSuittype() {
        return suittype;
    }

    public int getTanksize() {
        return tanksize;
    }

    public int getStartpressure() {
        return startpressure;
    }

    public int getEndpressure() {
        return endpressure;
    }

    public String getGastype() {
        return gastype;
    }

    public int getOxygenPercentage() {
        return oxygenPercentage;
    }

    public String getDescription() {
        return description;
    }

    public Dive setDive_id(int dive_id) {
        this.dive_id = dive_id;
        return this;
    }

    public Dive setDiver_id(int diver_id) {
        this.diver_id = diver_id;
        return this;
    }

    public Dive setSpot_id(int spot_id) {
        this.spot_id = spot_id;
        return this;
    }

    public Dive setDiveNumber(int diveNumber) {
        this.diveNumber = diveNumber;
        return this;
    }

    public Dive setDivedate(Date divedate) {
        this.divedate = divedate;
        return this;
    }

    public Dive setDivetimeInMinutes(int divetimeInMinutes) {
        this.divetimeInMinutes = divetimeInMinutes;
        return this;
    }

    public Dive setBottomtimeInMinutes(int bottomtimeInMinutes) {
        this.bottomtimeInMinutes = bottomtimeInMinutes;
        return this;
    }

    public Dive setMaxdepth(int maxdepth) {
        this.maxdepth = maxdepth;
        return this;
    }

    public Dive setVisibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public Dive setAirtemp(int airtemp) {
        this.airtemp = airtemp;
        return this;
    }

    public Dive setWatertemp(int watertemp) {
        this.watertemp = watertemp;
        return this;
    }

    public Dive setSuittype(String suittype) {
        this.suittype = suittype;
        return this;
    }

    public Dive setTanksize(int tanksize) {
        this.tanksize = tanksize;
        return this;
    }

    public Dive setStartpressure(int startpressure) {
        this.startpressure = startpressure;
        return this;
    }

    public Dive setEndpressure(int endpressure) {
        this.endpressure = endpressure;
        return this;
    }

    public Dive setGastype(String gastype) {
        this.gastype = gastype;
        return this;
    }

    public Dive setOxygenPercentage(int oxydenPercentage) {
        this.oxygenPercentage = oxydenPercentage;
        return this;
    }

    public Dive setDescription(String description) {
        this.description = description;
        return this;
    }
}
