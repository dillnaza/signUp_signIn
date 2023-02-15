import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Objects;
import java.util.Scanner;

public class Implementation {
    public void Start() throws NoSuchAlgorithmException, InvalidKeySpecException {
        Scanner s = new Scanner(System.in);
        SignUp sUp = new SignUp();
        SignIn sIn = new SignIn();
        while (true) {
            System.out.println("1. SignUp");
            System.out.println("2. SignIn");
            System.out.println("3. break");
            System.out.print("Choose number: ");
            String number = s.nextLine();
            if (Objects.equals(number, "1")) {
                System.out.print("Individual number: ");
                sUp.setEnteredId(s.nextLine());
                System.out.print("Login: ");
                sUp.setEnteredLogin(s.nextLine());
                System.out.print("Password: ");
                sUp.setEnteredPassword(s.nextLine());
                if (sUp.createUser()) {
                    System.out.println("    You have successfully registered");
                } else {
                    System.out.println("    The individual number must contain 12 digits");
                    System.out.println("    The password must be longer than 7 letters, " +
                            "contain a capital letter, and a digit");
                    System.out.println("    User with this login already exists");
                }
            } else if (Objects.equals(number, "2")) {
                for (int i = 3; i > 0; i--) {
                    System.out.print("Login or ID: ");
                    sIn.setLoginOrId(s.nextLine());
                    System.out.print("Password: ");
                    sIn.setEnteredPassword(s.nextLine());
                    if (sIn.Authorization()) {
                        System.out.println("    You have successfully logged in");
                        break;
                    } else {
                        System.out.println("    Incorrect login or password, you had " + i + "attemps");
                    }
                }
            } else if (Objects.equals(number, "3")) {
                break;
            }

        }
    }
}

