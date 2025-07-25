import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.swing.*;

public class Implementation {
    JFrame frame = new JFrame();
    JLabel loginlabel = new JLabel();
    JTextField logintext = new JTextField();
    JLabel loginerror = new JLabel("must contain a capital letter, and a digit*");
    JLabel idlabel = new JLabel("IIN:");
    JTextField idtext = new JTextField();
    JLabel iderror = new JLabel("must contain 12 digits");
    JLabel tglabel = new JLabel("Telegram:");
    JTextField tgtext = new JTextField();
    JLabel emaillabel = new JLabel("Email:");
    JTextField emailtext = new JTextField();
    JLabel tgerror = new JLabel("must start with symbol '@'");
    JLabel passwordlabel = new JLabel("Password:");
    JPasswordField passwordtext = new JPasswordField();
    JLabel passerror = new JLabel("*must be longer than 7 letters, contain a capital letter, and a digit");
    JButton Signup = new JButton("Sing up");
    JButton Signin = new JButton("Sign in");
    JButton Up2 = new JButton();
    JButton In2 = new JButton();
    JLabel haveacc = new JLabel();
    JLabel forgetpass = new JLabel("Forget password?");
    SignUp sUp = new SignUp();
    SignIn sIn = new SignIn();
    JFrame resFrame = new JFrame();
    JLabel resLabelCode = new JLabel();
    JTextField restCode = new JTextField();
    JLabel newPass = new JLabel("Enter new password:");
    JPasswordField newPassTx = new JPasswordField();
    JButton resetPass = new JButton();
    JButton sendCode = new JButton();
    JButton submit = new JButton();

    public void Start() {
        frame.add(loginlabel);
        frame.add(logintext);
        frame.add(idlabel);
        frame.add(idtext);
        frame.add(tglabel);
        frame.add(tgtext);
        frame.add(emaillabel);
        frame.add(emailtext);
        frame.add(passwordlabel);
        frame.add(passwordtext);
        frame.add(Signup);
        frame.add(Signin);
        frame.add(haveacc);
        frame.add(Up2);
        frame.add(In2);
        frame.add(forgetpass);
        loginerror.setVisible(false);
        iderror.setVisible(false);
        tgerror.setVisible(false);
        passerror.setVisible(false);
        loginerror.setBounds(90, 33, 250, 20);
        loginerror.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        loginerror.setForeground(Color.RED);
        frame.add(loginerror);
        iderror.setBounds(90, 63, 250, 20);
        iderror.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        iderror.setForeground(Color.RED);
        frame.add(iderror);
        tgerror.setBounds(90, 93, 250, 20);
        tgerror.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        tgerror.setForeground(Color.RED);
        frame.add(tgerror);
        passerror.setBounds(5, 153, 300, 20);
        passerror.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        passerror.setForeground(Color.RED);
        frame.add(passerror);
        frame.setLayout(null);
        frame.setVisible(true);
        SignUpPos();
        resFrame.add(resLabelCode);
        resFrame.add(restCode);
        resFrame.add(newPass);
        resFrame.add(newPassTx);
        resFrame.add(resetPass);
        resFrame.add(sendCode);
        resFrame.add(submit);
        resFrame.setVisible(false);
        resFrame.setSize(300, 200);
        frame.getContentPane().setBackground(Color.pink);
        logintext.setBackground(Color.lightGray);
        idtext.setBackground(Color.lightGray);
        passwordtext.setBackground(Color.lightGray);
        tgtext.setBackground(Color.lightGray);
        emailtext.setBackground(Color.lightGray);
        resFrame.getContentPane().setBackground(Color.pink);
        newPassTx.setBackground(Color.lightGray);
        restCode.setBackground(Color.lightGray);
    }

    private void SignUpActionPerformed(java.awt.event.ActionEvent evt) {
        SignUpPos();
    }

    private void SignInActionPerformed(java.awt.event.ActionEvent evt) {
        SignInPos();
    }

