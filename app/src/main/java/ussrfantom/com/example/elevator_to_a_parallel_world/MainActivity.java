package ussrfantom.com.example.elevator_to_a_parallel_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showSurvivors(View view) {
        Intent intent = new Intent(MainActivity.this,  DialogSurvivors.class);
        startActivity(intent);
    }
}