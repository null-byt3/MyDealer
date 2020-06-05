package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;

import controller.LoginController;
import model.employee.Employee;

public class SidePanel extends JPanel {

	private final PanelChanger panelChanger;
	private LoginController loginController;
	JButton bClients, bOrders, bInventory, bReports, bEmployees, bHome;
	ImageIcon clients_white, orders_white, inventory_white, reports_white, employees_white;
	ImageIcon clients_orange, orders_orange, inventory_orange, reports_orange, employees_orange;
	ImageIcon home;

	public SidePanel(PanelChanger panelChanger) {
		this.loginController = new LoginController();
		this.panelChanger = panelChanger;
		this.setLayout(new BorderLayout(4, 4));
		this.setBackground(Color.DARK_GRAY);
		this.add(TopButtonsCluster(), BorderLayout.NORTH);
		this.add(BottomButtonsCluster(), BorderLayout.SOUTH);
	}

///////////////////////////////////////////////
//////////// TOP   BUTTONS  CLUSTER ///////////
///////////////////////////////////////////////

	public JPanel TopButtonsCluster() {

		// CREATE BUTTONS //

		clients_white = new ImageIcon("icons/white/clients.png");
		orders_white = new ImageIcon("icons/white/orders.png");
		inventory_white = new ImageIcon("icons/white/inventory.png");
		reports_white = new ImageIcon("icons/white/reports.png");
		employees_white = new ImageIcon("icons/white/employees.png");

		clients_orange = new ImageIcon("icons/orange/clients.png");
		orders_orange = new ImageIcon("icons/orange/orders.png");
		inventory_orange = new ImageIcon("icons/orange/inventory.png");
		reports_orange = new ImageIcon("icons/orange/reports.png");
		employees_orange = new ImageIcon("icons/orange/employees.png");

		home = new ImageIcon("icons/home.png");
		bHome = new JButton(home);
		bHome.setBackground(Color.orange);
		bHome.setOpaque(true);
		//bHome.setContentAreaFilled(false);
		bHome.setBorderPainted(false);
		bHome.setFocusPainted(false);
		
		bHome.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				resetIcons();
				panelChanger.updateWorkPanel("WelcomePanel");
			}
		});
				
		bClients = ButtonFactory("Clients", "/clients.png");
		bOrders = ButtonFactory("Orders", "/orders.png");
		bInventory = ButtonFactory("Inventory", "/inventory.png");
		bReports = ButtonFactory("Reports", "/reports.png");
		bEmployees = ButtonFactory("Employees", "/employees.png");

		// ACTION LISTENERS - ASSIGN ACTION TO BUTTON //
		bClients.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				resetIcons();
				panelChanger.updateWorkPanel("ClientsPanel");
				mouseEntered(e);
				bClients.setContentAreaFilled(true);
			}

			public void mouseEntered(MouseEvent e) {
				bClients.setIcon(clients_orange);
				bClients.setForeground(Color.ORANGE);
			}

			public void mouseExited(MouseEvent e) {
					bClients.setIcon(clients_white);
					bClients.setForeground(Color.WHITE);
				
			}

		});

		bOrders.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				resetIcons();
				mouseEntered(e);
				panelChanger.updateWorkPanel("OrdersPanel");
				bOrders.setContentAreaFilled(true);
			}

			public void mouseEntered(MouseEvent e) {
				bOrders.setIcon(orders_orange);
				bOrders.setForeground(Color.ORANGE);
			}

			public void mouseExited(MouseEvent e) {
					bOrders.setIcon(orders_white);
					bOrders.setForeground(Color.WHITE);

			}

		});

		bInventory.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				resetIcons();
				mouseEntered(e);
				panelChanger.updateWorkPanel("InventoryPanel");
				bInventory.setContentAreaFilled(true);

			}

			public void mouseEntered(MouseEvent e) {
				bInventory.setIcon(inventory_orange);
				bInventory.setForeground(Color.ORANGE);
			}

			public void mouseExited(MouseEvent e) {
					bInventory.setIcon(inventory_white);
					bInventory.setForeground(Color.WHITE);
				
			}

		});

		bReports.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				resetIcons();
				mouseEntered(e);
				// panelChanger.updateWorkPanel("ReportsPanel");
				bReports.setContentAreaFilled(true);
			}

			public void mouseEntered(MouseEvent e) {
				bReports.setIcon(reports_orange);
				bReports.setForeground(Color.ORANGE);
			}

			public void mouseExited(MouseEvent e) {
					bReports.setIcon(reports_white);
					bReports.setForeground(Color.WHITE);
			}

		});

		bEmployees.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				resetIcons();
				mouseEntered(e);
				panelChanger.updateWorkPanel("EmployeesPanel");
				bEmployees.setContentAreaFilled(true);
			}

			public void mouseEntered(MouseEvent e) {
				bEmployees.setIcon(employees_orange);
				bEmployees.setForeground(Color.ORANGE);
			}

			public void mouseExited(MouseEvent e) {
					bEmployees.setIcon(employees_white);
					bEmployees.setForeground(Color.WHITE);
			}

		});

		// CREATE PANEL, ASSIGN LAYOUT //
		JPanel TopButtonsCluster = new JPanel();
		TopButtonsCluster.setLayout(new GridLayout(6, 1, 10, 20));

		// ADD BUTTONS TO PANEL //
		TopButtonsCluster.add(bHome);
		TopButtonsCluster.add(bClients);

		if (!loginController.getLoggedUserRole().equals("Secretary")) {
			TopButtonsCluster.add(bOrders);
			TopButtonsCluster.add(bInventory);
		}
		if (loginController.getLoggedUserRole().equals("Manager")) {
			TopButtonsCluster.add(bReports);
			TopButtonsCluster.add(bEmployees);
		}

		// SET BACKGROUND TO PANEL //
		TopButtonsCluster.setBackground(Color.DARK_GRAY);
		return TopButtonsCluster;

	}

