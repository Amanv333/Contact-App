package app.GUI;

import java.awt.BorderLayout;
import java.awt.Event.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Admin extends JFrame implements ActionListener,WindowListener {

	private JPanel contentPane;
	private JMenuItem mi_add,mi_update,mi_delete,mi_number;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		
		this.addWindowListener(this);
		createComponent();
	}
	public void createComponent() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Admin.class.getResource("/app/images/icon.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Admin");
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 837, 455);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_contact = new JMenu("Contacts");
		menu_contact.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(menu_contact);
		
		mi_add = new JMenuItem("Add");
		mi_add.addActionListener(this);
		mi_add.setIcon(new ImageIcon(Admin.class.getResource("/app/images/add.png")));
		mi_add.setForeground(Color.BLUE);
		mi_add.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menu_contact.add(mi_add);
		
		 mi_update = new JMenuItem("Update");
		 mi_update.addActionListener(this);
		 mi_update.setIcon(new ImageIcon(Admin.class.getResource("/app/images/update.png")));
		mi_update.setForeground(Color.BLUE);
		mi_update.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menu_contact.add(mi_update);
		
		 mi_delete = new JMenuItem("Delete");
		 mi_delete.addActionListener(this);
		 mi_delete.setIcon(new ImageIcon(Admin.class.getResource("/app/images/delete.png")));
		mi_delete.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mi_delete.setForeground(Color.BLUE);
		menu_contact.add(mi_delete);
		
		JMenu menu_search = new JMenu("Search");
		menu_search.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(menu_search);
		
		 mi_number = new JMenuItem("ByNumber");
		mi_number.addActionListener(this);
		mi_number.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mi_number.setForeground(Color.BLUE);
		menu_search.add(mi_number);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Frame");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(405, 20, 213, 33);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption = e.getActionCommand();
		if(caption.equalsIgnoreCase("add")) {
			Contact cf = new Contact();
			cf.setVisible(true);
		}
		if (caption.equalsIgnoreCase("delete")) 
		{
			DeleteContact d = new DeleteContact();
			d.setVisible(true);
		}
		if (caption.equalsIgnoreCase("update")) 
		{
			UpdateContact u = new UpdateContact();
			u.setVisible(true);
		}
		if (caption.equalsIgnoreCase("ByNumber")) 
		{
			Search s = new Search();
			s.setVisible(true);
		}
		
		
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		LoginFrame log = new LoginFrame();
		log.setVisible(true);
		
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
