package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Item;
import model.SaleItem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cart extends JFrame {
	ArrayList<Item> items;
	ArrayList<Integer> quantity;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	String customerID;
	String storeID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getVlues(ArrayList<Item> items, ArrayList<Integer> quantity, String customerID, String storeID) {
		this.items = items;
		this.customerID = customerID;
		this.quantity = quantity;
		this.storeID = storeID;
		model = (DefaultTableModel) table.getModel();

		displayItems();
	}

	public void displayItems() {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof SaleItem) {
				SaleItem item = (SaleItem) items.get(i);
				model.addRow(new Object[] { items.get(i).getItemID(), items.get(i).getItemName(),
						items.get(i).getItemPrice(), quantity.get(i), item.getPercentage() });
			} else {
				model.addRow(new Object[] { items.get(i).getItemID(), items.get(i).getItemName(),
						items.get(i).getItemPrice(), quantity.get(i), "No Discount" });
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public Cart() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 730, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CART");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(339, 11, 86, 30);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 61, 654, 345);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Item ID", "Name", "Price", "Quantity", "Discount(%)" }) {
			boolean[] columnEditables = new boolean[] { true, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setEnabled(false);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("CONFIRM BUY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerMenuView customerMenuView = new CustomerMenuView();
				customerMenuView.getValues(customerID);
				customerMenuView.setVisible(true);
				JOptionPane.showMessageDialog(null, "Shopping Successfully Completed. You can shop again");
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(560, 418, 125, 43);
		contentPane.add(btnNewButton);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ShoppingProcess shoppingProcess = new ShoppingProcess();
				shoppingProcess.getValues(storeID, customerID);
				shoppingProcess.cartItems = items;
				shoppingProcess.quantity = quantity;
				shoppingProcess.setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(SystemColor.controlShadow);
		btnBack.setBounds(31, 417, 125, 43);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_1.setBounds(0, 0, 714, 472);
		contentPane.add(lblNewLabel_1);
	}
}
