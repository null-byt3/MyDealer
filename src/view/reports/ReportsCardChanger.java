package view.reports;

import java.awt.CardLayout;

import javax.swing.JPanel;

import view.PanelChanger;
import view.WelcomePanel;

public class ReportsCardChanger extends JPanel implements PanelChanger {

	private static final long serialVersionUID = 1L;
	MyReportsPanel myReportsPanel;
	AllReportsPanel allReportsPanel;
	WelcomePanel welcomepanel;

	CardLayout cl = new CardLayout();

	public ReportsCardChanger() {
		this.setLayout(cl);
		this.myReportsPanel = new MyReportsPanel();
		this.allReportsPanel = new AllReportsPanel();
		this.welcomepanel = new WelcomePanel();

		this.add(welcomepanel, "WelcomePanel");
		this.add(myReportsPanel, "MyReportsPanel");
		this.add(allReportsPanel, "AllReportsPanel");
		cl.show(this, "WelcomePanel");
	}

	@Override
	public void updateWorkPanel(String panelName) {

		if (panelName.equals("MyReportsPanel")) {
			this.remove(myReportsPanel);
			myReportsPanel = new MyReportsPanel();
			this.add(myReportsPanel, "MyReportsPanel");
		}

		if (panelName.equals("AllReportsPanel")) {
			this.remove(allReportsPanel);
			allReportsPanel = new AllReportsPanel();
			this.add(allReportsPanel, "AllReportsPanel");
		}

		cl.show(this, panelName);

		System.out.println("ClientsCardChanger card changed to: " + panelName);

	}

}
