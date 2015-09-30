package edu.upc.eet.pma.exemples.intents;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class HelpActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview_layout);
		
		WebView webview = (WebView)findViewById(R.id.webview);
		webview.loadUrl("file:///android_asset/help.html");
	}
}
