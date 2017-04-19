package com.mazhan.theone.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mazhan.theone.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/4/13.
 */

public class RecyclerViewActivity extends AppCompatActivity implements RecyclerCallBack {
    @InjectView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.inject(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new NormalRecyclerViewAdapter(this, this));
    }

    @Override
    public void CallBack(int position) {
        Log.i("recycler======:", "position:" + position);
    }

    public static class NormalRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        enum ITEM_TYPE {
            ITEM_TYPE_IMAGE,
            ITEM_TYPE_TEXT
        }

        private final LayoutInflater mLayoutInflater;
        private final Context mContext;
        private String[] mTitles;
        private String[] seconds;
        private RecyclerCallBack recyclerCallBack;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()) {
                return new ImageViewHolder(mLayoutInflater.inflate(R.layout.item_image, parent, false), recyclerCallBack);
            } else {
                return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false), recyclerCallBack);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof NormalTextViewHolder) {
                ((NormalTextViewHolder) holder).mTextView.setText(mTitles[position]);
            } else if (holder instanceof ImageViewHolder) {
                ((ImageViewHolder) holder).mTextView.setText(mTitles[position]);
            }
        }

        @Override
        public int getItemCount() {
            return mTitles == null ? 0 : mTitles.length;
        }


        public NormalRecyclerViewAdapter(Context context, RecyclerCallBack callBack) {
            mTitles = context.getResources().getStringArray(R.array.titles);
            seconds = context.getResources().getStringArray(R.array.items);
            mContext = context;
            mLayoutInflater = LayoutInflater.from(context);
            this.recyclerCallBack = callBack;
        }

        @Override
        public int getItemViewType(int position) {
            return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
        }
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.text_view)
        TextView mTextView;
        RecyclerCallBack recyclerCallBack;

        NormalTextViewHolder(View view, final RecyclerCallBack recyclerCallBack1) {
            super(view);
            ButterKnife.inject(this, view);
            this.recyclerCallBack = recyclerCallBack1;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerCallBack != null) {
                        recyclerCallBack.CallBack(getAdapterPosition());
                    }
                    Log.d("NormalTextViewHolder", "onClick--> position = " + "//" + getAdapterPosition());
                }
            });
        }
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.text_view)
        TextView mTextView;
        @InjectView(R.id.image_view)
        ImageView mImageView;
        RecyclerCallBack recyclerCallBack;

        ImageViewHolder(View view, final RecyclerCallBack recyclerCallBack) {
            super(view);
            ButterKnife.inject(this, view);
            this.recyclerCallBack = recyclerCallBack;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerCallBack != null) {
                        recyclerCallBack.CallBack(getAdapterPosition());
                    }

                    Log.d("ImageViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }
}

