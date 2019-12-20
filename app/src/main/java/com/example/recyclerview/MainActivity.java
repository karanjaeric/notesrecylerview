package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NotesRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadNotes();
    }

    protected void loadNotes(){

        RecyclerView notesRecyclerView=findViewById(R.id.list_notes);
//        LinearLayoutManager notesLayoutManager=new LinearLayoutManager(this);
        GridLayoutManager notesLayoutManager=new GridLayoutManager(this,2);
        notesRecyclerView.setLayoutManager(notesLayoutManager);
        List<NotesInfo> notes=this.getNotes();
        adapter = new NotesRecyclerAdapter(this,notes);
        notesRecyclerView.setAdapter(adapter);

    }

    public List<NotesInfo> getNotes(){
        List<NotesInfo> notes=new ArrayList<>();
        for(int i=0;i<10;i++){
            notes.add(new NotesInfo("Notes "+i,"Test Notes"));

        }
        return notes;

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
