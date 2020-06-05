package com.example.poster.vista;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poster.R;
import com.example.poster.modelo.PostDataModel;

import java.util.ArrayList;

public class AdapterPostList extends RecyclerView.Adapter<AdapterPostList.ViewHolder> {

    private ArrayList<PostDataModel> postModel = new ArrayList<>();
    private Context context;


    public AdapterPostList(Context nContext, ArrayList<PostDataModel> postDataModels) {

        this.postModel = postDataModels;
        this.context = nContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_list_item, parent, false);
        return new AdapterPostList.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.post_title.setText(postModel.get(position).getTitle());

        //setOnclick
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPost.class);
                intent.putExtra("id", postModel.get(position).getId());
                intent.putExtra("idUser", postModel.get(position).getUserId());
                intent.putExtra("body", postModel.get(position).getBody());
                context.startActivity(intent);
            }
        });

        holder.favorito.setImageResource(R.drawable.unfilled_star);
        holder.favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.favorito.setImageResource(R.drawable.fill_star);
            }
        });

    }

    @Override
    public int getItemCount() {
        return postModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView post_title;
        LinearLayout linearLayout;
        private ImageView favorito;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            post_title = itemView.findViewById(R.id.post_title);
            linearLayout = itemView.findViewById(R.id.linearContainer);
            favorito = itemView.findViewById(R.id.favorito);

        }
    }

}
