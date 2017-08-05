package esecforte.com.qrscanner;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import esecforte.com.qrscanner.adapter.RecyclerAdapter;
import esecforte.com.qrscanner.model.NewFixtureModel;

/**
 * Created by esec-shiva on 4/8/17.
 */

public class AddNewFixture extends AppCompatActivity {
    TextView tv_add_new_fixture, tv_submit;
    TextView storename;
    Dialog alertDialog;
    private RecyclerAdapter mAdapter;
    private ArrayList<NewFixtureModel> newFixturelist = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_fixture);
        findId();
        if (getIntent().getExtras() != null) {
            storename.setText(getIntent().getExtras().getString("store_name"));
        }


    }

    private void findId() {
        tv_add_new_fixture = (TextView) findViewById(R.id.tv_add_new_fixture);
        storename = (TextView) findViewById(R.id.tv_selectStore);
        tv_submit = (TextView) findViewById(R.id.tv_submit);
        tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddNewFixture.this, StartScanActivity.class);
                intent.putExtra("store_name", storename.getText().toString());
                intent.putExtra("fixture_name", tv_add_new_fixture.getText().toString());
                startActivity(intent);
            }
        });
    }

    public void clickAddNewFixture(View v) {
        alertDialog();
    }


    private void alertDialog() {
        alertDialog = new Dialog(this);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(R.layout.alert_dialog_add_new_fixture);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = alertDialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        alertDialog.setCancelable(false);
        RecyclerView recyclerView = (RecyclerView) alertDialog.findViewById(R.id.recycler_home_list);
        mAdapter = new RecyclerAdapter(newFixturelist, AddNewFixture.this, R.layout.single_add_new_fixture, new RecyclerAdapter.ReturnView() {
            @Override
            public void getAdapterView(View view, List objects, final int position, int from) {
                TextView textView = (TextView) view.findViewById(R.id.tv_title);
                textView.setText(newFixturelist.get(position).getTitle());
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tv_add_new_fixture.setText(newFixturelist.get(position).getTitle());
                        alertDialog.dismiss();
                    }
                });

            }
        }, 0);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareData();

        alertDialog.show();

    }

    private void prepareData() {
        newFixturelist.clear();
        NewFixtureModel newFixtureModel = new NewFixtureModel("Fixture 1");
        newFixturelist.add(newFixtureModel);

        newFixtureModel = new NewFixtureModel("Fixture 1");
        newFixturelist.add(newFixtureModel);

        newFixtureModel = new NewFixtureModel("Fixture 2");
        newFixturelist.add(newFixtureModel);

        newFixtureModel = new NewFixtureModel("Fixture 3");
        newFixturelist.add(newFixtureModel);

    }

}
