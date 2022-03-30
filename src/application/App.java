package application;

import java.util.ArrayList;

public class App {
	private ArrayList<String> text;
	private int times;

	public App() {
	}

	public ArrayList<String> getText() {
		return text;
	}

	public void setText(ArrayList<String> text) {
		this.text = text;
	}

	// future addition
	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

}
