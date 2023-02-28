package com.example.assignment;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.assignment.service.FileService;
import com.example.assignment.service.impl.FilseServiceImpl;

public class main {
	public static void main(String[] args) throws IOException {

		FileService fieFileService = new FilseServiceImpl();
		fieFileService.readFile("test.txt");
	}
}
