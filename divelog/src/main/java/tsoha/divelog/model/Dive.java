package tsoha.divelog.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tsoha.divelog.database.Database;

/**
 *
 * @author jani
 */
public class Dive {

    private int dive_id;
    private int diver_id;
    private int spot_id;
    private String diveNumber;
    private String divedate;
    private String spotname;
    private String divetimeInMinutes;
    private String bottomtimeInMinutes;
    private String maxdepth;
    private String visibility;
    private String airtemp;
    private String watertemp;
    private String suittype;
    private String tanksize;
    private String startpressure;
    private String endpressure;
    private String gastype;
    private String oxygenPercentage;
    private String description;
    private String spotNameById;

    public int getDive_id() {
        return dive_id;
    }

    public int getDiver_id() {
        return diver_id;
    }

    public int getSpot_id() {
        return spot_id;
    }

    public String getDiveNumber() {
        return diveNumber;
    }

    public String getDivedate() {
        return divedate;
    }

    public String getSpotname() {
        return spotname;
    }

    public String getDivetimeInMinutes() {
        return divetimeInMinutes;
    }

    public String getBottomtimeInMinutes() {
        return bottomtimeInMinutes;
    }

    public String getMaxdepth() {
        return maxdepth;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getAirtemp() {
        return airtemp;
    }

    public String getWatertemp() {
        return watertemp;
    }

    public String getSuittype() {
        return suittype;
    }

    public String getTanksize() {
        return tanksize;
    }

    public String getStartpressure() {
        return startpressure;
    }

    public String getEndpressure() {
        return endpressure;
    }

    public String getGastype() {
        return gastype;
    }

    public String getOxygenPercentage() {
        return oxygenPercentage;
    }

    public String getDescription() {
        return description;
    }

    public String getSpotNameById() {
        return this.spotNameById;
    }

    public Dive setDive_id(int dive_id) {
        this.dive_id = dive_id;
        return this;
    }

    public Dive setDiver_id(int diver_id) {
        this.diver_id = diver_id;
        return this;
    }

    public void setSpot_id(int spot_id) {
        this.spot_id = spot_id;
    }

    public Dive setDiveNumber(String diveNumber) {
        this.diveNumber = diveNumber;
        return this;
    }

    public Dive setDivedate(String divedate) {
        this.divedate = divedate;
        return this;
    }

    public void setSpotname(String spotname) {
        this.spotname = spotname;
    }

    public Dive setDivetimeInMinutes(String divetimeInMinutes) {
        this.divetimeInMinutes = divetimeInMinutes;
        return this;
    }

    public Dive setBottomtimeInMinutes(String bottomtimeInMinutes) {
        this.bottomtimeInMinutes = bottomtimeInMinutes;
        return this;
    }

    public Dive setMaxdepth(String maxdepth) {
        this.maxdepth = maxdepth;
        return this;
    }

    public Dive setVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    public Dive setAirtemp(String airtemp) {
        this.airtemp = airtemp;
        return this;
    }

    public Dive setWatertemp(String watertemp) {
        this.watertemp = watertemp;
        return this;
    }

    public Dive setSuittype(String suittype) {
        this.suittype = suittype;
        return this;
    }

    public Dive setTanksize(String tanksize) {
        this.tanksize = tanksize;
        return this;
    }

    public Dive setStartpressure(String startpressure) {
        this.startpressure = startpressure;
        return this;
    }

    public Dive setEndpressure(String endpressure) {
        this.endpressure = endpressure;
        return this;
    }

    public Dive setGastype(String gastype) {
        this.gastype = gastype;
        return this;
    }

    public Dive setOxygenPercentage(String oxydenPercentage) {
        this.oxygenPercentage = oxydenPercentage;
        return this;
    }

    public Dive setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Haetaan tietokannasta sukelluskohteen nimi kohteen id-numeron perusteella
     *
     * @param id sukelluskohteen yksilöivä id-numero
     * @return Kohteen nimi, jos kohde löytyy tietokannasta, muuten null.
     * @throws SQLException
     * @throws Exception
     */
    public Dive setSpotNameById(int id) throws SQLException, Exception {
        Database database = new Database();
        PreparedStatement statement = database.query("SELECT name FROM spot WHERE spot_id =?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            this.spotNameById = result.getString(1);
        } else {
            this.spotNameById = null;
        }
        statement.close();
        result.close();
        database.closeConnection();
        return this;
    }

    /**
     * Tallennetaan sukellus tietokantaan.
     *
     * @throws SQLException
     * @throws Exception
     */
    public void insertInDatabase() throws SQLException, Exception {
        Database database = new Database();
        PreparedStatement statement = database.query("INSERT INTO dive(diver_id, spot_id, divenumber, divedate, divetimeInMinutes, bottomtimeInMinutes,"
                + "maxdepth, visibility, airtemp, watertemp, suittype, tanksize, startpressure, endpressure, gastype, oxygenPercentage"
                + "description) VALUES(?, ?, ?::int, ?, ?::int, ?::int, ?::int, ?::int, ?::int, ?::int, ?, ?::int, ?::int, ?::int, ?, ?::int, ?)");
        statement.setInt(1, this.diver_id);
        statement.setInt(2, this.spot_id);
        statement.setString(3,this.diveNumber);
        statement.setString(4, this.divedate);
        statement.setString(5, this.divetimeInMinutes);
        statement.setString(6, this.bottomtimeInMinutes);
        statement.setString(7, this.maxdepth);
        statement.setString(8,this.visibility);
        statement.setString(9, this.airtemp);
        statement.setString(10, this.watertemp);
        statement.setString(11, this.suittype);
        statement.setString(12, this.tanksize);
        statement.setString(13, this.startpressure);
        statement.setString(14, this.endpressure);
        statement.setString(15, this.gastype);
        statement.setString(16, this.oxygenPercentage);
        statement.setString(17, this.description);
        statement.close();
        database.closeConnection();
    }

    public static Dive getDiveByNumber(String divenumber) throws SQLException, Exception {
        Dive dive = new Dive();
        Database database = new Database();
        PreparedStatement statement = database.query("SELECT * FROM dive WHERE divenumber=?");
        statement.setString(1, divenumber);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            dive.setDive_id(result.getInt(1));
            dive.setDiver_id(result.getInt(2));
            dive.setSpot_id(result.getInt(3));
            dive.setDiveNumber(result.getString(4));
            dive.setDivedate(result.getString(5));
            dive.setDivetimeInMinutes(result.getString(6));
            dive.setBottomtimeInMinutes(result.getString(7));
            dive.setMaxdepth(result.getString(8));
            dive.setVisibility(result.getString(9));
            dive.setAirtemp(result.getString(10));
            dive.setWatertemp(result.getString(11));
            dive.setSuittype(result.getString(12));
            dive.setTanksize(result.getString(13));
            dive.setStartpressure(result.getString(14));
            dive.setEndpressure(result.getString(15));
            dive.setGastype(result.getString(16));
            dive.setOxygenPercentage(result.getString(17));
            dive.setDescription(result.getString(18));
            statement.close();
            result.close();
            database.closeConnection();
            return dive;
        }
        statement.close();
        result.close();
        database.closeConnection();
        return dive;
    }
}
