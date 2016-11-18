package com.bwf.lgqingdan.gui.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.lgqingdan.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LG on 2016/10/23.
 * Tips:
 */

public abstract class BaseMainRecycleViewAdapter<T> extends BaseRecycleViewAdapter<T> {


    public BaseMainRecycleViewAdapter(Context context) {
        super(context);
    }

    public static final int STATE_GONE = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_NO_MORE_DATA = 2;
    public static final int STATE_LOAD_FAILED = 3;
    private int state;

    public void updateFooterState(int state) {
        this.state = state;
        notifyItemChanged(getItemCount() - 1);
        Log.d("BaseMainRecycleViewAdap", "Adapter更新第" + (getItemCount() - 1) + "个View");
    }

    class FooterHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progressbar_subview_recycleview_loadfooter)
        ProgressBar progressbarSubviewRecycleviewLoadfooter;
        @BindView(R.id.textview_subview_recycleview_loadfooter)
        TextView textviewSubviewRecycleviewLoadfooter;
        @BindView(R.id.layout_subview_recycleview_loadfooter)
        RelativeLayout layoutSubviewRecycleviewLoadfooter;
        FooterHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            textviewSubviewRecycleviewLoadfooter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onRetryClick();
                    }
                }
            });
        }
    }

    protected void bindFooterViewHolder(RecyclerView.ViewHolder holder, int position) {
        FooterHolder mHolder = (FooterHolder) holder;
        Log.d("BaseMainRecycleViewAdap", "state:" + state);
        switch (state) {
            case STATE_GONE:
                return;
            case STATE_LOADING:
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                break;
            case STATE_NO_MORE_DATA:
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setText(getContext().getString(R.string.noMoreData));
                mHolder.textviewSubviewRecycleviewLoadfooter.setEnabled(false);
                break;
            case STATE_LOAD_FAILED:
                mHolder.progressbarSubviewRecycleviewLoadfooter.setVisibility(View.GONE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
                mHolder.textviewSubviewRecycleviewLoadfooter.setText(getContext().getString(R.string.loadDataFailedAndClickRetry));
                mHolder.textviewSubviewRecycleviewLoadfooter.setEnabled(true);
                break;
        }
        mHolder.layoutSubviewRecycleviewLoadfooter.setVisibility(View.VISIBLE);
    }

    protected RecyclerView.ViewHolder createFooterHolder(ViewGroup parent) {
        return new FooterHolder(inflaterView(R.layout.subview_recycleview_loadfooter, parent));
    }

    public interface OnRetryClickListener {
        void onRetryClick();
    }

    private OnRetryClickListener listener;

    public void setOnRetryClickListener(OnRetryClickListener listener) {
        this.listener = listener;
    }

    public class MyViewHolder extends BaseViewHolder {
        @BindView(R.id.root_main_list_item)
        public View rootLayout;
        @BindView(R.id.imageView_front_top_image)
        public SimpleDraweeView imageViewFrontTopImage;
        @BindView(R.id.view_temp)
        public View viewTemp;
        @BindView(R.id.textView_front_main_title)
        public TextView textViewFrontMainTitle;
        @BindView(R.id.textView_front_subtitle)
        public TextView textViewFrontSubtitle;
        @BindView(R.id.imageView_front_like)
        public ImageView imageViewFrontLike;
        @BindView(R.id.textView_front_num_liked)
        public TextView textViewFrontNumLiked;
        @BindView(R.id.textView_num_reviews)
        public TextView textViewNumReviews;
        @BindView(R.id.linear_bottom_count)
        public LinearLayout linearBottomCount;
        @BindView(R.id.linear_temp)
        public LinearLayout linearTemp;
        @BindView(R.id.rotate_textView_date)
        public TextView rotateTextViewDate;
        @BindView(R.id.rela_temp)
        public RelativeLayout relaTemp;
        @BindView(R.id.rela_special_tag)
        public TextView relaSpecialTag;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public String parseDate(String dateTime){
        try {
            String date = localSimpleDateFormat.parse(dateTime).toString().substring(4, 11);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }


}
