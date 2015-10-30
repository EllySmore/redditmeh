package ellysmore.redditmeh.ui.navigation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.commons.BaseActivity;
import ellysmore.redditmeh.ui.listing.ListingFragment;
import ellysmore.redditmeh.ui.models.SubredditType;

public class NavigationActivity extends BaseActivity implements
        NavigationDrawerFragment.NavigationSelectCallback {

    private NavigationDrawerFragment mNavigationDrawerFragment;

    private DrawerLayout mDrawerLayout;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(mDrawerLayout, mToolbar);
        //Initial fragment display frontpage
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(getContainerId(), ListingFragment.newInstance(SubredditType.FRONT_PAGE))
                    .commit();
        }
    }

    private int getContainerId() {
        return R.id.content_frame;
    }

    @Override
    public void onItemClick(SubredditType subredditType) {
        Fragment fragment = null;
        fragment = ListingFragment.newInstance(subredditType);
        mDrawerLayout.closeDrawers();
        if (fragment != null) {
            getSupportActionBar().setTitle(subredditType.toString());
            replaceFragment(fragment, null, getContainerId());
        }
    }
}
