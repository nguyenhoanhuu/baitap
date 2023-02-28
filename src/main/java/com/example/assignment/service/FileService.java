package com.example.assignment.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {
	public void readFile(String path) throws IOException;

	public void saveFile(String name, String kind, String area);
}
