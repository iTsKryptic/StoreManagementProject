package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.RemoveStoreController;
import model.Store;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveStoreView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;
	ArrayList<Store> stores;
	RemoveStoreController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveStoreView frame = new RemoveStoreView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getValues() {

		displayStores();
	}

	public void displayStores() {
		stores = controller.getStores();
		model.getDataVector().removeAllElements();
		table.revalidate();
		for (Store store : stores) {
			model.addRow(new Object[] { store.getId(), store.getName(), store.getAddress(), store.getOpen(),
					store.getClose() });

		}
	}

	/**
	 * Create the frame.
	 */
	public RemoveStoreView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new RemoveStoreController();

		JLabel lblNewLabel = new JLabel("REMOVE STORE");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(267, 11, 173, 30);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 80, 623, 295);
		contentPane.add(scrollPane);

		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = { "ID", "Name", "Address", "Opening Time", "Closing Time" };
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Select Store to Remove");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(36, 43, 196, 26);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i == -1) {
					JOptionPane.showMessageDialog(null, "Please Select any store to delete");
				} else {
					int choice = JOptionPane.showConfirmDialog(null, "Confirm again to delete Store" ,"Choice",
							JOptionPane.YES_NO_OPTION);
					if (choice == 0) {
						String storeIDString = (String) table.getValueAt(i, 0);
						controller.deleteStore(storeIDString);
						displayStores();
					} else {
						JOptionPane.showMessageDialog(null, "Cancelled");
					}

				}

			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setBounds(320, 386, 89, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 694, 432);
		contentPane.add(lblNewLabel_2);
	}
}
