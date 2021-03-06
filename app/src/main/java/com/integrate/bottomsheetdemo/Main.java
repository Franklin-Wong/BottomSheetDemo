package com.integrate.bottomsheetdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.cocosw.query.CocoQuery;

/**
 * Project: gradle
 * Created by LiaoKai(soarcn) on 2014/9/21.
 */
public class Main extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main);
        CocoQuery q = new CocoQuery(this);

        String[] items = new String[]{"From Xml", "Without Icon", "Dark Theme", "Grid", "Style", "Style from Theme", "ShareAction", "FullScreen", "Menu Manipulate", "HeaderLayout"};
        q.id(R.id.listView)
                .adapter(adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items))
                .itemClicked(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ListAcitivty.class).setFlags(position).putExtra("title", adapter.getItem(position));
        if (position == 5) {
            intent.putExtra("style", true);
        }
        startActivity(intent);
    }

}
