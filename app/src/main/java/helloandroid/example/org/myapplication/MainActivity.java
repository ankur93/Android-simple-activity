package helloandroid.example.org.myapplication;

import android.app.Activity;
import android.content.Intent;
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
        super.onCreate(savedInstanceState);/*Log.d(ANKUR, "Activity created or Device rotated");*/
        setContentView(R.layout.mainactivity);

        Toast.makeText(this,"Welcome Motherfucker",Toast.LENGTH_SHORT).show();
        Button b = (Button)findViewById(R.id.button1);
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
