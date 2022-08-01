package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.RemoveItemController;
import controller.RemoveManagerController;
import model.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveManagerView extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	private JTable table;
	ArrayList<Manager> managers;
	RemoveManagerController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveManagerView frame = new RemoveManagerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getValues() {
		model = (DefaultTableModel) table.getModel();
		displayManagers();

	}

	public void displayManagers() {
		managers = controller.getManagers();
		model.getDataVector().removeAllElements();
		table.revalidate();

		for (Manager manager : managers) {
			model.addRow(
					new Object[] { manager.getId(), manager.getName(), manager.getAddress(), manager.getStoreID() });
		}
	}

	/**
	 * Create the frame.
	 */
	public RemoveManagerView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 671, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new RemoveManagerController();

		JLabel lblNewLabel = new JLabel("REMOVE MANAGER");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(209, 11, 210, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Select Manger to Delete");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 45, 176, 24);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = table.getSelectedRow();
				String managerID = (String) table.getValueAt(i, 0);
				controller.deleteManager(managerID);
				displayManagers();
				JOptionPane.showMessageDialog(null, "Successfully deleted Manager");

			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(270, 362, 102, 30);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 84, 571, 255);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Address", "Assigned Store" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table.getColumnModel().getColumn(3).setMinWidth(24);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 655, 403);
		contentPane.add(lblNewLabel_2);
	}

}
