package controller;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class LoginController {

	public boolean adminLogin(String id, String password) {
		boolean flag = false;
		if (id.equals("admin") && password.equals("123")) {
			flag = true;
			JOptionPane.showMessageDialog(null, "Successfully login");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Credentials");
		}
		return flag;
	}

	public boolean customerLogin(String id, String password) {
		boolean flag = false;
		try {
			FileReader fReader = new FileReader("Customers.csv");
			BufferedReader br = new BufferedReader(fReader);
			String line;
			String parts[];
			while ((line = br.readLine()) != null) {
				parts = line.split(",");
				if (parts[0].equals(id) && parts[3].equals(password)) {
					flag = true;
				}

			}
			br.close();
			fReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (flag) {
			JOptionPane.showMessageDialog(null, "Successfully login");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Credentials. Try again");
		}
		return flag;
	}

	public boolean managerLogin(String id, String password) {
		boolean flag = false;
		try {
			FileReader fReader = new FileReader("Managers.csv");
			BufferedReader br = new BufferedReader(fReader);
			String line;
			String parts[];
			while ((line = br.readLine()) != null) {
				parts = line.split(",");
				if (parts[0].equals(id) && parts[3].equals(password)) {
					flag = true;
				}

			}
			br.close();
			fReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (flag) {
			JOptionPane.showMessageDialog(null, "Successfully login");
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Credentials. Try again");
		}
		return flag;
	}
}
