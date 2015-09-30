package com.example.listadelacompra;

public class Item {
	private String  mName;
	private boolean mChecked = false;
	
	public Item(String name) { mName = name; }
	String getName()    { return mName; }
	boolean isChecked() { return mChecked; }
	public void toggleChecked() { mChecked = !mChecked; }
}
