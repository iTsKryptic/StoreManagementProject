package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.Item;
import model.SaleItem;

public class ShoppingProcessController {
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

	public ArrayList<SaleItem> returnSaleItems(String storeID) {
		ArrayList<SaleItem> saleItems = new ArrayList<>();

		try {
			FileReader fReader = new FileReader("SaleItems.csv");
			BufferedReader bReader = new BufferedReader(fReader);
			String line;
			String parts[];
			while ((line = bReader.readLine()) != null) {
				parts = line.split(",");
				if (parts[0].equals(storeID)) {
					saleItems.add(new SaleItem(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]),
							parts[5], parts[6]));
				}

			}
			bReader.close();
			fReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return saleItems;
	}
}
