package ellysmore.redditmeh.ui.listing.subreddit.widgets;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.Constants;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.models.Listing.Data_;
import ellysmore.redditmeh.util.RoundedTransformation;

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

        final String postTimeDifference = getPostTimeDifference(data.getCreated());
        mTimeByAuthor.setText(getResources()
                .getString(R.string.xtime_by_xauthor, postTimeDifference,
                        data.getAuthor()));

        loadImage();
    }

    private String getPostTimeDifference(Long timeCreatedInMillis){
        return String.valueOf(timeCreatedInMillis);
    }

    public void loadImage() {
        if (mData.isOver18()) {
            Picasso.with(getContext()).load(R.drawable.redditplaceholder_nsfw)
                    .transform(new RoundedTransformation(4, 0)).fit().into(mThumbnail);
        } else if (mData.getThumbnail() == null || mData.getThumbnail().isEmpty() || mData
                .getThumbnail().equalsIgnoreCase(Constants.SELF)) {
            Picasso.with(getContext()).load(R.drawable.redditplaceholder)
                    .transform(new RoundedTransformation(2, 0)).fit().into(mThumbnail);
        } else {
            Picasso.with(getContext()).load(mData.getThumbnail())
                    .transform(new RoundedTransformation(2, 0)).fit().into(mThumbnail);
        }
    }

}
