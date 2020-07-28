package view.orders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.LoginController;
import view.PanelChanger;

public class OrdersSidePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private LoginController loginController;
	JButton bNewOrder = new JButton("New Order");
	JButton bAllOrders = new JButton("All Orders");

	@SuppressWarnings("unused")
	private final PanelChanger panelchanger;

	public OrdersSidePanel(PanelChanger panelchanger) {

		this.loginController = new LoginController();
		this.panelchanger = panelchanger;
		bNewOrder.setPreferredSize(new Dimension(150, 50));
		bNewOrder.setBackground(Color.GRAY);
		bNewOrder.setForeground(Color.WHITE);
		bAllOrders.setPreferredSize(new Dimension(150, 50));
		bAllOrders.setBackground(Color.GRAY);
		bAllOrders.setForeground(Color.WHITE);

		this.setLayout(new GridLayout(15, 1, 5, 5));
		this.setBackground(Color.BLACK);
		
		if (!loginController.getLoggedUserRole().equals("Secretary")) {
			this.add(bNewOrder);
		}
		
		//this.add(bNewOrder);
		this.add(bAllOrders);

		bNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("Open New Order panel");
				panelchanger.updateWorkPanel("NewOrderPanel");

			}

		});

		bAllOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("Open All Orders panel");
				panelchanger.updateWorkPanel("AllOrdersPanel");

			}

		});
	}
}