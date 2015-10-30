package ellysmore.redditmeh.ui.commons;

import android.support.v4.widget.SwipeRefreshLayout;

import ellysmore.redditmeh.R;

public abstract class BaseFragmentWithSwipeRefreshListener extends BaseFragment
        implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = BaseFragmentWithSwipeRefreshListener.class.getSimpleName();


    protected void setUpSwipeRefreshColorScheme(SwipeRefreshLayout layout) {
        layout.setColorSchemeResources(R.color.c1_2, R.color.c3_2, R.color.c5_3, R.color.c4_3);
    }

    @Override
    public void onRefresh() {
        //no op
    }

}
