package ellysmore.redditmeh.ui.listing.subreddit.widgets;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.api.models.Listing.Data_;

public class ListingGrid extends CardView {

    @InjectView(R.id.image)
    protected DynamicHeightImageView mImage;

    @InjectView(R.id.title)
    protected TextView mTitle;

    private Data_ mData;

    public ListingGrid(Context context) {
        this(context, null);
    }

    public ListingGrid(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListingGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.grid_listing, this);
        ButterKnife.inject(this);
    }

    public void updateUI(Data_ data) {
        mData = data;
        mTitle.setText(mData.getTitle());
        Picasso.with(getContext()).load(data.getThumbnail()).into(mImage);
    }
}
