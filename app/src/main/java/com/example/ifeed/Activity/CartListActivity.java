package com.example.ifeed.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ifeed.Activity.Adaptor.CartListAdapter;
import com.example.ifeed.Activity.Helper.ManagementCart;
import com.example.ifeed.Activity.Interface.ChangeNumberItemsListener;
import com.example.ifeed.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.example.ifeed.Activity.Domain.FoodDomain;

public class CartListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt;
    private double tax;
    private ScrollView scrollViewCart;

    TextView finishedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managementCart = new ManagementCart(this);

        initView();
        initList();
        CalculateCart();
        bottomNavigation();
        showMessageBtn();



    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this, CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartListActivity.this, MainActivity.class));
            }
        });

    }

    private void initView() {
        //recyclerViewList = findViewById(R.id.recyclerView);
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        //emptyTxt = findViewById(R.id.emptyTxt);
        scrollViewCart = findViewById(R.id.scrollViewCart);
        recyclerViewList = findViewById(R.id.cartView);


    }

    private void initList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if(managementCart.getListCart().isEmpty()) { //here :)
            scrollViewCart.setVisibility(View.GONE);
        }
        else {
            scrollViewCart.setVisibility(View.VISIBLE);
        }

    }

    private void CalculateCart() {
        double percentTax = 0.02;
        double delivery = 10;

        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100)/ 100;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100)/100;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100)/ 100;


        totalFeeTxt.setText("$"+itemTotal);
        taxTxt.setText("$"+tax);
        deliveryTxt.setText("$"+delivery);
        totalTxt.setText("$"+total);
    }


    private void showMessageBtn() {
        finishedBtn = findViewById(R.id.textView16);
        finishedBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                sendRequest();
            }
        });
    }

    private void sendRequest() {
        /**FoodDAO comidaDAO = new FoodDAO(this);
        FoodDomain comida = new FoodDomain("comida 1", "slices pepperoni, mussarela, queijo, fresh, oregano", 1.00);
        long id = comidaDAO.inserir(comida);
        Toast.makeText(this, "Comida Salva, id: "+id, Toast.LENGTH_LONG).show();**/
        Context context = getApplicationContext();
        CharSequence text = "FALA GALERINHA!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }

}