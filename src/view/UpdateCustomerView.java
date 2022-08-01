package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UpdateCustomerController;
import model.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateCustomerView extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField password;
	private JTextField address;
	UpdateCustomerController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCustomerView frame = new UpdateCustomerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void getValues(String ID) {
		Customer customer = controller.getCustomer(ID);
		id.setText(ID);
		name.setText(customer.getName());
		address.setText(customer.getAddress());
		password.setText(customer.getPassword());
	}

	/**
	 * Create the frame.
	 */
	public UpdateCustomerView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new UpdateCustomerController();

		JLabel lblNewLabel = new JLabel("UPDATE CUSTOMER");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(238, 11, 218, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(46, 86, 63, 24);
		contentPane.add(lblNewLabel_1);

		id = new JTextField();
		id.setEditable(false);
		id.setBounds(122, 81, 130, 30);
		contentPane.add(id);
		id.setColumns(10);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(122, 153, 130, 30);
		contentPane.add(name);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(46, 158, 63, 24);
		contentPane.add(lblNewLabel_1_1);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(475, 153, 130, 30);
		contentPane.add(password);

		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(399, 158, 63, 24);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(399, 86, 63, 24);
		contentPane.add(lblNewLabel_1_2);

		address = new JTextField();
		address.setColumns(10);
		address.setBounds(475, 81, 130, 30);
		contentPane.add(address);

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().isEmpty() || address.getText().isEmpty() || password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Error. Empty Fields");
				} else {
					controller.updateCustomer(
							new Customer(id.getText(), name.getText(), address.getText(), password.getText()));
					dispose();
					JOptionPane.showMessageDialog(null, "Successfully Updated Details");
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(475, 200, 130, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 666, 267);
		contentPane.add(lblNewLabel_2);
	}

}
