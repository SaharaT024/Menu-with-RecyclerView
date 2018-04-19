package com.gamerstyle.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private  String [] mDrawerTitle = {"File", "Load...", "Open", "Contact"};
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ListView mListView, listView;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview1);
        int[] resId = { R.drawable.cher , R.drawable.pun , R.drawable.orn , R.drawable.music , R.drawable.kai};
        String[] value = {"CHERPANG","PUN","ORN","MUSIC","KAIMOOK"};
        CustomAdapter adapter1 = new CustomAdapter(getApplicationContext(), value,resId);
        //ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.activity_list_item,android.R.id.text1,value);
        listView.setAdapter(adapter1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long row_id) {
                if(position==0){
                    Intent myintent = new Intent(view.getContext(),Main2Activity.class);
                    startActivityForResult(myintent,0);
                }
                if(position==1){
                    Intent myintent = new Intent(view.getContext(),Main3Activity.class);
                    startActivityForResult(myintent,1);
                }
                if(position==2){
                    Intent myintent = new Intent(view.getContext(),Main4Activity.class);
                    startActivityForResult(myintent,2);
                }
                if(position==3){
                    Intent myintent = new Intent(view.getContext(),Main5Activity.class);
                    startActivityForResult(myintent,2);
                }
                if(position==4){
                    Intent myintent = new Intent(view.getContext(),Main6Activity.class);
                    startActivityForResult(myintent,2);
                }

            }
        });

        mDrawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                mDrawerLayout,
                R.string.open_drawer,
                R.string.close_drawer);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mListView = findViewById(R.id.drawer);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>( this,
                android.R.layout.simple_list_item_1,mDrawerTitle );
        mListView.setAdapter(adapter2);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) mListView.getItemAtPosition(position);

                mDrawerLayout.closeDrawers();
                Toast.makeText(getApplicationContext(),
                        "Position :" + position + "  ListItem : " + itemValue, Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        switch (item.getItemId()) {
            case R.id.mnuNew:
                Toast.makeText(this, "New!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnuHelp:
                Toast.makeText(this, "Help!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
