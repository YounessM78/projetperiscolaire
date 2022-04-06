package vue;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Connexion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private javax.swing.JLabel at;
	private JTextField txtuser;
	private JTextField txtpass;
	Connection cnx = null;
	ResultSet Rs = null;
	PreparedStatement ps=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion window = new Connexion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 488, 294);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtuser = new JTextField();
		txtuser.setBounds(137, 79, 192, 20);
		panel.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Identifiant :");
		lblNewLabel.setBounds(61, 82, 57, 14);
		panel.add(lblNewLabel);
		
		txtpass = new JTextField();
		txtpass.setBounds(137, 121, 192, 20);
		panel.add(txtpass);
		txtpass.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setBounds(49, 124, 71, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Se connecter");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(178, 35, 96, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ma Cantine");
		lblNewLabel_3.setBounds(10, 236, 71, 14);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0)
			
			{
		        try
		       
		        {
		        

		         String Sql = "Select * from tabLogin WHERE username ='" +txtuser.getText()+
		        		 "'and password='"+txtpass.getText()+"'";
		         
		                ps = cnx.prepareStatement(Sql);
		                Rs = ps.executeQuery();
		                
		                if (Rs.next())
		                {
		                    JOptionPane.showMessageDialog(null, "username and password is Correct");
		                    Menu s = new Menu();
		                    s.setVisible(true);
		                    
		                    
		                    
		                }else {
		                    JOptionPane.showMessageDialog(null, "invalide username or password" );
		                    
		                    
		                    at.setText("invalid username or password");
		                }
		        }
		      	
		               
		        
		        catch(Exception e){
		            JOptionPane.showMessageDialog(null, e);
		        }
				
			}
			
		
			
				@SuppressWarnings("unused")
				
				private void windowOpened(WindowEvent e) {
					cnx = login.ConnectDB();
				}
			
		}
		);
		
		btnNewButton.setBounds(164, 160, 133, 28);
		panel.add(btnNewButton);
		
		JLabel at = new JLabel("");
		at.setBounds(210, 199, 46, 14);
		panel.add(at);
	}
	
}
