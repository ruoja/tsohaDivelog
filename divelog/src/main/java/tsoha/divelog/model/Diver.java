package tsoha.divelog.model;

/**
 *
 * @author jani
 */
public class Diver {

    private int diverId;
    private String diverFirstName;
    private String diverLastName;
    private String diverClass;
    private String diverPhone;
    private String diverEmail;

    public Diver(int diverId, String diverFirstName, String diverLastName, String diverClass, String diverPhone, String diverEmail) {
        this.diverId = diverId;
        this.diverFirstName = diverFirstName;
        this.diverLastName = diverLastName;
        this.diverClass = diverClass;
        this.diverPhone = diverPhone;
        this.diverEmail = diverEmail;
    }

    private Diver() {
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

    public void setDiverId(int diverId) {
        this.diverId = diverId;
    }

    public void setDiverFirstName(String diverFirstName) {
        this.diverFirstName = diverFirstName;
    }

    public void setDiverLastName(String diverLastName) {
        this.diverLastName = diverLastName;
    }

    public void setDiverClass(String diverClass) {
        this.diverClass = diverClass;
    }

    public void setDiverPhone(String diverPhone) {
        this.diverPhone = diverPhone;
    }

    public void setDiverEmail(String diverEmail) {
        this.diverEmail = diverEmail;
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
