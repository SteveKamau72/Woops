package com.microclinic.woops.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.microclinic.woops.R;
import com.microclinic.woops.utilities.NavigationDrawerCallbacks;
import com.microclinic.woops.utilities.NavigationDrawerFragment;

/**
 * Created by Steve Kamau on 23/06/2017.
 */

public class MainActivity extends AppCompatActivity implements NavigationDrawerCallbacks {
    Toolbar toolbar;
    TextView toolbar_text;
    boolean activity_started = true;
    FragmentTransaction fragmentTransaction;
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
        finish();
        setUpToolBar(getString(R.string.app_name));
        setViews();
    }

    private void setUpToolBar(String title) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_text = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar_text.setText(title);
    }

    private void setViews() {
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.fragment_drawer);
        // Set up the drawer.
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), toolbar);
        mNavigationDrawerFragment.closeDrawer();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                if (!activity_started) {
                    title = getString(R.string.app_name);
                    toolbar_text.setText(title);
                }
                activity_started = false;
                break;
            case 1:
                fragment = new AddPatientFragment();
                title = getString(R.string.new_patient);
                toolbar_text.setText(title);

                break;
            case 2:
                fragment = new AddFamilyFragment();
                title = getString(R.string.new_family);
                toolbar_text.setText(title);
                break;
            case 3:
                fragment = new VoiceFragment();
                title = getString(R.string.voice);
                toolbar_text.setText(title);
                break;
            case 4:
                fragment = new UpdateStockFragment();
                title = getString(R.string.update_stock);
                toolbar_text.setText(title);
                break;

        }
        createFragments(fragment, title);
    }

    private void createFragments(Fragment fragment, String title) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_body, fragment);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

}