    private void SignUpPos() {
        frame.setTitle("Sign-up frame");
        forgetpass.setVisible(false);
        idlabel.setVisible(true);
        idtext.setVisible(true);
        tglabel.setVisible(true);
        tgtext.setVisible(true);
        emaillabel.setVisible(true);
        emailtext.setVisible(true);
        Signin.setVisible(false);
        Signup.setVisible(true);
        In2.setVisible(false);
        Up2.setVisible(true);
        resFrame.setVisible(false);
        loginlabel.setText("Login:");
        loginlabel.setBounds(20, 20, 150, 20);
        logintext.setText("");
        logintext.setBounds(90, 20, 200, 20);
        logintext.addActionListener(actionlogin);
        idlabel.setBounds(20, 50, 150, 20);
        idtext.setText("");
        idtext.setBounds(90, 50, 200, 20);
        idtext.addActionListener(actionid);
        tglabel.setBounds(20, 80, 150, 20);
        tgtext.setText("");
        tgtext.setBounds(90, 80, 200, 20);
        tgtext.addActionListener(actiontg);
        emaillabel.setBounds(20, 110, 150, 20);
        emailtext.setText("");
        emailtext.setBounds(90, 110, 200, 20);
        passwordlabel.setBounds(20, 140, 150, 20);
        passwordtext.setText("");
        passwordtext.setEchoChar('*');
        passwordtext.setBounds(90, 140, 200, 20);
        passwordtext.addActionListener(actionpass);
        Signup.setBounds(120, 180, 85, 20);
        Signup.addActionListener(this::CreateUser);
        haveacc.setText("Already have an account?");
        haveacc.setBounds(100, 220, 220, 20);
        Up2.setText("Sign in");
        Up2.setBounds(120, 240, 85, 20);
        Up2.addActionListener(this::SignInActionPerformed);
        frame.setSize(330, 330);
    }

