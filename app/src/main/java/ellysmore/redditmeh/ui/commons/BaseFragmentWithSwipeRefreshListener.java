package ellysmore.redditmeh.ui.commons;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.AbsListView;
import android.widget.ListView;

import butterknife.InjectView;
import butterknife.Optional;
import ellysmore.redditmeh.R;

public class BaseFragmentWithSwipeRefreshListener extends BaseFragment
        implements SwipeRefreshLayout.OnRefreshListener {

    @Optional
    @InjectView(R.id.list)
    protected ListView mList;

    @Optional
    @InjectView(R.id.swipe_container)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    protected void setUpListScrollListener() {
        mList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                    int totalItemCount) {
                int topRowVerticalPosition = (mList == null || mList.getChildCount() == 0) ?
                        0 : mList.getChildAt(0).getTop();
                mSwipeRefreshLayout.setEnabled((topRowVerticalPosition >= 0));
            }
        });
    }

    protected void setUpSwipeRefreshColorScheme() {
        mSwipeRefreshLayout
                .setColorSchemeResources(R.color.c1_2, R.color.c3_2, R.color.c5_3, R.color.c4_3);
    }


    @Override
    public void onRefresh() {
        //no op
    }
}
