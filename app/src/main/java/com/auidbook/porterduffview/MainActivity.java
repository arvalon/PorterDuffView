package com.auidbook.porterduffview;

import android.graphics.PorterDuff;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayAdapter<PorterDuff.Mode> mAdapter;
    private PorterDuffView mPorterDuffView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get reference to the PorterDuffView
        mPorterDuffView = findViewById(R.id.porter_duff_view);

        // Create array of PorterDuff.Modes
        final PorterDuff.Mode[] porterDuffModes = PorterDuff.Mode.values();

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, porterDuffModes);

        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = findViewById(R.id.spinner);

        spinner.setAdapter(mAdapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mPorterDuffView.setPorterDuffMode(mAdapter.getItem(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Ignored
    }
}