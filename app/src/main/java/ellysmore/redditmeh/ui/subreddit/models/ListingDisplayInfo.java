package ellysmore.redditmeh.ui.subreddit.models;

import java.util.List;

import ellysmore.redditmeh.api.models.Listing.Child;
import ellysmore.redditmeh.api.models.Listing.Data_;
import ellysmore.redditmeh.api.models.Listing.Listing;

public class ListingDisplayInfo {

    private Listing mData;

    public ListingDisplayInfo(Listing data) {
        mData = data;
    }

    public List<Child> getListingData() {
        return mData.getData().getChildren();
    }

    public Data_ getItem(int position) {
        return mData.getData().getChildren().get(position).getData();
    }

    public int getSize() {
        if (mData != null && mData.getData() != null) {
            return mData.getData().getChildren().size();
        }
        return 0;
    }
}

