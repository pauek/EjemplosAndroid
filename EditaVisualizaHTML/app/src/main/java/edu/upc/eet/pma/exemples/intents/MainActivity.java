package edu.upc.eet.pma.exemples.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private String mHtml;
	private TextView mHtmlView;
	final public static String HTML_KEY = "edu.upc.eet.pma.exemples.intents.html";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mHtml = "<p>Aixo es <b>HTML</b>, com mola!</p>";
		mHtmlView = (TextView)findViewById(R.id.html);
		mHtmlView.setText(mHtml);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 0:
			if (resultCode == RESULT_OK) {
				mHtml = data.getExtras().getString(HTML_KEY);
				mHtmlView.setText(mHtml);
			}
		}
	}
	
	public boolean onHelp(MenuItem item) {
		Intent intent = new Intent(this, HelpActivity.class);
		startActivity(intent);
		return true;
	}
	
    public void onEdit(View view) {
    	Intent intent = new Intent(this, EditActivity.class);
    	intent.putExtra(HTML_KEY, mHtml);
    	startActivityForResult(intent, 0);
    }

    public void onShow(View view) {
    	Intent intent = new Intent(this, ShowActivity.class);
    	intent.putExtra(HTML_KEY, mHtml);
    	startActivity(intent);
    }
}













