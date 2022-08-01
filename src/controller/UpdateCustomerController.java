package controller;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import model.Customer;

public class UpdateCustomerController {
	public Customer getCustomer(String id) {
		Customer customer = null;

		try {
			FileReader fileReader = new FileReader("Customers.csv");
			BufferedReader bReader = new BufferedReader(fileReader);
			String line;
			String parts[];
			while ((line = bReader.readLine()) != null) {
				parts = line.split(",");
				if (parts[0].equals(id)) {
					customer = new Customer(parts[0], parts[1], parts[2], parts[3]);
				}

			}
			bReader.close();
			fileReader.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return customer;
	}

	public void updateCustomer(Customer customer) {

		try {
			FileWriter fWriter = new FileWriter("temp.csv");
			BufferedWriter bWriter = new BufferedWriter(fWriter);

			FileReader fileReader = new FileReader("Customers.csv");
			BufferedReader bReader = new BufferedReader(fileReader);
			String line;
			String parts[];
			while ((line = bReader.readLine()) != null) {
				parts = line.split(",");
				if (parts[0].equals(customer.getId())) {

					bWriter.write(customer.getId() + "," + customer.getName() + "," + customer.getAddress() + ","
							+ customer.getPassword());
					bWriter.newLine();
				} else {
					bWriter.write(line);
					bWriter.newLine();
				}

			}
			bReader.close();
			fileReader.close();
			bWriter.close();
			fWriter.close();

			File objFile = new File("Customers.csv");
			objFile.delete();
			File objFile2 = new File("temp.csv");
			objFile2.renameTo(objFile);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
