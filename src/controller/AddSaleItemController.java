package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Item;
import model.SaleItem;
import model.Store;

public class AddSaleItemController {

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

	public void saveSaleItem(String storeID, String id, String name, String category, double price, String duration,
			String percentage) {

		try {

			FileWriter fWriter = new FileWriter("SaleItems.csv", true);
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			bWriter.write(
					storeID + "," + id + "," + name + "," + category + "," + price + "," + duration + "," + percentage);
			bWriter.newLine();
			bWriter.close();
			fWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<SaleItem> returnSaleItems() {
		ArrayList<SaleItem> saleItems = new ArrayList<>();

		try {
			FileReader fReader = new FileReader("SaleItems.csv");
			BufferedReader bReader = new BufferedReader(fReader);
			String line;
			String parts[];
			while ((line = bReader.readLine()) != null) {
				parts = line.split(",");
				saleItems.add(new SaleItem(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]),
						parts[5], parts[6]));
			}
			bReader.close();
			fReader.close();

		} catch (Exception e) {

		}
		return saleItems;
	}

}
