package org.virtao.notonlybutton;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
					// 显式Intent
					intent = new Intent(FirstActivity.this, SecondActivity.class);
				} else {
					// 隐式Intent
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
		
		Button buttonDial = (Button)this.findViewById(R.id.button_first_activity_dial);
		buttonDial.setOnClickListener(new OnClickListener () {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10086"));
				try {
					startActivity(intent);
				} catch (ActivityNotFoundException e) {
					Log.e(GlobalVar.TAG, "Dial failed!");
				}
			}
			
		});
		
		Button buttonExtraData = (Button)this.findViewById(R.id.button_first_activity_extra_data);
		buttonExtraData.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String data = "Hello! I comes from FirstActivity.";
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				intent.putExtra("extra_data", data);
				startActivity(intent);
			}
			
		});
		
		Button buttonIntentResult = (Button)this.findViewById(R.id.button_first_activity_intent_result);
		buttonIntentResult.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				startActivityForResult(intent, 10086);
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

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 10086:
			if	(resultCode == RESULT_OK) {
				String returnData = data.getStringExtra("data_return");
				Toast.makeText(this, "The result : " + returnData, Toast.LENGTH_SHORT).show();
			}
			break;
		}
	}
	
	
}
