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
public class Spot {

    private int spot_id;
    private String name;
    private String location;
    private String spottype;
    private int mindepth;
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

    public int getMindepth() {
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

    public Spot setMindepth(int mindepth) {
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
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT * FROM spot");
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            Spot spot = new Spot();
            spot.setSpot_id(result.getInt(1));
            spot.setName(result.getString(2));
            spot.setLocation(result.getString(3));
            spot.setSpottype(result.getString(4));
            spot.setMindepth(result.getInt(5));
            spot.setDescription(result.getString(6));
            allSpots.add(spot);
        }
        query.closeConnection();
        statement.close();
        result.close();
        return allSpots;
    }
}
