package ussrfantom.com.example.elevator_to_a_parallel_world;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DialogSurvivors extends AppCompatActivity {
    private ListView listViewSurvivors;
    private ArrayList <String> arrayList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_survivors);

        db = FirebaseFirestore.getInstance();
        Map<String, Object> user = new HashMap<>();
        user.put("name", "иван");
        user.put("lastname", "иванjdbx");
        user.put("age", 15);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println("УСПЕШНО! <------------------------------------");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("провал <------------------------------------"+ e);
                    }
                });


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