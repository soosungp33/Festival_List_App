package org.techtown.festival;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView = null ;
    RecyclerTextAdapter mAdapter = null ;
    ArrayList<RecyclerItem> mList = new ArrayList<RecyclerItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //스피너 part
        Spinner spinner = (Spinner)findViewById(R.id.spinner_rg);

        ArrayAdapter monthAdapter = ArrayAdapter.createFromResource(this, R.array.region, android.R.layout.simple_spinner_dropdown_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(monthAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        mRecyclerView = findViewById(R.id.recycler_v) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        mAdapter = new RecyclerTextAdapter(mList) ;
        mRecyclerView.setAdapter(mAdapter) ;

        // 리사이클러뷰에 LinearLayoutManager 지정. (vertical)
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        // 아이템 추가.
        addItem("동화 축제",
                "광진구", "5.4~5.6 (3일간)") ;
        // 두 번째 아이템 추가.
        addItem("관악 강감찬축제",
                "관악구", "10.16~10.18 (3일간)") ;
        // 세 번째 아이템 추가.
        addItem("2020 이태원 지구촌 축제",
                "용산구", "10월중") ;

        mAdapter.notifyDataSetChanged() ;

    }

    public void addItem(String name, String location, String period) {
        RecyclerItem item = new RecyclerItem();

        item.setName(name);
        item.setLocation(location);
        item.setPeriod(period);

        mList.add(item);
    }

}

