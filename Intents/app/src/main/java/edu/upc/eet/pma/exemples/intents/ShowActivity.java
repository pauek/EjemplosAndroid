package edu.upc.eet.pma.exemples.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class ShowActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview_layout);
		
		Intent intent = getIntent();
		String html = intent.getExtras().getString(MainActivity.HTML_KEY);
		WebView webview = (WebView)findViewById(R.id.webview);
		webview.loadData(html, "text/html", "");
	}
}
