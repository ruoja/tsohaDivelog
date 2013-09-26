package tsoha.divelog.model;

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

    public void setSpot_id(int spot_id) {
        this.spot_id = spot_id;
    }

    public void setName(String name) {
        this.name = name;
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
}
