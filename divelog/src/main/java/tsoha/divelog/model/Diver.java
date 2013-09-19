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
    private String DiverPassword;

    public Diver(int diverId, String diverFirstName, String diverLastName, String diverClass, String diverPhone, String diverEmail, String DiverPassword) {
        this.diverId = diverId;
        this.diverFirstName = diverFirstName;
        this.diverLastName = diverLastName;
        this.diverClass = diverClass;
        this.diverPhone = diverPhone;
        this.diverEmail = diverEmail;
        this.DiverPassword = DiverPassword;
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

    public String getDiverPassword() {
        return DiverPassword;
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

    public void setDiverPassword(String DiverPassword) {
        this.DiverPassword = DiverPassword;
    }
}
