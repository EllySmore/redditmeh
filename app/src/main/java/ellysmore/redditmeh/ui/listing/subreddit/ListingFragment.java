package ellysmore.redditmeh.ui.listing.subreddit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.Constants;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.NetworkClient;
import ellysmore.redditmeh.api.models.Listing.Listing;
import ellysmore.redditmeh.ui.commons.BaseFragmentWithSwipeRefreshListener;
import ellysmore.redditmeh.ui.listing.subreddit.adapters.ListingAdapter;
import ellysmore.redditmeh.ui.listing.subreddit.models.ListingDisplayInfo;
import ellysmore.redditmeh.ui.listing.subreddit.widgets.Footer;
import rx.android.schedulers.AndroidSchedulers;

public class ListingFragment
        extends BaseFragmentWithSwipeRefreshListener {

    private static final String TAG = ListingFragment.class.getSimpleName();

    private static final String PARAM_SUBREDDIT_NAME = "PARAM_SUBREDDIT_NAME";

    @InjectView(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    @InjectView(R.id.footer)
    protected Footer mFooter;

    private View mRootView;

    private String mSubredditName;

    private ListingAdapter mListingAdapter;

    private ListingDisplayInfo mListingDisplayInfo;

    public static ListingFragment newInstance() {
        return ListingFragment.newInstance(null);
    }

    public static ListingFragment newInstance(String subredditName) {
        ListingFragment
                listingFragment = new ListingFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_SUBREDDIT_NAME, subredditName);
        listingFragment.setArguments(bundle);
        return listingFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getArguments();
        if (extras != null) {
            mSubredditName = extras.getString(PARAM_SUBREDDIT_NAME, null);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_listing, container, false);
        ButterKnife.inject(this, mRootView);
        setUpAdapter();
        setUpSwipeRefreshLayout();
        setUpListScrollListener();
        fetchInitialListing();
        return mRootView;
    }

    @Override
    public void reachBottomOfList() {
        fetchNextListing();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        fetchInitialListing();
    }

    //region SetUp
    private void setUpAdapter() {
        mListingAdapter = new ListingAdapter();
        mList.setAdapter(mListingAdapter);
    }

    private void setUpSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        setUpSwipeRefreshColorScheme();
    }
    //endregion

    //region API calls

    /**
     * This must be fetched first before fetching next set of data.
     */
    private void fetchInitialListing() {
        mIsFetching = true;
        showContentLoading();
        if (mSubredditName == null) {
            fetchFrontPageListing();
        } else {
            fetchSubredditListing();
        }
    }

    private void fetchNextListing() {
        mIsFetching = true;
        showFooterLoading();
        if (mSubredditName == null) {
            fetchNextFrontPageListing();
        } else {
            fetchNextSubredditListing();
        }
    }

    private void fetchSubredditListing() {
        NetworkClient.getInstance()
                .getRedditApiService()
                .getSubRedditListing(mSubredditName, Constants.LISTING_TYPE_HOT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessFetchingInitialListing, this::onError);
    }

    private void fetchNextSubredditListing() {
        NetworkClient.getInstance()
                .getRedditApiService()
                .getNextSubredditListing(mSubredditName,
                        Constants.LISTING_TYPE_HOT,
                        mListingDisplayInfo.getAfterTag(),
                        Constants.LIMIT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessFetchingNextListing, this::onError);
    }

    private void fetchFrontPageListing() {
        NetworkClient.getInstance()
                .getRedditApiService()
                .getFrontPageListing(Constants.LISTING_TYPE_HOT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessFetchingInitialListing, this::onError);
    }

    private void onSuccessFetchingInitialListing(Listing subredditListing) {
        mListingDisplayInfo = new ListingDisplayInfo(subredditListing);
        mListingAdapter.setData(mListingDisplayInfo);
        mListingAdapter.notifyDataSetChanged();
        hideContentLoading();
        mSwipeRefreshLayout.setRefreshing(false);
        mIsFetching = false;
    }

    private void onSuccessFetchingNextListing(Listing subredditListing) {
        mListingAdapter.setData(subredditListing);
        mListingAdapter.notifyDataSetChanged();
        mIsFetching = false;
        hideFooterLoading();
    }

    private void onError(Throwable error) {
        Toast.makeText(getActivity(), "SERVER ERROR", Toast.LENGTH_LONG).show();
        mIsFetching = false;
        hideContentLoading();
        hideFooterLoading();
    }

    private void fetchNextFrontPageListing() {
        NetworkClient.getInstance()
                .getRedditApiService()
                .getNextFrontPageListing(Constants.LISTING_TYPE_HOT,
                        mListingDisplayInfo.getAfterTag(), Constants.LIMIT)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccessFetchingNextListing, this::onError);
    }
    //endregion

    //region ToggleViews
    private void showContentLoading() {
        mList.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideContentLoading() {
        mList.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    private void showFooterLoading() {
        mFooter.setVisibility(View.VISIBLE);
        mFooter.showLoading();
    }

    private void hideFooterLoading() {
        mFooter.setVisibility(View.INVISIBLE);
        mFooter.hideLoading();
    }
    //endregion
}
