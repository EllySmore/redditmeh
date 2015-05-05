package ellysmore.redditmeh.ui.listing.widgets;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.models.Listing.Data_;
import ellysmore.redditmeh.ui.widgets.FlatButton;
import ellysmore.redditmeh.util.PicassoHelper;
import ellysmore.redditmeh.util.TimeHelper;

public class ListingRow extends RelativeLayout {

    @InjectView(R.id.title)
    protected TextView mTitle;

    @InjectView(R.id.subreddit_by_domain)
    protected TextView mSubredditByDomain;

    @InjectView(R.id.time_by_author)
    protected TextView mTimeByAuthor;

    @InjectView(R.id.thumbnail)
    protected ImageView mThumbnail;

    @InjectView(R.id.flatbutton)
    protected FlatButton mFlatButton;

    private Data_ mData;

    public ListingRow(Context context) {
        this(context, null);
    }

    public ListingRow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListingRow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.row_listing, this);
        ButterKnife.inject(this);
    }

    public void updateUI(Data_ data) {
        mData = data;
        mTitle.setText(data.getTitle());
        mSubredditByDomain.setText(getResources()
                .getString(R.string.xtime_by_xauthor, data.getSubreddit(), data.getDomain()));
        mFlatButton.setText(String.valueOf(data.getNumComments()));

        final String postTimeDifference = getPostTimeDifference(data.getCreatedUtc());
        mTimeByAuthor.setText(getResources()
                .getString(R.string.xtime_by_xauthor, postTimeDifference,
                        data.getAuthor()));

        loadImage();
    }

    private String getPostTimeDifference(long epochTimeInSeconds) {
        final long epochTimeInMillis = epochTimeInSeconds * 1000;
        String timeDifference = TimeHelper
                .getDifference(new DateTime(epochTimeInMillis, DateTimeZone.UTC));
        return getResources().getString(R.string.xtime, timeDifference);
    }

    public void loadImage() {
        if (mData.isOver18()) {
            PicassoHelper.loadImage(mThumbnail, getContext(), R.drawable.redditplaceholder_nsfw);
        } else {
            PicassoHelper.loadImage(mThumbnail, getContext(), mData.getThumbnail());
        }
    }

}
