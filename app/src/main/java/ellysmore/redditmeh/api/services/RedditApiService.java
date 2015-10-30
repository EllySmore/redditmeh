package ellysmore.redditmeh.api.services;

import ellysmore.redditmeh.api.ApiPath;
import ellysmore.redditmeh.api.models.Listing.Listing;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface RedditApiService {

    @GET("{path}/{listing}.json")
    Observable<Listing> getSubRedditListing(
            @Path("path") String path,
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
