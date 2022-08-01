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

import controller.UpdateManagerController;
import model.Manager;
import model.Store;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class UpdateManager extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField name;
	private JTextField address;
	private JTextField password;
	private JComboBox storeCombo;
	DefaultTableModel model;
	ArrayList<Manager> managers;
	UpdateManagerController controller;
	ArrayList<Store> stores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateManager frame = new UpdateManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getValues() {
		model = (DefaultTableModel) table.getModel();
		stores = controller.getStores();
		for (Store store : stores) {
			storeCombo.addItem(store.getId());
		}
		displayManagers();
	}

	public void displayManagers() {
		model.getDataVector().removeAllElements();
		table.revalidate();
		managers = controller.getManagers();
		for (Manager manager : managers) {
			model.addRow(new Object[] { manager.getId(), manager.getName(), manager.getAddress(), manager.getPassword(),
					manager.getStoreID() });
		}
	}

	/**
	 * Create the frame.
	 */
	public UpdateManager() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 724, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new UpdateManagerController();

		JLabel lblNewLabel = new JLabel("UPDATE MANAGER");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(267, 11, 218, 30);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(232, 105, 452, 236);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int i = table.getSelectedRow();
					id.setText((String) table.getValueAt(i, 0));
					name.setText((String) table.getValueAt(i, 1));
					address.setText((String) table.getValueAt(i, 2));
					password.setText((String) table.getValueAt(i, 3));
					storeCombo.setSelectedItem(table.getValueAt(i, 4));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Address", "Password", "Assigned Store" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(24, 81, 46, 23);
		contentPane.add(lblNewLabel_1);

		id = new JTextField();
		id.setEditable(false);
		id.setBounds(24, 105, 161, 30);
		contentPane.add(id);
		id.setColumns(10);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(24, 176, 161, 30);
		contentPane.add(name);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(24, 152, 46, 23);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(24, 222, 83, 23);
		contentPane.add(lblNewLabel_1_1_1);

		address = new JTextField();
		address.setColumns(10);
		address.setBounds(24, 246, 161, 30);
		contentPane.add(address);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(24, 311, 161, 30);
		contentPane.add(password);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(24, 287, 83, 23);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Assigned Store");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(24, 354, 161, 23);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		storeCombo = new JComboBox();
		storeCombo.setModel(new DefaultComboBoxModel(new String[] { "Assign Store" }));
		storeCombo.setBounds(24, 381, 161, 30);
		contentPane.add(storeCombo);

		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Select any manager to update");
				} else {
					if (name.getText().isEmpty() || address.getText().isEmpty() || password.getText().isBlank()
							|| storeCombo.getSelectedIndex() == 0)

					{
						JOptionPane.showMessageDialog(null, "Error. Empty Fields");
					} else {
						controller.updateManager(id.getText(), name.getText(), address.getText(), password.getText(),
								storeCombo.getSelectedItem().toString());
						displayManagers();
						id.setText("");
						name.setText("");
						address.setText("");
						password.setText("");
						storeCombo.setSelectedIndex(0);
						table.clearSelection();
						JOptionPane.showMessageDialog(null, "Successfully updatedCustomer");
					}
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(232, 381, 110, 30);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 708, 442);
		contentPane.add(lblNewLabel_2);
	}
}
