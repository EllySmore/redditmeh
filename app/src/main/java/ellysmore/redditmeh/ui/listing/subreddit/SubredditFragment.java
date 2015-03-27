package ellysmore.redditmeh.ui.listing.subreddit;

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
import ellysmore.redditmeh.api.models.Listing.Listing;
import ellysmore.redditmeh.ui.commons.BaseFragmentWithSwipeRefreshListener;
import ellysmore.redditmeh.ui.listing.subreddit.adapters.ListingAdapter;
import ellysmore.redditmeh.ui.listing.subreddit.models.ListingDisplayInfo;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

public class SubredditFragment
        extends BaseFragmentWithSwipeRefreshListener {

    private static final String TAG = SubredditFragment.class.getSimpleName();

    private static final String PARAM_SUBREDDIT_NAME = "PARAM_SUBREDDIT_NAME";

    @InjectView(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    private View mRootView;

    private String mSubredditName;

    private ListingAdapter mListingAdapter;

    private ListingDisplayInfo mListingDisplayInfo;

    public static SubredditFragment newInstance() {
        return SubredditFragment.newInstance(null);
    }

    public static SubredditFragment newInstance(String subredditName) {
        SubredditFragment
                subredditFragment = new SubredditFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_SUBREDDIT_NAME, subredditName);
        subredditFragment.setArguments(bundle);
        return subredditFragment;
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
        fetchSubredditListing();

        if (mSubredditName == null) {
            fetchFrontPageListing();
        } else {
            fetchSubredditListing();
        }
        return mRootView;
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        if (mSubredditName == null) {
            fetchFrontPageListing();
        } else {
            fetchSubredditListing();
        }
    }

    private void setUpAdapter() {
        mListingAdapter = new ListingAdapter();
        mList.setAdapter(mListingAdapter);
    }

    private void setUpSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        setUpSwipeRefreshColorScheme();
    }

    private void fetchSubredditListing() {
        Observable<Listing> observable = NetworkClient.getInstance()
                .getRedditApiService()
                .getSubRedditListing(mSubredditName, Constants.LISTING_TYPE_HOT);
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
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
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
                        mSwipeRefreshLayout.setRefreshing(false);
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

}
