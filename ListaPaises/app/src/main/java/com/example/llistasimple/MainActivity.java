package com.example.llistasimple;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView list;
	private String[] countries;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        list = (ListView)findViewById(R.id.llista);
        countries = getResources().getStringArray(R.array.paisos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        list.setAdapter(adapter);
        
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
				Toast.makeText(
						MainActivity.this,
						String.format("Has seleccionat \"%s\"", countries[pos]),
						Toast.LENGTH_SHORT
				).show();
			}
		});
    }
}