///////////////////////////////////////////////
//////////// BOTTOM BUTTONS CLUSTER ///////////
///////////////////////////////////////////////

	public JPanel BottomButtonsCluster() {

		// CREATE BUTTONS //
		JButton bLogout = new JButton("Logout");
		JButton bExit = new JButton("Exit");

		bLogout.setBackground(Color.GRAY);
		bLogout.setForeground(Color.WHITE);
		bExit.setBackground(Color.GRAY);
		bExit.setForeground(Color.WHITE);

		bLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("Close main window. Open login-page");
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				loginController.logOut();
				new Login();
			}

		});
		bExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				System.out.println("Close application");
			}

		});

		// CREATE PANEL, ASSIGN LAYOUT //
		JPanel BottomButtonsCluster = new JPanel();
		BottomButtonsCluster.setLayout(new GridLayout(2, 1, 5, 5));

		// ADD BUTTONS TO PANEL //
		BottomButtonsCluster.add(bLogout);
		BottomButtonsCluster.add(bExit);

		// SET BACKGROUND TO PANEL //
		BottomButtonsCluster.setBackground(Color.DARK_GRAY);
		return BottomButtonsCluster;

	}

///////////////////////////////////////////////
//////////// BUTTON IMAGE CREATOR /////////////
///////////////////////////////////////////////

	public JButton ButtonFactory(String text, String iconFile) {
		JButton button = new JButton(text);

		button.setPreferredSize(new Dimension(100, 100));
		button.setForeground(Color.WHITE);
		button.setBackground(Color.GRAY);
		button.setIcon(new ImageIcon("icons/white/" + iconFile));
		button.setOpaque(true);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setIconTextGap(10);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setFocusPainted(false);

		return button;
	}
	
	
	public void resetIcons() {

		bClients.setForeground(Color.WHITE);
		bClients.setContentAreaFilled(false);
		bClients.setIcon(clients_white);
		bOrders.setForeground(Color.WHITE);
		bOrders.setContentAreaFilled(false);
		bOrders.setIcon(orders_white);
		bInventory.setForeground(Color.WHITE);
		bInventory.setContentAreaFilled(false);
		bInventory.setIcon(inventory_white);
		bReports.setForeground(Color.WHITE);
		bReports.setContentAreaFilled(false);
		bReports.setIcon(reports_white);
		bEmployees.setForeground(Color.WHITE);
		bEmployees.setContentAreaFilled(false);
		bEmployees.setIcon(employees_white);

	}

}
