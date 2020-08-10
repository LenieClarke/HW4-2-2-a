package com.example.hw4_2_2_a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    private ItemsDataAdapter adapter;
    private List<String> effort = new ArrayList<>();
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        ListView listView = findViewById(R.id.list);

        fillEffort();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandomItemData();
                count++;
            }
        });

        adapter = new ItemsDataAdapter(this, null);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ItemData itemData = adapter.getItem(position);
                Toast.makeText(MainActivity.this, itemData.getTitle() + "\n"
                        + itemData.getSubtitle(), Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    private void fillEffort() {
        effort.add(getString(R.string.subtitleBook));
        effort.add(getString(R.string.subtitleGrammar));
        effort.add(getString(R.string.subtitlePodcast));
        effort.add(getString(R.string.subtitleFilm));
        effort.add(getString(R.string.subtitleCommunication));
    }

    private void generateRandomItemData() {
        Button deleteBtn = findViewById(R.id.deleteBtn);
        adapter.addItem(new ItemData(R.drawable.ic_baseline_adb_24,
                getString(R.string.title) + count,
                effort.get(random.nextInt(effort.size())), deleteBtn));
    }
}