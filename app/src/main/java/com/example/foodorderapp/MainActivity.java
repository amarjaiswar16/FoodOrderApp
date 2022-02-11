package com.example.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        setTitle("Food menu");

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.bicecream,"Chicken Cheese Burger","500","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.burger,"Stuffed Bean Burger","400","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.burgerwithchicken,"Crunchy Chicken burger","800","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.bwithcocke,"Big King","300","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.capcicumpizza,"Detroit Pizza","400","Pepperoni, brick cheese and tomato sauce."));
        list.add(new MainModel(R.drawable.cheesepizza,"Cipolla","500","Tomato sauce, Mozzarella, Onions, Oregano."));
        list.add(new MainModel(R.drawable.cherrypizza,"Neapolitan Pizza","600","tomatoes, mozzarella from Campania."));
        list.add(new MainModel(R.drawable.chickenpizza,"Sicilian Pizza","400","Topped with bits of tomato, onion, anchovies, and herbs."));
        list.add(new MainModel(R.drawable.sandwich,"Supreme Veggie","200","Tomato sauce, Mozzarella, Hot Italian salami, Hot chili peppers."));
        list.add(new MainModel(R.drawable.slider,"Tikki Burger Meal","300","Mayo, fresh onions, and tomatoes"));
        list.add(new MainModel(R.drawable.tomatopizza,"Con cozze","500","Mussels, Garlic, Olive oil, Parsley"));
        list.add(new MainModel(R.drawable.tripleburger,"Chicken Twin Burgers","800","Chicken burger with extra cheese"));


        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        finish();
    }
}


