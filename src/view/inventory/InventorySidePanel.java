package view.inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.LoginController;
import view.PanelChanger;

public class InventorySidePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JButton bAll = new JButton("All Inventory");
	JButton bCarProps = new JButton("Car Properties");
	JButton bAddInventory = new JButton("Add Inventory");

	LoginController logincontroller;
	@SuppressWarnings("unused")
	private final PanelChanger panelchanger;

	public InventorySidePanel(PanelChanger panelchanger) {

		logincontroller = new LoginController();

		this.panelchanger = panelchanger;
		bAll.setPreferredSize(new Dimension(150, 100));
		bAll.setBackground(Color.GRAY);
		bAll.setForeground(Color.WHITE);
		bAddInventory.setPreferredSize(new Dimension(150, 100));
		bAddInventory.setBackground(Color.GRAY);
		bAddInventory.setForeground(Color.WHITE);
		bCarProps.setPreferredSize(new Dimension(150, 100));
		bCarProps.setBackground(Color.GRAY);
		bCarProps.setForeground(Color.WHITE);

		bAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelchanger.updateWorkPanel("AllInventoryPanel");

			}

		});

		bCarProps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelchanger.updateWorkPanel("CarPropertiesPanel");

			}

		});

		bAddInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelchanger.updateWorkPanel("AddInventoryPanel");

			}

		});

		this.setLayout(new GridLayout(15, 1, 5, 5));
		this.setBackground(Color.BLACK);
		this.add(bAll);

		if (logincontroller.getLoggedUserRole().equals("Manager")) {
			this.add(bAddInventory);
			this.add(bCarProps);
		}

	}
}