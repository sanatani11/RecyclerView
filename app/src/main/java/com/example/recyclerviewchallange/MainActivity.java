package com.example.recyclerviewchallange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
    RecyclerView recyclerView;
    ArrayList<Person> people;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter myAdapter;
    Button btnCar, btnOwner;
    TextView tvFixed, tvName, tvNum,tvCar;
    ImageView ivLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListFrag listFrag = (ListFrag) getSupportFragmentManager().findFragmentById(R.id.fragment_list);
        if(listFrag != null)
        {
            recyclerView = findViewById(R.id.list);
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            people = new ArrayList<Person>();
            people.add(new Person("Dezire","Raushan","mercedes","952546"));
            people.add(new Person("Polo","Mishra","nissan","993424"));
            people.add(new Person("Alto","Rashi","mercedes","887758"));
            people.add(new Person("Ampere","Rupal","volkswagen","843128"));
            people.add(new Person("Tesla","Dutt","volkswagen","952520"));
            people.add(new Person("Maruti","Utkarsh","nissan","953457"));
            myAdapter = new PersonAdapter(this,people);
            recyclerView.setAdapter(myAdapter);
        }
        DetailFrag detailFrag = (DetailFrag) getSupportFragmentManager().findFragmentById(R.id.fragment_detail);
        if(detailFrag != null){
            tvFixed = findViewById(R.id.tvFixed);
            tvName = findViewById(R.id.tvName);
            tvNum = findViewById(R.id.tvNum);
            ivLogo = findViewById(R.id.ivLogo);
            tvCar = findViewById(R.id.tvCar);
            tvCar.setVisibility(View.GONE);
            ivLogo.setVisibility(View.GONE);

            onItemClicked(0);
        }
        ButtonFrag buttonFrag = (ButtonFrag) getSupportFragmentManager().findFragmentById(R.id.fragment_button);
        if(buttonFrag != null)
        {
            btnCar = findViewById(R.id.btnCar);
            btnOwner = findViewById(R.id.btnOwner);

            btnOwner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvFixed.setVisibility(View.VISIBLE);
                    tvName.setVisibility(View.VISIBLE);
                    tvNum.setVisibility(View.VISIBLE);
                    tvCar.setVisibility(View.GONE);
                    ivLogo.setVisibility(View.GONE);



                }
            });

            btnCar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvFixed.setVisibility(View.GONE);
                    tvName.setVisibility(View.GONE);
                    tvNum.setVisibility(View.GONE);
                    ivLogo.setVisibility(View.VISIBLE);
                    tvCar.setVisibility(View.VISIBLE);
                }
            });
        }

    }

    @Override
    public void onItemClicked(int index) {
        if ((tvFixed!= null && tvNum != null && tvName != null && ivLogo != null)){
            tvName.setText(people.get(index).getName());
            tvNum.setText(people.get(index).getTel());
            tvCar.setText(people.get(index).getModel());
            if(people.get(index).getLogo().equals("mercedes"))
            {
                ivLogo.setImageResource(R.drawable.mercedes);
            }
            else if (people.get(index).getLogo().equals("volkswagen"))
            {
                ivLogo.setImageResource(R.drawable.volkswagen);
            }
            else {
                ivLogo.setImageResource(R.drawable.nissan);
            }
        }
    }
}