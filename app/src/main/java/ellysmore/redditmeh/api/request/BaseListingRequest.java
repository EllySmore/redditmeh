package ellysmore.redditmeh.api.request;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.okhttp.OkHttpSpiceRequest;

import ellysmore.redditmeh.api.models.Listing.Listing;

public class BaseListingRequest extends OkHttpSpiceRequest<Listing> implements
        RequestListener<Listing> {

    public BaseListingRequest() {
        super(Listing.class);
    }

    @Override
    public void onRequestFailure(SpiceException spiceException) {

    }

    @Override
    public void onRequestSuccess(Listing listing) {

    }

    @Override
    public Listing loadDataFromNetwork() throws Exception {
        return null;
    }
}
