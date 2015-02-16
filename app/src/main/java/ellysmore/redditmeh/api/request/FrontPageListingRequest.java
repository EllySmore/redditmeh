package ellysmore.redditmeh.api.request;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.okhttp.OkHttpSpiceRequest;
import com.squareup.okhttp.ConnectionPool;

import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;

import de.greenrobot.event.EventBus;
import ellysmore.redditmeh.Constants;
import ellysmore.redditmeh.api.events.ListingEvent;
import ellysmore.redditmeh.api.models.Listing.Listing;
import ellysmore.redditmeh.util.RequestHelper;

public class FrontPageListingRequest extends OkHttpSpiceRequest<Listing> implements
        RequestListener<Listing> {

    public static final String LISTING_TYPE = "LISTING_TYPE";

    private String ROUTE = "/" + LISTING_TYPE + "/.json";

    private static final String TAG = FrontPageListingRequest.class.getSimpleName();

    private String mListingType;

    public FrontPageListingRequest(String listingType) {
        super(Listing.class);
        if (listingType == null) {
            mListingType = Constants.LISTING_TYPE_HOT;
        } else {
            mListingType = listingType;
        }
    }

    @Override
    public Listing loadDataFromNetwork() throws Exception {
        //TODO: Delete request, commented out, okHttpClient does not have open func
//        URI uri = RequestHelper.buildFrontPageURI(ROUTE, mListingType);
//        Log.i(TAG, "url: " + uri);
//        ConnectionPool connection = getOkHttpClient().getConnectionPool();
//        connection.
//        InputStream in = null;
//        in = connection.getInputStream();
//        Listing listing = Listing.buildFromJson(in, Listing.class, true);
        return null;
    }

    @Override
    public void onRequestFailure(SpiceException spiceException) {
        Log.i(TAG, "OnSuccess");
        EventBus.getDefault().post(new ListingEvent(false));
    }

    @Override
    public void onRequestSuccess(Listing listing) {
        Log.i(TAG, "OnSuccess:" + listing.toString());
        EventBus.getDefault().post(new ListingEvent(listing));
    }
}
