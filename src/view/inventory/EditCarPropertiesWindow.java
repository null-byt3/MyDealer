package view.inventory;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CarPropertiesController;
import controller.LoginController;
import model.InputValidation.InputValidationException;

public class EditCarPropertiesWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel main_panel, buttonsPanel;
	private JButton saveButton, deleteButton;
	private JLabel make_label, model_label, trim_label, type_label, price_label, colors_label;
	private JTextField make_field, model_field;
	private JComboBox<String> type_box;
	private JTextField[] trim_fields, price_fields, color_fields;
	private CarPropertiesController carpropscontroller = new CarPropertiesController();
	LoginController loginController = new LoginController();
	String model;

	EditCarPropertiesWindow(JFrame mainwindow, String carModel) {
		super(mainwindow);
		requestFocus();
		setModal(true);
		// setAlwaysOnTop(true);
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		setSize(350, 750);
		setLocation(500, 280);

		this.model = carModel;
		this.main_panel = createPanel();
		this.buttonsPanel = CreateButtonsPanel();

		if (model != null) {
			this.setTitle("Edit Car Property: " + carModel);
			populateFields(carModel);
			this.make_field.setEditable(false);
			this.model_field.setEditable(false);
			this.type_box.setSelectedItem(carpropscontroller.getType(model));
			this.type_box.setEnabled(false);
		} else {
			this.setTitle("Add Car Property");
			this.deleteButton.setVisible(false);
		}

		main_panel.setLayout(null);
		buttonsPanel.setLayout(null);
		main_panel.add(buttonsPanel);
		this.add(main_panel);
		setVisible(true);
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel();

		// MAKE
		make_label = new JLabel("Make:");
		make_field = new JTextField();
		make_label.setBounds(20, 10, 100, 50);
		make_field.setBounds(20, 50, 130, 30);
		panel.add(make_label);
		panel.add(make_field);

		// MODEL

		model_label = new JLabel("Model:");
		model_field = new JTextField();
		model_label.setBounds(170, 10, 100, 50);
		model_field.setBounds(170, 50, 130, 30);
		panel.add(model_label);
		panel.add(model_field);

		// TYPE

		type_label = new JLabel("Type:");
		type_label.setBounds(20, 70, 100, 50);
		type_box = new JComboBox<String>();
		type_box.setBounds(20, 110, 120, 30);

		for (String type : carpropscontroller.getAllCarTypes()) {
			type_box.addItem(type);
		}

		panel.add(type_label);
		panel.add(type_box);

		// TRIM LABEL
		trim_label = new JLabel("Trim:");
		trim_label.setBounds(20, 160, 100, 50);
		panel.add(trim_label);

		// PRICE LABEL
		price_label = new JLabel("Price:");
		price_label.setBounds(170, 160, 100, 50);
		panel.add(price_label);

		// TRIM + PRICE FIELDS
		trim_fields = new JTextField[5];
		price_fields = new JTextField[5];
		int trim_spacing = 200;

		for (int i = 0; i < 5; i++) {
			trim_fields[i] = new JTextField();
			trim_fields[i].setBounds(20, trim_spacing, 130, 30);

			price_fields[i] = new JTextField();
			price_fields[i].setBounds(170, trim_spacing, 130, 30);

			trim_spacing += 40;
			panel.add(trim_fields[i]);
			panel.add(price_fields[i]);
		}

		// COLOR LABEL
		colors_label = new JLabel("Colors:");
		colors_label.setBounds(20, 400, 100, 50);
		panel.add(colors_label);

		// COLOR FIELDS
		color_fields = new JTextField[10];

		int color_spacing = 440;

		for (int i = 0; i < 10; i += 2) {
			color_fields[i] = new JTextField();
			color_fields[i].setBounds(20, color_spacing, 130, 30);
			color_fields[i + 1] = new JTextField();
			color_fields[i + 1].setBounds(170, color_spacing, 130, 30);

			color_spacing += 40;

			panel.add(color_fields[i]);
			panel.add(color_fields[i + 1]);
		}

		return panel;
	}

	private void populateFields(String model) {
		make_field.setText(carpropscontroller.getMake(model));
		model_field.setText(model);

		Map<String, Integer> trim_map = carpropscontroller.getTrimsMap(model);

		int i = 0;
		for (Map.Entry<String, Integer> entry : trim_map.entrySet()) {
			trim_fields[i].setText(entry.getKey());
			price_fields[i].setText(Integer.toString(entry.getValue()));
			i++;
		}

		i = 0;

		for (String color : carpropscontroller.getColors(model)) {
			color_fields[i].setText(color);
			i++;
		}

	}

	public JPanel CreateButtonsPanel() {

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(20, 650, 300, 150);

		saveButton = new JButton("Save Property");
		saveButton.setBackground(Color.GREEN);
		saveButton.setForeground(Color.BLACK);
		saveButton.setBounds(0, 0, 130, 45);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (fieldValidator()) {
					if (model != null) {
						updateModel(model);
					} else {
						createModel();
					}

				}
			}
		});

		deleteButton = new JButton("Delete Property");
		deleteButton.setForeground(Color.BLACK);
		deleteButton.setBackground(Color.RED);
		deleteButton.setBounds(160, 0, 130, 45);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				carpropscontroller.deleteModel(model);
				JOptionPane.showMessageDialog(null, "Properties Deleted");
				dispose();
			}
		});

		buttonsPanel.add(saveButton);
		buttonsPanel.add(deleteButton);
		return buttonsPanel;
	}

	public boolean fieldValidator() {

		make_label.setForeground(Color.BLACK);
		model_label.setForeground(Color.BLACK);
		trim_label.setForeground(Color.BLACK);
		colors_label.setForeground(Color.BLACK);

		// MAKE AND MODEL
		if (make_field.getText().isEmpty()) {
			make_label.setForeground(Color.RED);
			JOptionPane.showMessageDialog(null, "Error: Make field empty");
			return false;
		}

		if (model_field.getText().isEmpty()) {
			model_label.setForeground(Color.RED);
			JOptionPane.showMessageDialog(null, "Error: Model field empty");
			return false;
		}

		// TRIMS AND PRICES
		int flag = 0;
		for (int i = 0; i < 5; i++) {

			// Check that at least 1 trim-price pair is filled
			if (!trim_fields[i].getText().isEmpty() && !price_fields[i].getText().isEmpty()) {

				// check that price_field only contains positive numbers
				if (!price_fields[i].getText().matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Error: Price field must contain a positive numeric value");
					return false;
				}

				flag++;
			}

			// Check that there are no trim names without prices or prices without trim
			// names
			if (!trim_fields[i].getText().isEmpty() && price_fields[i].getText().isEmpty()
					|| trim_fields[i].getText().isEmpty() && !price_fields[i].getText().isEmpty()) {
				trim_label.setForeground(Color.RED);
				JOptionPane.showMessageDialog(null, "Error: Trim name or price missing");
				return false;
			}
		}

		if (flag == 0) {
			trim_label.setForeground(Color.RED);
			JOptionPane.showMessageDialog(null, "Error: Property must contain at least one trim-price pair");
			return false;
		}

		// COLORS
		flag = 0;

		List<String> colorsList = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			if (!color_fields[i].getText().isEmpty()) {

				if (colorsList.contains(color_fields[i].getText())) {
					JOptionPane.showMessageDialog(null, "Error: Duplicate colors found");
					return false;
				}

				else {
					colorsList.add(color_fields[i].getText());
					flag++;
				}

			}

		}

		if (flag == 0) {
			JOptionPane.showMessageDialog(null, "Error: Property must contain at least one color");
			colors_label.setForeground(Color.RED);
			return false;
		}

		return true;
	}

	public void updateModel(String model) {

		Map<String, Integer> trims = new HashMap<String, Integer>();
		List<String> colors = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			if (!trim_fields[i].getText().isEmpty()) {
				trims.put(trim_fields[i].getText(), Integer.valueOf(price_fields[i].getText()));
			}
		}

		for (int i = 0; i < 10; i++) {
			if (!color_fields[i].getText().isEmpty()) {
				colors.add(color_fields[i].getText());
			}
		}

		carpropscontroller.updateModel(model, trims, colors);
		JOptionPane.showMessageDialog(null, "Model Updated");
		dispose();
	}

	public void createModel() {

		String type = (String) type_box.getSelectedItem();
		String make = make_field.getText();
		String model = model_field.getText();

		Map<String, Integer> trims = new HashMap<String, Integer>();
		List<String> colors = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			if (!trim_fields[i].getText().isEmpty()) {
				trims.put(trim_fields[i].getText(), Integer.valueOf(price_fields[i].getText()));
			}
		}

		for (int i = 0; i < 10; i++) {
			if (!color_fields[i].getText().isEmpty()) {
				colors.add(color_fields[i].getText());
			}
		}

		try {
			carpropscontroller.addModel(type, make, model, trims, colors);
			JOptionPane.showMessageDialog(null, "Model Created");
			dispose();
		} catch (InputValidationException e) {
			JOptionPane.showMessageDialog(null, e.toString());

			e.printStackTrace();
		}

	}
}
