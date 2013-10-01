package tsoha.divelog.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tsoha.divelog.database.DatabaseQuery;

/**
 *
 * @author jani
 */
public class Diver extends DatabaseQuery {

    private int diverId;
    private String diverFirstName;
    private String diverLastName;
    private String diverClass;
    private String diverPhone;
    private String diverEmail;

    public Diver() {
    }

    public int getDiverId() {
        return diverId;
    }

    public String getDiverFirstName() {
        return diverFirstName;
    }

    public String getDiverLastName() {
        return diverLastName;
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

    public Diver setDiverId(int diverId) {
        this.diverId = diverId;
        return this;
    }

    public Diver setDiverFirstName(String diverFirstName) {
        this.diverFirstName = diverFirstName;
        return this;
    }

    public Diver setDiverLastName(String diverLastName) {
        this.diverLastName = diverLastName;
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

    public Diver getDiverLogin(String email, String password) throws SQLException, Exception {
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT diver_id FROM diver WHERE email=? AND pswd=?");
        statement.setString(1, email);
        statement.setNString(2, password);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            int id = result.getInt("diver_id");
            return getDiverById(id);
        }
        return null;
    }

    private Diver getDiverById(int id) throws SQLException, Exception {
        DatabaseQuery query = new DatabaseQuery();
        PreparedStatement statement = query.query("SELECT * FROM diver WHERE diver_id=?");
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            int diver_id = result.getInt("diver_id");
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String classification = result.getString("classification");
            String phonenumber = result.getString("phonenumber");
            String email = result.getString("email");

            Diver diver = new Diver();
            diver.setDiverId(diver_id);
            diver.setDiverFirstName(firstname);
            diver.setDiverLastName(lastname);
            diver.setDiverClass(classification);
            diver.setDiverPhone(phonenumber);
            diver.setDiverEmail(email);

            return diver;
        }
        return null;
    }
}
