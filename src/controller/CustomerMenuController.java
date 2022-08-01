package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.Store;

public class CustomerMenuController {
	
	public String returnLocation(String id)
	{
		String locationString=null;
		
		try {
			FileReader fReader=new FileReader("Customers.csv");
			BufferedReader bReader=new BufferedReader(fReader);
			String line;
			String parts[];
			while ((line=bReader.readLine())!=null) {
				parts=line.split(",");
				
				if(parts[0].equals(id))
				{
					locationString=parts[2];
				}
				
			}
			bReader.close();
			fReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationString;
	}
	
	public ArrayList<Store> getStores(String location) {
		ArrayList<Store> stores = new ArrayList<>();
		try {
			FileReader fr = new FileReader("Stores.csv");
			BufferedReader br = new BufferedReader(fr);
			String line;
			String parts[];
			while ((line = br.readLine()) != null) {
				parts = line.split(",");
				if(location.equals(parts[2]))
				{
					stores.add(new Store(parts[0], parts[1], parts[2], parts[3], parts[4]));
				}
				

			}
			br.close();
			fr.close();
		} catch (Exception e) {

		}
		return stores;
	}

}
