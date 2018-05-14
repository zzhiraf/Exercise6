package com.example.exercise6;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public  class OurAdapter extends RecyclerView.Adapter<OurAdapter.ViewHolder> {
    private ArrayList<NoteClass> mDataSource;

    public OurAdapter(ArrayList<NoteClass> dataSources) {
        mDataSource = dataSources;
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
        final NoteClass noteClass = mDataSource.get(position);

        // Bind our views with our data!
        holder.title.setText(noteClass.getTitle());
        holder.body.setText(noteClass.getBody());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}
