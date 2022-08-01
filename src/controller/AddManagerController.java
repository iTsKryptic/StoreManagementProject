package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Store;

public class AddManagerController {
	public ArrayList<Store> getStores() {
		ArrayList<Store> stores = new ArrayList<>();
		try {
			FileReader fr = new FileReader("Stores.csv");
			BufferedReader br = new BufferedReader(fr);
			String line;
			String parts[];
			while ((line = br.readLine()) != null) {
				parts = line.split(",");
				stores.add(new Store(parts[0], parts[1], parts[2], parts[3], parts[4]));

			}
			br.close();
			fr.close();
		} catch (Exception e) {

		}
		return stores;
	}

	public void addManager(String id, String name, String address, String password, String storeID) {
		try {
			FileWriter fWriter = new FileWriter("Managers.csv",true);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			bWriter.write(id + "," + name + "," + address + "," + password + "," + storeID);
			bWriter.newLine();
			bWriter.close();
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
