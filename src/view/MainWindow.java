package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainWindow extends JFrame {


	private static final long serialVersionUID = 1L;
	private Container mainContainer = getContentPane();
	private BorderLayout bl = new BorderLayout(2,2);
	private MainCardChanger workpanel;
	private SidePanel sidepanel;
	
	
	MainWindow(){
		super("MyDealer");	
		workpanel = new MainCardChanger();
		sidepanel = new SidePanel(workpanel);
		mainContainer.setLayout(bl);
		mainContainer.setBackground(Color.ORANGE);
		mainContainer.add(sidepanel, BorderLayout.WEST);
		mainContainer.add(workpanel, BorderLayout.CENTER);
	
		setUndecorated(true); 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);

		setVisible(true);
		//setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		//new Login2(this);
//		this.loginController = new LoginController();
//		sidepanel = new SidePanel(workpanel);
//		mainContainer.add(sidepanel, BorderLayout.WEST);
//		workpanel = new MainCardChanger();
//		mainContainer.add(workpanel, BorderLayout.CENTER);
//
//
//		revalidate();
//		repaint();
		
	}
	
//	public static void main(String[] args) {
//		new MainWindow();
//	}
}
