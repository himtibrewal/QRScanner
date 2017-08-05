package esecforte.com.qrscanner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ubuntu on 4/8/17.
 */

public class StoreActivity extends AppCompatActivity {

    Spinner spinner;
    TextView tv_ok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_activity);
        findId();
        checkpermission();
    }


    private void checkpermission() {
        ActivityCompat.requestPermissions(StoreActivity.this,
                new String[]{Manifest.permission.CAMERA},
                1);
    }

    private void findId() {
        spinner = (Spinner) findViewById(R.id.spinner);
        tv_ok = (TextView) findViewById(R.id.tv_ok);
        spinnerDropdown();
    }

    private void spinnerDropdown() {

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Store Name 1");
        categories.add("Store Name 2");
        categories.add("Store Name 3");
        categories.add("Store Name 4");
        categories.add("Store Name 5");
        categories.add("Store Name 6");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    public void clickOk(View v) {
        String selectedStore = spinner.getSelectedItem().toString();
        Log.e("strore_name", "is" + selectedStore);
        Intent i = new Intent(StoreActivity.this, AddNewFixture.class);
        i.putExtra("store_name", selectedStore);
        startActivity(i);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(StoreActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
