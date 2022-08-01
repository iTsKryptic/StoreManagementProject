package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;
import javax.swing.JOptionPane;

import model.Store;

public class RemoveStoreController {

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

	public void deleteStore(String id) {
		
		try {
			FileWriter fWriter=new FileWriter("temp.csv");
			BufferedWriter bWriter=new BufferedWriter(fWriter);
			
			FileReader fReader=new FileReader("Stores.csv");
			BufferedReader bReader=new BufferedReader(fReader);
			String line;
			
			String parts[];
			
			while((line=bReader.readLine())!=null) {
				parts=line.split(",");
				if(parts[0].equals(id))
				{
					
				}else {
					bWriter.write(line);
					bWriter.newLine();
				}
			}
			
			bReader.close();
			fReader.close();
			bWriter.close();
			fWriter.close();
			
			File objFile=new File("Stores.csv");
			objFile.delete();
			
			File objFile2=new File("temp.csv");
			objFile2.renameTo(objFile);
			
			FileWriter fWriter1=new FileWriter("temp.csv");
			BufferedWriter bWriter1=new BufferedWriter(fWriter1);
			
			FileReader fReader1=new FileReader("Items.csv");
			BufferedReader bReader1=new BufferedReader(fReader1);
			String line1;
			
			String parts1[];
			
			while((line1=bReader1.readLine())!=null) {
				parts1=line1.split(",");
				if(parts1[0].equals(id))
				{
					
				}else {
					bWriter1.write(line1);
					bWriter1.newLine();
				}
			}
			
			bReader1.close();
			fReader1.close();
			bWriter1.close();
			fWriter1.close();
			
			File objFile3=new File("Items.csv");
			objFile3.delete();
			
			File objFile4=new File("temp.csv");
			objFile4.renameTo(objFile3);
			
			
			
			
			JOptionPane.showMessageDialog(null,"Successfully Deleted Store");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
