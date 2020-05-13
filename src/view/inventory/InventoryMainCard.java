package view.inventory;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class InventoryMainCard extends JPanel {

	BorderLayout bl = new BorderLayout(2,2);
	InventoryCardChanger inventorycardchanger = new InventoryCardChanger();
	InventorySidePanel inventorysidepanel = new InventorySidePanel(inventorycardchanger);
	
	public InventoryMainCard() {
		this.setLayout(bl);
		this.add(inventorysidepanel,BorderLayout.WEST);
		this.add(inventorycardchanger, BorderLayout.CENTER);
		this.setBackground(Color.ORANGE);
	}
}
