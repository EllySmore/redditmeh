package ellysmore.redditmeh.ui.listing.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ellysmore.redditmeh.ui.listing.ListingFragment;
import ellysmore.redditmeh.ui.models.ListingType;
import ellysmore.redditmeh.ui.models.SubredditType;

import static ellysmore.redditmeh.ui.listing.ListingFragment.EXTRA_LISTING_TYPE;
import static ellysmore.redditmeh.ui.listing.ListingFragment.EXTRA_SUBREDDIT_NAME;
import static ellysmore.redditmeh.ui.models.ListingType.CONTROVERSIAL;
import static ellysmore.redditmeh.ui.models.ListingType.GILDED;
import static ellysmore.redditmeh.ui.models.ListingType.HOT;
import static ellysmore.redditmeh.ui.models.ListingType.NEW;
import static ellysmore.redditmeh.ui.models.ListingType.PROMOTED;
import static ellysmore.redditmeh.ui.models.ListingType.RISING;
import static ellysmore.redditmeh.ui.models.ListingType.TOP;
import static ellysmore.redditmeh.ui.models.ListingType.values;

public class ListingFragmentViewPager extends FragmentPagerAdapter {

    private SubredditType mSubRedditType;

    private Context mContext;

    public ListingFragmentViewPager(SubredditType type, FragmentManager fm) {
        super(fm);
        mSubRedditType = type;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_SUBREDDIT_NAME, mSubRedditType.toString());
        switch (position) {
            case 0:
                bundle.putString(EXTRA_LISTING_TYPE, HOT.toString());
                break;
            case 1:
                bundle.putString(EXTRA_LISTING_TYPE, RISING.toString());
                break;
            case 2:
                bundle.putString(EXTRA_LISTING_TYPE, NEW.toString());
                break;
            case 3:
                bundle.putString(EXTRA_LISTING_TYPE, CONTROVERSIAL.toString());
                break;
            case 4:
                bundle.putString(EXTRA_LISTING_TYPE, TOP.toString());
                break;
            case 5:
                bundle.putString(EXTRA_LISTING_TYPE, GILDED.toString());
                break;
            case 6:
                bundle.putString(EXTRA_LISTING_TYPE, PROMOTED.toString());
                break;
        }

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
