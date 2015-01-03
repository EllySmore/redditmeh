package ellysmore.redditmeh.util;

import android.net.Uri;
import android.util.Log;

import java.net.URI;
import java.net.URISyntaxException;

import ellysmore.redditmeh.Config;
import ellysmore.redditmeh.api.request.FrontPageListingRequest;
import ellysmore.redditmeh.api.request.SubredditListingRequest;

public class RequestHelper {

    public static URI buildURI(String route) throws URISyntaxException {
        Uri.Builder uriBuilder = Uri.parse(Config.END_POINT + route).buildUpon();
        URI uri = new URI(uriBuilder.build().toString());
        Log.d("RequestHelperUtil", "Url: " + uriBuilder.toString());
        return uri;
    }

    public static URI buildSubredditURI(String route, String subredditName, String listingType) throws URISyntaxException {
        route = route.replace(SubredditListingRequest.SUBREDDIT_NAME, subredditName);
        route = route.replace(SubredditListingRequest.LISTING_TYPE, listingType);
        Uri.Builder uriBuilder = Uri.parse(Config.END_POINT + route).buildUpon();
        URI uri = new URI(uriBuilder.build().toString());
        Log.d("RequestHelperUtil", "Url: " + uriBuilder.toString());
        return uri;
    }

    public static URI buildFrontPageURI(String route, String listingType) throws URISyntaxException {
        route = route.replace(FrontPageListingRequest.LISTING_TYPE, listingType);
        Uri.Builder uriBuilder = Uri.parse(Config.END_POINT + route).buildUpon();
        URI uri = new URI(uriBuilder.build().toString());
        Log.d("RequestHelperUtil", "Url: " + uriBuilder.toString());
        return uri;
    }

    public static boolean isJsonArray(String obj) {
        boolean isJsonArray = false;

        if (obj.length() > 0 && obj.charAt(0) == '[') {
            isJsonArray = true;
        }
        return isJsonArray;
    }
}
