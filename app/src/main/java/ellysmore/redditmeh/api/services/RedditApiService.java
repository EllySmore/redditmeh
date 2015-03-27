package ellysmore.redditmeh.api.services;

import ellysmore.redditmeh.api.ApiPath;
import ellysmore.redditmeh.api.models.Listing.Listing;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface RedditApiService {

    @GET(ApiPath.SUBREDDIT_LISTING)
    Observable<Listing> getSubRedditListing(
            @Path("SUBREDDIT_NAME") String subredditName,
            @Path("LISTING_TYPE") String listingType
    );

    @GET(ApiPath.SUBREDDIT_LISTING)
    Observable<Listing> getNextSubredditListing(
            @Path("SUBREDDIT_NAME") String subredditName,
            @Path("LISTING_TYPE") String listingType,
            @Field("after") String afterFullName,
            @Field("limit") int limit
    );

    @GET(ApiPath.FRONT_PAGE_LISTING)
    Observable<Listing> getFrontPageListing(
            @Path("LISTING_TYPE") String listingType
    );
}
