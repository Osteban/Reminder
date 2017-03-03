package com.example.stepanrerikh.reminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    private Intent intent;
    ArrayAdapter<String> adapter;
    Toolbar toolbar;
    ListView listView;
    ArrayList<String> goal;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        goal = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, goal);

        listView = (ListView) findViewById(R.id.content_main);
        listView.setAdapter(adapter);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(MainScreen.this, GoalEdit.class);
                startActivityForResult(intent, 1);

                Snackbar.make(view, R.string.add_new_goal, Snackbar.LENGTH_LONG)
                        .setAction("Cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //Отмена действия
                            }
                        }).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null)
            return;
        String nameG = data.getStringExtra("nameGoal");
        goal.add(0, nameG);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Edit:
                 //Выбрать goal и изменить его
                break;
            case R.id.Delete:
                //Выбрать goal и удалить его
                break;
            case R.id.Exit:

                break;
            default:
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
