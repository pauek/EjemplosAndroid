package com.example.listadelacompra;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<Item> {

	public ItemAdapter(Context context, int resource, ArrayList<Item> llista) {
		super(context, resource, R.id.item_text, llista);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = super.getView(position, convertView, parent);
		Item item = getItem(position);
		
		CheckBox checkbox = (CheckBox)convertView.findViewById(R.id.item_checked);
		TextView textview = (TextView)convertView.findViewById(R.id.item_text);
		checkbox.setChecked(item.isChecked());
		textview.setText(item.getName());
		
		return convertView;
	}
}
