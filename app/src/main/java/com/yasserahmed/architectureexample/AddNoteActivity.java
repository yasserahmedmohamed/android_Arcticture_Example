package com.yasserahmed.architectureexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE="com.yasserahmed.architectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION="com.yasserahmed.architectureexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY="com.yasserahmed.architectureexample.EXTRA_PRIORITY";

    private EditText edittextTitle;
    private EditText edittextDescription;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        edittextTitle = findViewById(R.id.edit_text_title);
        edittextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void  saveNote(){
        String title = edittextTitle.getText().toString();
        String description = edittextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();
        if (title.trim().isEmpty()||description.trim().isEmpty())
        {
            Toast.makeText(this,"Please enter a title and description",Toast.LENGTH_SHORT).show();
        return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE , title);
        data.putExtra(EXTRA_DESCRIPTION , description);
        data.putExtra(EXTRA_PRIORITY , priority);
        setResult(RESULT_OK,data);
        finish();
    }
}
