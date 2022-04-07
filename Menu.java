package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;

public class Menu extends JFrame {

	private JPanel contentPane;
	public int authority;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(3);
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
	public Menu(int level) {
		
        level = authority;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue ");
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblNewLabel.setBounds(310, 11, 280, 26);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Lucida Bright", Font.BOLD, 17));
		menuBar.setBounds(10, 64, 138, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("MS Gothic", Font.BOLD, 17));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu de la semaine");
		mntmNewMenuItem.setSelected(true);
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0)
			
			{
				RepasSemaine s = new RepasSemaine();
			    s.setVisible(true);
			    dispose();
			}
			
		});
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("R\u00E9server le repas");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0)
			
			{
				ReserverRepas s = new ReserverRepas();
			    s.setVisible(true);
			    dispose();
			}
			
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Emploi du temps");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0)
			
			{
				EDT s = new EDT();
			    s.setVisible(true);
			    dispose();
			}
			
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("G\u00E9rer employ\u00E9");
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0)
			
			{
				GererEmployes s = new GererEmployes();
			    s.setVisible(true);
			    dispose();
			}
			
		});
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Liste \u00E9l\u00E8ves");
		mnNewMenu.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0)
			
			{
				ListeEleves s = new ListeEleves();
			    s.setVisible(true);
			    dispose();
			}
			
		});
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Liste employ\u00E9s");
		mnNewMenu.add(mntmNewMenuItem_5);
		mntmNewMenuItem_5.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0)
			
			{
				ListeEmployes s = new ListeEmployes();
			    s.setVisible(true);
			    dispose();
			}
			
		});
	}
}
