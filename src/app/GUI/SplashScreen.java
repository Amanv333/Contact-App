package app.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class SplashScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
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
	public SplashScreen() {
		AddComponents();
		loadFrame();
	}
	
	public void loadFrame() {
		Thread t = new Thread(
				new Runnable() //anonymous inner class object
				{
					public void run() {
						try {
						Thread.sleep(5000);
						LoginFrame l = new LoginFrame();
						l.setVisible(true);
						SplashScreen.this.dispose();
						}
						catch(InterruptedException ie) {
							ie.printStackTrace();
						}
					}
				}
				
				);//constructor close
		t.start();
	}
	
	public void AddComponents() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 974, 725);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("Contact App Welcoms you...");
	lblNewLabel.setForeground(new Color(0, 0, 255));
	lblNewLabel.setFont(new Font("Nirmala UI", Font.BOLD, 24));
	lblNewLabel.setBounds(276, 191, 410, 240);
	contentPane.add(lblNewLabel);}

}
