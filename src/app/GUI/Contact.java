package app.GUI;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.dbtask.DatabaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;

public class Contact extends JFrame implements ActionListener,KeyListener,WindowListener {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtemail;
	private JTextField txtphone;
	private JTextArea txtArea;
	JRadioButton rdmale;
	JRadioButton rdFemale;
	private final ButtonGroup Gender_Group = new ButtonGroup();
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contact frame = new Contact();
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
	public Contact() {
		con = DatabaseConnection.createConnection();//it will give the ref of mycontact db 
		AddDetails();
		this.addWindowListener(this);
	}
	public void AddDetails() {
		setTitle("Contact");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//it will close only this frame
		setBounds(100, 100, 708, 527);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setBounds(103, 75, 90, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(103, 127, 90, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(103, 173, 90, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(103, 230, 90, 24);
		contentPane.add(lblNewLabel_3);
		
		txtname = new JTextField();
		txtname.setBounds(372, 75, 151, 24);
		contentPane.add(txtname);
		txtname.addKeyListener(this);
		txtname.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(372, 128, 151, 24);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.setBounds(372, 173, 151, 24);
		contentPane.add(txtphone);
		txtphone.addKeyListener(this);
		txtphone.setColumns(10);
		
		txtArea = new JTextArea();
		txtArea.setWrapStyleWord(true);
		txtArea.setLineWrap(true);
		txtArea.setBounds(372, 233, 151, 55);
		contentPane.add(txtArea);
		
		rdmale = new JRadioButton("Male");
		Gender_Group.add(rdmale);
		rdmale.setBackground(new Color(255, 250, 205));
		rdmale.setFont(new Font("Arial", Font.PLAIN, 16));
		rdmale.setBounds(266, 327, 103, 21);
		contentPane.add(rdmale);
		
		rdFemale = new JRadioButton("Female");
		Gender_Group.add(rdFemale);
		rdFemale.setBackground(new Color(255, 250, 205));
		rdFemale.setFont(new Font("Arial", Font.PLAIN, 16));
		rdFemale.setBounds(372, 327, 103, 21);
		contentPane.add(rdFemale);
		
		JButton btnsubmit = new JButton("SUBMIT");
		btnsubmit.setFont(new Font("Arial Narrow", Font.BOLD, 17));
		btnsubmit.setForeground(new Color(138, 43, 226));
		btnsubmit.setBounds(296, 383, 96, 41);
		btnsubmit.addActionListener(this);
		btnsubmit.addKeyListener(this);//regster key listener
		contentPane.add(btnsubmit);
		
		JLabel lblNewLabel_4 = new JLabel("Contact");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setForeground(new Color(0, 0, 205));
		lblNewLabel_4.setBackground(new Color(240, 255, 240));
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 23));
		lblNewLabel_4.setBounds(266, 10, 112, 41);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Contact.class.getResource("/app/images/77.jpg")));
		lblNewLabel_5.setBounds(0, 0, 694, 480);
		contentPane.add(lblNewLabel_5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		InsertData();
	}
	
	public void InsertData() {
		
		String name = txtname.getText().trim();
		String phone = txtphone.getText().trim();
		String email = txtemail.getText().trim();
		String Address = txtArea.getText();
		
		String gender = "";
		
		if (rdmale.isSelected()) {
			gender = rdmale.getText();
		}
		if (rdFemale.isSelected()) {
			gender = rdFemale.getText();
		}
		
		
		
		if(name.length()>0&&phone.length()>0&& email.length()>0&&gender.length()>0) {
			String strinsert = "insert into contacts(Name, Email, Phone, Address, Gender, Date)values(?,?,?,?,?,?)";
			PreparedStatement ps = null;
			try {
				java.util.Date dt = new java.util.Date();
				long d = dt.getTime();
				java.sql.Date sd = new java.sql.Date(d);
				ps=con.prepareStatement(strinsert);
				ps.setString(1,name);
				ps.setString(2,email);
				ps.setString(3,phone);
				ps.setString(4,Address);
				ps.setString(5,gender);
				ps.setDate(6, sd);
				int status = ps.executeUpdate();
				if(status>0) {
					JOptionPane.showMessageDialog(this, "contact added");
					txtArea.setText("");
					txtname.setText("");
					txtemail.setText("");
					txtphone.setText("");
					Gender_Group.clearSelection();

				}
				
			
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
			finally {
				try {
					if(ps!=null) {
						ps.close();
					}
						
					}
					catch(SQLException se) {
						se.printStackTrace();
					}
				}
			}
		}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		
		if(e.getSource()==txtname) {
		
		if(!(c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE||Character.isLetter(c)))
		{
			e.consume();
			JOptionPane.showMessageDialog(this,"name requirs only Alphabate");
		}
		}
		
		if(e.getSource()==txtphone) {
		
		if(!((c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE||(Character.isDigit(c))))) {
			e.consume();
			JOptionPane.showMessageDialog(this,"name requirs only Alphabate");
		}
	}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getExtendedKeyCode();
		System.out.println(code);
		if (code==10) {
			InsertData();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		

		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
		DatabaseConnection.closeConnection();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
		

}
