package com.example.shopsy.home.horizontallayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopsy.R;

import java.util.ArrayList;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder> {
    private ArrayList<HorizontalProductModel> horizontalProductModelArrayList;
    public HorizontalProductScrollAdapter(ArrayList<HorizontalProductModel> horizontalProductModelArrayList) {
        this.horizontalProductModelArrayList = horizontalProductModelArrayList;
    }



    @NonNull
    @Override
    public HorizontalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.ViewHolder holder, int position) {
        int resource=horizontalProductModelArrayList.get(position).getProductImage();
        String title=horizontalProductModelArrayList.get(position).getProductTitle();
        String description=horizontalProductModelArrayList.get(position).getProductDescription();
        String price=horizontalProductModelArrayList.get(position).getProductPrice();
        holder.setProductImage(resource);
        holder.setProductTitle(title);
        holder.setProductPrice(price);
        holder.setProductDescription(description);
    }

    @Override
    public int getItemCount() {
        return horizontalProductModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        private TextView productTitle,productDescription,productPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.hs_product_image);
            productTitle=itemView.findViewById(R.id.hs_product_title);
            productDescription=itemView.findViewById(R.id.hs_product_description);
            productPrice=itemView.findViewById(R.id.hs_product_price);
        }
        private void setProductImage(int resource){
            productImage.setImageResource(resource);
        }
        private void setProductTitle(String title){
            productTitle.setText(title);
        }
        private void setProductDescription(String description){
            productDescription.setText(description);
        }
        private void setProductPrice(String price){
            productPrice.setText(price);
        }
    }
}
