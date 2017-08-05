package esecforte.com.qrscanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ubuntu on 4/8/17.
 */

public class StartScanActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvStorename;
    private TextView tvFixturename;
    private Button btnScan;
    private Button btnSave;
    private String storename;
    private String fixture_name;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_scan);
        tvStorename = (TextView) findViewById(R.id.tv_storename);
        tvFixturename = (TextView) findViewById(R.id.tv_fixturename);
        btnScan = (Button) findViewById(R.id.btn_scan);
        btnSave = (Button) findViewById(R.id.btn_save);
        if (getIntent().getExtras() != null) {
            storename = getIntent().getExtras().getString("store_name");
            fixture_name = getIntent().getExtras().getString("fixture_name");
            tvStorename.setText(getIntent().getExtras().getString("store_name"));
            tvFixturename.setText(getIntent().getExtras().getString("fixture_name"));
        }
        btnScan.setOnClickListener(this);
        btnSave.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_scan:
                Intent intent = new Intent(StartScanActivity.this, FullScannerActivity.class);
                intent.putExtra("store_name", storename);
                intent.putExtra("fixture_name", fixture_name);
                startActivity(intent);
                break;
            case R.id.btn_save:
                QRCode.fixturelist.add(fixture_name);
                Toast.makeText(this, "Data saved Successfully without Scan", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
