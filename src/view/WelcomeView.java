package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;

public class WelcomeView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeView frame = new WelcomeView();
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
	public WelcomeView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(176, 8, 104, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("SELECT LOGIN CHOICE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(151, 56, 152, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("CUSTOMER");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginView loginView = new LoginView();

				loginView.setVisible(true);

				loginView.setType("Customer");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(167, 92, 126, 36);
		contentPane.add(btnNewButton);

		JButton btnManager = new JButton("MANAGER");
		btnManager.setForeground(Color.WHITE);
		btnManager.setBackground(SystemColor.controlShadow);
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				LoginView loginView = new LoginView();

				loginView.setVisible(true);

				loginView.setType("Manager");
			}
		});
		btnManager.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManager.setBounds(165, 154, 126, 36);

		contentPane.add(btnManager);

		JButton btnManager_1 = new JButton("ADMIN");
		btnManager_1.setForeground(Color.WHITE);
		btnManager_1.setBackground(SystemColor.controlShadow);
		btnManager_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginView loginView = new LoginView();

				loginView.setVisible(true);
				loginView.setType("Admin");

			}
		});
		btnManager_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManager_1.setBounds(167, 220, 126, 36);
		contentPane.add(btnManager_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(-3, 0, 437, 313);
		contentPane.add(lblNewLabel_2);
	}
}
