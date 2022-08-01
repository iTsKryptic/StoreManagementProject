package view;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.RemoveItemController;
import model.Item;
import model.Store;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveItemView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox storeCombo;
	DefaultTableModel model;
	ArrayList<Store> stores;
	ArrayList<Item> items;
	RemoveItemController controller;
	String storeID = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveItemView frame = new RemoveItemView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getValues() {
		stores = controller.getStores();
		items = controller.getItems();
		model = (DefaultTableModel) table.getModel();
		for (Store store : stores) {

			storeCombo.addItem(store.getId() + ":" + store.getName());
		}
	}

	public void managerControl(String storeID) {
		this.storeID = storeID;
		model = (DefaultTableModel) table.getModel();
		storeCombo.setVisible(false);
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
	public RemoveItemView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new RemoveItemController();

		JLabel lblNewLabel = new JLabel("REMOVE ITEM");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(266, 11, 180, 30);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 133, 591, 279);
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
		storeCombo.setBounds(46, 67, 136, 30);
		contentPane.add(storeCombo);

		JLabel lblNewLabel_1 = new JLabel("Select Item To delete");
		lblNewLabel_1.setBounds(45, 108, 137, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i == -1) {
					JOptionPane.showMessageDialog(null, "Please Select any Item to delete");
				} else {

					int choice = JOptionPane.showConfirmDialog(null, "Confirm again to delete Store", "Choice",
							JOptionPane.YES_NO_OPTION);

					if (choice == 0) {

						String itemID = (String) table.getValueAt(i, 0);
						controller.removeItem(itemID);

						if (!storeID.isEmpty()) {
							display();
						} else {
							displayItems();
						}

					} else {
						JOptionPane.showMessageDialog(null, "Cancelled");
					}

				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setBounds(323, 422, 89, 30);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 684, 463);
		contentPane.add(lblNewLabel_2);
	}
}
