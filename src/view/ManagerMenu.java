package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ManagerMenuController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMenu extends JFrame {

	private JPanel contentPane;
	String storeID;
	ManagerMenuController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMenu frame = new ManagerMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getValues(String id) {
		storeID = controller.getManagers(id);
		System.out.println(storeID);
	}

	/**
	 * Create the frame.
	 */
	public ManagerMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new ManagerMenuController();

		JLabel lblNewLabel = new JLabel("Manager Menu");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(202, 11, 182, 30);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Add Items");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItemView addItemView = new AddItemView();
				addItemView.managerControl(storeID);
				addItemView.setVisible(true);
			}

		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(26, 88, 143, 30);
		contentPane.add(btnNewButton);

		JButton btnAddItems = new JButton("Update Items");
		btnAddItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateItemView updateItemView = new UpdateItemView();
				updateItemView.managerControl(storeID);
				updateItemView.setVisible(true);
			}
		});
		btnAddItems.setForeground(Color.WHITE);
		btnAddItems.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddItems.setBackground(SystemColor.controlShadow);
		btnAddItems.setBounds(206, 88, 152, 30);
		contentPane.add(btnAddItems);

		JButton btnRemoveItems = new JButton("Remove Items");
		btnRemoveItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveItemView removeItemView = new RemoveItemView();
				removeItemView.managerControl(storeID);
				removeItemView.setVisible(true);
			}
		});
		btnRemoveItems.setForeground(Color.WHITE);
		btnRemoveItems.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveItems.setBackground(SystemColor.controlShadow);
		btnRemoveItems.setBounds(392, 88, 143, 30);
		contentPane.add(btnRemoveItems);

		JButton btnAddItems_1 = new JButton("Add Sale Items");
		btnAddItems_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSaleItem addSaleItem = new AddSaleItem();
				addSaleItem.managerControl(storeID);
				addSaleItem.setVisible(true);
			}
		});
		btnAddItems_1.setForeground(Color.WHITE);
		btnAddItems_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddItems_1.setBackground(SystemColor.controlShadow);
		btnAddItems_1.setBounds(26, 152, 143, 30);
		contentPane.add(btnAddItems_1);

		JButton btnAddItems_1_1 = new JButton("Remove Sale Items");
		btnAddItems_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveSaleItem removeSaleItem = new RemoveSaleItem();
				removeSaleItem.managerControl(storeID);
				removeSaleItem.setVisible(true);
			}
		});
		btnAddItems_1_1.setForeground(Color.WHITE);
		btnAddItems_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddItems_1_1.setBackground(SystemColor.controlShadow);
		btnAddItems_1_1.setBounds(206, 152, 152, 30);
		contentPane.add(btnAddItems_1_1);

		JButton btnRemoveSale = new JButton("LOGOUT");
		btnRemoveSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginView loginView = new LoginView();
				loginView.setType("Manager");
				loginView.setVisible(true);
			}
		});
		btnRemoveSale.setForeground(Color.WHITE);
		btnRemoveSale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveSale.setBackground(SystemColor.controlShadow);
		btnRemoveSale.setBounds(392, 152, 143, 30);
		contentPane.add(btnRemoveSale);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_1.setBounds(0, 0, 558, 273);
		contentPane.add(lblNewLabel_1);
	}

}
