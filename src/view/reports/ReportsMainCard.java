package view.reports;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ReportsMainCard extends JPanel {

	private static final long serialVersionUID = 1L;
	BorderLayout bl = new BorderLayout(2,2);
	ReportsCardChanger reportscardchanger;
	ReportsSidePanel reportssidepanel;
	
	public ReportsMainCard() {
		this.setLayout(bl);
		
		reportscardchanger = new ReportsCardChanger();
		reportssidepanel = new ReportsSidePanel(reportscardchanger);
		
		this.add(reportssidepanel,BorderLayout.WEST);
		this.add(reportscardchanger, BorderLayout.CENTER);
		this.setBackground(Color.ORANGE);
	}
}
