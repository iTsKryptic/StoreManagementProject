package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AdminMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADMIN MENU");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(221, 23, 143, 30);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1_1 = new JButton("LOGOUT");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginView loginView = new LoginView();
				loginView.setVisible(true);
				loginView.setType("Admin");

			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(SystemColor.controlShadow);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(23, 365, 97, 36);
		contentPane.add(btnNewButton_1_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 567, 22);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("Store");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Store");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStoreView addStoreView = new AddStoreView();
				addStoreView.setVisible(true);

			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Remove Store");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveStoreView removeStoreView = new RemoveStoreView();
				removeStoreView.getValues();
				removeStoreView.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Update Store");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStore updateStore = new UpdateStore();
				updateStore.getValues();
				updateStore.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnNewMenu_1 = new JMenu("Item");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("Add Item");
		mntmNewMenuItem_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItemView addItemView = new AddItemView();
				addItemView.displayStore();
				addItemView.setVisible(true);

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1_2);

		JMenuItem mntmNewMenuItem_1_2_1_1 = new JMenuItem("Remove Item");
		mntmNewMenuItem_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveItemView removeItemView = new RemoveItemView();
				removeItemView.getValues();
				removeItemView.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1_2_1_1);

		JMenuItem mntmNewMenuItem_1_2_1 = new JMenuItem("Update Item");
		mntmNewMenuItem_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateItemView updateItemView = new UpdateItemView();
				updateItemView.getValues();
				updateItemView.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1_2_1);

		JMenu mnNewMenu_1_1 = new JMenu("Sale Item");
		menuBar.add(mnNewMenu_1_1);

		JMenuItem mntmNewMenuItem_1_2_2 = new JMenuItem("Add Sale");
		mntmNewMenuItem_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSaleItem aSaleItem = new AddSaleItem();
				aSaleItem.setvalues();
				aSaleItem.setVisible(true);
			}

		});
		mnNewMenu_1_1.add(mntmNewMenuItem_1_2_2);

		JMenuItem mntmNewMenuItem_1_2_1_2 = new JMenuItem("Remove Sale");
		mntmNewMenuItem_1_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveSaleItem removeSaleItem = new RemoveSaleItem();
				removeSaleItem.getValues();
				removeSaleItem.setVisible(true);
			}
		});
		mnNewMenu_1_1.add(mntmNewMenuItem_1_2_1_2);

		JMenu mnNewMenu_1_1_1 = new JMenu("Manager");
		menuBar.add(mnNewMenu_1_1_1);

		JMenuItem mntmNewMenuItem_1_2_2_1 = new JMenuItem("Add Manager");
		mntmNewMenuItem_1_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddManagerView addManagerView = new AddManagerView();
				addManagerView.getValues();
				addManagerView.setVisible(true);
			}
		});
		mnNewMenu_1_1_1.add(mntmNewMenuItem_1_2_2_1);

		JMenuItem mntmNewMenuItem_1_2_2_1_1 = new JMenuItem("Update Manager");
		mntmNewMenuItem_1_2_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateManager updateManager = new UpdateManager();
				updateManager.getValues();
				updateManager.setVisible(true);
			}
		});
		mnNewMenu_1_1_1.add(mntmNewMenuItem_1_2_2_1_1);

		JMenuItem mntmNewMenuItem_1_2_1_2_1 = new JMenuItem("Remove Manager");
		mntmNewMenuItem_1_2_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveManagerView removeManagerView = new RemoveManagerView();
				removeManagerView.getValues();
				removeManagerView.setVisible(true);
			}
		});
		mnNewMenu_1_1_1.add(mntmNewMenuItem_1_2_1_2_1);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_1.setBounds(0, 23, 567, 394);
		contentPane.add(lblNewLabel_1);
	}
}
