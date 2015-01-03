package ellysmore.redditmeh.api.events;

import ellysmore.redditmeh.api.models.Listing.Listing;

public class ListingEvent extends BaseEvent {

    private String mSubredditName;

    private Listing mResult;

    public ListingEvent(Listing result) {
        this(null, result);
    }

    public ListingEvent(String subredditName, Listing result) {
        super(true);
        mSubredditName = subredditName;
        mResult = result;
    }

    public ListingEvent(boolean isSuccess) {
        super(isSuccess);
    }

    public String getSubredditName() {
        return mSubredditName;
    }

    public Listing getResult() {
        return mResult;
    }
}
