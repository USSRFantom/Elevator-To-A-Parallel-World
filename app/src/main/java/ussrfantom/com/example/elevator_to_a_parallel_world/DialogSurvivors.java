package ussrfantom.com.example.elevator_to_a_parallel_world;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DialogSurvivors extends AppCompatActivity {
    private ListView listViewSurvivors;
   ArrayList <String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_survivors);
     arrayList = new ArrayList<>();
     arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        arrayList.add("Гоша");
        listViewSurvivors = findViewById(R.id.listViewSurvivors);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DialogSurvivors.this, R.layout.layouttextcolorwhite, arrayList);
        listViewSurvivors.setAdapter(adapter);
    }
}