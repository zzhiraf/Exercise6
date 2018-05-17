package com.example.exercise6;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public  class OurAdapter extends RecyclerView.Adapter<OurAdapter.ViewHolder> {
    private List<Note> mDataSource;
   // private final NotesAdapterInteraction mListener;

    public OurAdapter(List<Note> dataSources) {
        mDataSource = dataSources;
    }

    public void updateList(ArrayList<Note> updatedList) {
        mDataSource = updatedList;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title,body;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.titlelEl);
            body = view.findViewById(R.id.bodyEl);
        }
    }

    @Override
    //Количество элементов в данных
    public int getItemCount() {
        return mDataSource.size();
    }

    @Override
    //Инициализация
    public OurAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_image, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    //Заполним содержимое
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // get our custom object from our dataset at this position
        final Note note = mDataSource.get(position);

        // Bind our views with our data!
        holder.title.setText(note.getTitle());
        holder.body.setText(note.getBody());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void updateList(List<Note> updatedList) {
        mDataSource = updatedList;
        notifyDataSetChanged();
    }


}
