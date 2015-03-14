package ellysmore.redditmeh.ui.listing;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.commons.BaseFragmentWithSwipeRefreshListener;
import ellysmore.redditmeh.ui.listing.subreddit.adapters.ListingAdapter;
import ellysmore.redditmeh.ui.listing.subreddit.models.ListingDisplayInfo;

public class BaseListingFragment extends BaseFragmentWithSwipeRefreshListener {

    protected ListingAdapter mListingAdapter;

    protected ListingDisplayInfo mListingDisplayInfo;

    @InjectView(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    private View mRootView;

    private String TAG = BaseListingFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_listing, container, false);
        ButterKnife.inject(this, mRootView);
        setUpAdapter();
        setUpSwipeRefreshLayout();
        setUpListScrollListener();
        hideContent();
        showRefreshWidget();
        fetchSubredditListing();
        return mRootView;
    }

    protected void setUpAdapter() {
        mListingAdapter = new ListingAdapter();
        mList.setAdapter(mListingAdapter);
    }

    protected void setUpSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        setUpSwipeRefreshColorScheme();
    }

    protected void fetchSubredditListing() {
        Log.v(TAG, "fetchSubredditListing");
        //no op
    }

    protected void showRefreshWidget() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    protected void hideRefreshWidget() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    protected void hideContent() {
        mList.setVisibility(View.GONE);
    }

    protected void showContent() {
        mList.setVisibility(View.VISIBLE);
    }

    protected void updateUI() {
        mListingAdapter.setData(mListingDisplayInfo);
        mListingAdapter.notifyDataSetChanged();
    }

    protected void hideProgressbar() {
        mProgressBar.setVisibility(View.GONE);
    }

    protected void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

}
