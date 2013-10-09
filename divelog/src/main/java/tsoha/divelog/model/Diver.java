package tsoha.divelog.model;

import com.sun.rowset.JdbcRowSetImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
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

    public Diver getDiverByLogin(String email, String pswd) throws SQLException, Exception {
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
            return this;
        }
        return null;
    }

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
            dive.setDiveNumber(result.getInt(4));
            dive.setDivedate(result.getDate(5));
            dive.setDivetimeInMinutes(result.getInt(6));
            dive.setBottomtimeInMinutes(result.getInt(7));
            dive.setMaxdepth(result.getInt(8));
            dive.setVisibility(result.getInt(9));
            dive.setAirtemp(result.getInt(10));
            dive.setWatertemp(result.getInt(11));
            dive.setSuittype(result.getString(12));
            dive.setTanksize(result.getInt(13));
            dive.setStartpressure(result.getInt(14));
            dive.setEndpressure(result.getInt(15));
            dive.setGastype(result.getString(16));
            dive.setOxygenPercentage(result.getInt(17));
            dive.setDescription(result.getString(18));
            diveList.add(dive);
        }
        return diveList;
    }
}
