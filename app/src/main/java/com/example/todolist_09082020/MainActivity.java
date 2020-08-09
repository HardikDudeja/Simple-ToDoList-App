package com.example.todolist_09082020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items;
    Button btnAdd;
    EditText etItems;
    RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        etItems = findViewById(R.id.etItems);
        rvItems = findViewById(R.id.rvItems);

        items = new ArrayList<>();


        final ItemAdapter adapter = new ItemAdapter(items);
        rvItems.setLayoutManager(new LinearLayoutManager(this));

        rvItems.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etItems.getText().toString();
                if(!text.equals("")){
                    items.add(text);
                    adapter.notifyDataSetChanged();
                }
                etItems.setText("");
            }
        });

    }
}