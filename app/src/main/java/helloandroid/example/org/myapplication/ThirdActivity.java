package helloandroid.example.org.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Toast;

/**
 * Created by Ankur93 on 26-May-15.
 */
public class ThirdActivity extends ListActivity{

    public static final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdactivity);

        View bg = (View)findViewById(R.id.thirdAct);
        bg.getBackground().setAlpha(120);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.countries)));

        Button gotTo4 = (Button)findViewById(R.id.gotoFour);
        gotTo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goTo4Intent = new Intent(ThirdActivity.this,fourthActivity.class);
                goTo4Intent.putExtra("verText","This is ver text");
                startActivityForResult(goTo4Intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            Toast.makeText(this,"Item Added",Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
