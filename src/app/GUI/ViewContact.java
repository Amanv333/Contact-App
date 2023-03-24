package app.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.Font;

import app.dbtask.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ViewContact extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Connection con;
	private String[]columnNames= {"Name","Email","ContactNumber"};
	private Object[][]data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewContact frame = new ViewContact();
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
	public ViewContact() {
		con = DatabaseConnection.createConnection();
		CreateContact();
	}
	//find num of records(will create dd rows)
	//create obj of Dbl dimention Array
	//poppulate dd array from db table contacts
	
	public void populateArray() {
		PreparedStatement pscount , psdata;
		ResultSet rscount,rsdata;
		try {
			String strcount="select count(*) from contacts";
			pscount=con.prepareStatement(strcount);
			rscount=pscount.executeQuery();
			if(rscount.next()) {
				int row_count = rscount.getInt(1);//it will read data from first column
				System.out.println(row_count);
				data = new Object[row_count][3];//creating obj of dd array
				
				String stssql = "select * from contacts";
				psdata = con.prepareStatement(stssql);
				rsdata = psdata.executeQuery();//it will fetch all the records from contacts table and assign ref to rsdata
				int row =0;
				while(rsdata.next()) {
					String nm = rsdata.getString("name");
					String em = rsdata.getString("email");
					String ph = rsdata.getString("phone");
					
					data[row][0]=nm;//filling columns in row column of dd array from database
					data[row][1]=em;
					data[row][02]=ph;
					row++;

					

				}
			}
			else {
				JOptionPane.showMessageDialog(this, "No contacts to show");
			}
		}
		catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	private void CreateContact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 26, 724, 513);
		contentPane.add(scrollPane);
		
		table = new JTable();
		JTableHeader header =table.getTableHeader();
		header.setForeground(Color.white);
		header.setBackground(Color.BLUE);
		header("Comic Sans Ms",Font.PLAIN,20);
		
		populateArray();
//		for(int i=0;i<2;i++) {
//			for(int j = 0;j<3;j++) {
//				System.out.println(data[i][j]+" ");
//			}
//		}
		table.setModel(new DefaultTableModel(data,columnNames));//it will show record on table
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"aman"},
//				{null},
//			},
//			new String[] {
//				"Name"
//			}
//		));
		scrollPane.setViewportView(table);
	}

	private void header(String string, int plain, int i) {
		// TODO Auto-generated method stub
		
	}
}
