package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class AddStoreController {

	public void saveStore(String id, String name, String address, String open, String close) {
	

		try {
			FileWriter fw = new FileWriter("Stores.csv",true);
			BufferedWriter bWriter = new BufferedWriter(fw);
			bWriter.write(id + "," + name + "," + address + "," + open + "," + close);
			bWriter.newLine();
			bWriter.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Successfully Added Store");
		
	}

}
