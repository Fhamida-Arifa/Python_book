package com.example.mishkat_world.pythonbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Context mContext;
    ArrayList<String> titleArrayList;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=MainActivity.this;
        titleArrayList = new ArrayList<String >();
        titleArrayList.add(Constants.WHAT_IS_PYTHON);
        titleArrayList.add(Constants.HISTORY_OF_PYTHON);
        titleArrayList.add(Constants.Features_OF_PYTHON);
        titleArrayList.add(Constants.DECISION);
        titleArrayList.add(Constants.DEFINING_FUNCTION);
        titleArrayList.add(Constants.FOR_LOOPS);
        titleArrayList.add(Constants.DICTIONARIES);
        titleArrayList.add(Constants.Lists);
        titleArrayList.add(Constants.STRINGS);
        titleArrayList.add(Constants.USING_MODULES);
        titleArrayList.add(Constants.FILE_IO);
        titleArrayList.add(Constants.CODES);



        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomitemClickListener() {
            @Override
            public void onItemCLick(View v, int positon) {


                Intent desIntent = new Intent(mContext,DescriptionActivity.class);
                desIntent.putExtra("titles",titleArrayList.get(positon));
                startActivity(desIntent);

                Toast.makeText(mContext,"Clicked"+titleArrayList.get(positon), Toast.LENGTH_SHORT).show();

            }
        });

        mRecyclerView.setAdapter(adapter);

    }

}
