package esecforte.com.qrscanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import esecforte.com.qrscanner.adapter.RecyclerAdapter;

/**
 * Created by ubuntu on 4/8/17.
 */

public class FullDetailActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerAdapter mAdapter;
    TextView tvStorename;
    Button btntoreNewFixture, btnSubmit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_list);
        rv = (RecyclerView) findViewById(R.id.rv_fixturelist);
        tvStorename = (TextView) findViewById(R.id.tv_store_name);
        if (getIntent().getExtras() != null) {
            tvStorename.setText(getIntent().getExtras().getString("store_name"));
        }
        btntoreNewFixture = (Button) findViewById(R.id.add_new_fixture);
        btnSubmit = (Button) findViewById(R.id.Submit);
        mAdapter = new RecyclerAdapter(QRCode.fixturelist, this, R.layout.single_add_new_fixture, new RecyclerAdapter.ReturnView() {
            @Override
            public void getAdapterView(View view, List objects, final int position, int from) {
                TextView textView = (TextView) view.findViewById(R.id.tv_title);
                textView.setText(QRCode.fixturelist.get(position));
            }
        }, 0);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(mAdapter);
        btntoreNewFixture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullDetailActivity.this, AddNewFixture.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QRCode.fixturelist.clear();
                Toast.makeText(FullDetailActivity.this, "Data Updated Succesfully ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FullDetailActivity.this, StoreActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}