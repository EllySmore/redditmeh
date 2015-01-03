package ellysmore.redditmeh.ui.listing.subreddit.widgets;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.models.Listing.Data_;
import ellysmore.redditmeh.util.RoundedTransformation;

public class ListingRow extends RelativeLayout {

    @InjectView(R.id.title)
    protected TextView mTitle;

    @InjectView(R.id.author)
    protected TextView mAuthor;

    @InjectView(R.id.num_comments)
    protected TextView mNumComments;

    @InjectView(R.id.thumbnail)
    protected ImageView mThumbnail;

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
        mAuthor.setText("submitted by " + data.getAuthor());
        mNumComments.setText(String.format("%d comments", data.getNumComments()));
        loadImage();
    }

    public void loadImage() {
        String thumbnailUrl = mData.getThumbnail();
        if (thumbnailUrl != null && thumbnailUrl.isEmpty()) {
            thumbnailUrl = null;
        }
        if (thumbnailUrl == null) {
            Picasso.with(getContext()).load(R.drawable.redditplaceholder)
                    .transform(new RoundedTransformation(4, 0)).fit().into(mThumbnail);
        } else {
            Picasso.with(getContext()).load(thumbnailUrl)
                    .transform(new RoundedTransformation(4, 0)).fit().into(mThumbnail);
        }
    }
}
