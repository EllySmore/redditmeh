package ellysmore.redditmeh.ui.navigation;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnItemClick;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.commons.BaseFragment;
import ellysmore.redditmeh.ui.navigation.adapters.NavigationListAdapter;
import ellysmore.redditmeh.ui.navigation.models.NavItems;

public class NavigationDrawerFragment extends Fragment {

    private static final String TAG = NavigationDrawerFragment.class.getSimpleName();

    private ActionBarDrawerToggle mDrawerToggle;

    private ListView mDrawerListView;

    private NavigationListAdapter mNavigationListAdapter;

    private NavigationSelectCallback mCallbacks;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbacks = (NavigationSelectCallback) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mDrawerListView = (ListView) inflater.inflate(
                R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.inject(this, mDrawerListView);
        mNavigationListAdapter = new NavigationListAdapter(setUpNavigationDrawer(), true);
        mDrawerListView.setAdapter(mNavigationListAdapter);

        return mDrawerListView;
    }

    @OnItemClick(R.id.navigation_list)
    protected void onNavigationItemClicked(AdapterView<?> parent, View view, int position,
            long id) {
        Log.v(TAG, "I am clicked");
        mCallbacks.onItemClick(mNavigationListAdapter.getItem(position));

    }

    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar) {

        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };

        drawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private ArrayList<NavItems> setUpNavigationDrawer() {
        ArrayList<NavItems> navItems = new ArrayList<NavItems>();
        navItems.add(NavItems.FRONT_PAGE);
        navItems.add(NavItems.AWW);
        navItems.add(NavItems.FUNNY);
        navItems.add(NavItems.PICS);
        navItems.add(NavItems.PROGRAMMING);
        navItems.add(NavItems.SHOWER_THOUGHTS);
        return navItems;
    }

    public static interface NavigationSelectCallback {
        void onItemClick(NavItems navItems);
    }
}
