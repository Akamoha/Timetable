package com.example.timetable;

import java.util.Calendar;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TimetableScreen extends SwipeActivity implements OnClickListener {

	int daynumber, todaynumber;

	TextView day, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
	TextView cn1, cn2, cn3, cn4, cn5, cn6, cn7, cn8, cn9, cn10;
	TextView lpt1, lpt2, lpt3, lpt4, lpt5, lpt6, lpt7, lpt8, lpt9, lpt10;

	TextView taptext;

	Button bEdit, bEnter, bDone;

	EditText textbox;

	SharedPreferences storage;
	SharedPreferences.Editor editor;

	String str;

	int ids;

	float oldTouchValue = 0;

	boolean isSwipeable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);

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

		storage = getSharedPreferences("timetablestorage", 0);
		editor = storage.edit();

		ids = 0;

		isSwipeable = true;

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

		c1.setOnClickListener(this);
		c2.setOnClickListener(this);
		c3.setOnClickListener(this);
		c4.setOnClickListener(this);
		c5.setOnClickListener(this);
		c6.setOnClickListener(this);
		c7.setOnClickListener(this);
		c8.setOnClickListener(this);
		c9.setOnClickListener(this);
		c10.setOnClickListener(this);

		cn1.setOnClickListener(this);
		cn2.setOnClickListener(this);
		cn3.setOnClickListener(this);
		cn4.setOnClickListener(this);
		cn5.setOnClickListener(this);
		cn6.setOnClickListener(this);
		cn7.setOnClickListener(this);
		cn8.setOnClickListener(this);
		cn9.setOnClickListener(this);
		cn10.setOnClickListener(this);

		lpt1.setOnClickListener(this);
		lpt2.setOnClickListener(this);
		lpt3.setOnClickListener(this);
		lpt4.setOnClickListener(this);
		lpt5.setOnClickListener(this);
		lpt6.setOnClickListener(this);
		lpt7.setOnClickListener(this);
		lpt8.setOnClickListener(this);
		lpt9.setOnClickListener(this);
		lpt10.setOnClickListener(this);

		c1.setClickable(false);
		c2.setClickable(false);
		c3.setClickable(false);
		c4.setClickable(false);
		c5.setClickable(false);
		c6.setClickable(false);
		c7.setClickable(false);
		c8.setClickable(false);
		c9.setClickable(false);
		c10.setClickable(false);

		cn1.setClickable(false);
		cn2.setClickable(false);
		cn3.setClickable(false);
		cn4.setClickable(false);
		cn5.setClickable(false);
		cn6.setClickable(false);
		cn7.setClickable(false);
		cn8.setClickable(false);
		cn9.setClickable(false);
		cn10.setClickable(false);

		lpt1.setClickable(false);
		lpt2.setClickable(false);
		lpt3.setClickable(false);
		lpt4.setClickable(false);
		lpt5.setClickable(false);
		lpt6.setClickable(false);
		lpt7.setClickable(false);
		lpt8.setClickable(false);
		lpt9.setClickable(false);
		lpt10.setClickable(false);

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

				isSwipeable = false;

				c1.setClickable(true);
				c2.setClickable(true);
				c3.setClickable(true);
				c4.setClickable(true);
				c5.setClickable(true);
				c6.setClickable(true);
				c7.setClickable(true);
				c8.setClickable(true);
				c9.setClickable(true);
				c10.setClickable(true);

				cn1.setClickable(true);
				cn2.setClickable(true);
				cn3.setClickable(true);
				cn4.setClickable(true);
				cn5.setClickable(true);
				cn6.setClickable(true);
				cn7.setClickable(true);
				cn8.setClickable(true);
				cn9.setClickable(true);
				cn10.setClickable(true);

				lpt1.setClickable(true);
				lpt2.setClickable(true);
				lpt3.setClickable(true);
				lpt4.setClickable(true);
				lpt5.setClickable(true);
				lpt6.setClickable(true);
				lpt7.setClickable(true);
				lpt8.setClickable(true);
				lpt9.setClickable(true);
				lpt10.setClickable(true);

			}
		});

		bEnter.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (ids != 0) {
					c1.setClickable(true);
					c2.setClickable(true);
					c3.setClickable(true);
					c4.setClickable(true);
					c5.setClickable(true);
					c6.setClickable(true);
					c7.setClickable(true);
					c8.setClickable(true);
					c9.setClickable(true);
					c10.setClickable(true);

					cn1.setClickable(true);
					cn2.setClickable(true);
					cn3.setClickable(true);
					cn4.setClickable(true);
					cn5.setClickable(true);
					cn6.setClickable(true);
					cn7.setClickable(true);
					cn8.setClickable(true);
					cn9.setClickable(true);
					cn10.setClickable(true);

					lpt1.setClickable(true);
					lpt2.setClickable(true);
					lpt3.setClickable(true);
					lpt4.setClickable(true);
					lpt5.setClickable(true);
					lpt6.setClickable(true);
					lpt7.setClickable(true);
					lpt8.setClickable(true);
					lpt9.setClickable(true);
					lpt10.setClickable(true);

					TextView tx = (TextView) findViewById(ids);
					str = textbox.getText().toString();
					tx.setTextColor(Color.BLACK);

					if (str.matches("")) {
						str = "-";
					}

					tx.setText(str);

					switch (daynumber) {
					case Calendar.SUNDAY:
						storeSundayValues();
						break;
					case Calendar.MONDAY:
						storeMondayValues();
						break;
					case Calendar.TUESDAY:
						storeTuesdayValues();
						break;
					case Calendar.WEDNESDAY:
						storeWednesdayValues();
						break;
					case Calendar.THURSDAY:
						storeThursdayValues();
						break;
					case Calendar.FRIDAY:
						storeFridayValues();
						break;
					case Calendar.SATURDAY:
						storeSaturdayValues();
						break;
					}
					editor.commit();
				}
				textbox.setText("");
			}
		});

		bDone.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				isSwipeable = true;

				if (ids != 0) {
					c1.setClickable(false);
					c2.setClickable(false);
					c3.setClickable(false);
					c4.setClickable(false);
					c5.setClickable(false);
					c6.setClickable(false);
					c7.setClickable(false);
					c8.setClickable(false);
					c9.setClickable(false);
					c10.setClickable(false);

					cn1.setClickable(false);
					cn2.setClickable(false);
					cn3.setClickable(false);
					cn4.setClickable(false);
					cn5.setClickable(false);
					cn6.setClickable(false);
					cn7.setClickable(false);
					cn8.setClickable(false);
					cn9.setClickable(false);
					cn10.setClickable(false);

					lpt1.setClickable(false);
					lpt2.setClickable(false);
					lpt3.setClickable(false);
					lpt4.setClickable(false);
					lpt5.setClickable(false);
					lpt6.setClickable(false);
					lpt7.setClickable(false);
					lpt8.setClickable(false);
					lpt9.setClickable(false);
					lpt10.setClickable(false);

					TextView tx = (TextView) findViewById(ids);
					str = textbox.getText().toString();
					tx.setTextColor(Color.BLACK);

					if (str.matches("")) {
						str = tx.getText().toString();

					}

					tx.setText(str);

					switch (daynumber) {
					case Calendar.SUNDAY:
						storeSundayValues();
						break;
					case Calendar.MONDAY:
						storeMondayValues();
						break;
					case Calendar.TUESDAY:
						storeTuesdayValues();
						break;
					case Calendar.WEDNESDAY:
						storeWednesdayValues();
						break;
					case Calendar.THURSDAY:
						storeThursdayValues();
						break;
					case Calendar.FRIDAY:
						storeFridayValues();
						break;
					case Calendar.SATURDAY:
						storeSaturdayValues();
						break;
					}
					editor.commit();

					v = findViewById(R.id.textbox);
					v.setVisibility(View.INVISIBLE);
					v = findViewById(R.id.bEnter);
					v.setVisibility(View.INVISIBLE);
					v = findViewById(R.id.bDone);
					v.setVisibility(View.INVISIBLE);
					v = findViewById(R.id.bEdit);
					v.setVisibility(View.VISIBLE);
					v = findViewById(R.id.bPrevious);
					v.setVisibility(View.VISIBLE);
					v = findViewById(R.id.bNext);
					v.setVisibility(View.VISIBLE);

				}
				textbox.setText("");
			}
		});

		bNext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				View b = findViewById(R.id.bToday);
				if (b.getVisibility() == View.INVISIBLE)
					b.setVisibility(View.VISIBLE);

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

				setValues();
			}
		});
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.c1:
		case R.id.c2:
		case R.id.c3:
		case R.id.c4:
		case R.id.c5:
		case R.id.c6:
		case R.id.c7:
		case R.id.c8:
		case R.id.c9:
		case R.id.c10:
		case R.id.cn1:
		case R.id.cn2:
		case R.id.cn3:
		case R.id.cn4:
		case R.id.cn5:
		case R.id.cn6:
		case R.id.cn7:
		case R.id.cn8:
		case R.id.cn9:
		case R.id.cn10:
		case R.id.lpt1:
		case R.id.lpt2:
		case R.id.lpt3:
		case R.id.lpt4:
		case R.id.lpt5:
		case R.id.lpt6:
		case R.id.lpt7:
		case R.id.lpt8:
		case R.id.lpt9:
		case R.id.lpt10:
			ids = v.getId();
			if (ids != 0) {

				TextView tv = (TextView) v;
				tv.setTextColor(Color.YELLOW);
				v = findViewById(R.id.taptext);
				v.setVisibility(View.INVISIBLE);
				v = findViewById(R.id.textbox);
				v.setVisibility(View.VISIBLE);
				v = findViewById(R.id.bDone);
				v.setVisibility(View.VISIBLE);
				v = findViewById(R.id.bEnter);
				v.setVisibility(View.VISIBLE);
				v = findViewById(R.id.bPrevious);
				v.setVisibility(View.INVISIBLE);
				v = findViewById(R.id.bNext);
				v.setVisibility(View.INVISIBLE);

				c1.setClickable(false);
				c2.setClickable(false);
				c3.setClickable(false);
				c4.setClickable(false);
				c5.setClickable(false);
				c6.setClickable(false);
				c7.setClickable(false);
				c8.setClickable(false);
				c9.setClickable(false);
				c10.setClickable(false);

				cn1.setClickable(false);
				cn2.setClickable(false);
				cn3.setClickable(false);
				cn4.setClickable(false);
				cn5.setClickable(false);
				cn6.setClickable(false);
				cn7.setClickable(false);
				cn8.setClickable(false);
				cn9.setClickable(false);
				cn10.setClickable(false);

				lpt1.setClickable(false);
				lpt2.setClickable(false);
				lpt3.setClickable(false);
				lpt4.setClickable(false);
				lpt5.setClickable(false);
				lpt6.setClickable(false);
				lpt7.setClickable(false);
				lpt8.setClickable(false);
				lpt9.setClickable(false);
				lpt10.setClickable(false);

			}
			break;
		}

	}

	public void setValues() {
		switch (daynumber) {
		case Calendar.SUNDAY:
			day.setText("Take lite, It's Sunday");
			c1.setText(storage.getString("suc0", "-"));
			c2.setText(storage.getString("suc1", "-"));
			c3.setText(storage.getString("suc2", "-"));
			c4.setText(storage.getString("suc3", "-"));
			c5.setText(storage.getString("suc4", "-"));
			c6.setText(storage.getString("suc5", "-"));
			c7.setText(storage.getString("suc6", "-"));
			c8.setText(storage.getString("suc7", "-"));
			c9.setText(storage.getString("suc8", "-"));
			c10.setText(storage.getString("suc9", "-"));
			cn1.setText(storage.getString("sucn0", "-"));
			cn2.setText(storage.getString("sucn1", "-"));
			cn3.setText(storage.getString("sucn2", "-"));
			cn4.setText(storage.getString("sucn3", "-"));
			cn5.setText(storage.getString("sucn4", "-"));
			cn6.setText(storage.getString("sucn5", "-"));
			cn7.setText(storage.getString("sucn6", "-"));
			cn8.setText(storage.getString("sucn7", "-"));
			cn9.setText(storage.getString("sucn8", "-"));
			cn10.setText(storage.getString("sucn9", "-"));
			lpt1.setText(storage.getString("sul0", "-"));
			lpt2.setText(storage.getString("sul1", "-"));
			lpt3.setText(storage.getString("sul2", "-"));
			lpt4.setText(storage.getString("sul3", "-"));
			lpt5.setText(storage.getString("sul4", "-"));
			lpt6.setText(storage.getString("sul5", "-"));
			lpt7.setText(storage.getString("sul6", "-"));
			lpt8.setText(storage.getString("sul7", "-"));
			lpt9.setText(storage.getString("sul8", "-"));
			lpt10.setText(storage.getString("sul9", "-"));
			break;
		case Calendar.MONDAY:
			day.setText("Monday");
			c1.setText(storage.getString("mc0", "-"));
			c2.setText(storage.getString("mc1", "-"));
			c3.setText(storage.getString("mc2", "-"));
			c4.setText(storage.getString("mc3", "-"));
			c5.setText(storage.getString("mc4", "-"));
			c6.setText(storage.getString("mc5", "-"));
			c7.setText(storage.getString("mc6", "-"));
			c8.setText(storage.getString("mc7", "-"));
			c9.setText(storage.getString("mc8", "-"));
			c10.setText(storage.getString("mc9", "-"));
			cn1.setText(storage.getString("mcn0", "-"));
			cn2.setText(storage.getString("mcn1", "-"));
			cn3.setText(storage.getString("mcn2", "-"));
			cn4.setText(storage.getString("mcn3", "-"));
			cn5.setText(storage.getString("mcn4", "-"));
			cn6.setText(storage.getString("mcn5", "-"));
			cn7.setText(storage.getString("mcn6", "-"));
			cn8.setText(storage.getString("mcn7", "-"));
			cn9.setText(storage.getString("mcn8", "-"));
			cn10.setText(storage.getString("mcn9", "-"));
			lpt1.setText(storage.getString("ml0", "-"));
			lpt2.setText(storage.getString("ml1", "-"));
			lpt3.setText(storage.getString("ml2", "-"));
			lpt4.setText(storage.getString("ml3", "-"));
			lpt5.setText(storage.getString("ml4", "-"));
			lpt6.setText(storage.getString("ml5", "-"));
			lpt7.setText(storage.getString("ml6", "-"));
			lpt8.setText(storage.getString("ml7", "-"));
			lpt9.setText(storage.getString("ml8", "-"));
			lpt10.setText(storage.getString("ml9", "-"));
			break;
		case Calendar.TUESDAY:
			day.setText("Tuesday");
			c1.setText(storage.getString("tc0", "-"));
			c2.setText(storage.getString("tc1", "-"));
			c3.setText(storage.getString("tc2", "-"));
			c4.setText(storage.getString("tc3", "-"));
			c5.setText(storage.getString("tc4", "-"));
			c6.setText(storage.getString("tc5", "-"));
			c7.setText(storage.getString("tc6", "-"));
			c8.setText(storage.getString("tc7", "-"));
			c9.setText(storage.getString("tc8", "-"));
			c10.setText(storage.getString("tc9", "-"));
			cn1.setText(storage.getString("tcn0", "-"));
			cn2.setText(storage.getString("tcn1", "-"));
			cn3.setText(storage.getString("tcn2", "-"));
			cn4.setText(storage.getString("tcn3", "-"));
			cn5.setText(storage.getString("tcn4", "-"));
			cn6.setText(storage.getString("tcn5", "-"));
			cn7.setText(storage.getString("tcn6", "-"));
			cn8.setText(storage.getString("tcn7", "-"));
			cn9.setText(storage.getString("tcn8", "-"));
			cn10.setText(storage.getString("tcn9", "-"));
			lpt1.setText(storage.getString("tl0", "-"));
			lpt2.setText(storage.getString("tl1", "-"));
			lpt3.setText(storage.getString("tl2", "-"));
			lpt4.setText(storage.getString("tl3", "-"));
			lpt5.setText(storage.getString("tl4", "-"));
			lpt6.setText(storage.getString("tl5", "-"));
			lpt7.setText(storage.getString("tl6", "-"));
			lpt8.setText(storage.getString("tl7", "-"));
			lpt9.setText(storage.getString("tl8", "-"));
			lpt10.setText(storage.getString("tl9", "-"));
			break;
		case Calendar.WEDNESDAY:
			day.setText("Wednesday");
			c1.setText(storage.getString("wc0", "-"));
			c2.setText(storage.getString("wc1", "-"));
			c3.setText(storage.getString("wc2", "-"));
			c4.setText(storage.getString("wc3", "-"));
			c5.setText(storage.getString("wc4", "-"));
			c6.setText(storage.getString("wc5", "-"));
			c7.setText(storage.getString("wc6", "-"));
			c8.setText(storage.getString("wc7", "-"));
			c9.setText(storage.getString("wc8", "-"));
			c10.setText(storage.getString("wc9", "-"));
			cn1.setText(storage.getString("wcn0", "-"));
			cn2.setText(storage.getString("wcn1", "-"));
			cn3.setText(storage.getString("wcn2", "-"));
			cn4.setText(storage.getString("wcn3", "-"));
			cn5.setText(storage.getString("wcn4", "-"));
			cn6.setText(storage.getString("wcn5", "-"));
			cn7.setText(storage.getString("wcn6", "-"));
			cn8.setText(storage.getString("wcn7", "-"));
			cn9.setText(storage.getString("wcn8", "-"));
			cn10.setText(storage.getString("wcn9", "-"));
			lpt1.setText(storage.getString("wl0", "-"));
			lpt2.setText(storage.getString("wl1", "-"));
			lpt3.setText(storage.getString("wl2", "-"));
			lpt4.setText(storage.getString("wl3", "-"));
			lpt5.setText(storage.getString("wl4", "-"));
			lpt6.setText(storage.getString("wl5", "-"));
			lpt7.setText(storage.getString("wl6", "-"));
			lpt8.setText(storage.getString("wl7", "-"));
			lpt9.setText(storage.getString("wl8", "-"));
			lpt10.setText(storage.getString("wl9", "-"));
			break;
		case Calendar.THURSDAY:
			day.setText("Thursday");
			c1.setText(storage.getString("thc0", "-"));
			c2.setText(storage.getString("thc1", "-"));
			c3.setText(storage.getString("thc2", "-"));
			c4.setText(storage.getString("thc3", "-"));
			c5.setText(storage.getString("thc4", "-"));
			c6.setText(storage.getString("thc5", "-"));
			c7.setText(storage.getString("thc6", "-"));
			c8.setText(storage.getString("thc7", "-"));
			c9.setText(storage.getString("thc8", "-"));
			c10.setText(storage.getString("thc9", "-"));
			cn1.setText(storage.getString("thcn0", "-"));
			cn2.setText(storage.getString("thcn1", "-"));
			cn3.setText(storage.getString("thcn2", "-"));
			cn4.setText(storage.getString("thcn3", "-"));
			cn5.setText(storage.getString("thcn4", "-"));
			cn6.setText(storage.getString("thcn5", "-"));
			cn7.setText(storage.getString("thcn6", "-"));
			cn8.setText(storage.getString("thcn7", "-"));
			cn9.setText(storage.getString("thcn8", "-"));
			cn10.setText(storage.getString("thcn9", "-"));
			lpt1.setText(storage.getString("thl0", "-"));
			lpt2.setText(storage.getString("thl1", "-"));
			lpt3.setText(storage.getString("thl2", "-"));
			lpt4.setText(storage.getString("thl3", "-"));
			lpt5.setText(storage.getString("thl4", "-"));
			lpt6.setText(storage.getString("thl5", "-"));
			lpt7.setText(storage.getString("thl6", "-"));
			lpt8.setText(storage.getString("thl7", "-"));
			lpt9.setText(storage.getString("thl8", "-"));
			lpt10.setText(storage.getString("thl9", "-"));
			break;
		case Calendar.FRIDAY:
			day.setText("Friday");
			c1.setText(storage.getString("fc0", "-"));
			c2.setText(storage.getString("fc1", "-"));
			c3.setText(storage.getString("fc2", "-"));
			c4.setText(storage.getString("fc3", "-"));
			c5.setText(storage.getString("fc4", "-"));
			c6.setText(storage.getString("fc5", "-"));
			c7.setText(storage.getString("fc6", "-"));
			c8.setText(storage.getString("fc7", "-"));
			c9.setText(storage.getString("fc8", "-"));
			c10.setText(storage.getString("fc9", "-"));
			cn1.setText(storage.getString("fcn0", "-"));
			cn2.setText(storage.getString("fcn1", "-"));
			cn3.setText(storage.getString("fcn2", "-"));
			cn4.setText(storage.getString("fcn3", "-"));
			cn5.setText(storage.getString("fcn4", "-"));
			cn6.setText(storage.getString("fcn5", "-"));
			cn7.setText(storage.getString("fcn6", "-"));
			cn8.setText(storage.getString("fcn7", "-"));
			cn9.setText(storage.getString("fcn8", "-"));
			cn10.setText(storage.getString("fcn9", "-"));
			lpt1.setText(storage.getString("fl0", "-"));
			lpt2.setText(storage.getString("fl1", "-"));
			lpt3.setText(storage.getString("fl2", "-"));
			lpt4.setText(storage.getString("fl3", "-"));
			lpt5.setText(storage.getString("fl4", "-"));
			lpt6.setText(storage.getString("fl5", "-"));
			lpt7.setText(storage.getString("fl6", "-"));
			lpt8.setText(storage.getString("fl7", "-"));
			lpt9.setText(storage.getString("fl8", "-"));
			lpt10.setText(storage.getString("fl9", "-"));
			break;
		case Calendar.SATURDAY:
			day.setText("Saturday");
			c1.setText(storage.getString("sc0", "-"));
			c2.setText(storage.getString("sc1", "-"));
			c3.setText(storage.getString("sc2", "-"));
			c4.setText(storage.getString("sc3", "-"));
			c5.setText(storage.getString("sc4", "-"));
			c6.setText(storage.getString("sc5", "-"));
			c7.setText(storage.getString("sc6", "-"));
			c8.setText(storage.getString("sc7", "-"));
			c9.setText(storage.getString("sc8", "-"));
			c10.setText(storage.getString("sc9", "-"));
			cn1.setText(storage.getString("scn0", "-"));
			cn2.setText(storage.getString("scn1", "-"));
			cn3.setText(storage.getString("scn2", "-"));
			cn4.setText(storage.getString("scn3", "-"));
			cn5.setText(storage.getString("scn4", "-"));
			cn6.setText(storage.getString("scn5", "-"));
			cn7.setText(storage.getString("scn6", "-"));
			cn8.setText(storage.getString("scn7", "-"));
			cn9.setText(storage.getString("scn8", "-"));
			cn10.setText(storage.getString("scn9", "-"));
			lpt1.setText(storage.getString("sl0", "-"));
			lpt2.setText(storage.getString("sl1", "-"));
			lpt3.setText(storage.getString("sl2", "-"));
			lpt4.setText(storage.getString("sl3", "-"));
			lpt5.setText(storage.getString("sl4", "-"));
			lpt6.setText(storage.getString("sl5", "-"));
			lpt7.setText(storage.getString("sl6", "-"));
			lpt8.setText(storage.getString("sl7", "-"));
			lpt9.setText(storage.getString("sl8", "-"));
			lpt10.setText(storage.getString("sl9", "-"));
			break;

		}
	}

	public void storeSundayValues() {
		switch (ids) {
		case R.id.c1:
			editor.putString("suc0", str);
			break;
		case R.id.c2:
			editor.putString("suc1", str);
			break;
		case R.id.c3:
			editor.putString("suc2", str);
			break;
		case R.id.c4:
			editor.putString("suc3", str);
			break;
		case R.id.c5:
			editor.putString("suc4", str);
			break;
		case R.id.c6:
			editor.putString("suc5", str);
			break;
		case R.id.c7:
			editor.putString("suc6", str);
			break;
		case R.id.c8:
			editor.putString("suc7", str);
			break;
		case R.id.c9:
			editor.putString("suc8", str);
			break;
		case R.id.c10:
			editor.putString("suc9", str);
			break;
		case R.id.cn1:
			editor.putString("sucn0", str);
			break;
		case R.id.cn2:
			editor.putString("sucn1", str);
			break;
		case R.id.cn3:
			editor.putString("sucn2", str);
			break;
		case R.id.cn4:
			editor.putString("sucn3", str);
			break;
		case R.id.cn5:
			editor.putString("sucn4", str);
			break;
		case R.id.cn6:
			editor.putString("sucn5", str);
			break;
		case R.id.cn7:
			editor.putString("sucn6", str);
			break;
		case R.id.cn8:
			editor.putString("sucn7", str);
			break;
		case R.id.cn9:
			editor.putString("sucn8", str);
			break;
		case R.id.cn10:
			editor.putString("sucn9", str);
			break;
		case R.id.lpt1:
			editor.putString("sul0", str);
			break;
		case R.id.lpt2:
			editor.putString("sul1", str);
			break;
		case R.id.lpt3:
			editor.putString("sul2", str);
			break;
		case R.id.lpt4:
			editor.putString("sul3", str);
			break;
		case R.id.lpt5:
			editor.putString("sul4", str);
			break;
		case R.id.lpt6:
			editor.putString("sul5", str);
			break;
		case R.id.lpt7:
			editor.putString("sul6", str);
			break;
		case R.id.lpt8:
			editor.putString("sul7", str);
			break;
		case R.id.lpt9:
			editor.putString("sul8", str);
			break;
		case R.id.lpt10:
			editor.putString("sul9", str);
			break;
		}
	}

	public void storeMondayValues() {
		switch (ids) {
		case R.id.c1:
			editor.putString("mc0", str);
			break;
		case R.id.c2:
			editor.putString("mc1", str);
			break;
		case R.id.c3:
			editor.putString("mc2", str);
			break;
		case R.id.c4:
			editor.putString("mc3", str);
			break;
		case R.id.c5:
			editor.putString("mc4", str);
			break;
		case R.id.c6:
			editor.putString("mc5", str);
			break;
		case R.id.c7:
			editor.putString("mc6", str);
			break;
		case R.id.c8:
			editor.putString("mc7", str);
			break;
		case R.id.c9:
			editor.putString("mc8", str);
			break;
		case R.id.c10:
			editor.putString("mc9", str);
			break;
		case R.id.cn1:
			editor.putString("mcn0", str);
			break;
		case R.id.cn2:
			editor.putString("mcn1", str);
			break;
		case R.id.cn3:
			editor.putString("mcn2", str);
			break;
		case R.id.cn4:
			editor.putString("mcn3", str);
			break;
		case R.id.cn5:
			editor.putString("mcn4", str);
			break;
		case R.id.cn6:
			editor.putString("mcn5", str);
			break;
		case R.id.cn7:
			editor.putString("mcn6", str);
			break;
		case R.id.cn8:
			editor.putString("mcn7", str);
			break;
		case R.id.cn9:
			editor.putString("mcn8", str);
			break;
		case R.id.cn10:
			editor.putString("mcn9", str);
			break;
		case R.id.lpt1:
			editor.putString("ml0", str);
			break;
		case R.id.lpt2:
			editor.putString("ml1", str);
			break;
		case R.id.lpt3:
			editor.putString("ml2", str);
			break;
		case R.id.lpt4:
			editor.putString("ml3", str);
			break;
		case R.id.lpt5:
			editor.putString("ml4", str);
			break;
		case R.id.lpt6:
			editor.putString("ml5", str);
			break;
		case R.id.lpt7:
			editor.putString("ml6", str);
			break;
		case R.id.lpt8:
			editor.putString("ml7", str);
			break;
		case R.id.lpt9:
			editor.putString("ml8", str);
			break;
		case R.id.lpt10:
			editor.putString("ml9", str);
			break;
		}
	}

	public void storeTuesdayValues()

	{
		switch (ids) {
		case R.id.c1:
			editor.putString("tc0", str);
			break;
		case R.id.c2:
			editor.putString("tc1", str);
			break;
		case R.id.c3:
			editor.putString("tc2", str);
			break;
		case R.id.c4:
			editor.putString("tc3", str);
			break;
		case R.id.c5:
			editor.putString("tc4", str);
			break;
		case R.id.c6:
			editor.putString("tc5", str);
			break;
		case R.id.c7:
			editor.putString("tc6", str);
			break;
		case R.id.c8:
			editor.putString("tc7", str);
			break;
		case R.id.c9:
			editor.putString("tc8", str);
			break;
		case R.id.c10:
			editor.putString("tc9", str);
			break;
		case R.id.cn1:
			editor.putString("tcn0", str);
			break;
		case R.id.cn2:
			editor.putString("tcn1", str);
			break;
		case R.id.cn3:
			editor.putString("tcn2", str);
			break;
		case R.id.cn4:
			editor.putString("tcn3", str);
			break;
		case R.id.cn5:
			editor.putString("tcn4", str);
			break;
		case R.id.cn6:
			editor.putString("tcn5", str);
			break;
		case R.id.cn7:
			editor.putString("tcn6", str);
			break;
		case R.id.cn8:
			editor.putString("tcn7", str);
			break;
		case R.id.cn9:
			editor.putString("tcn8", str);
			break;
		case R.id.cn10:
			editor.putString("tcn9", str);
			break;
		case R.id.lpt1:
			editor.putString("tl0", str);
			break;
		case R.id.lpt2:
			editor.putString("tl1", str);
			break;
		case R.id.lpt3:
			editor.putString("tl2", str);
			break;
		case R.id.lpt4:
			editor.putString("tl3", str);
			break;
		case R.id.lpt5:
			editor.putString("tl4", str);
			break;
		case R.id.lpt6:
			editor.putString("tl5", str);
			break;
		case R.id.lpt7:
			editor.putString("tl6", str);
			break;
		case R.id.lpt8:
			editor.putString("tl7", str);
			break;
		case R.id.lpt9:
			editor.putString("tl8", str);
			break;
		case R.id.lpt10:
			editor.putString("tl9", str);
			break;
		}
	}

	public void storeWednesdayValues()

	{
		switch (ids) {
		case R.id.c1:
			editor.putString("wc0", str);
			break;
		case R.id.c2:
			editor.putString("wc1", str);
			break;
		case R.id.c3:
			editor.putString("wc2", str);
			break;
		case R.id.c4:
			editor.putString("wc3", str);
			break;
		case R.id.c5:
			editor.putString("wc4", str);
			break;
		case R.id.c6:
			editor.putString("wc5", str);
			break;
		case R.id.c7:
			editor.putString("wc6", str);
			break;
		case R.id.c8:
			editor.putString("wc7", str);
			break;
		case R.id.c9:
			editor.putString("wc8", str);
			break;
		case R.id.c10:
			editor.putString("wc9", str);
			break;
		case R.id.cn1:
			editor.putString("wcn0", str);
			break;
		case R.id.cn2:
			editor.putString("wcn1", str);
			break;
		case R.id.cn3:
			editor.putString("wcn2", str);
			break;
		case R.id.cn4:
			editor.putString("wcn3", str);
			break;
		case R.id.cn5:
			editor.putString("wcn4", str);
			break;
		case R.id.cn6:
			editor.putString("wcn5", str);
			break;
		case R.id.cn7:
			editor.putString("wcn6", str);
			break;
		case R.id.cn8:
			editor.putString("wcn7", str);
			break;
		case R.id.cn9:
			editor.putString("wcn8", str);
			break;
		case R.id.cn10:
			editor.putString("wcn9", str);
			break;
		case R.id.lpt1:
			editor.putString("wl0", str);
			break;
		case R.id.lpt2:
			editor.putString("wl1", str);
			break;
		case R.id.lpt3:
			editor.putString("wl2", str);
			break;
		case R.id.lpt4:
			editor.putString("wl3", str);
			break;
		case R.id.lpt5:
			editor.putString("wl4", str);
			break;
		case R.id.lpt6:
			editor.putString("wl5", str);
			break;
		case R.id.lpt7:
			editor.putString("wl6", str);
			break;
		case R.id.lpt8:
			editor.putString("wl7", str);
			break;
		case R.id.lpt9:
			editor.putString("wl8", str);
			break;
		case R.id.lpt10:
			editor.putString("wl9", str);
			break;
		}
	}

	public void storeThursdayValues() {

		switch (ids) {
		case R.id.c1:
			editor.putString("thc0", str);
			break;
		case R.id.c2:
			editor.putString("thc1", str);
			break;
		case R.id.c3:
			editor.putString("thc2", str);
			break;
		case R.id.c4:
			editor.putString("thc3", str);
			break;
		case R.id.c5:
			editor.putString("thc4", str);
			break;
		case R.id.c6:
			editor.putString("thc5", str);
			break;
		case R.id.c7:
			editor.putString("thc6", str);
			break;
		case R.id.c8:
			editor.putString("thc7", str);
			break;
		case R.id.c9:
			editor.putString("thc8", str);
			break;
		case R.id.c10:
			editor.putString("thc9", str);
			break;
		case R.id.cn1:
			editor.putString("thcn0", str);
			break;
		case R.id.cn2:
			editor.putString("thcn1", str);
			break;
		case R.id.cn3:
			editor.putString("thcn2", str);
			break;
		case R.id.cn4:
			editor.putString("thcn3", str);
			break;
		case R.id.cn5:
			editor.putString("thcn4", str);
			break;
		case R.id.cn6:
			editor.putString("thcn5", str);
			break;
		case R.id.cn7:
			editor.putString("thcn6", str);
			break;
		case R.id.cn8:
			editor.putString("thcn7", str);
			break;
		case R.id.cn9:
			editor.putString("thcn8", str);
			break;
		case R.id.cn10:
			editor.putString("thcn9", str);
			break;
		case R.id.lpt1:
			editor.putString("thl0", str);
			break;
		case R.id.lpt2:
			editor.putString("thl1", str);
			break;
		case R.id.lpt3:
			editor.putString("thl2", str);
			break;
		case R.id.lpt4:
			editor.putString("thl3", str);
			break;
		case R.id.lpt5:
			editor.putString("thl4", str);
			break;
		case R.id.lpt6:
			editor.putString("thl5", str);
			break;
		case R.id.lpt7:
			editor.putString("thl6", str);
			break;
		case R.id.lpt8:
			editor.putString("thl7", str);
			break;
		case R.id.lpt9:
			editor.putString("thl8", str);
			break;
		case R.id.lpt10:
			editor.putString("th9", str);
			break;
		}
	}

	public void storeFridayValues() {

		switch (ids) {
		case R.id.c1:
			editor.putString("fc0", str);
			break;
		case R.id.c2:
			editor.putString("fc1", str);
			break;
		case R.id.c3:
			editor.putString("fc2", str);
			break;
		case R.id.c4:
			editor.putString("fc3", str);
			break;
		case R.id.c5:
			editor.putString("fc4", str);
			break;
		case R.id.c6:
			editor.putString("fc5", str);
			break;
		case R.id.c7:
			editor.putString("fc6", str);
			break;
		case R.id.c8:
			editor.putString("fc7", str);
			break;
		case R.id.c9:
			editor.putString("fc8", str);
			break;
		case R.id.c10:
			editor.putString("fc9", str);
			break;
		case R.id.cn1:
			editor.putString("fcn0", str);
			break;
		case R.id.cn2:
			editor.putString("fcn1", str);
			break;
		case R.id.cn3:
			editor.putString("fcn2", str);
			break;
		case R.id.cn4:
			editor.putString("fcn3", str);
			break;
		case R.id.cn5:
			editor.putString("fcn4", str);
			break;
		case R.id.cn6:
			editor.putString("fcn5", str);
			break;
		case R.id.cn7:
			editor.putString("fcn6", str);
			break;
		case R.id.cn8:
			editor.putString("fcn7", str);
			break;
		case R.id.cn9:
			editor.putString("fcn8", str);
			break;
		case R.id.cn10:
			editor.putString("fcn9", str);
			break;
		case R.id.lpt1:
			editor.putString("fl0", str);
			break;
		case R.id.lpt2:
			editor.putString("fl1", str);
			break;
		case R.id.lpt3:
			editor.putString("fl2", str);
			break;
		case R.id.lpt4:
			editor.putString("fl3", str);
			break;
		case R.id.lpt5:
			editor.putString("fl4", str);
			break;
		case R.id.lpt6:
			editor.putString("fl5", str);
			break;
		case R.id.lpt7:
			editor.putString("fl6", str);
			break;
		case R.id.lpt8:
			editor.putString("fl7", str);
			break;
		case R.id.lpt9:
			editor.putString("fl8", str);
			break;
		case R.id.lpt10:
			editor.putString("fl9", str);
			break;
		}
	}

	public void storeSaturdayValues()

	{
		switch (ids) {
		case R.id.c1:
			editor.putString("sc0", str);
			break;
		case R.id.c2:
			editor.putString("sc1", str);
			break;
		case R.id.c3:
			editor.putString("sc2", str);
			break;
		case R.id.c4:
			editor.putString("sc3", str);
			break;
		case R.id.c5:
			editor.putString("sc4", str);
			break;
		case R.id.c6:
			editor.putString("sc5", str);
			break;
		case R.id.c7:
			editor.putString("sc6", str);
			break;
		case R.id.c8:
			editor.putString("sc7", str);
			break;
		case R.id.c9:
			editor.putString("sc8", str);
			break;
		case R.id.c10:
			editor.putString("sc9", str);
			break;
		case R.id.cn1:
			editor.putString("scn0", str);
			break;
		case R.id.cn2:
			editor.putString("scn1", str);
			break;
		case R.id.cn3:
			editor.putString("scn2", str);
			break;
		case R.id.cn4:
			editor.putString("scn3", str);
			break;
		case R.id.cn5:
			editor.putString("scn4", str);
			break;
		case R.id.cn6:
			editor.putString("scn5", str);
			break;
		case R.id.cn7:
			editor.putString("scn6", str);
			break;
		case R.id.cn8:
			editor.putString("scn7", str);
			break;
		case R.id.cn9:
			editor.putString("scn8", str);
			break;
		case R.id.cn10:
			editor.putString("scn9", str);
			break;
		case R.id.lpt1:
			editor.putString("sl0", str);
			break;
		case R.id.lpt2:
			editor.putString("sl1", str);
			break;
		case R.id.lpt3:
			editor.putString("sl2", str);
			break;
		case R.id.lpt4:
			editor.putString("sl3", str);
			break;
		case R.id.lpt5:
			editor.putString("sl4", str);
			break;
		case R.id.lpt6:
			editor.putString("sl5", str);
			break;
		case R.id.lpt7:
			editor.putString("sl6", str);
			break;
		case R.id.lpt8:
			editor.putString("sl7", str);
			break;
		case R.id.lpt9:
			editor.putString("sl8", str);
			break;
		case R.id.lpt10:
			editor.putString("sl9", str);
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

	@Override
	protected void previous() {
		// TODO Auto-generated method stub
		if (isSwipeable == true) {
			View v = findViewById(R.id.bPrevious);
			v.performClick();
		}
	}

	@Override
	protected void next() {
		// TODO Auto-generated method stub
		if (isSwipeable == true) {
			View v = findViewById(R.id.bNext);
			v.performClick();
		}
	}

}
