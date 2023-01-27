package com.example.ifeed.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.ifeed.Activity.Adaptor.CategoryAdaptor;
import com.example.ifeed.Activity.Adaptor.PopularAdaptor;
import com.example.ifeed.Activity.Domain.CategoryDomain;
import com.example.ifeed.Activity.Domain.FoodDomain;
import com.example.ifeed.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recycleViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("ourFoods","cat_1"));
        category.add(new CategoryDomain("bestFoods", "cat_2"));
        category.add(new CategoryDomain("breads","cat_3"));
        category.add(new CategoryDomain("burgers", "cat_4"));
        category.add(new CategoryDomain("chocolates","cat_5"));
        category.add(new CategoryDomain("desserts","cat_1"));
        category.add(new CategoryDomain("drinks", "cat_2"));
        category.add(new CategoryDomain("friedChicken","cat_3"));
        category.add(new CategoryDomain("iceCream", "cat_4"));
        category.add(new CategoryDomain("pizzas","cat_5"));
        category.add(new CategoryDomain("porks","cat_1"));
        category.add(new CategoryDomain("sandwiches", "cat_2"));
        category.add(new CategoryDomain("sausages","cat1"));
        category.add(new CategoryDomain("steaks","cat_1"));


        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recycleViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();

        foodList.add(new FoodDomain("comida 2", "burger", "hamburger, molho, pao, queijo, tomate", 1.50));
        foodList.add(new FoodDomain("comida 3", "pizza2", "olho vegetal, tomate, cebola, alface", 1.80));
        foodList.add(new FoodDomain("comida 4", "pizza1", "descricao:", 30.00));
        foodList.add(new FoodDomain("comida 5", "burger", "descricao:", 10.00));
        foodList.add(new FoodDomain("comida 6", "pizza2", "descricao:", 45.00));
        foodList.add(new FoodDomain("comida 7", "pizza1", "descricao:", 9.70));
        foodList.add(new FoodDomain("comida 8", "burger", "descricao:", 9.75));
        foodList.add(new FoodDomain("comida 9", "pizza2", "descricao:", 8.25));
        foodList.add(new FoodDomain("comida 10", "pizza1", "descricao:", 100.00));


        adapter2 = new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);

    }

}