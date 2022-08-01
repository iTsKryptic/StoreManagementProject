package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Item;
import model.Store;

public class AddItemController {

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

	public ArrayList<Item> getItems() {
		ArrayList<Item> items = new ArrayList<>();
		try {
			FileReader fr = new FileReader("Items.csv");
			BufferedReader br = new BufferedReader(fr);
			String line;
			String parts[];
			while ((line = br.readLine()) != null) {
				parts = line.split(",");

				items.add(new Item(parts[0], parts[1], parts[4], parts[2], Double.parseDouble(parts[3])));

			}
			br.close();
			fr.close();
		} catch (Exception e) {

		}
		return items;
	}

	public ArrayList<Item> getItems(String storeID) {
		ArrayList<Item> items = new ArrayList<>();
		try {
			FileReader fr = new FileReader("Items.csv");
			BufferedReader br = new BufferedReader(fr);
			String line;
			String parts[];
			while ((line = br.readLine()) != null) {
				parts = line.split(",");
				if (parts[0].equals(storeID)) {
					items.add(new Item(parts[0], parts[1], parts[4], parts[2], Double.parseDouble(parts[3])));
				}

			}
			br.close();
			fr.close();
		} catch (Exception e) {

		}
		return items;
	}

	public void saveItems(String storeID, String itemID, String name, String price, String category) {
		try {
			FileWriter fW = new FileWriter("Items.csv", true);
			BufferedWriter bWriter = new BufferedWriter(fW);
			bWriter.write(storeID + "," + itemID + "," + name + "," + price + "," + category);
			bWriter.newLine();
			bWriter.close();
			fW.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
