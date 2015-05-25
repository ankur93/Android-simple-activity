package helloandroid.example.org.myapplication;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.EventListener;


public class MainActivity extends Activity {

    public static final String ANKUR = "Ankur";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);Log.d(ANKUR, "Activity created or Device rotated");
        setContentView(R.layout.mainactivity);

        //Activity Creation Toast Message
        Toast.makeText(this,"Welcome Motherfucker",Toast.LENGTH_SHORT).show();
        Button b = (Button)findViewById(R.id.button1);

        //getting value entered in the text  box and passing it to second activity
        final EditText et = (EditText)findViewById(R.id.textBox1);
        et.setHint("Enter your name");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("textBox", et.getText().toString());

                startActivity(intent);
            }
        });

        //setting transparency for the background image
        View bg = findViewById(R.id.layout);
        bg.getBackground().setAlpha(120);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                return false;
            case R.id.action_icon_share:
                Intent msgInt = new Intent();
                msgInt.setAction(Intent.ACTION_SEND);
                msgInt.setType("text/plain");
                msgInt.putExtra(Intent.EXTRA_TEXT, "Sharing Data through Action Bar. (Android Generated. Please ignore)");
                startActivity(msgInt);
                break;
            case R.id.action_icon_fb:
                Intent shareInt = new Intent(Intent.ACTION_VIEW, Uri.parse("https:facebook.com"));
                startActivity(shareInt);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation== Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this,"Landscape", Toast.LENGTH_SHORT).show();
        }
        else if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this,"Portrait",Toast.LENGTH_SHORT).show();
        }
    }

    /*@Override
    protected void onPause() {
        super.onPause();
        Log.d(ANKUR,"Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(ANKUR,"resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(ANKUR,"restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(ANKUR,"stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(ANKUR,"destroy");
    }*/
}
