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

import controller.UpdateStoreController;
import model.Store;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateStore extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField id;
	private JTextField name;
	private JTextField location;
	private JTextField openingTime;
	private JTextField closingTime;
	DefaultTableModel model;
	ArrayList<Store> stores;
	UpdateStoreController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStore frame = new UpdateStore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getValues() {
		model = (DefaultTableModel) table.getModel();
		displayStore();
	}

	public void displayStore() {
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
	public UpdateStore() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 724, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new UpdateStoreController();

		JLabel lblNewLabel = new JLabel("UPDATE STORE");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(278, 11, 181, 24);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 106, 432, 276);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int i = table.getSelectedRow();
					id.setText((String) table.getValueAt(i, 0));
					name.setText((String) table.getValueAt(i, 1));
					location.setText((String) table.getValueAt(i, 2));
					openingTime.setText((String) table.getValueAt(i, 3));
					closingTime.setText((String) table.getValueAt(i, 4));

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Location", "Opening Time", "Closing Time" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 71, 46, 24);
		contentPane.add(lblNewLabel_1);

		id = new JTextField();
		id.setEditable(false);
		id.setBounds(22, 106, 165, 31);
		contentPane.add(id);
		id.setColumns(10);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(22, 183, 165, 31);
		contentPane.add(name);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(22, 148, 46, 24);
		contentPane.add(lblNewLabel_1_1);

		location = new JTextField();
		location.setColumns(10);
		location.setBounds(22, 270, 165, 31);
		contentPane.add(location);

		JLabel lblNewLabel_1_2 = new JLabel("Location");
		lblNewLabel_1_2.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(22, 235, 84, 24);
		contentPane.add(lblNewLabel_1_2);

		openingTime = new JTextField();
		openingTime.setColumns(10);
		openingTime.setBounds(22, 351, 165, 31);
		contentPane.add(openingTime);

		JLabel lblNewLabel_1_3 = new JLabel("Opening Time");
		lblNewLabel_1_3.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(22, 316, 101, 24);
		contentPane.add(lblNewLabel_1_3);

		closingTime = new JTextField();
		closingTime.setColumns(10);
		closingTime.setBounds(22, 428, 165, 31);
		contentPane.add(closingTime);

		JLabel lblNewLabel_1_4 = new JLabel("Closing Time");
		lblNewLabel_1_4.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(22, 393, 101, 24);
		contentPane.add(lblNewLabel_1_4);

		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Select any Store to Update");
				} else {
					if (name.getText().isEmpty() || location.getText().isEmpty() || openingTime.getText().isEmpty()
							|| closingTime.getText().isEmpty())

					{
						JOptionPane.showMessageDialog(null, "Error. Empty Fields");
					} else {
						controller.updateStore(id.getText(), name.getText(), location.getText(), openingTime.getText(),
								closingTime.getText());
						displayStore();
						JOptionPane.showMessageDialog(null, "Successfully Updated");
						id.setText("");
						name.setText("");
						location.setText("");
						openingTime.setText("");
						closingTime.setText("");
					}
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setBounds(253, 428, 101, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 708, 486);
		contentPane.add(lblNewLabel_2);
	}
}
