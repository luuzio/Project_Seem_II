package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import dao.AccountDAO;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import entities.Account;

public class Fr_Login extends JFrame {

	 private static final long serialVersionUID = 1L;
	 private JPanel contentPane;
	 private JLabel labelLogin;
	 private JLabel labelUsername;
	 private JLabel labelPassword;
	 private JTextField textFieldUsername;
	 private JPasswordField pwdFieldPassword;
	 private JButton buttonLogin;

	 protected static String username;

	 public static void main(String[] args) {

		  Fr_Login frame = new Fr_Login();
		  frame.setVisible(true);
		  try {
				UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());

		  } catch (Exception e) {
		  }
	 }

	 public Fr_Login() {
		  setTitle("    User Login");
		  setType(Type.UTILITY);
		  setResizable(false);
		  initialize();
	 }

	 private void initialize() {
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setBounds(((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width - 450) / 2),
					 ((java.awt.Toolkit.getDefaultToolkit().getScreenSize().height - 250) / 2), 380, 180);
		  contentPane = new JPanel();
		  setContentPane(contentPane);
		  contentPane.setLayout(null);

		  labelLogin = new JLabel("LOG - IN");
		  labelLogin.setForeground(new Color(139, 0, 139));
		  labelLogin.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		  labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		  labelLogin.setBounds(0, 0, 120, 30);
		  contentPane.add(labelLogin);

		  labelUsername = new JLabel("User :");
		  labelUsername.setForeground(new Color(75, 0, 130));
		  labelUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  labelUsername.setBounds(45, 41, 75, 20);
		  contentPane.add(labelUsername);

		  labelPassword = new JLabel("Password :");
		  labelPassword.setForeground(new Color(75, 0, 130));
		  labelPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  labelPassword.setBounds(45, 72, 75, 20);
		  contentPane.add(labelPassword);

		  textFieldUsername = new JTextField();
		  textFieldUsername.setForeground(new Color(75, 0, 130));
		  textFieldUsername.setBorder(new EmptyBorder(0, 10, 0, 10));
		  textFieldUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  textFieldUsername.setBounds(130, 41, 185, 20);
		  contentPane.add(textFieldUsername);
		  textFieldUsername.setColumns(10);

		  pwdFieldPassword = new JPasswordField();
		  pwdFieldPassword.setForeground(new Color(75, 0, 130));
		  pwdFieldPassword.setBorder(new EmptyBorder(0, 10, 0, 10));
		  pwdFieldPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  pwdFieldPassword.setBounds(130, 72, 185, 20);
		  contentPane.add(pwdFieldPassword);

		  buttonLogin = new JButton("LOGIN!");
		  buttonLogin.addActionListener(a -> buttonLoginActionPerformed());
		  buttonLogin.setBackground(new Color(0, 0, 0));
		  buttonLogin.setForeground(new Color(240, 255, 240));
		  buttonLogin.setBorder(null);
		  buttonLogin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  buttonLogin.setBounds(226, 103, 89, 30);
		  contentPane.add(buttonLogin);
		  getRootPane().setDefaultButton(buttonLogin);
	 }

	 protected void buttonLoginActionPerformed() {
		  Account account = new AccountDAO().login(textFieldUsername.getText(),
					 String.valueOf(pwdFieldPassword.getPassword()));
		  if (null != account) {
				Fr_Login.username = account.getUsername();
				this.setVisible(false);
				new Fr_Main().setVisible(true);
		  } else
				JOptionPane.showMessageDialog(null, "Account is invalid!");
	 }
}
