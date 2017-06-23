package com.microclinic.woops.activities;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.microclinic.woops.R;
import com.microclinic.woops.adapter.MenuGridRecyclerView;
import com.microclinic.woops.models.MenuItemsObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    Activity parentActivity;

    @BindView(R.id.menu_recyclerview)
    RecyclerView menuRecyclerView;
    private GridLayoutManager lLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * Change the null parameter in {@code inflater.inflate()}
     * to a layout resource {@code R.layout.example}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: hit");
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);
        setViews();
        return rootView;
    }

    private void setViews() {
        List<MenuItemsObject> rowListItem = new ArrayList<>();

        lLayout = new GridLayoutManager(parentActivity, 2);
        menuRecyclerView.setHasFixedSize(true);
        menuRecyclerView.setLayoutManager(lLayout);
        menuRecyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        menuRecyclerView.setItemAnimator(new DefaultItemAnimator());
        MenuGridRecyclerView rcAdapter = new MenuGridRecyclerView(parentActivity, prepareMenu(rowListItem));
        menuRecyclerView.setAdapter(rcAdapter);
    }

    private List<MenuItemsObject> prepareMenu(List<MenuItemsObject> rowListItem) {
        MenuItemsObject menuItems = new MenuItemsObject("Register Patient", R.drawable.ic_add_patient_colored);
        rowListItem.add(menuItems);
        menuItems = new MenuItemsObject("Administer Vaccines", R.drawable.ic_syringe);
        rowListItem.add(menuItems);
        menuItems = new MenuItemsObject("Inventory", R.drawable.ic_report);
        rowListItem.add(menuItems);
        menuItems = new MenuItemsObject("Adherence Report", R.drawable.ic_progress);
        rowListItem.add(menuItems);
        return rowListItem;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated: hit");
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onResume() {
        Log.d(TAG, "onResume: hit");
        super.onResume();
    }


    @Override
    public void onPause() {
        Log.d(TAG, "onPause: hit");
        super.onPause();
    }


    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView: hit");
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: hit");
        super.onDestroy();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        parentActivity = activity;
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
}
