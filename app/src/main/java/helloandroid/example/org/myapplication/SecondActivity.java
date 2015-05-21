package helloandroid.example.org.myapplication;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by aagr12 on 5/21/2015.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

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

    }
}
