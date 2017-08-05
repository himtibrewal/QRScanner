package esecforte.com.qrscanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ubuntu on 4/8/17.
 */

public class ScanResultActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvStorename;
    private TextView tvFixtureName;
    private TextView tvNotification;
    private Button btnSubmit;
    private Button btnRescan;
    private String storename, fixturename;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);
        tvStorename = (TextView) findViewById(R.id.tv_storename);
        tvFixtureName = (TextView) findViewById(R.id.tv_fixturename);
        tvNotification = (TextView) findViewById(R.id.tv_notification);
        btnRescan = (Button) findViewById(R.id.btn_rescan);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        if (getIntent().getExtras() != null) {
            storename = getIntent().getExtras().getString("store_name");
            fixturename = getIntent().getExtras().getString("fixture_name");
            tvStorename.setText(getIntent().getExtras().getString("store_name"));
            tvFixtureName.setText(getIntent().getExtras().getString("fixture_name"));
            tvNotification.setText("Code Scan Successfully");
        }
        btnRescan.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_rescan:
                onBackPressed();
                break;
            case R.id.btn_submit:
                QRCode.fixturelist.add(fixturename);
                Intent intent = new Intent(this, FullDetailActivity.class);
                intent.putExtra("store_name", storename);
                startActivity(intent);
                finish();
                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
