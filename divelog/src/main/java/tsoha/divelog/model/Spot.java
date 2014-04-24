package tsoha.divelog.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import tsoha.divelog.database.Database;

/**
 *
 * @author jani
 */
public class Spot {

    private int spot_id;
    private String name;
    private String location;
    private String spottype;
    private String mindepth;
    private String description;
    private Map<String, String> errors = new HashMap<String, String>();

    public int getSpot_id() {
        return spot_id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getSpottype() {
        return spottype;
    }

    public String getMindepth() {
        return mindepth;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
    
    public Spot setSpot_id(int spot_id) {
        this.spot_id = spot_id;
        return this;
    }

    public Spot setName(String name) {
        this.name = name;
        return this;
    }

    public Spot setLocation(String location) {
        this.location = location;
        return this;
    }

    public Spot setMindepth(String mindepth) {
        if(Integer.parseInt(mindepth) < 0) {
            errors.put("minimisyvyys", " minimisyvyys ei voi olla negatiivinen");
        } else {
            errors.remove("minimisyvyys");
        }
        this.mindepth = mindepth;
        return this;
    }

    public Spot setSpottype(String spottype) {
        this.spottype = spottype;
        return this;
    }

    public Spot setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * kaikkien talletettujen kohteiden lista
     *
     * @return lista kohteista
     */
    public static List<Spot> getAllSpots() {
        List<Spot> allSpots = new ArrayList<Spot>();
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT * FROM spot ORDER BY name");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Spot spot = new Spot();
                spot.setSpot_id(result.getInt(1));
                spot.setName(result.getString(2));
                spot.setLocation(result.getString(3));
                spot.setSpottype(result.getString(4));
                spot.setMindepth(result.getString(5));
                spot.setDescription(result.getString(6));
                allSpots.add(spot);
            }
            statement.close();
            result.close();
            database.closeConnection();
            return allSpots;
        } catch (SQLException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allSpots;
    }

    /**
     * haetaan tietty kohde id-numeron perusteella
     *
     * @param id
     * @return kohde
     */
    public static Spot getSpotById(int id) {
        Spot spot = new Spot();
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT * FROM spot WHERE spot_id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                spot.setSpot_id(result.getInt(1));
                spot.setName(result.getString(2));
                spot.setLocation(result.getString(3));
                spot.setSpottype(result.getString(4));
                spot.setMindepth(result.getString(5));
                spot.setDescription(result.getString(6));
            }
            statement.close();
            result.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return spot;
    }

    /**
     * haetaan kohteen id-numero kohteen nimen perusteella
     *
     * @param name
     * @return kohteen id-numero
     */
    public static int getSpotIdByName(String name) {
        int id = -1;
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT spot_id FROM spot WHERE name = ?");
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            result.next();
            id = result.getInt(1);
            statement.close();
            result.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    /**
     * poistetaan kohde
     *
     * @param id
     */
    public static void deleteSpotById(int id) {
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("DELETE FROM spot WHERE spot_id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * päivitetään kohteen tiedot
     *
     * @param id
     */
    public void updateSpotById(int id) {
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("UPDATE spot SET name = ?, location = ?, spottype = ?::place, mindepth = ?::int, description = ?"
                    + "WHERE spot_id = ?");
            statement.setString(1, this.name);
            statement.setString(2, this.location);
            statement.setString(3, this.spottype);
            statement.setString(4, this.mindepth);
            statement.setString(5, this.description);
            statement.setInt(6, id);
            statement.executeUpdate();
            statement.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * tarkistetaan onko kohteessa sukelluksia
     *
     * @param id
     * @return true jos kohde liittyy johonkin sukellukseen, muuten false
     */
    public static boolean hasDive(int id) {
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("SELECT * FROM dive WHERE spot_id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * talletetaan kohde
     *
     * @return talletetun kohteen id-numero
     */
    public int insertInDatabase() {
        try {
            Database database = new Database();
            PreparedStatement statement = database.query("INSERT INTO spot(name, location, spottype, mindepth, description)"
                    + "VALUES(?, ?, ?::place, ?::int, ?) RETURNING spot_id");
            statement.setString(1, this.name);
            statement.setString(2, this.location);
            statement.setString(3, this.spottype);
            statement.setString(4, this.mindepth);
            statement.setString(5, this.description);
            ResultSet result = statement.executeQuery();
            result.next();
            this.spot_id = result.getInt(1);
            result.close();
            statement.close();
            database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Spot.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return this.spot_id;
        }
    }
}
