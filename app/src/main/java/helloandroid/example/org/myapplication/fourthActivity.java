package helloandroid.example.org.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Ankur93 on 27-May-15.
 */
public class fourthActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourthactivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add("ADD");
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent addIntent = new Intent();
                addIntent.putExtra("action","add");
                setResult(RESULT_OK,addIntent);
                finish();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);


    }
}
