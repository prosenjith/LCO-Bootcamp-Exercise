package com.studycseathome.todoappwithfirestore2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class UpdateActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private Button updateButton,deleteButton;
    private EditText editTextTitle,editTextDescription;
    private ListItem note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        note= (ListItem) getIntent().getSerializableExtra("note");

        db=FirebaseFirestore.getInstance();
        updateButton=findViewById(R.id.add_btn_id);
        deleteButton=findViewById(R.id.delete_btn_id);
        editTextTitle=findViewById(R.id.title_id);
        editTextDescription=findViewById(R.id.description_id);

        editTextTitle.setText(note.getTitle());
        editTextDescription.setText(note.getDescription());

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNote();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNote();
            }
        });
    }

    private void deleteNote() {
        db.collection("Notebook").document(note.getId()).delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(UpdateActivity.this,"Note Updated",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void updateNote() {
        String title=editTextTitle.getText().toString();
        String description=editTextDescription.getText().toString();
        ListItem l=new ListItem(title,description);
        if(TextUtils.isEmpty(title) || TextUtils.isEmpty(description)){
            return;
        }
        db.collection("Notebook").document(note.getId())
                .set(l).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(UpdateActivity.this,"Note Updated",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
