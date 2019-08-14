package com.example.root.gallery;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AdapterImage extends PagerAdapter{

    private Context context;
    private int[] img;

    public AdapterImage(Context context, int[] img) {
        this.context = context;
        this.img = img;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(lp);
        container.addView(ll);

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(img[position]);
        ll.addView(imageView);

        Log.i("script", "Imagem "+position+" construida");
        return ll;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        Log.i("script", "Imagem "+position+" destruida");
    }
}
