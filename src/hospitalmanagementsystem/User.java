package hospitalmanagementsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFullName;
	private JComboBox ComboBoxUserType;
	private JPasswordField textFieldPassword;
	private JTextField textFieldUserName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	PreparedStatement pst;

	/**
	 * Create the frame.
	 */
	public User() {
		setTitle("Create new User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1057, 869);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1023, 810);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 1003, 100);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblUserCreation = new JLabel("User Creation");
		lblUserCreation.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserCreation.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblUserCreation.setBounds(265, 23, 472, 53);
		panel_1.add(lblUserCreation);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(10, 122, 1003, 677);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Full Name:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 98, 81, 48);
		panel_1_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Username:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 157, 81, 48);
		panel_1_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Please enter the information for the new User.");
		lblNewLabel_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 11, 983, 76);
		panel_1_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Password:");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 216, 81, 48);
		panel_1_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("Usertype:");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 275, 81, 48);
		panel_1_1.add(lblNewLabel_1_1_1);

		textFieldFullName = new JTextField();
		textFieldFullName.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldFullName.setBounds(101, 108, 295, 30);
		panel_1_1.add(textFieldFullName);
		textFieldFullName.setColumns(10);

		ComboBoxUserType = new JComboBox();
		ComboBoxUserType.setModel(new DefaultComboBoxModel(new String[] { "Pharmacist", "Doctor", "Receptionist" }));
		ComboBoxUserType.setFont(new Font("Arial", Font.PLAIN, 14));
		ComboBoxUserType.setBounds(101, 285, 295, 30);
		panel_1_1.add(ComboBoxUserType);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(101, 226, 295, 30);
		panel_1_1.add(textFieldPassword);

		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Arial", Font.PLAIN, 14));
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(101, 167, 295, 30);
		panel_1_1.add(textFieldUserName);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textFieldFullName.getText();
				String username = textFieldUserName.getText();
				String password = textFieldPassword.getText();
				String usertype = ComboBoxUserType.getSelectedItem().toString();

				Connect();
				try {
					// Inserting new User into the DB
					pst = con.prepareStatement("INSERT INTO user(name,username,password,utype)VALUES(?,?,?,?)");
					pst.setString(1, name);
					pst.setString(2, username);
					pst.setString(3, password);
					pst.setString(4, usertype);
					pst.executeUpdate();

					// Preparing confirm statement about new user Creation
					String output = "";
					output += "Created new User: ";
					output += "Fullname: ";
					output += name;
					output += ", with Username: ";
					output += username;
					output += ", as Usertype: ";
					output += usertype;
					output += ".";

					// Displaying a window that confirms the new user creation
					JOptionPane.showMessageDialog(null, output);

					// emptying the textfields and setting first field active again, for next input
					textFieldFullName.setText("");
					textFieldUserName.setText("");
					textFieldPassword.setText("");
					ComboBoxUserType.setSelectedIndex(-1);
					textFieldFullName.requestFocus();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAdd.setBounds(10, 611, 188, 55);
		panel_1_1.add(btnAdd);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCancel.setBounds(208, 611, 188, 55);
		panel_1_1.add(btnCancel);
	}

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
}
