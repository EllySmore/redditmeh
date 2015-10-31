package ellysmore.redditmeh.api.models.Listing;

import ellysmore.redditmeh.api.models.BaseModel;

public class PostData extends BaseModel {

    private String id;

    private String domain;

    private String subreddit;

    private String author;

    private int score;

    private String approved_by;

    private boolean over_18;

    private String thumbnail;

    private String subreddit_id;

    private int downs;

    private String name;

    private String permalink;

    private long created;

    private String url;

    private String title;

    private long created_utc;

    private int ups;

    private int num_comments;

    private int num_reports;

    public String getDomain() {
        return domain;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public int getScore() {
        return score;
    }

    public String getApprovedBy() {
        return approved_by;
    }

    public boolean isOver18() {
        return over_18;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getSubredditId() {
        return subreddit_id;
    }

    public int getDowns() {
        return downs;
    }

    public String getName() {
        return name;
    }

    public long getCreated() {
        return created;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public long getCreatedUtc() {
        return created_utc;
    }

    public int getUps() {
        return ups;
    }

    public int getNumComments() {
        return num_comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PostData)) {
            return false;
        }

        PostData postData = (PostData) o;

        return !(id != null ? !id.equals(postData.id) : postData.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
