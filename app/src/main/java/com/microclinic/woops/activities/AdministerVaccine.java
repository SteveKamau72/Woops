package com.microclinic.woops.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.microclinic.woops.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdministerVaccine extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administer_vaccine);
        ButterKnife.bind(this);
        setViews();
    }

    private void setViews() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle(getString(R.string.patient_search));
    }

    @OnClick(R.id.row1)
    void firstRow() {
        startActivity(new Intent(getApplicationContext(), PatientDetails.class));
    }

    @OnClick(R.id.row2)
    void secondRow() {
        startActivity(new Intent(getApplicationContext(), PatientDetails.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

