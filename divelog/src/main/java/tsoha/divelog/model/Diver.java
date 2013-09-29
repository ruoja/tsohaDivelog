package tsoha.divelog.model;

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

    public static Diver getDiverLogin(String email, String password) throws SQLException, Exception {
        DatabaseQuery query = new DatabaseQuery();
        ResultSet result;
        result = query.query("SELECT email, pswd FROM diver");
        while (result.next()) {
            String acceptMail = result.getString("email");
            String acceptPassword = result.getString("pswd");
            if (acceptMail.equals(email) && acceptPassword.equals(password)) {
                return new Diver(); //TODO: hae kannasta sukeltaja olio
            }
        }
        return null;
    }
}
