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
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.CustomerMenuController;
import model.Store;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CustomerMenuView extends JFrame {
	private JTable table;
	private JTextField searchBar;
	String idString;
	DefaultTableModel model;
	CustomerMenuController controller;
	String locationString;
	ArrayList<Store> stores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMenuView frame = new CustomerMenuView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getValues(String ID) {
		idString = ID;
		model = (DefaultTableModel) table.getModel();
		locationString = controller.returnLocation(idString);
		stores = controller.getStores(locationString);
		displayStores();

	}

	public void displayStores() {
		model.getDataVector().removeAllElements();
		table.revalidate();
		for (Store store : stores) {
			model.addRow(new Object[] { store.getName(), store.getAddress() });
		}

	}

	/**
	 * Create the frame.
	 */
	public CustomerMenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 423);
		getContentPane().setLayout(null);

		controller = new CustomerMenuController();

		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(269, 11, 106, 30);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Stores nearby You");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(313, 72, 137, 18);
		getContentPane().add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(313, 95, 279, 216);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Location" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		searchBar = new JTextField();
		searchBar.setBounds(51, 94, 199, 30);
		getContentPane().add(searchBar);
		searchBar.setColumns(10);

		JButton btnNewButton = new JButton("Search Store by Name");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (searchBar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Search Bar can't be empty");
					displayStores();
				} else {
					model.getDataVector().removeAllElements();
					table.revalidate();
					for (Store store : stores) {
						if (store.getName().equals(searchBar.getText())) {
							model.addRow(new Object[] { store.getName(), store.getAddress() });
						}
					}
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setBounds(51, 150, 199, 30);
		getContentPane().add(btnNewButton);

		JButton btnEnterStore = new JButton("ENTER STORE");
		btnEnterStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i == -1) {
					JOptionPane.showMessageDialog(null, "Please Select any store to enter");
				} else {
					String storeNameString = (String) table.getValueAt(i, 0);
					String storeLocaString = (String) table.getValueAt(i, 1);

					String storeIDString = null;
					for (Store store : stores) {
						if (store.getName().equals(storeNameString) && store.getAddress().equals(storeLocaString)) {
							storeIDString = store.getId();
						}
					}
					dispose();

					ShoppingProcess shoppingProcess = new ShoppingProcess();
					shoppingProcess.getValues(storeIDString, idString);
					shoppingProcess.setVisible(true);

				}
			}
		});
		btnEnterStore.setForeground(Color.WHITE);
		btnEnterStore.setBackground(SystemColor.controlShadow);
		btnEnterStore.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnterStore.setBounds(51, 280, 199, 30);
		getContentPane().add(btnEnterStore);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginView loginView = new LoginView();
				loginView.setType("Customer");
				loginView.setVisible(true);
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setBackground(SystemColor.controlShadow);
		btnLogout.setBounds(488, 330, 106, 30);
		getContentPane().add(btnLogout);

		JButton btnChangeInfo = new JButton("Change INFO");
		btnChangeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCustomerView updateCustomerView = new UpdateCustomerView();
				updateCustomerView.getValues(idString);
				updateCustomerView.setVisible(true);
			}
		});
		btnChangeInfo.setForeground(Color.WHITE);
		btnChangeInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChangeInfo.setBackground(SystemColor.controlShadow);
		btnChangeInfo.setBounds(313, 330, 124, 30);
		getContentPane().add(btnChangeInfo);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 645, 384);
		getContentPane().add(lblNewLabel_2);
	}
}
