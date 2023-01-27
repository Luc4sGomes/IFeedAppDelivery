package com.example.ifeed.Activity.API;

import com.example.ifeed.Activity.Models.HomeFoodModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeMenuFood {
        @GET("/our-foods")
        Call<List<HomeFoodModel>>ourFoodsForHome();

        @GET("/bbqs")
        Call<List<HomeFoodModel>>bbqsForHome();

        @GET("/best-foods")
        Call<List<HomeFoodModel>>bestFoodsForHome();

        @GET("/breads")
        Call<List<HomeFoodModel>> breadsForHome();

        @GET("/burgers")
        Call<List<HomeFoodModel>>burgersForHome();

        @GET("/chocolates")
        Call<List<HomeFoodModel>>chocolatesForHome();

        @GET("/desserts")
        Call<List<HomeFoodModel>>dessertsForHome();

        @GET("/drinks")
        Call<List<HomeFoodModel>>drinksForHome();

        @GET("/fried-chicken")
        Call<List<HomeFoodModel>>friedChickenForHome();

        @GET("/ice-cream")
        Call<List<HomeFoodModel>>iceCreamForHome();

        @GET("/pizzas")
        Call<List<HomeFoodModel>>pizzasForHome();

        @GET("/porks")
        Call<List<HomeFoodModel>>porksForHome();

        @GET("/sandwiches")
        Call<List<HomeFoodModel>>sandwichesForHome();

        @GET("/sausages")
        Call<List<HomeFoodModel>>sausagesForHome();

        @GET("/steaks")
        Call<List<HomeFoodModel>>steaksForHome();

}
