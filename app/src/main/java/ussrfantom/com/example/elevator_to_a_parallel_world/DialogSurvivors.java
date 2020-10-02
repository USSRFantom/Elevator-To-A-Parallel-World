package ussrfantom.com.example.elevator_to_a_parallel_world;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.events.Event;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
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
        arrayList = new ArrayList<>(); //массив для вывода текста
        db = FirebaseFirestore.getInstance();
        listViewSurvivors = findViewById(R.id.listViewSurvivors);//ссылка на view с измененным текстом

        //получение данных из базы
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    Toast.makeText(DialogSurvivors.this, "Успешно", Toast.LENGTH_SHORT).show();
                    QuerySnapshot querySnapshot = task.getResult();
                    if (querySnapshot == null) return;
                    for (QueryDocumentSnapshot documentSnapshot:querySnapshot){
                        Map<String, Object> user = documentSnapshot.getData();
                        arrayList.add(user.get("1").toString());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(DialogSurvivors.this, R.layout.layouttextcolorwhite, arrayList);
                    listViewSurvivors.setAdapter(adapter);
                }else{
                    Toast.makeText(DialogSurvivors.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

//добавление данных
/*
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
*/