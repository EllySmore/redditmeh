package ellysmore.redditmeh.ui.navigation;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.commons.BaseActivity;
import ellysmore.redditmeh.ui.commons.BaseFragmentWithSwipeRefreshListener;
import ellysmore.redditmeh.ui.listing.subreddit.ListingFragment;
import ellysmore.redditmeh.ui.navigation.models.NavItems;

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
        getSupportActionBar().setTitle(NavItems.FRONT_PAGE.getTitleResId());
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(mDrawerLayout, mToolbar);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(getContainerId(),
                            ListingFragment.newInstance())
                    .commit();
        }
    }

    private int getContainerId() {
        return R.id.content_frame;
    }

    @Override
    public void onItemClick(NavItems navItems) {
        BaseFragmentWithSwipeRefreshListener fragment = null;
        switch (navItems) {
            case FRONT_PAGE:
                fragment = ListingFragment.newInstance();
                break;
            case AWW:
                fragment = ListingFragment
                        .newInstance(getString(R.string.aww));
                break;
            case FUNNY:
                fragment = ListingFragment
                        .newInstance(getString(R.string.funny));
                break;
            case PICS:
                fragment = ListingFragment
                        .newInstance(getString(R.string.pics));
                break;
            case PROGRAMMING:
                fragment = ListingFragment
                        .newInstance(getString(R.string.programming));
                break;
            case SHOWER_THOUGHTS:
                fragment = ListingFragment
                        .newInstance(getString(R.string.shower_thoughts));
                break;
            default:
                break;
        }
        mDrawerLayout.closeDrawers();
        if (fragment != null) {
            getSupportActionBar().setTitle(navItems.getTitleResId());
            replaceFragment(fragment, null, getContainerId());
        }
    }
}
