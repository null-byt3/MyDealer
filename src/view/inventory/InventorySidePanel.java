package view.inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.PanelChanger;

public class InventorySidePanel extends JPanel {

	JButton bAll = new JButton("All");
	JButton bCarProps = new JButton("Car Properties");
	JButton bAddInventory = new JButton("Add Inventory");

	private final PanelChanger panelchanger;

	public InventorySidePanel(PanelChanger panelchanger) {

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
		this.add(bAddInventory);
		this.add(bCarProps);
	}
}