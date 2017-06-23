package com.microclinic.woops.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.microclinic.woops.R;
import com.microclinic.woops.activities.AddPatient;
import com.microclinic.woops.activities.AdministerVaccine;
import com.microclinic.woops.models.MenuItemsObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by steve on 6/23/17.
 */
public class MenuGridRecyclerView extends RecyclerView.Adapter<MenuGridRecyclerView.ViewHolder> {

    private static final String TAG = MenuGridRecyclerView.class.getSimpleName();

    private Context mContext;
    private List<MenuItemsObject> mData;

    /**
     * Change {@link List} type according to your needs
     */
    public MenuGridRecyclerView(Context context, List<MenuItemsObject> data) {
        if (context == null) {
            throw new NullPointerException("context can not be NULL");
        }

        if (data == null) {
            throw new NullPointerException("data list can not be NULL");
        }

        this.mContext = context;
        this.mData = data;
    }


    /**
     * Change the null parameter to a layout resource {@code R.layout.example}
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_grid_view, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // include binding logic here
        MenuItemsObject menuItemsObject = mData.get(position);
        holder.tvTitle.setText(menuItemsObject.getTitle());
        holder.thumbnailImageView.setImageResource(menuItemsObject.getIcon());
        holder.placeholderImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = null;
                switch (position) {
                    case 0:
                        i = new Intent(mContext, AddPatient.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(i);
                        break;
                    case 1:
                        i = new Intent(mContext, AdministerVaccine.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(i);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }

//                Toast.makeText(mContext, "Test", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // include {@link View} components here
        @BindView(R.id.thumbnail)
        ImageView thumbnailImageView;
        @BindView(R.id.placeholder)
        ImageView placeholderImageView;
        @BindView(R.id.title)
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
} 