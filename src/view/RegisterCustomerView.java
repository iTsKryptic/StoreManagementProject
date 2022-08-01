package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.RegisterCustomerController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class RegisterCustomerView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField address;
	private JTextField password;
	RegisterCustomerController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterCustomerView frame = new RegisterCustomerView();
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
	public RegisterCustomerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new RegisterCustomerController();

		JLabel lblNewLabel = new JLabel("REGISTER USER");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(156, 11, 188, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(125, 71, 60, 24);
		contentPane.add(lblNewLabel_1);

		id = new JTextField();
		id.setBounds(195, 69, 136, 24);
		contentPane.add(id);
		id.setColumns(10);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(195, 127, 136, 24);
		contentPane.add(name);

		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(125, 129, 60, 24);
		contentPane.add(lblNewLabel_1_1);

		address = new JTextField();
		address.setColumns(10);
		address.setBounds(195, 183, 136, 24);
		contentPane.add(address);

		JLabel lblNewLabel_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(125, 185, 60, 24);
		contentPane.add(lblNewLabel_1_1_1);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(195, 237, 136, 24);
		contentPane.add(password);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(125, 239, 60, 24);
		contentPane.add(lblNewLabel_1_1_1_1);

		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flag=controller.registerCustomer(id.getText(),name.getText(),address.getText(),password.getText());
				if (flag) {
					dispose();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(195, 283, 136, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 458, 333);
		contentPane.add(lblNewLabel_2);

	}

}
