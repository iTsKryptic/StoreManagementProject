package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Store;

public class UpdateStoreController {
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

	public void updateStore(String id, String name, String address, String open, String close) {
		try {
			FileWriter fWriter = new FileWriter("temp.csv");
			BufferedWriter bWriter = new BufferedWriter(fWriter);

			FileReader fr = new FileReader("Stores.csv");
			BufferedReader br = new BufferedReader(fr);
			String line;
			String parts[];
			while ((line = br.readLine()) != null) {
				parts = line.split(",");
				if (parts[0].equals(id)) {
					bWriter.write(id + "," + name + "," + address + "," + open + "," + close);
					bWriter.newLine();
				} else {
					bWriter.write(line);
					bWriter.newLine();
				}

			}
			br.close();
			fr.close();
			bWriter.close();
			fWriter.close();

			File objFile = new File("Stores.csv");
			objFile.delete();
			File obFile2 = new File("temp.csv");
			obFile2.renameTo(objFile);
		} catch (Exception e) {

		}

	}

}
