package com.example.shopsy.categorymodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopsy.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<CategoryModel> categoryModels;

    public CategoryAdapter(ArrayList<CategoryModel> categoryModels) {

        this.categoryModels = categoryModels;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
    String icon=categoryModels.get(position).getCategoryIconLink();
    String name=categoryModels.get(position).getCategoryName();
    holder.setCategoryIcon(icon);
    holder.setCategoryName(name);
    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.category_icon);
            textView=itemView.findViewById(R.id.category_name);
        }
        private void setCategoryIcon(String icon){

        }
        private void setCategoryName(String name){
        textView.setText(name);
        }
    }
}
