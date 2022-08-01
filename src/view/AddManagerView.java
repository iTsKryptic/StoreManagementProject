package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AddManagerController;
import model.Store;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddManagerView extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField address;
	private JComboBox storeCombo;
	private JTextField password;
	ArrayList<Store> stores;
	AddManagerController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddManagerView frame = new AddManagerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getValues() {
		stores = controller.getStores();
		for (Store store : stores) {
			storeCombo.addItem(store.getId() + ":" + store.getName());
		}
	}

	/**
	 * Create the frame.
	 */
	public AddManagerView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 652, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new AddManagerController();

		JLabel lblNewLabel = new JLabel("ADD MANAGER");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(237, 11, 171, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(84, 77, 46, 24);
		contentPane.add(lblNewLabel_1);

		id = new JTextField();
		id.setBounds(154, 77, 134, 24);
		contentPane.add(id);
		id.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(84, 139, 46, 24);
		contentPane.add(lblNewLabel_1_1);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(154, 139, 134, 24);
		contentPane.add(name);

		JLabel lblNewLabel_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(341, 77, 60, 24);
		contentPane.add(lblNewLabel_1_1_1);

		address = new JTextField();
		address.setColumns(10);
		address.setBounds(411, 77, 134, 24);
		contentPane.add(address);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(341, 139, 60, 24);
		contentPane.add(lblNewLabel_1_1_1_1);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(411, 139, 134, 24);
		contentPane.add(password);

		storeCombo = new JComboBox();
		storeCombo.setFont(new Font("Candara", Font.PLAIN, 14));
		storeCombo.setModel(new DefaultComboBoxModel(new String[] { "Assign Store" }));
		storeCombo.setBounds(154, 194, 134, 30);
		contentPane.add(storeCombo);

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id.getText().isEmpty() || name.getText().isEmpty() || address.getText().isEmpty()
						|| password.getText().isEmpty() || storeCombo.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null,"Error. Empty Fields");
				}else {
					String parts[]=storeCombo.getSelectedItem().toString().split(":");
					controller.addManager(id.getText(), name.getText(), address.getText(),password.getText(),parts[0]);
					JOptionPane.showMessageDialog(null,"Successfully Added Manager");
					id.setText("");
					name.setText("");
					address.setText("");
					password.setText("");
					storeCombo.setSelectedIndex(0);
				}

			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(411, 192, 134, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 636, 286);
		contentPane.add(lblNewLabel_2);
	}

}
