package app.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.dbtask.DatabaseConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Search extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtphone;
	private JTextField txtname;
	private JTextField txtemail;
	private JButton btnsearch;
	private Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		con = DatabaseConnection.createConnection();
		AddDetails();
	}
	
	void AddDetails() {		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 674, 487);
	contentPane = new JPanel();
	contentPane.setBackground(Color.GREEN);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lbl = new JLabel("Search");
	lbl.setFont(new Font("Arial Black", Font.BOLD, 16));
	lbl.setBounds(264, 27, 135, 30);
	contentPane.add(lbl);
	
	JLabel lblNewLabel = new JLabel("Phone");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	lblNewLabel.setBounds(44, 124, 124, 30);
	contentPane.add(lblNewLabel);
	
	txtphone = new JTextField();
	txtphone.setBounds(186, 126, 178, 25);
	contentPane.add(txtphone);
	txtphone.setColumns(10);
	
	btnsearch = new JButton("Search");
	btnsearch.setBackground(new Color(255, 255, 204));
	btnsearch.setForeground(new Color(153, 153, 51));
	btnsearch.addActionListener(this);
	btnsearch.setFont(new Font("Arial", Font.BOLD, 14));
	btnsearch.setBounds(465, 124, 100, 25);
	contentPane.add(btnsearch);
	
	JLabel lblNewLabel_1 = new JLabel("Name");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblNewLabel_1.setBounds(55, 222, 45, 13);
	contentPane.add(lblNewLabel_1);
	
	txtname = new JTextField();
	txtname.setDisabledTextColor(new Color(0, 0, 128));
	txtname.setSelectionColor(new Color(0, 0, 0));
	txtname.setFont(new Font("Tahoma", Font.BOLD, 10));
	txtname.setForeground(new Color(0, 0, 128));
	txtname.setEnabled(false);
	txtname.setEditable(false);
	txtname.setBounds(185, 220, 214, 19);
	contentPane.add(txtname);
	txtname.setColumns(10);
	
	JLabel lblNewLabel_2 = new JLabel("email");
	lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblNewLabel_2.setBounds(55, 267, 45, 13);
	contentPane.add(lblNewLabel_2);
	
	txtemail = new JTextField();
	txtemail.setFont(new Font("Tahoma", Font.BOLD, 10));
	txtemail.setDisabledTextColor(new Color(0, 0, 128));
	txtemail.setEnabled(false);
	txtemail.setEditable(false);
	txtemail.setBounds(186, 265, 213, 19);
	contentPane.add(txtemail);
	txtemail.setColumns(10);}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String phone = txtphone.getText();
		if(phone.isEmpty()) {
			JOptionPane.showMessageDialog(this, "phone number required","Mandatory",JOptionPane.ERROR_MESSAGE);
		}
		else {
			String strsql = "select * from contacts where phone=?";
			PreparedStatement ps;
			ResultSet rs;
			
			try {
				ps = con.prepareStatement(strsql);
				ps.setString(1, phone);
				rs = ps.executeQuery();
				if(rs.next()) {
					String nm = rs.getString("name");
					String em = rs.getString("email");
					txtname.setText(nm);
					txtemail.setText(em);
					
				}
				else {
					JOptionPane.showMessageDialog(this, "No phone num is exist");
				}
				
			}
			catch(SQLException s) {
				s.printStackTrace();
			}
		}
	}
}
