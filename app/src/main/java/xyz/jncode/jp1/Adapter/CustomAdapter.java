package xyz.jncode.jp1.Adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.ArrayList;

import xyz.jncode.jp1.Model.Articles;
import xyz.jncode.jp1.Presenter.Mypresenter;
import xyz.jncode.jp1.R;
import xyz.jncode.jp1.Retrofit.GlobalContract;
import xyz.jncode.jp1.Util.Function;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Articles> dataList;
    private Context context;

    Mypresenter mypresenter;

//    public CustomAdapter(Context context, List<ModelPhoto> dataList) {
//        this.context = context;
//        this.dataList = dataList;
//    }

    public CustomAdapter(Context context, ArrayList<Articles> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mypresenter = new Mypresenter((GlobalContract.IMainView) context);
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //View view = layoutInflater.inflate(R.layout.item_photos, parent, false);
        View view = layoutInflater.inflate(R.layout.item_news, parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.txtTitle.setText(dataList.get(position).title);
        try {
            holder.txtTime.setText(Function.getDateString(dataList.get(position).publishedAt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.coverImage.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.get().load(dataList.get(position).mediaUrlImage).into(holder.coverImage);
        holder.txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    //mypresenter.animateLoading();
                mypresenter.toastTitle(context,dataList.get(position).getTitle().trim());


            }
        });




    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView txtTitle;
        AppCompatTextView txtTime;
        AppCompatImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);


            txtTitle = itemView.findViewById(R.id.titleID);
            txtTime = itemView.findViewById(R.id.timeID);
            coverImage = itemView.findViewById(R.id.imageID);
        }
    }
}