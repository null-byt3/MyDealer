package view.reports;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.LoginController;
import view.PanelChanger;

public class ReportsSidePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private final PanelChanger panelchanger;

	JButton bMyReports = new JButton("My Reports");
	JButton bAllReports = new JButton("All Reports");
	LoginController logincontroller;

	public ReportsSidePanel(PanelChanger panelchanger) {

		logincontroller = new LoginController();
		this.panelchanger = panelchanger;
		bMyReports.setPreferredSize(new Dimension(150, 100));
		bMyReports.setBackground(Color.GRAY);
		bMyReports.setForeground(Color.WHITE);
		bAllReports.setPreferredSize(new Dimension(150, 100));
		bAllReports.setBackground(Color.GRAY);
		bAllReports.setForeground(Color.WHITE);

		this.setLayout(new GridLayout(15, 1, 5, 5));
		this.setBackground(Color.BLACK);
		this.add(bMyReports);

		if (logincontroller.getLoggedUserRole().equals("Manager")) {
			this.add(bAllReports);
		}

		bMyReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelchanger.updateWorkPanel("MyReportsPanel");

			}

		});

		bAllReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelchanger.updateWorkPanel("AllReportsPanel");

			}

		});
	}

}
