package com.example.budivelnymagasin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.budivelnymagasin.Activity.BudivelniSumishActivity;
import com.example.budivelnymagasin.Activity.ElectroinstrumentActivity;
import com.example.budivelnymagasin.Activity.InstrumentyActivity;
import com.example.budivelnymagasin.Activity.SadGorodActivity;
import com.example.budivelnymagasin.Activity.SantehnikaActivity;
import com.example.budivelnymagasin.Activity.VseDlyaRemontuActivity;
import com.example.budivelnymagasin.Utils.Adapter;

public class MainActivity extends AppCompatActivity {

    private Adapter mAdapter;
    private RecyclerView mNumbersList;
    private CardView vseDlyaREmontu;
    private CardView electroinstrument;
    private CardView santehnica;
    private CardView instrumenty;
    private CardView budSumishi;
    private CardView sadGorod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vseDlyaREmontu= findViewById(R.id.first_page_card_view_1);
        electroinstrument= findViewById(R.id.first_page_card_view_2);
        santehnica= findViewById(R.id.first_page_card_view_3);
        instrumenty= findViewById(R.id.first_page_card_view_4);
        budSumishi= findViewById(R.id.first_page_card_view_5);
        sadGorod= findViewById(R.id.first_page_card_view_6);

        vseDlyaREmontu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), VseDlyaRemontuActivity.class);
                startActivity(intent);
            }
        });

        electroinstrument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), ElectroinstrumentActivity.class);
                startActivity(intent);
            }
        });

        santehnica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), SantehnikaActivity.class);
                startActivity(intent);
            }
        });

        instrumenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), InstrumentyActivity.class);
                startActivity(intent);
            }
        });

        budSumishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), BudivelniSumishActivity.class);
                startActivity(intent);
            }
        });

        sadGorod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), SadGorodActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int idItemThetWasSelected=item.getItemId();

        return super.onOptionsItemSelected(item);
    }


}
