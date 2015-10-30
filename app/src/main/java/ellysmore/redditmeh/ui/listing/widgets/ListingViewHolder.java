package ellysmore.redditmeh.ui.listing.widgets;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.widgets.FlatButton;

public class ListingViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.title)
    public TextView mTitle;

    @Bind(R.id.subreddit_by_domain)
    public TextView mSubredditByDomain;

    @Bind(R.id.time_by_author)
    public TextView mTimeByAuthor;

    @Bind(R.id.thumbnail)
    public ImageView mThumbnail;

    @Bind(R.id.number_of_comments)
    public FlatButton mNumberOfCommentButton;

    public ListingViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
