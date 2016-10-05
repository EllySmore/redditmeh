package ellysmore.redditmeh.ui.listing.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import ellysmore.redditmeh.ui.listing.ListingFragment;
import ellysmore.redditmeh.ui.models.ListingType;
import ellysmore.redditmeh.ui.models.SubredditType;

import static ellysmore.redditmeh.ui.listing.ListingFragment.EXTRA_LISTING_TYPE;
import static ellysmore.redditmeh.ui.listing.ListingFragment.EXTRA_SUBREDDIT_NAME;
import static ellysmore.redditmeh.ui.models.ListingType.values;

public class ListingFragmentViewPager extends FragmentStatePagerAdapter {

    private SubredditType mSubRedditType;

    public ListingFragmentViewPager(SubredditType type, FragmentManager fm) {
        super(fm);
        mSubRedditType = type;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_SUBREDDIT_NAME, mSubRedditType.toString());
        bundle.putString(EXTRA_LISTING_TYPE, ListingType.values()[position].toString());
        return ListingFragment.newInstance(bundle);
    }

    @Override
    public int getCount() {
        return ListingType.values().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return values()[position].toString();
    }
}
