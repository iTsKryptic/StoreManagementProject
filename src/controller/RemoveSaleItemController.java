package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Item;
import model.SaleItem;

public class RemoveSaleItemController {
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
			e.printStackTrace();
		}
		return saleItems;
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

	public void deleteItem(String id) {
		try {
			FileWriter fWriter = new FileWriter("temp.csv");
			BufferedWriter bWriter = new BufferedWriter(fWriter);

			FileReader fReader = new FileReader("SaleItems.csv");
			BufferedReader bReader = new BufferedReader(fReader);
			String line;
			String parts[];
			while ((line = bReader.readLine()) != null) {
				parts = line.split(",");
				if (parts[1].equals(id)) {

				} else {
					bWriter.write(line);
					bWriter.newLine();
				}

			}
			bReader.close();
			fReader.close();
			bWriter.close();
			fWriter.close();

			File obj = new File("SaleItems.csv");
			obj.delete();
			File obj2 = new File("temp.csv");
			obj2.renameTo(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
