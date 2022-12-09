package com.mad.it21009686supplementaryassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updateActivity extends AppCompatActivity {
    EditText titleInput, authorInput,pagesInput;
    Button updateButton;

    String id, title, author, pages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        titleInput = findViewById(R.id.titleInput2);
        authorInput = findViewById(R.id.authorInput2);
        pagesInput = findViewById(R.id.pagesInput2);
        updateButton = findViewById(R.id.updateButton);

        //first we call
        getAndSetIntentData();

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDb = new MyDatabaseHelper(updateActivity.this);
                //and then call
                myDb.updateData(id,title,author,pages);
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id")
                && getIntent().hasExtra("title")
                && getIntent().hasExtra("author")
                && getIntent().hasExtra("pages")){
            //getting data from Intent
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author = getIntent().getStringExtra("author");
            pages = getIntent().getStringExtra("pages");

            //setting intent data
            titleInput.setText(title);
            authorInput.setText(author);
            pagesInput.setText(pages);
        }
        else{
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }
    }
}