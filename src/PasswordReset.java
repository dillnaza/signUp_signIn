import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class PasswordReset extends SignIn {
    Scanner sc = new Scanner(System.in);

    public void sendcode(String to) {
        String from = "dilnazbaidakhanova@gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dilnazbaidakhanova@gmail.com", "qifhyokkjdndvnst");
            }
        });
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Java project by dillnaza");
            message.setText("Password reset code: 252525\n" +
                    "If it's not you just ignore this message");
            System.out.println("Sending code to email '" + to + "'...");
            Transport.send(message);
            System.out.println("Code sended");
            ;
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public String getEmail(String LoginOrId) {
        try {
            Connection con = DriverManager.getConnection(jdbcUrl, userName, MasterPassword);
            Statement statement = con.createStatement();
            String sql = "";
            sql = "SELECT email FROM users WHERE login = '" + LoginOrId + "';";
            ResultSet resultSet = statement.executeQuery(sql);
            String email = " ";
            while (resultSet.next()) {
                email = resultSet.getString(1);
            }
            setEnteredEmail(email);
        } catch (SQLException e) {
            System.out.println("Error in connecting to postgres server");
            throw new RuntimeException(e);
        }
        return getEnteredEmail();
    }

    public void     UpdatePassword(String pass, String loginOrId) throws NoSuchAlgorithmException {
        PasswordEncryptionService passwordEncryptionService = new PasswordEncryptionService();
        try {
            Connection con = DriverManager.getConnection(jdbcUrl, userName, MasterPassword);
            Statement statement = con.createStatement();
            String sqlsalt = "SELECT salt FROM users WHERE login = '" + loginOrId + "';";
            ResultSet resultSet = statement.executeQuery(sqlsalt);
            String salt = "";
            while (resultSet.next()) {
                salt = resultSet.getString(1);
            }
            String encryptedPassword = passwordEncryptionService.getEncryptedPassword(pass, salt);
            String sql = "UPDATE users SET password = '" + encryptedPassword + "' WHERE login = '" + loginOrId + "';";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error in connecting to postgres server");
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}

