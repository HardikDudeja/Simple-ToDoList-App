package com.example.todolist_09082020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.itemHolder> {
    ArrayList<String> items;

    public ItemAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = li.inflate(R.layout.list_item, parent, false);
        return new itemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {
        String item = items.get(position);
        holder.tvListItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class itemHolder extends RecyclerView.ViewHolder{

        TextView tvListItem;
        Button btnDelete;

        public itemHolder(@NonNull View itemView) {
            super(itemView);
            tvListItem = itemView.findViewById(R.id.tvListItem);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    items.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }
    }
}
