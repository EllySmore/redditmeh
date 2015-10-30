package ellysmore.redditmeh.ui.navigation;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.navigation.adapters.NavigationListAdapter;
import ellysmore.redditmeh.ui.models.SubredditType;

public class NavigationDrawerFragment extends Fragment {

    private static final String TAG = NavigationDrawerFragment.class.getSimpleName();

    private static final String PARAM_SELECT_POSITION = "PARAM_SELECT_POSITION";

    @Bind(R.id.navigation_list)
    protected ListView mNavigationList;

    private ActionBarDrawerToggle mDrawerToggle;

    private View mRootView;

    private NavigationListAdapter mNavigationListAdapter;

    private NavigationSelectCallback mCallbacks;

    private int mCurrentSelectedPosition = 0;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallbacks = (NavigationSelectCallback) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(PARAM_SELECT_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mRootView = inflater.inflate(
                R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.bind(this, mRootView);
        mNavigationListAdapter = new NavigationListAdapter(setUpNavigationDrawer(), true);
        mNavigationList.setAdapter(mNavigationListAdapter);
        mNavigationList.setItemChecked(mCurrentSelectedPosition, true);
        return mRootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PARAM_SELECT_POSITION, mCurrentSelectedPosition);
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

    @OnItemClick(R.id.navigation_list)
    protected void onNavigationItemClicked(AdapterView<?> parent, View view, int pos, long id) {
        selectItem(pos);
    }

    private ArrayList<SubredditType> setUpNavigationDrawer() {
        ArrayList<SubredditType> navItems = new ArrayList<SubredditType>();
        navItems.add(SubredditType.FRONT_PAGE);
        navItems.add(SubredditType.AWW);
        navItems.add(SubredditType.FUNNY);
        navItems.add(SubredditType.PICS);
        navItems.add(SubredditType.PROGRAMMING);
        navItems.add(SubredditType.SHOWER_THOUGHTS);
        return navItems;
    }

    private void selectItem(int position) {
        mCurrentSelectedPosition = position;
        mNavigationList.setItemChecked(position, true);
        mCallbacks.onItemClick(mNavigationListAdapter.getItem(position));
        mNavigationListAdapter.notifyDataSetInvalidated();
    }

    public interface NavigationSelectCallback {

        void onItemClick(SubredditType subredditType);
    }
}
