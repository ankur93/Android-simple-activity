package helloandroid.example.org.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.net.URI;

/**
 * Created by aagr12 on 5/21/2015.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        View bg =findViewById(R.id.layout);
        bg.getBackground().setAlpha(120);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tw = (TextView)findViewById(R.id.textView2);
        tw.setText(getIntent().getExtras().getString("textBox"));

        TextView wifi_text = (TextView)findViewById(R.id.wifiStatus);
        TextView BT_text = (TextView)findViewById(R.id.BTStatus);

        ConnectivityManager conman = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean wifi = conman.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
        boolean bluetooth = conman.getNetworkInfo(ConnectivityManager.TYPE_BLUETOOTH).isConnectedOrConnecting();

        if(wifi){
            wifi_text.setText("WIfi On");
        }
        if(bluetooth){
            BT_text.setText("BT On");
        }

        //Access Google
        Button hitUrl = (Button)findViewById(R.id.hitUrl);
        hitUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hitUrlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https:google.com"));
                startActivity(hitUrlIntent);
            }
        });

        final Button sendMsg = (Button)findViewById(R.id.sendText);
        sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendMsgIntent =new Intent();
                sendMsgIntent.setAction(Intent.ACTION_SEND);
                sendMsgIntent.putExtra(Intent.EXTRA_TEXT,"This is an ANDROID generated message. Please ignore. Do not reply");
                sendMsgIntent.setType("text/plain");
                startActivity(sendMsgIntent);
            }
        });

        Button getCall = (Button)findViewById(R.id.getCall);
        getCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,CallReceiver.class));
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
