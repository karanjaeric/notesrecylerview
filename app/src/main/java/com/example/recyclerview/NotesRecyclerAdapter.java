package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesRecyclerAdapter  extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder>{

    private final Context mContext;
    private final LayoutInflater mlaLayoutInflater;
    private final List<NotesInfo> mNotes;

    public NotesRecyclerAdapter(Context mContext, List<NotesInfo> mNotes) {
        this.mContext = mContext;
        this.mlaLayoutInflater = LayoutInflater.from(mContext);
        this.mNotes = mNotes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=mlaLayoutInflater.inflate(R.layout.item_node_list,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotesInfo note=mNotes.get(position);
        holder.textTitle.setText(note.getTitle());
        holder.textCourse.setText(note.getCourse());
        holder.mCurrentPosition=position;
    }

    @Override
    public int getItemCount() {
        return this.mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        private final TextView textTitle;
        private final TextView textCourse;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle= itemView.findViewById(R.id.textView5);
            textCourse = itemView.findViewById(R.id.textView6);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Clicked item position "+mCurrentPosition, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
