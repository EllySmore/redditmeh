package ellysmore.redditmeh.api.models.Listing;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import ellysmore.redditmeh.api.models.BaseModel;

public class PostData extends BaseModel {

    private String id;

    private String domain;

    private MediaEmbed media_embed;

    private String subreddit;

    private Media secure_media;

    private MediaEmbed secure_media_embed;

    private String author;

    private Media media;

    private int score;

    private String approved_by;

    private boolean over_18;

    private boolean hidden;

    private String thumbnail;

    private String subreddit_id;

    private JsonElement edited;

    private int downs;

    private String name;

    private String permalink;

    private long created;

    private String url;

    private String title;

    private long created_utc;

    private int ups;

    private int num_comments;

    private boolean visited;

    private int num_reports;

    public String getDomain() {
        return domain;
    }

    public MediaEmbed getMediaEmbed() {
        return media_embed;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public Media getSecureMedia() {
        return secure_media;
    }

    public MediaEmbed getSecureMediaEmbed() {
        return secure_media_embed;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public Media getMedia() {
        return media;
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

    public boolean isHidden() {
        return hidden;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getSubredditId() {
        return subreddit_id;
    }

    public Boolean getEdited() {
        Boolean isEdited = false;
        if (edited.isJsonPrimitive()) {
            JsonPrimitive object = edited.getAsJsonPrimitive();
            if (object.isNumber()) {
                long value = object.getAsLong();
            } else if (object.isBoolean()) {
                isEdited = object.getAsBoolean();
            }
        }
        return isEdited;
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

    @Override
    public String toString() {
        return "PostData{" +
                "id='" + id + '\'' +
                ", domain='" + domain + '\'' +
                ", media_embed=" + media_embed +
                ", subreddit='" + subreddit + '\'' +
                ", secure_media=" + secure_media +
                ", secure_media_embed=" + secure_media_embed +
                ", author='" + author + '\'' +
                ", media=" + media +
                ", score=" + score +
                ", approved_by='" + approved_by + '\'' +
                ", over_18=" + over_18 +
                ", hidden=" + hidden +
                ", thumbnail='" + thumbnail + '\'' +
                ", subreddit_id='" + subreddit_id + '\'' +
                ", edited=" + edited +
                ", downs=" + downs +
                ", name='" + name + '\'' +
                ", permalink='" + permalink + '\'' +
                ", created=" + created +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", created_utc=" + created_utc +
                ", ups=" + ups +
                ", num_comments=" + num_comments +
                ", visited=" + visited +
                ", num_reports=" + num_reports +
                '}';
    }
}
