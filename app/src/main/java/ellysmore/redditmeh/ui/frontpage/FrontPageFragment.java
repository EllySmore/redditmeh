package ellysmore.redditmeh.ui.frontpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.Constants;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.events.ListingEvent;
import ellysmore.redditmeh.api.request.FrontPageListingRequest;
import ellysmore.redditmeh.ui.commons.BaseFragment;
import ellysmore.redditmeh.ui.subreddit.adapters.ListingAdapter;
import ellysmore.redditmeh.ui.subreddit.models.ListingDisplayInfo;

public class FrontPageFragment extends BaseFragment {

    @InjectView(R.id.list)
    protected ListView mList;

    @InjectView(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    private View mRootView;

    private ListingAdapter mListingAdapter;

    private ListingDisplayInfo mListingDisplayInfo;

    public static FrontPageFragment newInstance() {
        FrontPageFragment fragment = new FrontPageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_listing, container, false);
        ButterKnife.inject(this, mRootView);
        mListingAdapter = new ListingAdapter();
        mList.setAdapter(mListingAdapter);
        getFrontPageListing();
        return mRootView;
    }

    public void getFrontPageListing() {
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
        showLoading(false);
    }

    private void updateUI() {
        mListingAdapter.setData(mListingDisplayInfo);
        mListingAdapter.notifyDataSetChanged();
    }

}
