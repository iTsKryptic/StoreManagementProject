package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AddStoreController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStoreView extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField closeTime;
	private JTextField openHours;
	AddStoreController controller;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStoreView frame = new AddStoreView();
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
	public AddStoreView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 631, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		controller = new AddStoreController();

		JLabel lblNewLabel = new JLabel("ADD STORE");
		lblNewLabel.setFont(new Font("Candara", Font.PLAIN, 24));
		lblNewLabel.setBounds(244, 11, 127, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Store Name");
		lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(36, 148, 82, 24);
		contentPane.add(lblNewLabel_1);

		name = new JTextField();
		name.setBounds(148, 148, 140, 24);
		contentPane.add(name);
		name.setColumns(10);

		address = new JTextField();
		address.setColumns(10);
		address.setBounds(148, 206, 140, 24);
		contentPane.add(address);

		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(36, 206, 82, 24);
		contentPane.add(lblNewLabel_1_1);

		closeTime = new JTextField();
		closeTime.setColumns(10);
		closeTime.setBounds(441, 148, 140, 24);
		contentPane.add(closeTime);

		JLabel lblNewLabel_1_1_1 = new JLabel("Closing Hours");
		lblNewLabel_1_1_1.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(329, 148, 102, 24);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Opening Hours");
		lblNewLabel_1_2.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(329, 79, 102, 24);
		contentPane.add(lblNewLabel_1_2);

		openHours = new JTextField();
		openHours.setColumns(10);
		openHours.setBounds(441, 79, 140, 24);
		contentPane.add(openHours);

		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.saveStore(id.getText(), name.getText(), address.getText(), openHours.getText(),
						closeTime.getText());
				id.setText("");
				name.setText("");
				address.setText("");
				openHours.setText("");
				closeTime.setText("");
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(441, 200, 140, 30);
		contentPane.add(btnNewButton);

		id = new JTextField();
		id.setColumns(10);
		id.setBounds(148, 79, 140, 24);
		contentPane.add(id);

		JLabel lblNewLabel_1_3 = new JLabel("Store ID");
		lblNewLabel_1_3.setFont(new Font("Candara", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(36, 79, 82, 24);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("images\\background.jpg"));
		lblNewLabel_2.setBounds(0, 0, 615, 259);
		contentPane.add(lblNewLabel_2);
	}
}
