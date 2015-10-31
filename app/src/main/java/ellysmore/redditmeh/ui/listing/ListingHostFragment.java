package ellysmore.redditmeh.ui.listing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.listing.adapters.ListingFragmentViewPager;
import ellysmore.redditmeh.ui.models.ListingType;
import ellysmore.redditmeh.ui.models.SubredditType;
import ellysmore.redditmeh.ui.navigation.NavigationActivity;

public class ListingHostFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private SubredditType mSubreddit;

    //Views
    private View mRootView;

    private ListingFragmentViewPager mPageAdapter;

    private ViewPager mViewPager;

    private TabLayout mTabStrip;

    public static Fragment newInstance(SubredditType type) {
        Bundle bundle = new Bundle();
        bundle.putString(ListingFragment.EXTRA_SUBREDDIT_NAME, type.toString());
        ListingHostFragment fragment = new ListingHostFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSubreddit = SubredditType
                .getType(getArguments().getString(ListingFragment.EXTRA_SUBREDDIT_NAME, null));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_host_listing, container, false);
        mPageAdapter = new ListingFragmentViewPager(mSubreddit, getChildFragmentManager());
        mTabStrip = (TabLayout) mRootView.findViewById(R.id.sliding_tabs);
        mViewPager = (ViewPager) mRootView.findViewById(R.id.pager);
        mViewPager.setAdapter(mPageAdapter);
        mViewPager.addOnPageChangeListener(this);
        mTabStrip.setupWithViewPager(mViewPager);
        NavigationActivity activity = (NavigationActivity) getActivity();
        activity.getToolbar().setTitle(getString(R.string.x_bullet_y,
                getString(mSubreddit.getTitleResId()), ListingType.HOT.toString()));
        return mRootView;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        String actionBarTitle = getString(R.string.x_bullet_y,
                getString(mSubreddit.getTitleResId()),
                ListingType.values()[position].toString());
        NavigationActivity activity = (NavigationActivity) getActivity();
        activity.getToolbar().setTitle(actionBarTitle);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
