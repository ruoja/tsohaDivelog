package tsoha.divelog.model;

import tsoha.divelog.database.DatabaseOperation;

/**
 *
 * @author jani
 */
public class Diver extends DatabaseOperation {

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

    public static Diver getDiver(String email, String password) {
        String acceptMail = "test";
        String acceptPass = "test";
        if (email.equals(acceptMail) && password.equals(acceptPass)) {
            return new Diver();
        }
        return null;
    }
}
