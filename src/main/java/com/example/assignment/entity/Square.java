package com.example.assignment.entity;

public class Square extends Shape {

	private double edge;

	public Square() {
		super();
	}

	public Square(String name, String kind, double edge) {
		super(name, kind);
		this.edge = calculateArea(edge);
	}

	public double getedge() {
		return edge;
	}

	public void setedge(double edge) {
		this.edge = edge;
	}

	@Override
	public double calculateArea(double edge) {
		return edge * edge;
	}

	public String toString() {
		return String.format("My name is \"%s\". I’m a square. My area is %.1f.", name, edge);
	}

}
