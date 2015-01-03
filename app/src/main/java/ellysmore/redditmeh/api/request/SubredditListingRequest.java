package ellysmore.redditmeh.api.request;

import com.google.gson.reflect.TypeToken;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.okhttp.OkHttpSpiceRequest;
import com.squareup.okhttp.internal.http.Request;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import android.util.Log;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;

import de.greenrobot.event.EventBus;
import ellysmore.redditmeh.Constants;
import ellysmore.redditmeh.api.events.ListingEvent;
import ellysmore.redditmeh.api.models.Listing.Listing;
import ellysmore.redditmeh.util.RequestHelper;

public class SubredditListingRequest extends OkHttpSpiceRequest<Listing> implements
        RequestListener<Listing> {

    public static final String SUBREDDIT_NAME = "SUBREDDIT_NAME";

    public static final String LISTING_TYPE = "LISTING_TYPE";

    private String ROUTE = "/r/" + SUBREDDIT_NAME + "/" + LISTING_TYPE + "/.json";

    private static final String TAG = SubredditListingRequest.class.getSimpleName();

    private String mSubredditName;

    private String mListingType;

    public SubredditListingRequest(String subredditName, String listingType) {
        super(Listing.class);
        mSubredditName = subredditName;
        if (listingType == null) {
            mListingType = Constants.LISTING_TYPE_HOT;
        } else {
            mListingType = listingType;
        }
    }

    @Override
    public Listing loadDataFromNetwork() throws Exception {
        URI uri = RequestHelper.buildSubredditURI(ROUTE, mSubredditName, mListingType);
        HttpURLConnection connection = getOkHttpClient().open(uri.toURL());
        InputStream in = null;
        in = connection.getInputStream();
        Listing listing = Listing.buildFromJson(in, Listing.class, true);
        return listing;
    }

    @Override
    public void onRequestFailure(SpiceException spiceException) {
        Log.i(TAG, "onRequestFailure");
        EventBus.getDefault().post(new ListingEvent(false));
    }

    @Override
    public void onRequestSuccess(Listing listing) {
        Log.i(TAG, "OnSuccess");
        EventBus.getDefault().post(new ListingEvent(mSubredditName, listing));
    }
}
