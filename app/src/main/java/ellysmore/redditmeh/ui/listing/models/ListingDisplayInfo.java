package ellysmore.redditmeh.ui.listing.models;

import java.util.List;

import ellysmore.redditmeh.api.models.Listing.Child;
import ellysmore.redditmeh.api.models.Listing.Data_;
import ellysmore.redditmeh.api.models.Listing.Listing;

public class ListingDisplayInfo {

    private Listing mData;

    private String mAfterTag;

    public ListingDisplayInfo(Listing data) {
        mData = data;
        mAfterTag = mData.getData().getAfter();
    }

    public List<Child> getListingData() {
        return mData.getData().getChildren();
    }

    public Data_ getItem(int position) {
        return mData.getData().getChildren().get(position).getData();
    }

    public void add(Listing nextData) {
        if (mData != null && mData.getData() != null) {
            mData.getData().getChildren().addAll(nextData.getData().getChildren());
            setAfterTag(nextData.getData().getAfter());
        }
    }

    public int getSize() {
        if (mData != null && mData.getData() != null) {
            return mData.getData().getChildren().size();
        }
        return 0;
    }

    public String getAfterTag() {
        return mAfterTag;
    }

    public void setAfterTag(String newAfterTag) {
        mAfterTag = newAfterTag;
    }
}

