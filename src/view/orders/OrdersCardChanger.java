package view.orders;

import java.awt.CardLayout;

import javax.swing.JPanel;

import view.PanelChanger;
import view.WelcomePanel;

public class OrdersCardChanger extends JPanel implements PanelChanger {

	private static final long serialVersionUID = 1L;
	NewOrderPanel neworderpanel = new NewOrderPanel();
	AllOrdersPanel allorderspanel = new AllOrdersPanel();
	WelcomePanel welcomepanel = new WelcomePanel();

	CardLayout cl = new CardLayout();

	public OrdersCardChanger() {
		this.setLayout(cl);
		this.add(welcomepanel, "WelcomePanel");
		this.add(neworderpanel, "NewOrderPanel");
		this.add(allorderspanel, "AllOrdersPanel");
		cl.show(this, "WelcomePanel");
	}

	@Override
	public void updateWorkPanel(String panelName) {

		if (panelName.equals("NewOrderPanel")) {
			this.remove(neworderpanel);
			neworderpanel = new NewOrderPanel();
			this.add(neworderpanel, "NewOrderPanel");
		}

		if (panelName.equals("AllOrdersPanel")) {
			this.remove(allorderspanel);
			allorderspanel = new AllOrdersPanel();
			this.add(allorderspanel, "AllOrdersPanel");
		}

		cl.show(this, panelName);
		System.out.println("OrdersCardChanger card changed to: " + panelName);

	}
}