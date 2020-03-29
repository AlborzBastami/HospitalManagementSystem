package hospitalmanagementsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	/**
	 * MYSQL Connector
	 */
	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		Font titleFont = new Font("Arial", Font.TRUETYPE_FONT, 18);
		panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEFT, TitledBorder.TOP, titleFont, null));
		panel.setBounds(10, 11, 804, 462);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCancel.setBounds(208, 396, 188, 55);
		panel.add(btnCancel);

		JLabel lblNewLabel_1_1 = new JLabel("Username:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 56, 81, 48);
		panel.add(lblNewLabel_1_1);

		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(101, 66, 295, 30);
		panel.add(textFieldUsername);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(101, 125, 295, 30);
		panel.add(textFieldPassword);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPassword.setBounds(10, 115, 81, 48);
		panel.add(lblPassword);

		JLabel lblUsertype = new JLabel("Usertype:");
		lblUsertype.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsertype.setBounds(10, 174, 81, 48);
		panel.add(lblUsertype);

		JComboBox ComboBoxUserType = new JComboBox();
		ComboBoxUserType.setModel(new DefaultComboBoxModel(new String[] { "Pharmcist", "Doctor", "Receptionist" }));
		ComboBoxUserType.setFont(new Font("Arial", Font.PLAIN, 14));
		ComboBoxUserType.setBounds(101, 184, 295, 30);
		panel.add(ComboBoxUserType);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username;
				String password;
				String usertype;

				// Building String for Login Check
				username = textFieldUsername.getText();
				password = textFieldPassword.getText();
				usertype = ComboBoxUserType.getSelectedItem().toString();

				Connect();

				// Search the database for username and password matching
				/*
				 * SELECT * FROM USER WHERE username="The username entered" AND
				 * password="The password entered" AND utype="The usertype selected"
				 * 
				 * The verification is done fully in mysql
				 */

				try {
					// #1 Build the search Query
					pst = con.prepareStatement("select * from user where username=? and password=? and utype=?");
					pst.setString(1, username);
					pst.setString(2, password);
					pst.setString(3, usertype);

					// #2 Run the Query
					rs = pst.executeQuery();

					// #3 if ResultSet = true
					if (rs.next()) {
						int userid = rs.getInt("id");

						// close this window
						setVisible(false);

						// Construct a new Main Window and transmit login credentials
						new Main(userid, username, usertype);
					} else {

						// If User Login was not successful
						JOptionPane.showMessageDialog(null, "Username or Password wrong");
						textFieldUsername.setText("");
						textFieldPassword.setText("");
						ComboBoxUserType.setSelectedIndex(-1);
						textFieldUsername.requestFocus();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		btnLogin.setBounds(10, 396, 188, 55);
		panel.add(btnLogin);
	}
}
