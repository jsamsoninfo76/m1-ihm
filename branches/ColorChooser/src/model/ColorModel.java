package model;

import java.util.Observable;

public class ColorModel extends Observable {

	private double red;
	private double green;
	private double blue;
	
	public ColorModel() {
		this.red = Math.random() * 255;
		this.green = Math.random() * 255;
		this.blue = Math.random() * 255;
	}
	
	public double getRed() {
		return red;
	}
	public void setRed(double red) {
		this.red = red;
		setChanged();
        notifyObservers();
	}
	public double getGreen() {
		return green;
	}
	public void setGreen(double green) {
		this.green = green;
		setChanged();
        notifyObservers();
	}
	public double getBlue() {
		return blue;
	}
	public void setBlue(double blue) {
		this.blue = blue;
		setChanged();
        notifyObservers();
	}
	
}
