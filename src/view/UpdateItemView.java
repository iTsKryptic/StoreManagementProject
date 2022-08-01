package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.UpdateItemController;
import model.Item;
import model.Store;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;
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
import java.security.Identity;

public class UpdateItemView extends JFrame {

	private JPanel contentPane;
	private JTextField itemID;
	private JTextField name;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField category;
	private JTextField price;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JTable table;
	DefaultTableModel model;
	private JComboBox storeCombo;
	ArrayList<Store> stores;
	ArrayList<Item> items;
	UpdateItemController controller;
	private JLabel lblNewLabel_5;
	String storeID = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateItemView frame = new UpdateItemView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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

	public void managerControl(String storeID) {
		this.storeID = storeID;
		model = (DefaultTableModel) table.getModel();
		storeCombo.setVisible(false);
		display();
	}

	public void getValues() {
		stores = controller.getStores();
		items = controller.getItems();
		model = (DefaultTableModel) table.getModel();
		for (Store store : stores) {

			storeCombo.addItem(store.getId() + ":" + store.getName());
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
	public UpdateItemView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 731, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new UpdateItemController();

		JLabel lblNewLabel = new JLabel("UPDATE ITEM");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(298, 11, 163, 37);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ITEM ID");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(48, 107, 63, 25);
		contentPane.add(lblNewLabel_1);

		itemID = new JTextField();
		itemID.setEditable(false);
		itemID.setBounds(48, 131, 163, 25);
		contentPane.add(itemID);
		itemID.setColumns(10);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(48, 202, 163, 25);
		contentPane.add(name);

		lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(48, 178, 63, 25);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Category");
		lblNewLabel_3.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(48, 326, 63, 25);
		contentPane.add(lblNewLabel_3);

		category = new JTextField();
		category.setColumns(10);
		category.setBounds(48, 350, 163, 25);
		contentPane.add(category);

		price = new JTextField();
		price.setColumns(10);
		price.setBounds(48, 277, 163, 25);
		contentPane.add(price);

		lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(48, 253, 63, 25);
		contentPane.add(lblNewLabel_4);

		btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (itemID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please first select any item to update");
				} else {
					if (name.getText().isEmpty() || price.getText().isEmpty() || category.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Error. Empty Fields");
					} else {
						controller.updateItem(itemID.getText(), name.getText(), price.getText(), category.getText());
						if (storeID.isEmpty()) {
							displayItems();
						} else {
							display();
						}

						JOptionPane.showMessageDialog(null, "Successfully Updated Item");
						itemID.setText("");
						name.setText("");
						price.setText("");
						category.setText("");
					}
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(48, 405, 163, 31);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(273, 59, 398, 377);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					int i = table.getSelectedRow();
					System.out.println(i);
					itemID.setText((String) table.getValueAt(i, 0));
					name.setText((String) table.getValueAt(i, 1));
					category.setText((String) table.getValueAt(i, 2));
					price.setText((Double) table.getValueAt(i, 3) + "");

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
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
		storeCombo.setBounds(48, 58, 163, 25);
		contentPane.add(storeCombo);

		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_5.setBounds(0, 0, 715, 459);
		contentPane.add(lblNewLabel_5);
	}
}
