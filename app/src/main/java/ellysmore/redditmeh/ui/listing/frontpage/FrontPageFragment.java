package ellysmore.redditmeh.ui.listing.frontpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.Constants;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.events.ListingEvent;
import ellysmore.redditmeh.api.request.FrontPageListingRequest;
import ellysmore.redditmeh.ui.commons.BaseFragmentWithSwipeRefreshListener;
import ellysmore.redditmeh.ui.listing.subreddit.adapters.ListingAdapter;
import ellysmore.redditmeh.ui.listing.subreddit.models.ListingDisplayInfo;

public class FrontPageFragment
        extends BaseFragmentWithSwipeRefreshListener {

    @InjectView(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    private View mRootView;

    private ListingAdapter mListingAdapter;

    private ListingDisplayInfo mListingDisplayInfo;

    public static FrontPageFragment newInstance() {
        FrontPageFragment
                fragment = new FrontPageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_listing, container, false);
        ButterKnife.inject(this, mRootView);
        setUpAdapter();
        setUpSwipeRefreshLayout();
        setUpListScrollListener();
        fetchFrontPageListing();
        return mRootView;
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        fetchFrontPageListing();
    }

    private void setUpSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        setUpSwipeRefreshColorScheme();
    }

    private void setUpAdapter() {
        mListingAdapter = new ListingAdapter();
        mList.setAdapter(mListingAdapter);
    }

    public void fetchFrontPageListing() {
        showLoading(true);
        FrontPageListingRequest request = new FrontPageListingRequest(Constants.LISTING_TYPE_HOT);
        getSpiceManager().execute(request, request);
    }

    private void showLoading(boolean isLoading) {
        if (isLoading) {
            mList.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        } else {
            mList.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @SuppressWarnings("UnusedDeclaration")
    public void onEventMainThread(ListingEvent event) {
        mListingDisplayInfo = new ListingDisplayInfo(event.getResult());
        updateUI();
        mSwipeRefreshLayout.setRefreshing(false);
        showLoading(false);
    }

    private void updateUI() {
        mListingAdapter.setData(mListingDisplayInfo);
        mListingAdapter.notifyDataSetChanged();
    }

}
