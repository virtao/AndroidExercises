package org.virtao.notonlybutton;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.first_layout);
		
		Button button1 = (Button) this.findViewById(R.id.button_1);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(FirstActivity.this, "You clicked Button 1", Toast.LENGTH_LONG).show();
			}
		});
		
		Button button2 = (Button) this.findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
			
		});
		
		Button button3 = (Button) this.findViewById(R.id.button_3);
		button3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent;
				if (Math.random() > 0.5) {
					// œ‘ ΩIntent
					intent = new Intent(FirstActivity.this, SecondActivity.class);
				} else {
					// “˛ ΩIntent
					intent = new Intent("org.virtao.notonlybutton.ACTION_START");
					intent.addCategory("org.virtao.notonlybutton.MY_CATEGORY");
				}
				startActivity(intent);
			}
			
		});
		
		Button buttonGotoInternet = (Button) this.findViewById(R.id.button_first_action_view_intent);
		buttonGotoInternet.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://cn.bing.com"));
				startActivity(intent);
			}
			
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
			break;
		case R.id.remove_item:
			Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
			break;
			default:
		}
		
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