    private void SignInPos() {
        frame.setTitle("Sign-in frame");
        loginerror.setVisible(false);
        iderror.setVisible(false);
        tgerror.setVisible(false);
        passerror.setVisible(false);
        idlabel.setVisible(false);
        idtext.setVisible(false);
        tglabel.setVisible(false);
        tgtext.setVisible(false);
        emaillabel.setVisible(false);
        emailtext.setVisible(false);
        Signup.setVisible(false);
        Signin.setVisible(true);
        Up2.setVisible(false);
        In2.setVisible(true);
        forgetpass.setVisible(true);
        resFrame.setVisible(false);
        loginlabel.setText("Login or IIN:");
        loginlabel.setBounds(30, 20, 150, 20);
        logintext.setText("");
        logintext.setBounds(40, 40, 220, 30);
        passwordlabel.setBounds(30, 80, 150, 20);
        passwordtext.setText("");
        passwordtext.setBounds(40, 100, 220, 30);
        Signin.setBounds(100, 150, 85, 20);
        Signin.addActionListener(this::Authorization);
        forgetpass.setBounds(100, 180, 200, 20);
        forgetpass.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                forgetpass.setText("<html><u>Forget password?</u></html>");
            }
            public void mouseExited(MouseEvent evt) {
                forgetpass.setText("<html><b>Forget password?</b></html>");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                int input = JOptionPane.showConfirmDialog(null, "Do you want to change password?");
                if (input == 0) {
                    ResetPassword();
                }
                // 0=yes, 1=no, 2=cancel
                System.out.println(input);
            }
        });
        haveacc.setText("Don't have an account?");
        haveacc.setBounds(80, 250, 200, 20);
        In2.setText("Sign up");
        In2.setBounds(100, 270, 85, 20);
        In2.addActionListener(this::SignUpActionPerformed);
        frame.setSize(300, 370);
    }

    Action actionlogin = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginerror.setVisible(!sUp.isValidLogin(logintext.getText()));
        }
    };

    Action actionid = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            iderror.setVisible(!sUp.isValidID(idtext.getText()));
        }
    };
    
    Action actiontg = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tgerror.setVisible(!sUp.isValidTg(tgtext.getText()));
        }
    };
    
    Action actionpass = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            passerror.setBounds(5, 153, 300, 20);
            passerror.setVisible(!sUp.isValidPassword(Arrays.toString(passwordtext.getPassword())));
        }
    };

    private void CreateUser(ActionEvent actionEvent) {
        sUp.setEnteredLogin(logintext.getText());
        sUp.setEnteredId(idtext.getText());
        sUp.setEnteredPassword(Arrays.toString(passwordtext.getPassword()));
        sUp.setEnteredTg(tgtext.getText());
        sUp.setEnteredEmail(emailtext.getText());
        {
            try {
                if (sUp.createUser()) {
                    JOptionPane.showMessageDialog(frame, "You have successfully registered", "Success", JOptionPane.PLAIN_MESSAGE);
                    logintext.setText("");
                    idtext.setText("");
                    passwordtext.setText("");
                    tgtext.setText("");
                    emailtext.setText("");
                } else {
                    iderror.setVisible(!sUp.isValidID(idtext.getText()));
                    passerror.setVisible(!sUp.isValidPassword(Arrays.toString(passwordtext.getPassword())));
                    loginerror.setVisible(!sUp.isValidLogin(logintext.getText()));
                    tgerror.setVisible(!sUp.isValidTg(tgtext.getText()));
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void Authorization(ActionEvent actionEvent) {
        sIn.setLoginOrId(logintext.getText());
        sIn.setEnteredPassword(Arrays.toString(passwordtext.getPassword()));
        TelegramNotification notification = new TelegramNotification();
        try {
            if (sIn.Authorization()) {
                JOptionPane.showMessageDialog(frame, "You have successfully logged in", "Success", JOptionPane.PLAIN_MESSAGE);
                notification.setAnswer("Someone logged into the app now");
                logintext.setText("");
                passwordtext.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Incorrect login or password", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    private void ResetPassword() {
        resFrame.setVisible(true);
        resFrame.setLayout(null);
        sendCode.setVisible(true);
        submit.setVisible(false);
        resetPass.setVisible(false);
        PasswordReset passwordReset = new PasswordReset();
        resLabelCode.setText("Enter login:");
        resLabelCode.setBounds(30, 20, 150, 20);
        restCode.setText("");
        restCode.setBounds(40, 40, 200, 30);
        sendCode.setText("Send code");
        sendCode.setBounds(90, 80, 100, 20);
        sendCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ee) {
                sendCode.setVisible(false);
                submit.setVisible(true);
                resetPass.setVisible(false);
                String login = restCode.getText();
                if (passwordReset.doesUserExist(login, login)) {
                    passwordReset.sendcode(passwordReset.getEmail(login));
                    resLabelCode.setText("Enter code:");
                    resLabelCode.setBounds(30, 20, 150, 20);
                    restCode.setText("");
                    restCode.setBounds(40, 40, 200, 30);
                    submit.setText("Submit");
                    submit.setBounds(90, 80, 100, 20);
                    submit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (restCode.getText().equals("252525")) {
                                sendCode.setVisible(false);
                                submit.setVisible(false);
                                resetPass.setVisible(true);
                                resLabelCode.setText("Enter your new password:");
                                resLabelCode.setBounds(30, 20, 150, 20);
                                restCode.setText("");
                                restCode.setBounds(40, 40, 200, 30);
                                resetPass.setText("Save password");
                                resetPass.setBounds(70, 80, 150, 20);
                                resetPass.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent ae) {
                                        String pass = restCode.getText();
                                        if (sUp.isValidPassword(pass)) {
                                            try {
                                                passwordReset.UpdatePassword(pass, login);
                                            } catch (NoSuchAlgorithmException ex) {
                                                throw new RuntimeException(ex);
                                            }
                                            JOptionPane.showMessageDialog(frame, "Password have successfully changed", "Success", JOptionPane.PLAIN_MESSAGE);
                                            resFrame.setVisible(false);
                                        } else {
                                            resFrame.add(passerror);
                                            passerror.setVisible(!sUp.isValidPassword(Arrays.toString(passwordtext.getPassword())));
                                            passerror.setBounds(5, 153, 300, 20);
                                        }
                                    }
                                });
                            } else {
                                JOptionPane.showMessageDialog(frame, "Incorrect code", "Error", JOptionPane.PLAIN_MESSAGE);
                                restCode.setText("");
                            }
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(frame, "Incorrect login or IIN", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }
}

