package ellysmore.redditmeh.ui.listing.models;

import android.content.Context;

import ellysmore.redditmeh.api.models.Listing.PostData;
import ellysmore.redditmeh.util.TimeHelper;

public class ListingDisplayViewModel {

    private final Context context;

    private final PostData data;

    public ListingDisplayViewModel(Context context, PostData data) {
        this.context = context;
        this.data = data;
    }

    public String getTitle() {
        return data.getTitle();
    }

    public String getDateCreated() {
        return TimeHelper.getDifference(data.getCreated());
    }

    public String getAuthor() {
        return data.getAuthor();
    }

    public String getThumbnailUrl() {
        return data.getThumbnail();
    }

    public String getDomain() {
        return data.getDomain();
    }

    public String getSubreddit() {
        return data.getSubreddit();
    }

    public int getUps() {
        return data.getUps();
    }

    public int getNumberOfComments() {
        return data.getNumComments();
    }

    public int getDowns() {
        return data.getDowns();
    }

}
