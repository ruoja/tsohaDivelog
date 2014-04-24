package tsoha.divelog.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import tsoha.divelog.database.Database;

/**
 *
 * @author jani
 */
public class Diver {

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
     * Haetaan tietokannasta sukeltajan tiedot kirjautumistietojen perusteella.
     *
     * @param email sukeltajan käyttäjätunnuksena käytettävä email-osoite
     * @param pswd sukeltajan salasana
     * @return true jos sukeltaja löytyy, muuten false
     */
    public boolean loginDiver(String email, String pswd) {
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT * FROM diver WHERE email=? AND pswd=?");
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
                setDivelistByDiverId(this.diverId);
                statement.close();
                result.close();
                database.closeConnection();
                return true;
            }
            statement.close();
            result.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Haetaan lista sukeltajan kirjaamista sukelluksista sukeltajan id-numeron
     * perusteella.
     *
     * @param id sukeltajan yksilöivä id-numero
     * @return lista sukeltajan kirjaamista sukelluksista
     */
    public List<Dive> setDivelistByDiverId(int diver_id) {
        try {
            this.diveList.clear();
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT * FROM dive WHERE diver_id=? ORDER BY divedate");
            statement.setInt(1, diver_id);
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
                this.diveList.add(dive);
            }
            statement.close();
            result.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.diveList;
    }

    public List<Dive> addNewDive(Dive dive) {
        this.diveList.add(dive);
        return this.diveList;
    }

    public void clearDives() {
        this.diveList.clear();
    }

    /**
     * Poistetaan sukellus ja päivitetään samalla sukeltajan sukelluslistaa
     *
     * @param dive_id
     * @param diver_id
     * @return Päivitetty sukelluslista
     */
    public List<Dive> deleteDiveById(int dive_id, int diver_id) {
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("DELETE FROM dive WHERE dive_id = ?");
            statement.setInt(1, dive_id);
            statement.executeUpdate();
            statement.close();
            database.closeConnection();
            this.diveList.clear();
            this.diveList = setDivelistByDiverId(diver_id);
        } catch (SQLException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.diveList;

    }

    /**
     * Haetaan sukelluksen kirjaussivulle näkyviin seuraavan sukelluksen
     * oletusnumero, eli yhtä suurempi kuin nyt kannassa olava suurin
     * järjestysnumero.
     *
     * @return sukelluksen oletusnumero
     */
    public int defaultDiveNumber() {
        try {
            int id = diverId;
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT MAX(divenumber) FROM dive WHERE diver_id=?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int maxdivenumber = result.getInt(1);
                statement.close();
                result.close();
                return maxdivenumber + 1;
            }
            statement.close();
            result.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
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
     */
    public int getLongestDive() {
        try {
            int id = diverId;
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT MAX(divetime) FROM dive WHERE diver_id=?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int longest = result.getInt(1);
                statement.close();
                result.close();
                return longest;
            }
            statement.close();
            result.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * haetaan tietokannasta kaikkien sukellusten yhteiskesto
     *
     * @return sukellusten yhteiskesto minuutteina
     */
    public int getTotalDivetime() {
        try {
            int id = diverId;
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT SUM(divetime) FROM dive WHERE diver_id=?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int totaltime = result.getInt(1);
                statement.close();
                result.close();
                return totaltime;
            }
            statement.close();
            result.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * haetaan tietokannasta suosituimman kohteen nimi
     *
     * @return sen kohteen nimi jossa sukeltajalla on eniten sukelluksia
     */
    public String getFavoriteSpot() {
        try {
            int id = diverId;
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT name from spot WHERE spot_id="
                    + "(SELECT spot_id FROM dive WHERE diver_id=? GROUP BY spot_id ORDER BY COUNT(*) DESC LIMIT 1)");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String favourite = result.getString(1);
                statement.close();
                result.close();
                database.closeConnection();
                return favourite;
            }
            statement.close();
            result.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Et ole lisännyt yhtään kohdetta.";
    }

    /**
     * haetaan tietokannasta syvin sukellus
     *
     * @return suurin sukellussyvyys metreinä
     */
    public int getMaxDepth() {
        try {
            int id = diverId;
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT MAX(maxdepth) FROM dive WHERE diver_id=?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int maxdepth = result.getInt(1);
                statement.close();
                result.close();
                database.closeConnection();
                return maxdepth;
            }
            statement.close();
            result.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * haetaan tietokannasta sukellukset joissa kaasutyyppinä on nitrox
     *
     * @return nitrox-sukellusten lukumäärä
     */
    public int getNitroxDives() {
        try {
            int id = diverId;
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT COUNT(gastype) FROM dive WHERE diver_id=? AND gastype='nitrox'");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int nitroxDives = result.getInt(1);
                statement.close();
                result.close();
                database.closeConnection();
                return nitroxDives;
            }
            statement.close();
            result.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * haetaan tietokannasta sukellukset joissa kaasutyyppinä on ilma
     *
     * @return ilmasukellusten lukumäärä
     */
    public int getAirDives() {
        try {
            int id = diverId;
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT COUNT(gastype) FROM dive WHERE diver_id=? AND gastype='air'");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int airDives = result.getInt(1);
                statement.close();
                result.close();
                database.closeConnection();
                return airDives;
            }
            statement.close();
            result.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * tallennetaan sukeltajan tiedot tietokantaan
     */
    public void insertInDatabase() {
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("INSERT INTO diver(firstname,lastname,classification,phonenumber,email,pswd) VALUES(?,?,?,?,?,?)");
            statement.setString(1, this.diverFirstname);
            statement.setString(2, this.diverLastname);
            statement.setString(3, this.diverClass);
            statement.setString(4, this.diverPhone);
            statement.setString(5, this.diverEmail);
            statement.setString(6, this.diverPswd);
            statement.executeUpdate();
            statement.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * päivitetään sukeltajan tiedot
     *
     * @param id
     */
    public void updateDiver(int id) {
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("UPDATE diver SET firstname = ?, lastname = ?, classification = ?, phonenumber = ?, email = ?, pswd = ?"
                    + "WHERE diver_id = ?");
            statement.setString(1, this.diverFirstname);
            statement.setString(2, this.diverLastname);
            statement.setString(3, this.diverClass);
            statement.setString(4, this.diverPhone);
            statement.setString(5, this.diverEmail);
            statement.setString(6, this.diverPswd);
            statement.setInt(7, id);
            statement.executeUpdate();
            statement.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * vaihdetaan sukeltajan salasana
     *
     * @param id
     * @param pswd
     */
    public void changePswd(int id, String pswd) {
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("UPDATE diver SET pswd = ? WHERE diver_id = ?");
            statement.setString(1, pswd);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Diver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
