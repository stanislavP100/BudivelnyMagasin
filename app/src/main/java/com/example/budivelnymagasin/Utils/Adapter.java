package com.example.budivelnymagasin.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.budivelnymagasin.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.NumberViewHolder>{

    private int mNumberItems;

    private List<Product> products;


    public Adapter(List<Product> product){
        mNumberItems = product.size();
        this.products=product;
        //  bb=image;
    }


    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.activity_main2;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);

        return new NumberViewHolder(view);
    }


    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {

        holder.setDetails(products, position);

    }


    @Override
    public int getItemCount() {

        return mNumberItems;
    }


    static class NumberViewHolder extends RecyclerView.ViewHolder {


        TextView viewHolderIndex;
        ImageView imageView;
        TextView price;
        TextView description;
        TextView articul;



        NumberViewHolder(View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.my_image);
            price=itemView.findViewById(R.id.price_Id_in_Cardview);
            description=itemView.findViewById(R.id.description_Id_in_Cardview);
            articul=itemView.findViewById(R.id.artikul_Id_in_Cardview);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_instance);
        }


        void setDetails(List<Product>products, int p) {
            viewHolderIndex.setText(products.get(p).getName());
            imageView.setImageBitmap(products.get(p).getImageBitmap());
            description.setText(products.get(p).getDescription());
            price.setText(products.get(p).getPrice());
            articul.setText(products.get(p).getId());

        }



    }
}
