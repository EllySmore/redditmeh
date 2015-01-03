package ellysmore.redditmeh.ui.listing.subreddit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.events.ListingEvent;
import ellysmore.redditmeh.api.request.SubredditListingRequest;
import ellysmore.redditmeh.ui.commons.BaseFragmentWithSwipeRefreshListener;
import ellysmore.redditmeh.ui.listing.subreddit.adapters.ListingAdapter;
import ellysmore.redditmeh.ui.listing.subreddit.models.ListingDisplayInfo;

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
            mSubredditName = extras.getString(PARAM_SUBREDDIT_NAME);
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
        return mRootView;
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        fetchSubredditListing();
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
        showLoading(true);
        SubredditListingRequest request = new SubredditListingRequest(mSubredditName, null);
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

    private void updateUI() {
        mListingAdapter.setData(mListingDisplayInfo);
        mListingAdapter.notifyDataSetChanged();
    }

    @SuppressWarnings("UnusedDeclaration")
    public void onEventMainThread(ListingEvent event) {
        if (event.isSuccess() && event.getSubredditName().equals(mSubredditName)) {
            mListingDisplayInfo = new ListingDisplayInfo(event.getResult());
            updateUI();
        }
        showLoading(false);
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
