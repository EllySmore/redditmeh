package ellysmore.redditmeh.ui.listing.widgets;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.widgets.FlatButton;

public class ListingViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.title)
    public TextView mTitle;

    @BindView(R.id.subreddit_by_domain)
    public TextView mSubredditByDomain;

    @BindView(R.id.time_by_author)
    public TextView mTimeByAuthor;

    @BindView(R.id.thumbnail)
    public ImageView mThumbnail;

    @BindView(R.id.number_of_comments)
    public FlatButton mNumberOfCommentButton;

    public ListingViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
