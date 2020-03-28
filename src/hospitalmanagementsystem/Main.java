package hospitalmanagementsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frmHospitalManagementSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmHospitalManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHospitalManagementSystem = new JFrame();
		frmHospitalManagementSystem.setTitle("Hospital Management System");
		frmHospitalManagementSystem.setBounds(100, 100, 1722, 1079);
		frmHospitalManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHospitalManagementSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 396, 1020);
		frmHospitalManagementSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnPatient = new JButton("Patient");
		btnPatient.setFont(new Font("Arial", Font.PLAIN, 18));
		btnPatient.setBounds(10, 11, 376, 55);
		panel.add(btnPatient);
		
		JButton btnDoctor = new JButton("Doctor");
		btnDoctor.setFont(new Font("Arial", Font.PLAIN, 18));
		btnDoctor.setBounds(10, 77, 376, 55);
		panel.add(btnDoctor);
		
		JButton btnCreateChannel = new JButton("Create Channel");
		btnCreateChannel.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCreateChannel.setBounds(10, 179, 376, 55);
		panel.add(btnCreateChannel);
		
		JButton btnViewChannel = new JButton("View Channel");
		btnViewChannel.setFont(new Font("Arial", Font.PLAIN, 18));
		btnViewChannel.setBounds(10, 245, 376, 55);
		panel.add(btnViewChannel);
		
		JButton btnViewPrescription = new JButton("View Prescription");
		btnViewPrescription.setFont(new Font("Arial", Font.PLAIN, 18));
		btnViewPrescription.setBounds(10, 347, 376, 55);
		panel.add(btnViewPrescription);
		
		JButton btnCreateItem = new JButton("Create Item");
		btnCreateItem.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCreateItem.setBounds(10, 449, 376, 55);
		panel.add(btnCreateItem);
		
		JButton btnDoctor_4_1 = new JButton("Create User");
		btnDoctor_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = new User();
				u.setVisible(true);
			}
		});
		btnDoctor_4_1.setFont(new Font("Arial", Font.PLAIN, 18));
		btnDoctor_4_1.setBounds(10, 515, 376, 55);
		panel.add(btnDoctor_4_1);
		
		JButton btnDoctor_4_2 = new JButton("View Doctor");
		btnDoctor_4_2.setFont(new Font("Arial", Font.PLAIN, 18));
		btnDoctor_4_2.setBounds(10, 617, 376, 55);
		panel.add(btnDoctor_4_2);
		
		JButton btnDoctor_4_1_1 = new JButton("Logout");
		btnDoctor_4_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		btnDoctor_4_1_1.setBounds(10, 719, 376, 55);
		panel.add(btnDoctor_4_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(416, 11, 1282, 151);
		frmHospitalManagementSystem.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hospital Management System");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(405, 49, 472, 53);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(416, 173, 641, 248);
		frmHospitalManagementSystem.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 11, 100, 48);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usertype:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 70, 100, 48);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel LabelUserName = new JLabel("<UserNameField>");
		LabelUserName.setFont(new Font("Arial", Font.PLAIN, 15));
		LabelUserName.setBounds(120, 11, 511, 48);
		panel_2.add(LabelUserName);
		
		JLabel LabelUserType = new JLabel("<UserTypeField>");
		LabelUserType.setFont(new Font("Arial", Font.PLAIN, 15));
		LabelUserType.setBounds(120, 70, 511, 48);
		panel_2.add(LabelUserType);
	}
}
