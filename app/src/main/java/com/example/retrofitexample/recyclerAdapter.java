package com.example.retrofitexample;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.holder> {
    Context context;
    List<Post> posts;

    public recyclerAdapter(List<Post> posts, Context context) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public recyclerAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_view, null, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.holder holder, int position) {
        Post post = posts.get(position);
        /*URL url = null;
        try {
            url = new URL(post.getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.imageViewPhotos.setImageBitmap(bitmap);*/

        Picasso.get().load(post.getUrl()).into(holder.imageViewPhotos);
        String text = post.getId() + "\n" + post.getAlbumId()+"\n" + post.getTitle() ;
        holder.textViewPhotos.setText(text);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class holder extends RecyclerView.ViewHolder {
        ImageView imageViewPhotos;
        TextView textViewPhotos;

        holder(@NonNull View itemView) {
            super(itemView);
            imageViewPhotos = itemView.findViewById(R.id.imagePhotos);
            textViewPhotos = itemView.findViewById(R.id.textPhotos);
        }
    }
}
