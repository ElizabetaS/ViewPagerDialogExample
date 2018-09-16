package com.example.elizabeta.viewpagerdialog;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rd.PageIndicatorView;

import java.util.List;

public class MyPageAdapter extends PagerAdapter{
Context context;
List<PageModel> model;
LayoutInflater inflater;
    int selected = -1;


    public MyPageAdapter(Context context,List<PageModel> model)
{
    this.context = context;
    this.model = model;

    inflater = ((Activity)context).getLayoutInflater();
}

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view =  inflater.inflate(R.layout.view_pager_item,container,false);
        selected =SharedPeferencesManager.getInstance(container.getContext()).getData();
        TextView textView = (TextView)view.findViewById(R.id.text);
        view.setTag(position);
        ((ViewPager)container).addView(view);
        PageModel pageModel= model.get(position);

        textView.setText(pageModel.getTitle());
        if(selected==position)
        {
            ImageView img = (ImageView)view.findViewById(R.id.slika);
            img.setVisibility(View.VISIBLE);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPeferencesManager.getInstance(container.getContext()).saveData(position);
                ImageView img = (ImageView)v.findViewById(R.id.slika);
                img.setVisibility(View.VISIBLE);
                notifyDataSetChanged();


            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(View)object;
    }
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}


