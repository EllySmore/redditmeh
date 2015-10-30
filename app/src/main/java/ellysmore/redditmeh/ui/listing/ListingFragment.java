package ellysmore.redditmeh.ui.listing;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.NetworkClient;
import ellysmore.redditmeh.api.models.Listing.Listing;
import ellysmore.redditmeh.ui.commons.BaseFragmentWithSwipeRefreshListener;
import ellysmore.redditmeh.ui.commons.DividerItemDecoration;
import ellysmore.redditmeh.ui.listing.adapters.ListingRecyclerAdapter;
import ellysmore.redditmeh.ui.models.ListingType;
import ellysmore.redditmeh.ui.models.SubredditType;
import ellysmore.redditmeh.ui.widgets.Footer;

public class ListingFragment extends BaseFragmentWithSwipeRefreshListener {

    private static final String TAG = ListingFragment.class.getSimpleName();

    private static final String PARAM_SUBREDDIT_NAME = "PARAM_SUBREDDIT_NAME";

    @Bind(R.id.progress_bar)
    protected ProgressBar mProgressBar;


    @Bind(R.id.swipe_container)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.footer)
    protected Footer mFooter;

    @Bind(R.id.list)
    protected RecyclerView mRecyclerView;

    private View mRootView;

    private SubredditType mSubredditName;

    private ListingRecyclerAdapter mAdapter;

    public static ListingFragment newInstance(SubredditType type) {
        ListingFragment listingFragment = new ListingFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_SUBREDDIT_NAME, type.toString());
        listingFragment.setArguments(bundle);
        return listingFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getArguments();
        if (extras != null) {
            mSubredditName = SubredditType.getType(extras.getString(PARAM_SUBREDDIT_NAME, null));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_listing, container, false);
        ButterKnife.bind(this, mRootView);
        setUpSwipeRefreshColorScheme(mSwipeRefreshLayout);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ListingRecyclerAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        onRefresh();
        return mRootView;
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        fetchListing();
    }

    /**
     * This must be fetched first before fetching next set of data.
     */
    private void fetchListing() {
        NetworkClient.getInstance().getListing(mSubredditName, ListingType.HOT).subscribe(
                listing -> {
                    Log.v("eee", "listing: " + listing);
                    mAdapter.setPosts(listing.getChildren().getPosts());
                    mAdapter.notifyDataSetChanged();
                }, throwable -> {
                    Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT)
                            .show();
                });
    }

    private void onSuccessFetchingInitialListing(Listing subredditListing) {

    }

    private void onSuccessFetchingNextListing(Listing subredditListing) {

    }

    private void onError(Throwable error) {

    }

    private void showContentLoading() {

    }

    private void hideContentLoading() {

    }

    private void showFooterLoading() {

    }

    private void hideFooterLoading() {
        ;
    }
}
