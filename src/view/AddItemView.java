package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AddItemController;
import model.Item;
import model.Store;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddItemView extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField category;
	private JTextField price;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JComboBox storeCombo;
	private JTable table;
	DefaultTableModel model;
	ArrayList<Store> stores;
	ArrayList<Item> items;
	AddItemController controller;
	Object[] row;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	String storeID = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemView frame = new AddItemView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void displayStore() {
		stores = controller.getStores();
		model = (DefaultTableModel) table.getModel();
		for (Store store : stores) {

			storeCombo.addItem(store.getId() + ":" + store.getName());
		}
	}

	public void managerControl(String storeID) {
		this.storeID = storeID;
		storeCombo.setVisible(false);
		model = (DefaultTableModel) table.getModel();
		display();

	}

	public void display() {
		model.getDataVector().removeAllElements();
		table.revalidate();
		items = controller.getItems(storeID);

		for (Item item : items) {

			model.addRow(
					new Object[] { item.getItemID(), item.getItemName(), item.getItemCategory(), item.getItemPrice() });

		}

	}

	public void displayItems() {
		model.getDataVector().removeAllElements();
		table.revalidate();
		items = controller.getItems();
		if (storeCombo.getSelectedIndex() != -1) {
			String storeID = storeCombo.getSelectedItem().toString();
			String parts[] = storeID.split(":");

			for (Item item : items) {

				if (parts[0].equals(item.getStoreID())) {

					model.addRow(new Object[] { item.getItemID(), item.getItemName(), item.getItemCategory(),
							item.getItemPrice() });
				}

			}

		}
	}

	/**
	 * Create the frame.
	 */
	public AddItemView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 731, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new AddItemController();

		JLabel lblNewLabel = new JLabel("ADD ITEM");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(298, 11, 115, 37);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ITEM ID");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(47, 123, 63, 25);
		contentPane.add(lblNewLabel_1);

		id = new JTextField();
		id.setBounds(47, 147, 163, 25);
		contentPane.add(id);
		id.setColumns(10);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(47, 207, 163, 25);
		contentPane.add(name);

		lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(47, 183, 63, 25);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Category");
		lblNewLabel_3.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(47, 327, 63, 25);
		contentPane.add(lblNewLabel_3);

		category = new JTextField();
		category.setColumns(10);
		category.setBounds(47, 351, 163, 25);
		contentPane.add(category);

		price = new JTextField();
		price.setColumns(10);
		price.setBounds(47, 278, 163, 25);
		contentPane.add(price);

		lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(47, 254, 63, 25);
		contentPane.add(lblNewLabel_4);

		btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (storeCombo.getSelectedIndex() == -1 || id.getText().isEmpty() || name.getText().isEmpty()
						|| price.getText().isEmpty() || category.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Error. Empty Fields");
				} else {
					if (!storeID.isEmpty()) {
						controller.saveItems(storeID, id.getText(), name.getText(), price.getText(),
								category.getText());
						display();
					} else {
						String parts[] = storeCombo.getSelectedItem().toString().split(":");
						controller.saveItems(parts[0], id.getText(), name.getText(), price.getText(),
								category.getText());
						displayItems();
					}

					JOptionPane.showMessageDialog(null, "Successfully Added Item");
					id.setText("");
					name.setText("");
					price.setText("");
					category.setText("");

				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(47, 406, 163, 31);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(273, 100, 398, 337);
		contentPane.add(scrollPane);

		table = new JTable();

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Category", "Price" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		storeCombo = new JComboBox();
		storeCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItems();
			}
		});

		storeCombo.setModel(new DefaultComboBoxModel(new String[] { "Select Store" }));
		storeCombo.setBounds(47, 75, 163, 25);
		contentPane.add(storeCombo);

		lblNewLabel_5 = new JLabel("Store Inventory");
		lblNewLabel_5.setBounds(273, 80, 97, 14);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_6.setBounds(0, 0, 715, 467);
		contentPane.add(lblNewLabel_6);
	}
}
