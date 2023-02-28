package com.example.assignment.entity;

public abstract class Shape {

	protected String name;
	protected String kind;

	public Shape() {
		super();
	}

	public Shape(String name, String kind) {
		super();
		this.name = name;
		this.kind = kind;
	}

	public abstract double calculateArea(double edge);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

}
