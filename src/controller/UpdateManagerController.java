package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Manager;
import model.Store;

public class UpdateManagerController {
	public ArrayList<Manager> getManagers() {
		ArrayList<Manager> managers = new ArrayList<>();
		try {
			FileReader fReader = new FileReader("Managers.csv");
			BufferedReader bReader = new BufferedReader(fReader);
			String line;
			String parts[];
			while ((line = bReader.readLine()) != null) {
				parts = line.split(",");
				managers.add(new Manager(parts[0], parts[1], parts[2], parts[3], parts[4]));
			}
			bReader.close();
			fReader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return managers;
	}

	public void updateManager(String id, String name, String address, String password, String storeID) {
		try {
			FileWriter fWriter = new FileWriter("temp.csv");
			BufferedWriter bWriter = new BufferedWriter(fWriter);

			FileReader fReader = new FileReader("Managers.csv");
			BufferedReader bReader = new BufferedReader(fReader);
			String line;
			String parts[];
			while ((line = bReader.readLine()) != null) {
				parts = line.split(",");
				if (parts[0].equals(id)) {
					bWriter.write(id + "," + name + "," + address + "," + password + "," + storeID);
					bWriter.newLine();
				} else {
					bWriter.write(line);
					bWriter.newLine();
				}
			}
			bReader.close();
			fReader.close();
			bWriter.close();

			File objFile = new File("Managers.csv");
			objFile.delete();
			File objFile2 = new File("temp.csv");
			objFile2.renameTo(objFile);

			fWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

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

}
