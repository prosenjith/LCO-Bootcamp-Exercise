package com.studycseathome.todoappwithfirestore2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddNewActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private Button addButton;
    private EditText editTextTitle,editTextDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        db=FirebaseFirestore.getInstance();
        addButton=findViewById(R.id.add_btn_id);
        editTextTitle=findViewById(R.id.title_id);
        editTextDescription=findViewById(R.id.description_id);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=editTextTitle.getText().toString();
                String description=editTextDescription.getText().toString();
                if(TextUtils.isEmpty(title) || TextUtils.isEmpty(description)){
                    return;
                }
                CollectionReference collection=db.collection("Notebook");

                ListItem item=new ListItem(title,description);
                collection.add(item)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(AddNewActivity.this,"Note added.",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddNewActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
