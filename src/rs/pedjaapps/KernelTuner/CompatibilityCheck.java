package rs.pedjaapps.KernelTuner;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;
import rs.pedjaapps.KernelTuner.*;

public class CompatibilityCheck extends Activity
{

	public String out = "sad";
	private Object data = null;
	public String cmd;
	public int count = 0;
	public boolean saf;
	public boolean mp;
	public boolean td;
	public boolean vs;
	public boolean fs;
	public boolean fc;
	public boolean tis;
	public boolean uv;
	public boolean cd;
	public boolean lt;
	public boolean bl;
	public boolean g3d;
	public boolean g2d;
	public boolean s2w;
	public boolean sdc;
	public boolean sh;

	SharedPreferences sharedPrefs;

	private class exec extends AsyncTask<Void, Integer, Void>
	{


		@Override
		protected Void doInBackground(Void... args)
		{
			//Log.i("MyApp", "Background thread starting");
			// Random randomGenerator = new Random();

			// int randomInt = randomGenerator.nextInt(16);
			//int rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));

			//int progress = 0;
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/devices/system/cpu/cpu0/cpufreq/scaling_available_frequencies");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				saf = true;
			}
			catch (IOException e)
			{
				saf = false;
			}

			publishProgress(3);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/devices/system/cpu/cpufreq/vdd_table/vdd_levels");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				uv = true;
			}
			catch (IOException e)
			{
				uv = false;
			}
			publishProgress(4);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/devices/system/cpu/cpu0/cpufreq/stats/time_in_state");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				tis = true;
			}
			catch (IOException e)
			{
				tis = false;
			}
			publishProgress(5);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/kernel/notification_leds/off_timer_multiplier");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				lt = true;
			}
			catch (IOException e)
			{
				lt = false;
			}
			publishProgress(6);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/devices/platform/leds-pm8058/leds/button-backlight/currents");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				bl = true;
			}
			catch (IOException e)
			{
				bl = false;
			}
			publishProgress(7);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/devices/platform/kgsl-3d0.0/kgsl/kgsl-3d0/gpuclk");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				g3d = true;

			}
			catch (IOException e)
			{

				g3d = false;
			}
			publishProgress(8);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/devices/platform/kgsl-2d0.0/kgsl/kgsl-2d0/gpuclk");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				g2d = true;
			}
			catch (IOException e)
			{
				g2d = false;
			}
			publishProgress(9);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/kernel/fast_charge/force_fast_charge");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				fc = true;

			}
			catch (IOException e)
			{
				fc = false;
			}
			publishProgress(10);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/kernel/debug/msm_fb/0/vsync_enable");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				vs = true;
			}
			catch (IOException e)
			{
				vs = false;
			}
			publishProgress(11);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);

			try
			{

				File myFile = new File("/sys/kernel/debug/msm_fb/0/bpp");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				cd = true;

			}
			catch (IOException e)
			{
				cd = false;

			}
			publishProgress(12);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/kernel/dyn_fsync/Dyn_fsync_version");
				FileInputStream fIn = new FileInputStream(myFile);
				count = count + 1;
				fs = true;
			}
			catch (IOException e)
			{
				fs = false;
			}
			publishProgress(13);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File("/sys/android_touch/sweep2wake");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				s2w = true;
			}
			catch (IOException e)
			{
				s2w = false;
			}
			publishProgress(14);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/kernel/msm_thermal/conf/allowed_low_freq");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				td = true;
			}
			catch (IOException e)
			{

				td = false;
			}
			publishProgress(15);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/kernel/msm_mpdecision/conf/enabled");
				FileInputStream fIn = new FileInputStream(myFile);

				count = count + 1;
				mp = true;
			}
			catch (IOException e)
			{
				mp = false;

			}
			publishProgress(16);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			///SystemClock.sleep(rand);
			try
			{

				File myFile = new File(
					"/sys/devices/virtual/bdi/179:0/read_ahead_kb");
				FileInputStream fIn = new FileInputStream(myFile);
				count = count + 1;
				sdc = true;

			}
			catch (Exception e)
			{

				sdc = false;
			}
			publishProgress(17);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);

			try
			{

				File myFile = new File("/sys/block/mmcblk0/queue/scheduler");
				FileInputStream fIn = new FileInputStream(myFile);
				count = count + 1;
				sh = true;

			}
			catch (Exception e)
			{
				sh = false;
			}

			publishProgress(18);
			//rand = 100 + (int) (Math.random() * ((1000 - 100) + 1));
			//SystemClock.sleep(rand);

			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values)
		{

			super.onProgressUpdate();
			final TextView output = (TextView) findViewById(R.id.textView1);
			LinearLayout ll1 = (LinearLayout) findViewById(R.id.ll1);
			LinearLayout ll2 = (LinearLayout) findViewById(R.id.ll2);
			LinearLayout ll3 = (LinearLayout) findViewById(R.id.ll3);
			LinearLayout ll4 = (LinearLayout) findViewById(R.id.ll4);
			LinearLayout ll5 = (LinearLayout) findViewById(R.id.ll5);
			LinearLayout ll6 = (LinearLayout) findViewById(R.id.ll6);
			LinearLayout ll7 = (LinearLayout) findViewById(R.id.ll7);
			LinearLayout ll8 = (LinearLayout) findViewById(R.id.ll8);
			LinearLayout ll9 = (LinearLayout) findViewById(R.id.ll9);
			LinearLayout ll10 = (LinearLayout) findViewById(R.id.ll10);
			LinearLayout ll11 = (LinearLayout) findViewById(R.id.ll11);
			LinearLayout ll12 = (LinearLayout) findViewById(R.id.ll12);
			LinearLayout ll13 = (LinearLayout) findViewById(R.id.ll13);
			LinearLayout ll14 = (LinearLayout) findViewById(R.id.ll14);
			LinearLayout ll15 = (LinearLayout) findViewById(R.id.ll15);
			LinearLayout ll16 = (LinearLayout) findViewById(R.id.ll16);
			TextView saftv = (TextView) findViewById(R.id.textView2);
			TextView uvtv = (TextView) findViewById(R.id.textView4);
			TextView tistv = (TextView) findViewById(R.id.textView6);
			TextView lttv = (TextView) findViewById(R.id.textView8);
			TextView bltv = (TextView) findViewById(R.id.textView10);
			TextView g3dtv = (TextView) findViewById(R.id.textView12);
			TextView g2dtv = (TextView) findViewById(R.id.textView14);
			TextView fctv = (TextView) findViewById(R.id.textView16);
			TextView vstv = (TextView) findViewById(R.id.textView18);
			TextView cdtv = (TextView) findViewById(R.id.textView20);
			TextView fstv = (TextView) findViewById(R.id.textView22);
			TextView s2wtv = (TextView) findViewById(R.id.textView24);
			TextView tdtv = (TextView) findViewById(R.id.textView26);
			TextView mptv = (TextView) findViewById(R.id.textView28);
			TextView sdctv = (TextView) findViewById(R.id.textView30);
			TextView shtv = (TextView) findViewById(R.id.textView32);

			// output.setText(output.getText()+String.valueOf(values[0]));
			if (values[0] == 3)
			{
				ll1.setVisibility(View.VISIBLE);
				if (saf == true)
				{
					saftv.setText("[OK]");
					saftv.setTextColor(Color.GREEN);
				}
				else
				{
					saftv.setText("[Not Found]");
					saftv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 4)
			{
				ll2.setVisibility(View.VISIBLE);
				if (uv == true)
				{
					uvtv.setText("[OK]");
					uvtv.setTextColor(Color.GREEN);
				}
				else
				{
					uvtv.setText("[Not Found]");
					uvtv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 5)
			{
				ll3.setVisibility(View.VISIBLE);
				if (tis == true)
				{
					tistv.setText("[OK]");
					tistv.setTextColor(Color.GREEN);
				}
				else
				{
					tistv.setText("[Not Found]");
					tistv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 6)
			{
				ll4.setVisibility(View.VISIBLE);
				if (lt == true)
				{
					lttv.setText("[OK]");
					lttv.setTextColor(Color.GREEN);
				}
				else
				{
					lttv.setText("[Not Found]");
					lttv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 7)
			{
				ll5.setVisibility(View.VISIBLE);
				if (bl == true)
				{
					bltv.setText("[OK]");
					bltv.setTextColor(Color.GREEN);
				}
				else
				{
					bltv.setText("[Not Found]");
					bltv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 8)
			{
				ll6.setVisibility(View.VISIBLE);
				if (g3d == true)
				{
					g3dtv.setText("[OK]");
					g3dtv.setTextColor(Color.GREEN);
				}
				else
				{
					g3dtv.setText("[Not Found]");
					g3dtv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 9)
			{
				ll7.setVisibility(View.VISIBLE);
				if (g2d == true)
				{
					g2dtv.setText("[OK]");
					g2dtv.setTextColor(Color.GREEN);
				}
				else
				{
					g2dtv.setText("[Not Found]");
					g2dtv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 10)
			{
				ll8.setVisibility(View.VISIBLE);
				if (fc == true)
				{
					fctv.setText("[OK]");
					fctv.setTextColor(Color.GREEN);
				}
				else
				{
					fctv.setText("[Not Found]");
					fctv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 11)
			{
				ll9.setVisibility(View.VISIBLE);
				if (vs == true)
				{
					vstv.setText("[OK]");
					vstv.setTextColor(Color.GREEN);
				}
				else
				{
					vstv.setText("[Not Found]");
					vstv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 12)
			{
				ll10.setVisibility(View.VISIBLE);
				if (cd == true)
				{
					cdtv.setText("[OK]");
					cdtv.setTextColor(Color.GREEN);
				}
				else
				{
					cdtv.setText("[Not Found]");
					cdtv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 13)
			{
				ll11.setVisibility(View.VISIBLE);
				if (fs == true)
				{
					fstv.setText("[OK]");
					fstv.setTextColor(Color.GREEN);
				}
				else
				{
					fstv.setText("[Not Found]");
					fstv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 14)
			{
				ll12.setVisibility(View.VISIBLE);
				if (s2w == true)
				{
					s2wtv.setText("[OK]");
					s2wtv.setTextColor(Color.GREEN);
				}
				else
				{
					s2wtv.setText("[Not Found]");
					s2wtv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 15)
			{
				ll13.setVisibility(View.VISIBLE);
				if (td == true)
				{
					tdtv.setText("[OK]");
					tdtv.setTextColor(Color.GREEN);
				}
				else
				{
					tdtv.setText("[Not Found]");
					tdtv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 16)
			{
				ll14.setVisibility(View.VISIBLE);
				if (mp == true)
				{
					mptv.setText("[OK]");
					mptv.setTextColor(Color.GREEN);
				}
				else
				{
					mptv.setText("[Not Found]");
					mptv.setTextColor(Color.RED);
				}
			}

			if (values[0] == 17)
			{
				ll15.setVisibility(View.VISIBLE);
				if (sdc == true)
				{
					sdctv.setText("[OK]");
					sdctv.setTextColor(Color.GREEN);
				}
				else
				{
					sdctv.setText("[Not Found]");
					sdctv.setTextColor(Color.RED);
				}
			}
			if (values[0] == 18)
			{
				ll16.setVisibility(View.VISIBLE);
				if (sh == true)
				{
					shtv.setText("[OK]");
					shtv.setTextColor(Color.GREEN);
				}
				else
				{
					shtv.setText("[Not Found]");
					shtv.setTextColor(Color.RED);
				}
			}

		}

		@Override
		protected void onPostExecute(Void result)
		{
			// Pass the result data back to the main activity
			TextView res = (TextView) findViewById(R.id.textView34);
			int cn = count * 100 / 16;
			res.setText(String.valueOf(cn) + "%");
			if (cn < 30)
			{
				res.setTextColor(Color.RED);
			}
			else if (cn > 30 && cn < 50)
			{
				res.setTextColor(Color.MAGENTA);
			}
			else if (cn > 50 && cn < 70)
			{
				res.setTextColor(Color.YELLOW);
			}
			else if (cn > 70 && cn < 90)
			{
				res.setTextColor(Color.BLUE);
			}
			else if (cn > 90)
			{
				res.setTextColor(Color.GREEN);
			}
			ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar1);
			LinearLayout resultll = (LinearLayout) findViewById(R.id.resultll);
			resultll.setVisibility(View.VISIBLE);
			pb.setVisibility(View.GONE);
			Button ok = (Button) findViewById(R.id.button1);
			ok.setVisibility(View.VISIBLE);

			CompatibilityCheck.this.data = result;

		}

	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.check);
		//final EditText prompt = (EditText) findViewById(R.id.editText1);
		//final TextView output = (TextView) findViewById(R.id.textView1);
		new exec().execute();
		Button ok = (Button) findViewById(R.id.button1);
		ok.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0)
				{
					// TODO Auto-generated method stub
					finish();

				}
			});

	}
}