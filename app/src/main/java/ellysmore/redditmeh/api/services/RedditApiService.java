package ellysmore.redditmeh.api.services;


import ellysmore.redditmeh.api.models.Listing.Listing;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface RedditApiService {

    @GET("/r/{SUBREDDIT_NAME}/{LISTING_TYPE}/.json")
    Observable<Listing> getSubRedditListing(
            @Path("SUBREDDIT_NAME") String subredditName,
            @Path("LISTING_TYPE") String listingType
    );

    @GET("/{LISTING_TYPE}/.json")
    Observable<Listing> getFrontPageListing(
            @Path("LISTING_TYPE") String listingType
    );
}
