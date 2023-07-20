package com.example.shopsy.home.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.shopsy.R;
import com.example.shopsy.categorymodel.CategoryAdapter;
import com.example.shopsy.categorymodel.CategoryModel;
import com.example.shopsy.home.bannerslider.SliderAdapter;
import com.example.shopsy.home.bannerslider.SliderItem;
import com.example.shopsy.home.horizontallayout.HorizontalProductModel;
import com.example.shopsy.home.horizontallayout.HorizontalProductScrollAdapter;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    //implementing auto slide
    public Handler slideHandler=new Handler();
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    //strip ad layout
    ImageView strip_image;
    ConstraintLayout strip_container;
    //horizontal Product scroll
    private TextView HorizontalLayoutTitle;
    private Button viewAllButton;
    private RecyclerView horizontalScrollRecyclerView;

    ViewPager2 viewPager2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryModel> categoryModelArrayList = new ArrayList<CategoryModel>();
        categoryModelArrayList.add(new CategoryModel("link", "Home"));
        categoryModelArrayList.add(new CategoryModel("link", "Electronics"));
        categoryModelArrayList.add(new CategoryModel("link", "Furniture"));
        categoryModelArrayList.add(new CategoryModel("link", "Fashion"));
        categoryModelArrayList.add(new CategoryModel("link", "Toys"));
        categoryModelArrayList.add(new CategoryModel("link", "Sports"));
        categoryModelArrayList.add(new CategoryModel("link", "Wall Arts"));
        categoryModelArrayList.add(new CategoryModel("link", "Books"));
        categoryModelArrayList.add(new CategoryModel("link", "Shoes"));
        categoryAdapter = new CategoryAdapter(categoryModelArrayList);
        recyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
        //BannerSlide
        viewPager2 =view.findViewById(R.id.viewPager2);
        ArrayList<SliderItem> sliderItems=new ArrayList<SliderItem>();
        sliderItems.add(new SliderItem(R.drawable.pic1));
        sliderItems.add(new SliderItem(R.drawable.pic2));
        sliderItems.add(new SliderItem(R.drawable.pic3));
        sliderItems.add(new SliderItem(R.drawable.pic4));
        sliderItems.add(new SliderItem(R.drawable.banner));
        viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable,2000);
            }
        });
        //strip ad
        strip_image=view.findViewById(R.id.strip_ad_image);
        strip_container=view.findViewById(R.id.strip_ad_container);
        strip_image.setImageResource(R.drawable.stripad);
        strip_container.setBackgroundColor(Color.parseColor("#000000"));
        //horizontal scroll
        HorizontalLayoutTitle=view.findViewById(R.id.horizontal_scroll_layout_title);
        viewAllButton=view.findViewById(R.id.horizontal_scroll_layout_button);
        horizontalScrollRecyclerView=view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

        ArrayList<HorizontalProductModel> horizontalProductModelArrayList=new ArrayList<HorizontalProductModel>();
        horizontalProductModelArrayList.add(new HorizontalProductModel(R.drawable.pro1,"Iphone 14","Midnight Black","79,999/-"));
        horizontalProductModelArrayList.add(new HorizontalProductModel(R.drawable.pro1,"Iphone 14","Midnight Black","79,999/-"));
        horizontalProductModelArrayList.add(new HorizontalProductModel(R.drawable.pro1,"Iphone 14","Midnight Black","79,999/-"));
        horizontalProductModelArrayList.add(new HorizontalProductModel(R.drawable.pro1,"Iphone 14","Midnight Black","79,999/-"));
        horizontalProductModelArrayList.add(new HorizontalProductModel(R.drawable.pro1,"Iphone 14","Midnight Black","79,999/-"));
        horizontalProductModelArrayList.add(new HorizontalProductModel(R.drawable.pro1,"Iphone 14","Midnight Black","79,999/-"));
        horizontalProductModelArrayList.add(new HorizontalProductModel(R.drawable.pro1,"Iphone 14","Midnight Black","79,999/-"));
        horizontalProductModelArrayList.add(new HorizontalProductModel(R.drawable.pro1,"Iphone 14","Midnight Black","79,999/-"));
        horizontalProductModelArrayList.add(new HorizontalProductModel(R.drawable.pro1,"Iphone 14","Midnight Black","79,999/-"));
        horizontalProductModelArrayList.add(new HorizontalProductModel(R.drawable.pro1,"Iphone 14","Midnight Black","79,999/-"));
        HorizontalProductScrollAdapter horizontalProductScrollAdapter=new HorizontalProductScrollAdapter(horizontalProductModelArrayList);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(view.getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalScrollRecyclerView.setLayoutManager(linearLayoutManager1);
        horizontalScrollRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();
        return view;
    }
    private Runnable sliderRunnable =new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };

}
