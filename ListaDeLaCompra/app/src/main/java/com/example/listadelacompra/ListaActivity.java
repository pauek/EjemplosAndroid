package com.example.listadelacompra;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class ListaActivity extends Activity {

	private ArrayList<Item> dades;
	private ListView llista;
	private ItemAdapter adapter;
	private TextView new_item;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista);
		
		dades = new ArrayList<Item>();
		dades.add(new Item("Patates"));
		dades.add(new Item("Llet"));
		
		llista = (ListView)findViewById(R.id.list);
		adapter = new ItemAdapter(this, R.layout.item, dades);
		llista.setAdapter(adapter);
		
		llista.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
				Item item = dades.get(pos);
				item.toggleChecked();
				adapter.notifyDataSetChanged();
			}
		});
		llista.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int pos, long id) {
				removeItem(pos);
				return true;
			}
		});
		new_item = (TextView)findViewById(R.id.new_item);
	}
	
	public void addItem(View view) {
		dades.add(new Item(new_item.getText().toString()));
		adapter.notifyDataSetChanged();
		new_item.setText("");
	}
	
	public void removeItem(final int pos) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.confirm_title);
		builder.setMessage(R.string.confirm_text);
		builder.setPositiveButton(R.string.erase, new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dades.remove(pos);
				adapter.notifyDataSetChanged();
			}
		});
		builder.setNegativeButton(android.R.string.cancel, null);
		builder.create().show();
	}
}
