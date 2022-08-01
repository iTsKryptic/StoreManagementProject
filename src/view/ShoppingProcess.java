package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Item;
import model.SaleItem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import controller.ShoppingProcessController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShoppingProcess extends JFrame {

	private JPanel contentPane;
	String storeID;
	String customerID;
	private JTable table;
	private JTextField searchBar;
	ArrayList<Item> items;
	ArrayList<SaleItem> saleItems;
	private JTable table_1;
	private JTable table_2;
	DefaultTableModel model;
	DefaultTableModel model1;
	DefaultTableModel model2;
	ShoppingProcessController controller;
	ArrayList<Item> cartItems;
	ArrayList<Integer> quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingProcess frame = new ShoppingProcess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getValues(String storeID, String customerID) {
		this.storeID = storeID;
		this.customerID = customerID;
		model = (DefaultTableModel) table.getModel();
		model1 = (DefaultTableModel) table_1.getModel();
		model2 = (DefaultTableModel) table_2.getModel();
		items = controller.getItems(storeID);
		saleItems = controller.returnSaleItems(storeID);
		cartItems = new ArrayList<>();
		quantity = new ArrayList<>();
		displayItems();
		displaySaleItems();

	}

	public void displayItems() {
		model.getDataVector().removeAllElements();
		table.revalidate();
		for (int i = 0; i < items.size(); i++) {
			for (int j = 0; j < saleItems.size(); j++) {
				if (items.get(i).getItemID().equals(saleItems.get(j).getItemID())) {
					items.remove(i);
				}
			}
		}

		for (Item item : items) {

			model.addRow(new Object[] { item.getItemID(), item.getItemName(), item.getItemPrice() });

		}

	}

	public void displaySaleItems() {
		model1.getDataVector().removeAllElements();
		table_1.revalidate();
		for (SaleItem item : saleItems) {
			model1.addRow(
					new Object[] { item.getItemID(), item.getItemName(), item.getItemPrice(), item.getPercentage() });
		}
	}

	/**
	 * Create the frame.
	 */
	public ShoppingProcess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new ShoppingProcessController();

		JLabel lblNewLabel = new JLabel("SHOPPING");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(374, 11, 121, 30);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 105, 235, 215);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int i = table.getSelectedRow();
					String iString = (String) table.getValueAt(i, 0);

					model2.getDataVector().removeAllElements();
					table_2.revalidate();

					for (Item item : items) {
						if (item.getItemID().equals(iString)) {
							model2.addRow(new Object[] { item.getItemCategory(), "Not in sale", "0%" });
						}
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Price" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Select Item");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(37, 75, 104, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Select Sale Item");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(282, 75, 104, 23);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Search By");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(605, 70, 104, 23);
		contentPane.add(lblNewLabel_1_1_1);

		JRadioButton nameRadioButton = new JRadioButton("Name");
		nameRadioButton.setBounds(600, 104, 60, 23);
		contentPane.add(nameRadioButton);

		JRadioButton categoryRadioButton = new JRadioButton("Category");
		categoryRadioButton.setBounds(662, 105, 85, 23);
		contentPane.add(categoryRadioButton);

		searchBar = new JTextField();
		searchBar.setBounds(605, 144, 175, 30);
		contentPane.add(searchBar);
		searchBar.setColumns(10);

		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameRadioButton.isSelected() == false && categoryRadioButton.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Please first select any search Option");
				} else {
					if (searchBar.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Search Bar can't be empty");

					} else {
						model.getDataVector().removeAllElements();
						table.revalidate();
						model1.getDataVector().removeAllElements();
						table_1.revalidate();
						if (nameRadioButton.isSelected()) {
							for (Item item : items) {
								if (item.getItemName().equals(searchBar.getText())) {
									model.addRow(
											new Object[] { item.getItemID(), item.getItemName(), item.getItemPrice() });
								}

							}

							for (SaleItem item : saleItems) {
								if (item.getItemName().equals(searchBar.getText())) {
									model1.addRow(new Object[] { item.getItemID(), item.getItemName(),
											item.getItemPrice(), item.getPercentage() });
								}

							}
						} else if (categoryRadioButton.isSelected()) {
							for (Item item : items) {
								if (item.getItemCategory().equals(searchBar.getText())) {
									model.addRow(
											new Object[] { item.getItemID(), item.getItemName(), item.getItemPrice() });
								}

							}

							for (SaleItem item : saleItems) {
								if (item.getItemCategory().equals(searchBar.getText())) {
									model1.addRow(new Object[] { item.getItemID(), item.getItemName(),
											item.getItemPrice(), item.getPercentage() });
								}

							}
						}

					}
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(605, 186, 175, 23);
		contentPane.add(btnNewButton);

		JButton btnAddToCart = new JButton("ADD TO CART");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					int row1 = table_1.getSelectedRow();
					if (row == -1 && row1 == -1) {
						JOptionPane.showMessageDialog(null, "Please First Select any Item to Add");
					} else {
						if (row != -1 && row1 != -1) {
							JOptionPane.showMessageDialog(null, "Please Select one Item at a time");
						} else if (row != -1 && row1 == -1) {
							String itemIDString = (String) table.getValueAt(row, 0);
							Item cartItem = null;
							for (Item item : items) {
								if (item.getItemID().equals(itemIDString)) {
									cartItem = item;
								}
							}
							cartItems.add(cartItem);

						} else if (row == -1 && row1 != -1) {
							String itemIDString = (String) table_1.getValueAt(row1, 0);

							Item cartItem = null;
							for (SaleItem item : saleItems) {
								if (item.getItemID().equals(itemIDString)) {
									cartItem = item;
								}
							}
							cartItems.add(cartItem);

						}

						String inputString = JOptionPane.showInputDialog("Enter Quantity of items",
								JOptionPane.OK_OPTION);
						quantity.add(Integer.parseInt(inputString));
						table.clearSelection();
						table_1.clearSelection();
						JOptionPane.showMessageDialog(null, "Item Successfully added in Cart");

					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		btnAddToCart.setForeground(Color.WHITE);
		btnAddToCart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddToCart.setBackground(SystemColor.controlShadow);
		btnAddToCart.setBounds(605, 232, 175, 30);
		contentPane.add(btnAddToCart);

		JButton btnShowCart = new JButton("SHOW CART");
		btnShowCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Cart cart = new Cart();
				cart.getVlues(cartItems, quantity, customerID, storeID);
				cart.setVisible(true);
			}
		});
		btnShowCart.setForeground(Color.WHITE);
		btnShowCart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnShowCart.setBackground(SystemColor.controlShadow);
		btnShowCart.setBounds(605, 290, 175, 30);
		contentPane.add(btnShowCart);

		JButton btnMainMenu = new JButton("MAIN MENU");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerMenuView customerMenuView = new CustomerMenuView();
				customerMenuView.getValues(customerID);
				customerMenuView.setVisible(true);
			}
		});
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMainMenu.setBackground(SystemColor.controlShadow);
		btnMainMenu.setBounds(605, 417, 175, 30);
		contentPane.add(btnMainMenu);

		JLabel lblNewLabel_1_2 = new JLabel("Item Information");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(37, 342, 104, 23);
		contentPane.add(lblNewLabel_1_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(282, 105, 293, 215);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					model2.getDataVector().removeAllElements();
					table_2.revalidate();

					int i = table_1.getSelectedRow();
					String iString = (String) table_1.getValueAt(i, 0);

					for (SaleItem item : saleItems) {
						if (item.getItemID().equals(iString)) {
							model2.addRow(new Object[] { item.getItemCategory(), item.getDuration(),
									item.getPercentage() + "%" });
						}
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		table_1.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Price", "Discount(%)" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		scrollPane_1.setViewportView(table_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(37, 375, 540, 72);
		contentPane.add(scrollPane_2);

		table_2 = new JTable();
		table_2.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Category", "Sale Duration", "Discount" }) {
					boolean[] columnEditables = new boolean[] { false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		scrollPane_2.setViewportView(table_2);

		JRadioButton rdbtnAll = new JRadioButton("All");
		rdbtnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayItems();
				displaySaleItems();
			}
		});
		rdbtnAll.setBounds(764, 108, 71, 23);
		contentPane.add(rdbtnAll);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 835, 458);
		contentPane.add(lblNewLabel_2);
	}
}
