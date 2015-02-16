package ellysmore.redditmeh.api;

import ellysmore.redditmeh.Config;
import ellysmore.redditmeh.api.services.RedditApiService;
import retrofit.RestAdapter;

public class NetworkClient {

    private static NetworkClient mInstance = null;

    private RedditApiService mRedditApiService;

    private NetworkClient() {
        mRedditApiService = new RestAdapter.Builder()
                .setEndpoint(Config.getEndPoint()).setLogLevel(RestAdapter.LogLevel.FULL)
                .build().create(RedditApiService.class);
    }

    public static NetworkClient getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkClient();
        }
        return mInstance;
    }

    public RedditApiService getRedditApiService() {
        return mRedditApiService;
    }
}
