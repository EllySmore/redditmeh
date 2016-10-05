package ellysmore.redditmeh.api;

import ellysmore.redditmeh.Config;
import ellysmore.redditmeh.api.models.Listing.Listing;
import ellysmore.redditmeh.api.services.RedditApiService;
import ellysmore.redditmeh.ui.models.ListingType;
import ellysmore.redditmeh.ui.models.SubredditType;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Update service using oauth2
 */
public class NetworkClient {

    private static NetworkClient mInstance = null;

    private RedditApiService mRedditApiService;

    private NetworkClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.getEndPoint())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mRedditApiService = retrofit.create(RedditApiService.class);
    }

    public static NetworkClient getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkClient();
        }
        return mInstance;
    }

    public Observable<Listing> getListing(SubredditType subreddit, ListingType listingType) {
        return mRedditApiService.getSubRedditListing(subreddit.getPath(), listingType.getPath());
    }

    public Observable<Listing> getNextListing(SubredditType subreddit, ListingType listingType,
            String next) {
        return mRedditApiService
                .getNextSubredditListing(subreddit.toString(), listingType.toString(), next, 20);

    }
}
