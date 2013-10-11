package tsoha.divelog.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tsoha.divelog.database.DatabaseQuery;

/**
 *
 * @author jani
 */
public class Diver extends DatabaseQuery {

    private int diverId;
    private String diverFirstname;
    private String diverLastname;
    private String diverClass;
    private String diverPhone;
    private String diverEmail;
    private String diverPswd;
    private List<Dive> diveList = new ArrayList<Dive>();

    public int getDiverId() {
        return diverId;
    }

    public String getDiverFirstName() {
        return diverFirstname;
    }

    public String getDiverLastName() {
        return diverLastname;
    }

    public String getDiverClass() {
        return diverClass;
    }

    public String getDiverPhone() {
        return diverPhone;
    }

    public String getDiverEmail() {
        return diverEmail;
    }

    public String getDiverPswd() {
        return diverPswd;
    }

    public List<Dive> getDiveList() {
        return diveList;
    }

    private Diver setDiverId(int diverId) {
        this.diverId = diverId;
        return this;
    }

    public Diver setDiverFirstName(String diverFirstName) {
        this.diverFirstname = diverFirstName;
        return this;
    }

    public Diver setDiverLastName(String diverLastName) {
        this.diverLastname = diverLastName;
        return this;
    }

    public Diver setDiverClass(String diverClass) {
        this.diverClass = diverClass;
        return this;
    }

    public Diver setDiverPhone(String diverPhone) {
        this.diverPhone = diverPhone;
        return this;
    }

    public Diver setDiverEmail(String diverEmail) {
        this.diverEmail = diverEmail;
        return this;
    }

    public Diver setDiverPswd(String diverPswd) {
        this.diverPswd = diverPswd;
        return this;
    }

    public Diver setDiveList(List<Dive> diveList) {
        this.diveList = diveList;
        return this;
    }

    /**
     * Haetaan tietokannasta sukeltajan tiedot kirjautmistietojen perusteella.
     *
     * @param email sukeltajan käyttäjätunnuksena käytettävä email-osoite
     * @param pswd sukeltajan salasana
     * @return kirjautunut sukeltaja
     * @throws SQLException
     * @throws Exception
     */
    public boolean getDiverByLogin(String email, String pswd) throws SQLException, Exception {
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT * FROM diver WHERE email=? AND pswd=?");
        statement.setString(1, email);
        statement.setString(2, pswd);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            this.setDiverId(result.getInt(1));
            this.setDiverFirstName(result.getString(2));
            this.setDiverLastName(result.getString(3));
            this.setDiverClass(result.getString(4));
            this.setDiverPhone(result.getString(5));
            this.setDiverEmail(result.getString(6));
            this.setDiveList(getDivelistByDiverId(this.diverId));
            return true;
        }
        return false;
    }

    /**
     * Haetaan lista sukeltajan kirjaamista sukelluksista sukeltajan id-numeron
     * perusteella.
     *
     * @param id sukeltajan yksilöivä id-numero
     * @return lista sukeltajan kirjaamista sukelluksista
     * @throws SQLException
     * @throws Exception
     */
    private List<Dive> getDivelistByDiverId(int id) throws SQLException, Exception {
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT * FROM dive WHERE diver_id=?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            Dive dive = new Dive();
            dive.setDive_id(result.getInt(1));
            dive.setSpot_id(result.getInt(3));
            dive.setSpotNameById(result.getInt(3));
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
            diveList.add(dive);
        }
        return diveList;
    }

    /**
     *
     * @return kirjattujen sukellusten määrä
     */
    public int getTotalDives() {
        return this.diveList.size();
    }

    /**
     * haetaan viimeisimmän sukelluksen ajankohta
     *
     * @return edellisen sukelluksen päivämäärä. null jos sukelluksia ei ole
     */
    public String getLastDiveDate() {
        if (this.diveList.isEmpty()) {
            return null;
        } else {
            int dives = diveList.size() - 1;
            String lastDive = diveList.get(dives).getDivedate();
            return lastDive;
        }
    }

    /**
     * haetaan tietokannasta pisin sukellusaika
     *
     * @return pisin sukellusaika minuutteina
     * @throws SQLException
     * @throws Exception
     */
    public int getLongestDive() throws SQLException, Exception {
        int id = diverId;
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT MAX(divetime) FROM dive WHERE diver_id=?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getInt(1);
        }
        return 0;
    }

    /**
     * haetaan tietokannasta kaikkien sukellusten yhteiskesto
     *
     * @return sukellusten yhteiskesto minuutteina
     * @throws SQLException
     * @throws Exception
     */
    public int getTotalDivetime() throws SQLException, Exception {
        int id = diverId;
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT SUM(divetime) FROM dive WHERE diver_id=?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getInt(1);
        }
        return 0;
    }

    /**
     * haetaan tietokannasta suosituimman kohteen nimi
     *
     * @return sen kohteen nimi jossa sukeltajalla on eniten sukelluksia
     * @throws SQLException
     * @throws Exception
     */
    public String getFavoriteSpot() throws SQLException, Exception {
        int id = diverId;
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT name from spot WHERE spot_id="
                + "(SELECT spot_id FROM dive WHERE diver_id=? GROUP BY spot_id ORDER BY COUNT(*) DESC LIMIT 1)");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getString(1);
        }
        return "Et ole lisännyt yhtään kohdetta.";
    }

    /**
     * haetaan tietokannasta syvin sukellus
     *
     * @return suurin sukellussyvyys metreinä
     * @throws SQLException
     * @throws Exception
     */
    public int getMaxDepth() throws SQLException, Exception {
        int id = diverId;
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT MAX(maxdepth) FROM dive WHERE diver_id=?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getInt(1);
        }
        return 0;
    }

    /**
     * haetaan tietokannasta sukellukset joissa kaasutyyppinä on nitrox
     *
     * @return nitrox-sukellusten lukumäärä
     * @throws SQLException
     * @throws Exception
     */
    public int getNitroxDives() throws SQLException, Exception {
        int id = diverId;
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT COUNT(gastype) FROM dive WHERE diver_id=? AND gastype='nitrox'");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getInt(1);
        }
        return 0;
    }

    /**
     * haetaan tietokannasta sukellukset joissa kaasutyyppinä on ilma
     *
     * @return ilmasukellusten lukumäärä
     * @throws SQLException
     * @throws Exception
     */
    public int getAirDives() throws SQLException, Exception {
        int id = diverId;
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT COUNT(gastype) FROM dive WHERE diver_id=? AND gastype='air'");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getInt(1);
        }
        return 0;
    }

    /**
     * tallennetaan sukeltajan tiedot tietokantaan
     *
     * @throws SQLException
     * @throws Exception
     */
    public void insertInDatabase() throws SQLException, Exception {
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("INSERT INTO diver(firstname,lastname,classification,phonenumber,email,pswd) VALUES(?,?,?,?,?,?)");
        statement.setString(1, this.diverFirstname);
        statement.setString(2, this.diverLastname);
        statement.setString(3, this.diverClass);
        statement.setString(4, this.diverPhone);
        statement.setString(5, this.diverEmail);
        statement.setString(6, this.diverPswd);
        statement.executeUpdate();
    }
}
