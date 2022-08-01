package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class RegisterCustomerController {
	public boolean registerCustomer(String id, String name, String address, String password) {
		boolean flag = false;
		if (id.isEmpty() || name.isEmpty() || address.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error. Empty Fields");
		} else {
			flag = true;
			try {
				FileWriter fWriter = new FileWriter("Customers.csv", true);
				BufferedWriter bw = new BufferedWriter(fWriter);
				bw.write(id + "," + name + "," + address + "," + password);
				bw.newLine();
				bw.close();
				fWriter.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Successfully Registered Customer. You can login in now");
		}

		return flag;
	}

}
