package com.mazhan.theone.dagger2test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mazhan.theone.R;
import com.mazhan.theone.recyclerview.RecyclerViewActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/4/13.
 */

public class RecyclerViewAdatper extends RecyclerView.Adapter<RecyclerViewAdatper.NormalViewHolder> {
    private LayoutInflater layoutInflater;
    private Context Rcontext;
    private String[] mTitles;

    @Inject
    public RecyclerViewAdatper(Context context, String[] list) {
        this.Rcontext = context;
        layoutInflater = LayoutInflater.from(context);
        mTitles=list;
//        context.getResources().getStringArray(R.array.titles);
    }

    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalViewHolder(layoutInflater.inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalViewHolder holder, int position) {
        holder.text_view.setText(mTitles[position]);
    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }


    public static class NormalViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.text_view)
        TextView text_view;

        public NormalViewHolder(View view) {
            super(view);
            TextView mTextView;
            ButterKnife.inject(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + "//" + getAdapterPosition());
                }
            });
        }
    }
}
