package vue;
import Model.Enfants;
import Model.Employes_cantine;
import Model.Employes_mairie;
import Model.Parents;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JDialog;

public class Connexion extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	JTextField txtuser;
	JTextField txtpass;
	Connection cnx = null;
	ResultSet Rs = null;
	PreparedStatement ps=null;
	/**
	 * Launch the application.
	 * @throws SQLException 
	 */

	public static void main(String[] args) throws SQLException {
		
		
		EventQueue.invokeLater(
				new Runnable() {
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
	
	public void initializeBDD() {
		Statement statement = null;
		ResultSet resultat = null;
		
		try {
			statement = cnx.createStatement();
			System.out.println("OUI");
			resultat  = statement.executeQuery("SELECT * FROM tabLogin;");
			System.out.println(resultat.getMetaData().getColumnCount());
			while (resultat.next()) {
				System.out.println(resultat.getString("nom")+"nom");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String classe = resultat.getString("classe");
				if(resultat.getInt("autorite")==1) {
					Enfants.addEnfant(nom, prenom, classe);
					
				}else if(resultat.getInt("autorite")==2){
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
			
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {

            public void windowOpened(WindowEvent e) {
                cnx = login.ConnectDB();
                initializeBDD();
            }
        });
		
		

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
			
				
				try {
			
		         String Sql = "Select * from tabLogin WHERE username ='" +txtuser.getText()+
		        		 "'and password='"+txtpass.getText()+"'";
		         
		               
		                 Statement statement = cnx.createStatement();
						
		          
						  Rs = statement.executeQuery(Sql);
					
		              
		                System.out.println("fait");
		                System.out.println(Rs);
		               
		                
		               
							if (Rs.next())
							{
							    JOptionPane.showMessageDialog(null, "Identifiant et mot de passe correct.");
							    Menu s = new Menu(3);
							    s.setVisible(true);
							    
							    
							}
							
							else {
							    JOptionPane.showMessageDialog(null, "Identifiant ou mot de passe incorrect." );
							    

							}
				}  catch (SQLException e) {
							
							e.printStackTrace();
						}
		               
			}
			
			
			}
		
		);
		
		
		btnNewButton.setBounds(164, 160, 133, 28);
		panel.add(btnNewButton);
		
		JLabel at = new JLabel("");
		at.setBounds(151, 199, 160, 14);
		panel.add(at);
	}
	
}

