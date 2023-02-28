package com.example.assignment.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.example.assignment.service.FileService;

public class FilseServiceImpl implements FileService {

	@Override
	public void readFile(String path) throws IOException {
		File fileName = new File(path);
		if (!fileName.exists()) {
//			fileName.createNewFile();
			System.out.println("file not exist");
		}

		FileReader fileReader = new FileReader(path);
		BufferedReader bfr = new BufferedReader(fileReader);
		String line = bfr.readLine();
		try {
			while (line != null) {
				String[] columns = line.split(",");
				if (columns.length == 3) {
					String shape = columns[0].trim();
					String name = columns[1].trim();
					String property = columns[2].trim();
					String[] parts = property.split("=");
					if (parts.length == 2) {
						String propertyName = parts[0].trim();
						String propertyValue = parts[1].trim();
						if ((shape.equals("Circle") && propertyName.equals("radius")) || (shape.equals("Square")
								&& propertyName.equals("edge") && Double.parseDouble(propertyValue) > 0)) {

							System.out.println(shape.trim() + "," + name.trim() + "," + property.trim());
							line = bfr.readLine();

						} else {
							line = bfr.readLine();
						}
					} else {
						line = bfr.readLine();
					}
				} else {
					line = bfr.readLine();
				}

			}
			fileReader.close();
			bfr.close();
		} catch (Exception e) {
			System.err.println("Error reading file: " + e.getMessage());
		}

	}

	@Override
	public void saveFile(String name, String kind, String area) {
		// TODO Auto-generated method stub

	}

}
