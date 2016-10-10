package com.mmf.framework.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mmf.framework.R;
import com.mmf.framework.base.adapter.BaseRecyclerAdapter;
import com.mmf.framework.model.LawyerInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by MMF
 * date 2016/9/26
 * Description:
 */
public class LawyerAdapter extends BaseRecyclerAdapter<LawyerInfo> {
    Picasso picasso;
    public LawyerAdapter(Context context) {
        super(context);
        picasso = Picasso.with(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lawyer_item, parent, false);
        ViewHolder mHolder = new ViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        final LawyerInfo item = itemList.get(position);
        picasso.setLoggingEnabled(true);
        picasso.load(item.getImg())
                .noFade()
                .into(viewHolder.img);
        viewHolder.corp.setText("公司：" + item.getCorp());
        viewHolder.spec.setText("职业能力："+item.getSpec());
        viewHolder.name.setText(item.getName().substring(0, item.getName().length() - 2));

    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView corp, name, spec;
        ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.ivHead);
            corp = (TextView) view.findViewById(R.id.tvCorp);
            spec = (TextView) view.findViewById(R.id.tvSpec);
            name = (TextView) view.findViewById(R.id.tvName);
//            ButterKnife.bind(this, view);
        }
    }

}
