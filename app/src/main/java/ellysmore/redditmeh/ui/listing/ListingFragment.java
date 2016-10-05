package ellysmore.redditmeh.ui.listing;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.NetworkClient;
import ellysmore.redditmeh.ui.commons.BaseFragment;
import ellysmore.redditmeh.ui.listing.adapters.ListingRecyclerAdapter;
import ellysmore.redditmeh.ui.models.ListingType;
import ellysmore.redditmeh.ui.models.SubredditType;
import ellysmore.redditmeh.ui.widgets.Footer;

public class ListingFragment extends BaseFragment
        implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = ListingFragment.class.getSimpleName();

    public static final String EXTRA_SUBREDDIT_NAME = "EXTRA_SUBREDDIT_NAME";

    public static final String EXTRA_LISTING_TYPE = "EXTRA_LISTING_TYPE";

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.swipe_container)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.footer)
    Footer mFooter;

    @BindView(R.id.list)
    RecyclerView mRecyclerView;

    @BindView(R.id.empty_view)
    View mEmptyView;

    private SubredditType mSubreddit;
    private ListingType mListingType;
    private ListingRecyclerAdapter mAdapter;

    public static ListingFragment newInstance(Bundle bundle) {
        ListingFragment listingFragment = new ListingFragment();
        listingFragment.setArguments(bundle);
        return listingFragment;
    }

    public static ListingFragment newInstance(SubredditType subreddit, ListingType listingType) {
        ListingFragment listingFragment = new ListingFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_SUBREDDIT_NAME, subreddit.toString());
        bundle.putString(EXTRA_LISTING_TYPE, listingType.toString());
        listingFragment.setArguments(bundle);
        return listingFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getArguments();
        if (extras != null) {
            mSubreddit = SubredditType.getType(extras.getString(EXTRA_SUBREDDIT_NAME, null));
            mListingType = ListingType.getType(extras.getString(EXTRA_LISTING_TYPE, null));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_listing, container, false);
        ButterKnife.bind(this, rootView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //TODO: fetch next
            }
        });
        mAdapter = new ListingRecyclerAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.scrollToPosition(0);
        return rootView;
    }

    @Override
    public void onRefresh() {
        fetchListing();
    }

    /**
     * This must be fetched first before fetching next set of data.
     */
    private void fetchListing() {
        NetworkClient.getInstance()
                .getListing(mSubreddit, mListingType)
                .doOnNext(notification -> showLoading())
                .doAfterTerminate(this::hideLoading)
                .subscribe(listing -> {
                    if (listing.getChildren().getPosts().isEmpty()) {
                        mEmptyView.setVisibility(View.VISIBLE);
                    }
                    mAdapter.clear();
                    mAdapter.setPosts(listing.getChildren().getPosts());

                }, this::onError);
    }

    private void onError(Throwable error) {
        Toast.makeText(getActivity(), error.getMessage(),
                Toast.LENGTH_SHORT)
                .show();
    }

    private void showFooterLoading() {
        mFooter.setVisibility(View.VISIBLE);
    }

    private void hideFooterLoading() {
        mFooter.setVisibility(View.GONE);
    }

    private void showLoading() {
        mEmptyView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
