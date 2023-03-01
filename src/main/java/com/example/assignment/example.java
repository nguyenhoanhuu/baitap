package com.example.assignment;

public class example {
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.List;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	abstract class Shape {
	    abstract double getArea();
	}

	class Circle extends Shape {
	    private double radius;

	    Circle(double radius) {
	        this.radius = radius;
	    }

	    @Override
	    double getArea() {
	        return Math.PI * radius * radius;
	    }
	}

	class Square extends Shape {
	    private double side;

	    Square(double side) {
	        this.side = side;
	    }

	    @Override
	    double getArea() {
	        return side * side;
	    }
	}

	public class ExcelWriter {
	    public static void main(String[] args) {
	        List<Shape> shapes = new ArrayList<>();

	        // Add some shapes to the list
	        shapes.add(new Circle(5));
	        shapes.add(new Square(2));
	        shapes.add(new Circle(2.5));
	        shapes.add(new Square(3));
	        shapes.add(new Circle(3));

	        // Sort the shapes list based on area
	        Collections.sort(shapes, new Comparator<Shape>() {
	            @Override
	            public int compare(Shape s1, Shape s2) {
	                return Double.compare(s1.getArea(), s2.getArea());
	            }
	        });

	        // Create a new Excel workbook and sheet
	        Workbook workbook = new XSSFWorkbook();
	        Sheet sheet = workbook.createSheet("Shapes");

	        // Create a header row
	        Row headerRow = sheet.createRow(0);
	        Cell cell = headerRow.createCell(0);
	        cell.setCellValue("Name");
	        cell = headerRow.createCell(1);
	        cell.setCellValue("Type");
	        cell = headerRow.createCell(2);
	        cell.setCellValue("Area");

	        // Loop through the shapes list and write each shape to the sheet
	        int rowNum = 1;
	        for (Shape shape : shapes) {
	            Row row = sheet.createRow(rowNum++);
	            cell = row.createCell(0);
	            cell.setCellValue("Shape" + rowNum);
	            cell = row.createCell(1);
	            cell.setCellValue(shape instanceof Circle ? "Circle" : "Square");
	            cell = row.createCell(2);
	            cell.setCellValue(shape.getArea());
	        }

	        // Write the workbook to a file
	        try {
	            FileOutputStream outputStream = new FileOutputStream("shapes.xlsx");
	            workbook.write(outputStream);
	            workbook.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
