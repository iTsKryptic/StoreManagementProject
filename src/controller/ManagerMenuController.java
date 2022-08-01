package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.Manager;

public class ManagerMenuController {

	public String getManagers(String id) {
		String storeID = null;
		try {
			FileReader fr = new FileReader("Managers.csv");
			BufferedReader br = new BufferedReader(fr);
			String line;
			String parts[];
			while ((line = br.readLine()) != null) {
				parts = line.split(",");
				if (parts[0].equals(id)) {
					storeID = parts[4];

				}

			}
			br.close();
			fr.close();
		} catch (Exception e) {

		}
		return storeID;
	}

}
