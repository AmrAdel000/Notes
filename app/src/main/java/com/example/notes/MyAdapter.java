package com.example.notes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

     private ItemClickListener mItemListener ;

    ArrayList<String> images;
    ArrayList<String> imagess;
    Context context;
   ArrayList<String>  c;
   String s ;
    String v ;
   SharedPreferences shrd ;




    public MyAdapter(Context ct, ArrayList<String> toks2, ArrayList<String> toks3, ArrayList<String> toks, ArrayList<String> intt, ItemClickListener itemClickListener) {
        context = ct;
        images = toks;
        imagess = toks3;
        c= intt   ;
        shrd = context.getSharedPreferences("trans file", Context.MODE_PRIVATE);

        this .mItemListener = itemClickListener ;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row1,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position) {

        s = shrd .getString("theme_number" , "a");

        switch (s){
            case "one"    :holder.itemView.setBackgroundColor(Color.parseColor("#7E91AF")); break;
            case "tow"    :holder.itemView.setBackgroundColor(Color.parseColor("#141E37")); break;
            case "three"  :holder.itemView.setBackgroundColor(Color.parseColor("#4563C7")); break;
            case "normal" :holder.itemView.setBackground(ContextCompat.getDrawable(context, R.drawable.itemback)); break;
            case "materal" :holder.itemView.setBackground(ContextCompat.getDrawable(context, R.drawable.back2));
                //holder.mytext.setTextColor(ContextCompat.getColor(context , R.color.black));
            break;



        }

            holder.mytext.setText(images.get(position));
            holder.mytext2.setText(imagess.get(position));
         //   holder.mytext.setTextColor(Color.parseColor("#7E91AF"));
         //   holder.itemView.setBackgroundColor(Color.parseColor(v));
            holder.itemView.setOnClickListener(view -> {
            mItemListener.onItemClick(c.get(position));//it will get the position of our item in our resycler vew
        });
        holder.itemView.setOnLongClickListener( view -> {
            mItemListener.onItemClick(c.get(position));
            return true;
                    //Toast.makeText(  MyAdapter.this , "???? ??????????" , Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {

        return images.size() ;
    }

    public interface ItemClickListener {

        void onItemClick(String details);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mytext;
        TextView mytext2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mytext = itemView.findViewById(R.id.mytext);
            mytext2 = itemView.findViewById(R.id.textin);

        }

    }

}
