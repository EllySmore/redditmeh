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
import ellysmore.redditmeh.api.NetworkClient;
import ellysmore.redditmeh.api.events.ListingEvent;
import ellysmore.redditmeh.api.models.Listing.Listing;
import ellysmore.redditmeh.ui.commons.BaseFragmentWithSwipeRefreshListener;
import ellysmore.redditmeh.ui.listing.subreddit.adapters.ListingAdapter;
import ellysmore.redditmeh.ui.listing.subreddit.models.ListingDisplayInfo;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

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
        Observable<Listing> observable = NetworkClient.getInstance()
                .getRedditApiService()
                .getFrontPageListing(Constants.LISTING_TYPE_HOT);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Listing>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Listing subredditListing) {
                        mListingDisplayInfo = new ListingDisplayInfo(subredditListing);
                        mListingAdapter.setData(mListingDisplayInfo);
                        mListingAdapter.notifyDataSetChanged();
                        showLoading(false);
                    }
                });
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
