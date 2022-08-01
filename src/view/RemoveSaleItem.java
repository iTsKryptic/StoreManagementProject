package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.RemoveSaleItemController;
import model.SaleItem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class RemoveSaleItem extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	ArrayList<SaleItem> saleItems;
	RemoveSaleItemController controller;
	String storeID = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveSaleItem frame = new RemoveSaleItem();
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

	public void getValues() {
		model = (DefaultTableModel) table.getModel();
		displayItems();
	}

	public void displayItems() {
		model.getDataVector().removeAllElements();
		table.revalidate();
		saleItems = controller.returnSaleItems();
		for (SaleItem saleItem : saleItems) {
			model.addRow(new Object[] { saleItem.getItemID(), saleItem.getItemName(), saleItem.getItemCategory(),
					saleItem.getItemPrice(), saleItem.getDuration(), saleItem.getPercentage() });
		}
	}

	public void display() {
		model.getDataVector().removeAllElements();
		table.revalidate();
		saleItems = controller.returnSaleItems(storeID);
		for (SaleItem saleItem : saleItems) {
			model.addRow(new Object[] { saleItem.getItemID(), saleItem.getItemName(), saleItem.getItemCategory(),
					saleItem.getItemPrice(), saleItem.getDuration(), saleItem.getPercentage() });
		}
	}

	/**
	 * Create the frame.
	 */
	public RemoveSaleItem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 690, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new RemoveSaleItemController();

		JLabel lblNewLabel = new JLabel("REMOVE SALE ITEM");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(235, 11, 222, 30);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 69, 607, 299);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Category", "Price", "Duration", "Percentage" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i == -1) {
					JOptionPane.showMessageDialog(null, "Please select any sale item to delete");
				} else {
					String idString = (String) table.getValueAt(i, 0);
					int choice = JOptionPane.showConfirmDialog(null, "Confirm again to delete Item from sale", "Choice",
							JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						controller.deleteItem(idString);
						if (storeID.isEmpty()) {
							displayItems();
						} else {
							display();
						}

						JOptionPane.showMessageDialog(null, "Successfully Deleted item from sale");

					} else {
						JOptionPane.showMessageDialog(null, "Cancelled");
					}

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(300, 382, 103, 37);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_1.setBounds(0, 0, 674, 430);
		contentPane.add(lblNewLabel_1);
	}
}
