package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Order Item");

        final DBHelper helper = new DBHelper(this);

        if(getIntent().getIntExtra("type",0) == 1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailImage.setImageResource(image);
            binding.foodPrice.setText(String.format("%d", price));
            binding.foodName.setText(name);
            binding.detailDescription.setText(description);


            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.insterOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            binding.foodName.getText().toString(),
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );
                    if (isInserted) {
                        //Toast.makeText(DetailActivity.this, "Data Success.", Toast.LENGTH_SHORT).show();
                        Toast toast = new Toast(DetailActivity.this);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.setDuration(Toast.LENGTH_LONG);
                        LayoutInflater inflater = getLayoutInflater();
                        View appear = inflater.inflate(R.layout.orderlayout,findViewById(R.id.root));
                        toast.setView(appear);
                        toast.show();

                    }

                    else
                        Toast.makeText(DetailActivity.this, "Error.", Toast.LENGTH_SHORT).show();
                }
            });
        }else
        {
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
           // Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();
            int image = cursor.getInt(4);

            binding.detailImage.setImageResource(image);
            binding.foodPrice.setText(String.format("%d", cursor.getInt(3)));
            binding.foodName.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(5));

            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertButton.setText("Update Now");
            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean isUpdated = helper.updateOrder(
                                binding.nameBox.getText().toString(),
                                binding.phoneBox.getText().toString(),
                                Integer.parseInt(binding.foodPrice.getText().toString()),
                                image,
                                binding.detailDescription.getText().toString(),
                                binding.foodName.getText().toString(),
                                1,
                                 id
                            );
                    if(isUpdated) {
                        //Toast.makeText(DetailActivity.this, "Updated.", Toast.LENGTH_SHORT).show();
                        Toast toast = new Toast(DetailActivity.this);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.setDuration(Toast.LENGTH_LONG);
                        LayoutInflater inflater = getLayoutInflater();
                        View appear = inflater.inflate(R.layout.deletelayout,findViewById(R.id.deleteroot));
                        toast.setView(appear);
                        toast.show();

                    }
                    else
                        Toast.makeText(DetailActivity.this, "Failed.", Toast.LENGTH_SHORT).show();

                }
            });
        }

    }
}