package view;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class IFr_ProfileChange extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	static IFr_ProfileChange profileChange = null;
	
	private JTextField textFieldUsername;
	private JTextField textFieldFullName;
	private JTextField textFieldEmail;
	private JTextField textFieldWebsite;
	private JTextField textFieldRole;
	private JSeparator separator;
	private JPasswordField pwdFieldPassword;
	private JPasswordField pwdFieldRePassword;
	private JButton buttonNewButton;
	private JLabel labelNewLabel;
	private JLabel labelFullName;
	private JLabel labelEmail;
	private JLabel labelWebsite;
	private JLabel labelAccType;
	private JLabel labelPaswword;
	private JLabel labelRepassword;

	public IFr_ProfileChange() {
		setClosable(true);
		setBounds(100, 100, 403, 318);
		getContentPane().setLayout(null);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setForeground(new Color(255, 215, 0));
		textFieldUsername.setBorder(new EmptyBorder(10, 0, 0, 10));
		textFieldUsername.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFieldUsername.setEditable(false);
		textFieldUsername.setBounds(97, 11, 240, 20);
		getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldFullName = new JTextField();
		textFieldFullName.setForeground(new Color(255, 215, 0));
		textFieldFullName.setBorder(new EmptyBorder(10, 0, 0, 10));
		textFieldFullName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFieldFullName.setColumns(10);
		textFieldFullName.setBounds(97, 42, 240, 20);
		getContentPane().add(textFieldFullName);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setForeground(new Color(255, 215, 0));
		textFieldEmail.setBorder(new EmptyBorder(10, 0, 0, 10));
		textFieldEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(97, 73, 240, 20);
		getContentPane().add(textFieldEmail);
		
		textFieldWebsite = new JTextField();
		textFieldWebsite.setForeground(new Color(255, 215, 0));
		textFieldWebsite.setBorder(new EmptyBorder(10, 0, 0, 10));
		textFieldWebsite.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFieldWebsite.setColumns(10);
		textFieldWebsite.setBounds(97, 104, 240, 20);
		getContentPane().add(textFieldWebsite);
		
		textFieldRole = new JTextField();
		textFieldRole.setForeground(new Color(255, 215, 0));
		textFieldRole.setBorder(new EmptyBorder(10, 0, 0, 10));
		textFieldRole.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFieldRole.setEditable(false);
		textFieldRole.setColumns(10);
		textFieldRole.setBounds(97, 135, 240, 20);
		getContentPane().add(textFieldRole);
		
		separator = new JSeparator();
		separator.setBounds(10, 166, 351, 8);
		getContentPane().add(separator);
		
		pwdFieldPassword = new JPasswordField();
		pwdFieldPassword.setForeground(new Color(255, 215, 0));
		pwdFieldPassword.setBorder(new EmptyBorder(10, 0, 0, 10));
		pwdFieldPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		pwdFieldPassword.setBounds(97, 185, 240, 20);
		getContentPane().add(pwdFieldPassword);
		
		pwdFieldRePassword = new JPasswordField();
		pwdFieldRePassword.setForeground(new Color(255, 215, 0));
		pwdFieldRePassword.setBorder(new EmptyBorder(10, 0, 0, 10));
		pwdFieldRePassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		pwdFieldRePassword.setBounds(97, 216, 240, 20);
		getContentPane().add(pwdFieldRePassword);
		
		buttonNewButton = new JButton("Change");
		buttonNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		buttonNewButton.setBounds(272, 247, 89, 30);
		getContentPane().add(buttonNewButton);
		
		labelNewLabel = new JLabel("Username :");
		labelNewLabel.setForeground(new Color(255, 69, 0));
		labelNewLabel.setBounds(10, 14, 87, 14);
		getContentPane().add(labelNewLabel);
		
		labelFullName = new JLabel("Full Name :");
		labelFullName.setForeground(new Color(255, 69, 0));
		labelFullName.setBounds(10, 45, 87, 14);
		getContentPane().add(labelFullName);
		
		labelEmail = new JLabel("Email :");
		labelEmail.setForeground(new Color(255, 69, 0));
		labelEmail.setBounds(10, 76, 87, 14);
		getContentPane().add(labelEmail);
		
		labelWebsite = new JLabel("Website :");
		labelWebsite.setForeground(new Color(255, 69, 0));
		labelWebsite.setBounds(10, 107, 87, 14);
		getContentPane().add(labelWebsite);
		
		labelAccType = new JLabel("Acc Type :");
		labelAccType.setForeground(new Color(255, 69, 0));
		labelAccType.setBounds(10, 138, 87, 14);
		getContentPane().add(labelAccType);
		
		labelPaswword = new JLabel("Paswword :");
		labelPaswword.setForeground(new Color(255, 69, 0));
		labelPaswword.setBounds(10, 188, 87, 14);
		getContentPane().add(labelPaswword);
		
		labelRepassword = new JLabel("Re-Password :");
		labelRepassword.setForeground(new Color(255, 69, 0));
		labelRepassword.setBounds(10, 219, 87, 14);
		getContentPane().add(labelRepassword);

	}
}
