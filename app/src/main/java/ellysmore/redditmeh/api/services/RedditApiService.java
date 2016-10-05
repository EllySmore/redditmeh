package ellysmore.redditmeh.api.services;

import ellysmore.redditmeh.api.ApiPath;
import ellysmore.redditmeh.api.models.Listing.Listing;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface RedditApiService {

    @GET("{path}/{listing}.json")
    Observable<Listing> getSubRedditListing(
            @Path(value = "path", encoded = false) String path,
            @Path("listing") String listing
    );

    @GET(ApiPath.SUBREDDIT_LISTING)
    Observable<Listing> getNextSubredditListing(
            @Path(value = "SUBREDDIT_NAME", encoded = false) String subredditName,
            @Path("LISTING_TYPE") String listingType,
            @Query("after") String afterFullName,
            @Query("limit") int limit
    );
}
