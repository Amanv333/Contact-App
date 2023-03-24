package app.GUI;

import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
public class LoginFrame extends JFrame implements ActionListener {
	private JLabel lblNewLabel_1;
	private JTextField txtuserid;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		createComponent();
		
	}
	
	public void createComponent() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/app/images/icon.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 457);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new LineBorder(new Color(153, 51, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Frame");
		lblNewLabel.setForeground(new Color(51, 51, 204));
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 24));
		lblNewLabel.setBounds(346, 32, 175, 34);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("UserId");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(110, 127, 128, 20);
		contentPane.add(lblNewLabel_1);
		
		txtuserid = new JTextField();
		txtuserid.setBounds(332, 128, 96, 19);
		contentPane.add(txtuserid);
		txtuserid.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(332, 177, 96, 19);
		contentPane.add(passwordField);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		Password.setBounds(98, 177, 121, 19);
		contentPane.add(Password);
		
		JButton btnsSubmit = new JButton("SUBMIT");
		btnsSubmit.setBackground(new Color(51, 0, 255));
		btnsSubmit.addActionListener(this);
		btnsSubmit.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnsSubmit.setBounds(206, 245, 96, 43);
		contentPane.add(btnsSubmit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id =txtuserid.getText().trim();
		char[] pwd = passwordField.getPassword();//fetching the value from jpasswordField
		String password = String.valueOf(pwd).trim();//convert char[] into String
		
		if(id.length()>0 && password.length()>0) {
			if (id.equals("Akash")&& password.equals("Verma")) {
				JOptionPane.showMessageDialog(this, "Welcome "+id);
				Admin ad = new Admin();//for opening admin frame on button click
				ad.setVisible(true);
				this.dispose();
			}
			else {
			
			JOptionPane.showMessageDialog(this, "Invalid Credential");
			}
				
		}
		
		else {
			JOptionPane.showMessageDialog(this,"Data required for userID and password");
		}
	}
}
