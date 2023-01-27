package com.example.ifeed.Activity.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ifeed.Activity.API.HomeMenuFood;
import com.example.ifeed.Activity.Domain.CategoryDomain;
import com.example.ifeed.Activity.Domain.FoodDomain;
import com.example.ifeed.Activity.Models.HomeFoodModel;
import com.example.ifeed.Activity.Models.UpdateFoodRec;
import com.example.ifeed.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {

    ArrayList<CategoryDomain> categoryDomains;
    int row_index = -1;
    UpdateFoodRec updateFoodsRec;
    boolean check = true;

    public CategoryAdaptor(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //apagado no primeiro parametro @NonNull
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://free-food-menus-api.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        HomeMenuFood comidas = retrofit.create(HomeMenuFood.class);

            String picUrl = "";
        switch (position) {
            case 0: {
                picUrl = "cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background1));

                break;
            }
            case 1: {
                picUrl = "cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background2));

                break;
            }
            case 2: {
                picUrl = "cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background3));

                break;
            }
            case 3: {
                picUrl = "cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background4));

                break;
            }
            case 4: {
                picUrl = "cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background5));

                break;
            }
            case 5: {
                picUrl = "cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background2));

                break;
            }
            case 6: {
                picUrl = "cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background3));

                break;
            }
            case 7: {
                picUrl = "cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background4));

                break;
            }
            case 8: {
                picUrl = "cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background5));

                break;
            }
            case 9: {
                picUrl = "cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background1));

                break;
            }
            case 10: {
                picUrl = "cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background2));

                break;
            }
            case 11: {
                picUrl = "cat_0";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background3));

                break;
            }
            case 12: {
                picUrl = "cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background2));

                break;
            }
            case 13: {
                picUrl = "cat_0";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background5));

                break;
            }
        }

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();

                if (row_index == position) {
                    Call<List<HomeFoodModel>> call = comidas.ourFoodsForHome();
                    functionCall(call, position);


                } else if (position == 1) {
                    Call<List<HomeFoodModel>> call = comidas.bestFoodsForHome();


                } else if (position == 2) {
                    Call<List<HomeFoodModel>> call = comidas.breadsForHome();


                } else if (position == 3) {
                    Call<List<HomeFoodModel>> call = comidas.burgersForHome();


                } else if (position == 4) {
                    Call<List<HomeFoodModel>> call = comidas.chocolatesForHome();


                } else if (position == 5) {
                    Call<List<HomeFoodModel>> call = comidas.dessertsForHome();


                } else if (position == 6) {
                    Call<List<HomeFoodModel>> call = comidas.drinksForHome();


                } else if (position == 7) {
                    Call<List<HomeFoodModel>> call = comidas.friedChickenForHome();


                } else if (position == 8) {
                    Call<List<HomeFoodModel>> call = comidas.iceCreamForHome();


                } else if (position == 9) {
                    Call<List<HomeFoodModel>> call = comidas.pizzasForHome();


                } else if (position == 10) {
                    Call<List<HomeFoodModel>> call = comidas.porksForHome();


                } else if (position == 11) {
                    Call<List<HomeFoodModel>> call = comidas.sandwichesForHome();


                } else if (position == 12) {
                    Call<List<HomeFoodModel>> call = comidas.sausagesForHome();


                } else if (position == 13) {
                    Call<List<HomeFoodModel>> call = comidas.steaksForHome();

                }

            }
        });


        //
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable", holder.itemView.getContext().getOpPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryPic);

    }


    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

    private void functionCall(Call<List<HomeFoodModel>> call, int position) {
        call.enqueue(new Callback<List<HomeFoodModel>>() {
            @Override
            public void onResponse(Call<List<HomeFoodModel>> call, Response<List<HomeFoodModel>> response) {
                if(response.isSuccessful()) {
                    ArrayList<HomeFoodModel> comidasList = (ArrayList<HomeFoodModel>)response.body();
                    updateFoodsRec.callBack(position, comidasList);


                }
            }

            @Override
            public void onFailure(Call<List<HomeFoodModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}

