package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;

import controller.AddSaleItemController;
import model.Item;
import model.SaleItem;
import model.Store;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;

public class AddSaleItem extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox storeCombo;
	DefaultTableModel model;
	private JTextField duration;
	private JTextField percentage;
	ArrayList<Store> stores;
	ArrayList<Item> items;
	ArrayList<SaleItem> saleItems;
	AddSaleItemController controller;
	String storeID = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSaleItem frame = new AddSaleItem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void managerControl(String storeID) {
		this.storeID = storeID;
		model = (DefaultTableModel) table.getModel();
		display();

	}

	public void display() {
		model.getDataVector().removeAllElements();
		table.revalidate();
		items = controller.getItems(storeID);
		saleItems = controller.returnSaleItems();
		storeCombo.setVisible(false);
		for (Item item : items) {

			model.addRow(
					new Object[] { item.getItemID(), item.getItemName(), item.getItemCategory(), item.getItemPrice() });

		}

	}

	public void setvalues() {
		stores = controller.getStores();

		model = (DefaultTableModel) table.getModel();
		for (Store store : stores) {

			storeCombo.addItem(store.getId() + ":" + store.getName());
		}

	}

	public void displayItems() {
		model.getDataVector().removeAllElements();
		table.revalidate();
		items = controller.getItems();
		saleItems = controller.returnSaleItems();
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
	public AddSaleItem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new AddSaleItemController();

		JLabel lblNewLabel = new JLabel("ADD SALE ITEMS");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(288, 11, 183, 30);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 142, 417, 233);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Category", "Price" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		storeCombo = new JComboBox();
		storeCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItems();
			}
		});
		storeCombo.setModel(new DefaultComboBoxModel(new String[] { "Select store" }));
		storeCombo.setBounds(24, 66, 149, 30);
		contentPane.add(storeCombo);

		JLabel lblNewLabel_1 = new JLabel("Select Item for sale");
		lblNewLabel_1.setBounds(24, 117, 149, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Sale Duration");
		lblNewLabel_2.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(510, 149, 91, 21);
		contentPane.add(lblNewLabel_2);

		duration = new JTextField();
		duration.setBounds(509, 181, 141, 30);
		contentPane.add(duration);
		duration.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Sale Percentage");
		lblNewLabel_2_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(509, 236, 117, 21);
		contentPane.add(lblNewLabel_2_1);

		percentage = new JTextField();
		percentage.setColumns(10);
		percentage.setBounds(509, 260, 141, 30);
		contentPane.add(percentage);

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i == -1) {
					JOptionPane.showMessageDialog(null, "Please Select any item to add for sale");
				} else {
					if (duration.getText().isEmpty() || percentage.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Error. No fields should be empty.");
					} else {

						Boolean flag = false;
						String item = (String) table.getValueAt(i, 0);
						String name = (String) table.getValueAt(i, 1);
						String categor = (String) table.getValueAt(i, 2);
						double price = (double) table.getValueAt(i, 3);
						for (SaleItem sale : saleItems) {
							if (sale.getItemID().equals(item)) {
								flag = true;
							}
						}

						if (flag) {
							JOptionPane.showMessageDialog(null, "Item already exists in Sale");
						} else {
							String parts[] = storeCombo.getSelectedItem().toString().split(":");

							if (storeID.isEmpty()) {
								controller.saveSaleItem(parts[0], item, name, categor, price, duration.getText(),
										percentage.getText());
							} else {
								controller.saveSaleItem(storeID, item, name, categor, price, duration.getText(),
										percentage.getText());
							}

							JOptionPane.showMessageDialog(null, "Successfully added item to sale");
							duration.setText("");
							percentage.setText("");
							table.clearSelection();
							saleItems = controller.returnSaleItems();
						}

					}
				}

			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(510, 344, 140, 38);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_3.setBounds(0, 0, 677, 436);
		contentPane.add(lblNewLabel_3);
	}
}
