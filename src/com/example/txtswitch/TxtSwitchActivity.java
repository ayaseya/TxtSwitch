package com.example.txtswitch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class TxtSwitchActivity extends Activity implements ViewFactory {

	private int count;
	private TextSwitcher ts;
	private TextView txt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_txt_switch);

		count = 0;

//		final Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
//		final Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
		final Animation in = AnimationUtils.loadAnimation(this, R.anim.down_in);
		final Animation out = AnimationUtils.loadAnimation(this, R.anim.down_out);

		ts = (TextSwitcher) findViewById(R.id.countView);
		ts.setFactory(this);
		ts.setInAnimation(in);
		ts.setOutAnimation(out);
		ts.setText(String.valueOf(count));
		
		Button btn = (Button) findViewById(R.id.button1);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				count++;
				ts.setText(String.valueOf(count));

			}
		});

	}

	@Override
	public View makeView() {
		txt = new TextView(this);
		txt.setGravity(Gravity.CENTER);
		txt.setTextColor(0xFFFFFFFF);
		txt.setTextSize(36);
		return txt;
	}

}