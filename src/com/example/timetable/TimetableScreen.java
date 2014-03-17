package com.example.timetable;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TimetableScreen extends Activity implements OnClickListener {

	int daynumber, todaynumber;

	TextView day, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
	TextView cn1, cn2, cn3, cn4, cn5, cn6, cn7, cn8, cn9, cn10;
	TextView lpt1, lpt2, lpt3, lpt4, lpt5, lpt6, lpt7, lpt8, lpt9, lpt10;

	TextView taptext;

	Button bEdit, bEnter, bDone;

	EditText textbox;

	String[] mc = new String[10];
	String[] mcn = new String[10];
	String[] ml = new String[10];

	String[] tc = new String[10];
	String[] tcn = new String[10];
	String[] tl = new String[10];

	String[] wc = new String[10];
	String[] wcn = new String[10];
	String[] wl = new String[10];

	String[] thc = new String[10];
	String[] thcn = new String[10];
	String[] thl = new String[10];

	String[] fc = new String[10];
	String[] fcn = new String[10];
	String[] fl = new String[10];

	String[] sc = new String[10];
	String[] scn = new String[10];
	String[] sl = new String[10];

	String[] suc = new String[10];
	String[] sucn = new String[10];
	String[] sul = new String[10];
	int ids;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.timetablescreen);

		Button bNext = (Button) findViewById(R.id.bNext);
		Button bPrevious = (Button) findViewById(R.id.bPrevious);

		View v;
		v = findViewById(R.id.bToday);
		Button bToday = (Button) v;
		v.setVisibility(View.INVISIBLE);
		v = findViewById(R.id.bEdit);
		bEdit = (Button) v;
		v = findViewById(R.id.bDone);
		bDone = (Button) v;
		v.setVisibility(View.INVISIBLE);
		v = findViewById(R.id.bEnter);
		bEnter = (Button) v;
		v.setVisibility(View.INVISIBLE);

		Button TopBar = (Button) findViewById(R.id.TopBar);
		Typeface barfont = Typeface.createFromAsset(getAssets(), "ARMTB.ttf");
		TopBar.setTypeface(barfont);

		v = findViewById(R.id.taptext);
		taptext = (TextView) v;
		v.setVisibility(View.INVISIBLE);
		v = findViewById(R.id.textbox);
		textbox = (EditText) v;
		v.setVisibility(View.INVISIBLE);

		ids = 0;

		day = (TextView) findViewById(R.id.day);
		c1 = (TextView) findViewById(R.id.c1);
		c2 = (TextView) findViewById(R.id.c2);
		c3 = (TextView) findViewById(R.id.c3);
		c4 = (TextView) findViewById(R.id.c4);
		c5 = (TextView) findViewById(R.id.c5);
		c6 = (TextView) findViewById(R.id.c6);
		c7 = (TextView) findViewById(R.id.c7);
		c8 = (TextView) findViewById(R.id.c8);
		c9 = (TextView) findViewById(R.id.c9);
		c10 = (TextView) findViewById(R.id.c10);

		cn1 = (TextView) findViewById(R.id.cn1);
		cn2 = (TextView) findViewById(R.id.cn2);
		cn3 = (TextView) findViewById(R.id.cn3);
		cn4 = (TextView) findViewById(R.id.cn4);
		cn5 = (TextView) findViewById(R.id.cn5);
		cn6 = (TextView) findViewById(R.id.cn6);
		cn7 = (TextView) findViewById(R.id.cn7);
		cn8 = (TextView) findViewById(R.id.cn8);
		cn9 = (TextView) findViewById(R.id.cn9);
		cn10 = (TextView) findViewById(R.id.cn10);

		lpt1 = (TextView) findViewById(R.id.lpt1);
		lpt2 = (TextView) findViewById(R.id.lpt2);
		lpt3 = (TextView) findViewById(R.id.lpt3);
		lpt4 = (TextView) findViewById(R.id.lpt4);
		lpt5 = (TextView) findViewById(R.id.lpt5);
		lpt6 = (TextView) findViewById(R.id.lpt6);
		lpt7 = (TextView) findViewById(R.id.lpt7);
		lpt8 = (TextView) findViewById(R.id.lpt8);
		lpt9 = (TextView) findViewById(R.id.lpt9);
		lpt10 = (TextView) findViewById(R.id.lpt10);

		Calendar calendar = Calendar.getInstance();
		daynumber = calendar.get(Calendar.DAY_OF_WEEK);
		todaynumber = daynumber;
		// If current day is Sunday, day=1. Saturday, day=7.

		setValues();

		bEdit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				v = findViewById(R.id.bEdit);
				v.setVisibility(View.INVISIBLE);
				v = findViewById(R.id.taptext);
				v.setVisibility(View.VISIBLE);

			}
		});

		bNext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				View b = findViewById(R.id.bToday);
				if (b.getVisibility() == View.INVISIBLE)
					b.setVisibility(View.VISIBLE);

				setAllNull();

				if (daynumber != 7)
					daynumber++;
				else
					daynumber = 1;

				if (daynumber == todaynumber)
					b.setVisibility(View.INVISIBLE);

				setValues();

			}
		});

		bPrevious.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				View b = findViewById(R.id.bToday);
				if (b.getVisibility() == View.INVISIBLE)
					b.setVisibility(View.VISIBLE);

				setAllNull();

				if (daynumber != 1)
					daynumber--;
				else
					daynumber = 7;

				if (daynumber == todaynumber)
					b.setVisibility(View.INVISIBLE);

				setValues();
			}
		});

		bToday.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				daynumber = todaynumber;

				View b = findViewById(R.id.bToday);
				b.setVisibility(View.INVISIBLE);

				setAllNull();

				setValues();
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	public void setAllNull() {
		c1.setText("-");
		c2.setText("-");
		c3.setText("-");
		c4.setText("-");
		c5.setText("-");
		c6.setText("-");
		c7.setText("-");
		c8.setText("-");
		c9.setText("-");
		c10.setText("-");

		cn1.setText("-");
		cn2.setText("-");
		cn3.setText("-");
		cn4.setText("-");
		cn5.setText("-");
		cn6.setText("-");
		cn7.setText("-");
		cn8.setText("-");
		cn9.setText("-");
		cn10.setText("-");

		lpt1.setText("-");
		lpt2.setText("-");
		lpt3.setText("-");
		lpt4.setText("-");
		lpt5.setText("-");
		lpt6.setText("-");
		lpt7.setText("-");
		lpt8.setText("-");
		lpt9.setText("-");
		lpt10.setText("-");
	}

	public void setValues() {
		switch (daynumber) {
		case Calendar.SUNDAY:
			day.setText("Take lite, It's Sunday");
			break;
		case Calendar.MONDAY:
			day.setText("Monday");
			c2.setText("EG");
			c3.setText("EG");
			c4.setText("Math 2");
			c5.setText("Thermo");
			c8.setText("Comp");
			c9.setText("P&S");
			cn2.setText("CC");
			cn3.setText("CC");
			cn4.setText("LT2");
			cn5.setText("LT3");
			cn8.setText("LT2");
			cn9.setText("LT2");
			lpt2.setText("P");
			lpt3.setText("P");
			lpt4.setText("L");
			lpt5.setText("L");
			lpt8.setText("L");
			lpt9.setText("L");
			break;
		case Calendar.TUESDAY:
			day.setText("Tuesday");
			c1.setText("Thermo");
			c4.setText("ES");
			c9.setText("EG");
			c10.setText("Comp");
			cn1.setText("A507");
			cn4.setText("LT3");
			cn9.setText("LT2");
			cn10.setText("CC");
			lpt1.setText("T");
			lpt4.setText("L");
			lpt9.setText("L");
			lpt10.setText("P");
			break;
		case Calendar.WEDNESDAY:
			day.setText("Wednesday");
			c1.setText("Math 2");
			c2.setText("Chem lab");
			c3.setText("Chem lab");
			c4.setText("Math 2");
			c5.setText("Thermo");
			c8.setText("Comp");
			c9.setText("P&S");
			cn1.setText("C301");
			cn2.setText("Chem lab");
			cn3.setText("Chem lab");
			cn4.setText("LT2");
			cn5.setText("LT3");
			cn8.setText("LT2");
			cn9.setText("LT2");
			lpt1.setText("T");
			lpt2.setText("P");
			lpt3.setText("P");
			lpt4.setText("L");
			lpt5.setText("L");
			lpt8.setText("L");
			lpt9.setText("L");

			break;
		case Calendar.THURSDAY:
			day.setText("Thursday");
			c4.setText("ES");
			c9.setText("EG");
			cn4.setText("LT3");
			cn9.setText("A507");
			lpt4.setText("L");
			lpt9.setText("T");
			break;
		case Calendar.FRIDAY:
			day.setText("Friday");
			c1.setText("P&S");
			c4.setText("Math 2");
			c5.setText("Thermo");
			c8.setText("Comp");
			c9.setText("P&S");
			cn1.setText("LT1");
			cn4.setText("LT2");
			cn5.setText("LT3");
			cn8.setText("LT2");
			cn9.setText("LT2");
			lpt1.setText("T");
			lpt4.setText("L");
			lpt5.setText("L");
			lpt8.setText("L");
			lpt9.setText("L");
			break;
		case Calendar.SATURDAY:
			day.setText("Saturday");
			c1.setText("ES");
			c4.setText("ES");
			cn1.setText("LT3");
			cn4.setText("LT3");
			lpt1.setText("T");
			lpt4.setText("L");
			break;

		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timetable_screen, menu);
		return true;
	}

}
