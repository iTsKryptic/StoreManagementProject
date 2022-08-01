package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.Manager;

public class RemoveManagerController {

	public ArrayList<Manager> getManagers() {
		ArrayList<Manager> managers = new ArrayList<>();
		try {
			FileReader fr = new FileReader("Managers.csv");
			BufferedReader br = new BufferedReader(fr);
			String line;
			String parts[];
			while ((line = br.readLine()) != null) {
				parts = line.split(",");
				managers.add(new Manager(parts[0], parts[1], parts[2], parts[3], parts[4]));

			}
			br.close();
			fr.close();
		} catch (Exception e) {

		}
		return managers;
	}

	public void deleteManager(String id) {
		try {
			FileWriter fWriter = new FileWriter("temp.csv");
			BufferedWriter bWriter = new BufferedWriter(fWriter);

			FileReader fr = new FileReader("Managers.csv");
			BufferedReader br = new BufferedReader(fr);
			String line;
			String parts[];
			while ((line = br.readLine()) != null) {
				parts = line.split(",");
				if (parts[0].equals(id)) {

				} else {
					bWriter.write(line);
					bWriter.newLine();
				}

			}
			br.close();
			fr.close();
			bWriter.close();
			fWriter.close();

			File obj = new File("Managers.csv");
			obj.delete();
			File objFile = new File("temp.csv");
			objFile.renameTo(obj);
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
