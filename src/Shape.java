import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public abstract class Shape {
    String jdbcUrl = "jdbc:postgresql://localhost:5432/aitu";
    String userName = "postgres";
    String MasterPassword = "2305";
    private String enteredId;
    private String enteredLogin;
    private String enteredPassword;
    private String enteredTg;
    private String enteredEmail;
    private String salt;

    public String getEnteredId() {
        return enteredId;
    }

    public void setEnteredId(String enteredId) {
        this.enteredId = enteredId;
    }

    public String getEnteredLogin() {
        return enteredLogin;
    }

    public String getEnteredEmail() {
        return enteredEmail;
    }

    public String getEnteredTg() {
        return enteredTg;
    }

    public void setEnteredLogin(String enteredLogin) {
        this.enteredLogin = enteredLogin;
    }

    public String getEnteredPassword() {
        return enteredPassword;
    }

    public void setEnteredPassword(String getEnteredPassword) {
        this.enteredPassword = getEnteredPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setEnteredEmail(String enteredEmail) {
        this.enteredEmail = enteredEmail;
    }

    public void setEnteredTg(String enteredTg) {
        this.enteredTg = enteredTg;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    protected boolean doesUserExist(String individualNumber, String login) {
        return true;
    }
}
