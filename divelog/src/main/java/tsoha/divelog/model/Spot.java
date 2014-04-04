package tsoha.divelog.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    //private static List<Spot> allSpots = new ArrayList<Spot>();

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

    public static List<Spot> getAllSpots() throws SQLException, Exception {
        List<Spot> allSpots = new ArrayList<Spot>();
        Database database = new Database();
        PreparedStatement statement = database.query("SELECT * FROM spot");
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
    }

    public static Spot getSpotById(int id) throws SQLException, Exception {
        Spot spot = new Spot();
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
        return spot;
    }

    public static void deleteSpotById(int id) throws SQLException, Exception {
        Database database = new Database();
        PreparedStatement statement = database.query("DELETE FROM spot WHERE spot_id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        database.closeConnection();
    }
    /*
     * @TODO
     */
    public static void updateSpotById(int id) {
       
    }

    public static boolean exists(int id) throws SQLException, Exception {
        Database database = new Database();
        PreparedStatement statement = database.query("SELECT * FROM spot WHERE spot_id = ?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.wasNull()) {
            return false;
        }
        return true;
    }

    public void insertInDatabase() throws SQLException, NamingException, Exception {
        Database database = new Database();
        PreparedStatement statement = database.query("INSERT INTO spot(name, location, spottype, mindepth, description)"
                + "VALUES(?, ?, ?::place, ?::int, ?)");
        statement.setString(1, this.name);
        statement.setString(2, this.location);
        statement.setString(3, this.spottype);
        statement.setString(4, this.mindepth);
        statement.setString(5, this.description);
        statement.executeUpdate();
        statement.close();
        database.closeConnection();
    }
}
