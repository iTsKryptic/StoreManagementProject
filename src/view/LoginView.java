package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class LoginView extends JFrame {
	private JTextField username;
	private JPasswordField password;

	String type;
	JButton registerButton;
	LoginController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		view();
	}

	public void setType(String type) {
		this.type = type;

		if (this.type.equals("Admin") || this.type.equals("Manager")) {
			registerButton.setVisible(false);
		}

	}

	public void view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		getContentPane().setLayout(null);

		controller = new LoginController();

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(188, 10, 80, 31);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(125, 54, 95, 22);
		getContentPane().add(lblNewLabel_1);

		username = new JTextField();
		username.setBounds(125, 78, 215, 27);
		getContentPane().add(username);
		username.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(125, 126, 95, 22);
		getContentPane().add(lblNewLabel_1_1);

		password = new JPasswordField();
		password.setBounds(125, 152, 215, 27);
		getContentPane().add(password);

		registerButton = new JButton("REGISTER");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (type.equals("Customer")) {
					new RegisterCustomerView().setVisible(true);
				}
			}
		});
		registerButton.setForeground(Color.WHITE);
		registerButton.setBackground(SystemColor.controlShadow);
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		registerButton.setBounds(125, 205, 109, 39);
		getContentPane().add(registerButton);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (username.getText().isEmpty() || password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No Filed Can be Empty");
				} else {
					if (type.equals("Admin")) {
						Boolean flag = controller.adminLogin(username.getText(), password.getText());
						if (flag) {
							dispose();
							new AdminMenu().setVisible(true);
						}

					} else if (type.equals("Customer")) {
						boolean flag = controller.customerLogin(username.getText(), password.getText());
						if (flag) {
							dispose();
							CustomerMenuView customerMenuView = new CustomerMenuView();
							customerMenuView.getValues(username.getText());
							customerMenuView.setVisible(true);
						}
					} else if (type.equals("Manager")) {
						boolean flag = controller.managerLogin(username.getText(), password.getText());
						if (flag) {
							dispose();
							ManagerMenu managerMenu = new ManagerMenu();
							managerMenu.setVisible(true);
							managerMenu.getValues(username.getText());
						}
					}

				}
			}
		});
		btnLogin.setForeground(Color.WHITE);

		btnLogin.setBackground(SystemColor.controlShadow);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setBounds(242, 205, 98, 39);
		getContentPane().add(btnLogin);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new WelcomeView().setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBackground(SystemColor.controlShadow);
		btnBack.setBounds(10, 265, 80, 31);
		getContentPane().add(btnBack);

		JCheckBox checkBox = new JCheckBox("");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected() == true) {
					password.setEchoChar((char) 0);

				} else {

					password.setEchoChar('*');

				}
			}
		});
		checkBox.setBounds(346, 152, 30, 27);
		getContentPane().add(checkBox);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 434, 307);
		getContentPane().add(lblNewLabel_2);
	}
}
