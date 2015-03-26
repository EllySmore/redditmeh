package ellysmore.redditmeh.api.models.Listing;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import ellysmore.redditmeh.api.models.BaseModel;

public class Data_ extends BaseModel {

    private String domain;

    private String bannedBy;

    private MediaEmbed media_embed;

    private String subreddit;

    private String selftext_html;

    private String selftext;

    private Media secure_media;

    private MediaEmbed secure_media_embed;

    private String link_flair_text;

    private String id;

    private int gilded;

    private boolean clicked;

    private String author;

    private Media media;

    private int score;

    private String approved_by;

    private boolean over_18;

    private boolean hidden;

    private String thumbnail;

    private String subreddit_id;

    private JsonElement edited;

    private String link_flair_css_class;

    private String author_flair_css_class;

    private int downs;

    private boolean saved;

    private boolean is_self;

    private String name;

    private String permalink;

    private boolean stickied;

    private float created;

    private String url;

    private String author_flair_text;

    private String title;

    private float created_utc;

    private int ups;

    private int num_comments;

    private boolean visited;

    private int num_reports;

    public String getDomain() {
        return domain;
    }

    public String getBannedBy() {
        return bannedBy;
    }

    public MediaEmbed getMediaEmbed() {
        return media_embed;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public String getSelftextHtml() {
        return selftext_html;
    }

    public String getSelftext() {
        return selftext;
    }

    public Media getSecureMedia() {
        return secure_media;
    }

    public MediaEmbed getSecureMediaEmbed() {
        return secure_media_embed;
    }

    public String getLinkFlairText() {
        return link_flair_text;
    }

    public String getId() {
        return id;
    }

    public int getGilded() {
        return gilded;
    }

    public boolean isClicked() {
        return clicked;
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

    public String getLinkFlairCssClass() {
        return link_flair_css_class;
    }

    public String getAuthorFlairCssClass() {
        return author_flair_css_class;
    }

    public int getDowns() {
        return downs;
    }

    public boolean isSaved() {
        return saved;
    }

    public boolean isSelf() {
        return is_self;
    }

    public String getName() {
        return name;
    }

    public String getPermalink() {
        return permalink;
    }

    public boolean isStickied() {
        return stickied;
    }

    public float getCreated() {
        return created;
    }

    public String getUrl() {
        return url;
    }

    public String getAuthorFlairText() {
        return author_flair_text;
    }

    public String getTitle() {
        return title;
    }

    public float getCreatedUtc() {
        return created_utc;
    }

    public int getUps() {
        return ups;
    }

    public int getNumComments() {
        return num_comments;
    }

    public boolean isVisited() {
        return visited;
    }

    public int getNumReports() {
        return num_reports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Data_ data_ = (Data_) o;

        if (clicked != data_.clicked) {
            return false;
        }
        if (Float.compare(data_.created, created) != 0) {
            return false;
        }
        if (Float.compare(data_.created_utc, created_utc) != 0) {
            return false;
        }
        if (downs != data_.downs) {
            return false;
        }
        if (edited != data_.edited) {
            return false;
        }
        if (gilded != data_.gilded) {
            return false;
        }
        if (hidden != data_.hidden) {
            return false;
        }
        if (is_self != data_.is_self) {
            return false;
        }
        if (num_comments != data_.num_comments) {
            return false;
        }
        if (num_reports != data_.num_reports) {
            return false;
        }
        if (over_18 != data_.over_18) {
            return false;
        }
        if (saved != data_.saved) {
            return false;
        }
        if (score != data_.score) {
            return false;
        }
        if (stickied != data_.stickied) {
            return false;
        }
        if (ups != data_.ups) {
            return false;
        }
        if (visited != data_.visited) {
            return false;
        }
        if (approved_by != null ? !approved_by.equals(data_.approved_by)
                : data_.approved_by != null) {
            return false;
        }
        if (author != null ? !author.equals(data_.author) : data_.author != null) {
            return false;
        }
        if (author_flair_css_class != null ? !author_flair_css_class
                .equals(data_.author_flair_css_class)
                : data_.author_flair_css_class != null) {
            return false;
        }
        if (author_flair_text != null ? !author_flair_text.equals(data_.author_flair_text)
                : data_.author_flair_text != null) {
            return false;
        }
        if (bannedBy != null ? !bannedBy.equals(data_.bannedBy) : data_.bannedBy != null) {
            return false;
        }
        if (domain != null ? !domain.equals(data_.domain) : data_.domain != null) {
            return false;
        }
        if (id != null ? !id.equals(data_.id) : data_.id != null) {
            return false;
        }
        if (link_flair_css_class != null ? !link_flair_css_class.equals(data_.link_flair_css_class)
                : data_.link_flair_css_class != null) {
            return false;
        }
        if (link_flair_text != null ? !link_flair_text.equals(data_.link_flair_text)
                : data_.link_flair_text != null) {
            return false;
        }
        if (media != null ? !media.equals(data_.media) : data_.media != null) {
            return false;
        }
        if (media_embed != null ? !media_embed.equals(data_.media_embed)
                : data_.media_embed != null) {
            return false;
        }
        if (name != null ? !name.equals(data_.name) : data_.name != null) {
            return false;
        }
        if (permalink != null ? !permalink.equals(data_.permalink) : data_.permalink != null) {
            return false;
        }
        if (secure_media != null ? !secure_media.equals(data_.secure_media)
                : data_.secure_media != null) {
            return false;
        }
        if (secure_media_embed != null ? !secure_media_embed.equals(data_.secure_media_embed)
                : data_.secure_media_embed != null) {
            return false;
        }
        if (selftext != null ? !selftext.equals(data_.selftext) : data_.selftext != null) {
            return false;
        }
        if (selftext_html != null ? !selftext_html.equals(data_.selftext_html)
                : data_.selftext_html != null) {
            return false;
        }
        if (subreddit != null ? !subreddit.equals(data_.subreddit) : data_.subreddit != null) {
            return false;
        }
        if (subreddit_id != null ? !subreddit_id.equals(data_.subreddit_id)
                : data_.subreddit_id != null) {
            return false;
        }
        if (thumbnail != null ? !thumbnail.equals(data_.thumbnail) : data_.thumbnail != null) {
            return false;
        }
        if (title != null ? !title.equals(data_.title) : data_.title != null) {
            return false;
        }
        if (url != null ? !url.equals(data_.url) : data_.url != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = domain != null ? domain.hashCode() : 0;
        result = 31 * result + (bannedBy != null ? bannedBy.hashCode() : 0);
        result = 31 * result + (media_embed != null ? media_embed.hashCode() : 0);
        result = 31 * result + (subreddit != null ? subreddit.hashCode() : 0);
        result = 31 * result + (selftext_html != null ? selftext_html.hashCode() : 0);
        result = 31 * result + (selftext != null ? selftext.hashCode() : 0);
        result = 31 * result + (secure_media != null ? secure_media.hashCode() : 0);
        result = 31 * result + (secure_media_embed != null ? secure_media_embed.hashCode() : 0);
        result = 31 * result + (link_flair_text != null ? link_flair_text.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + gilded;
        result = 31 * result + (clicked ? 1 : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (media != null ? media.hashCode() : 0);
        result = 31 * result + score;
        result = 31 * result + (approved_by != null ? approved_by.hashCode() : 0);
        result = 31 * result + (over_18 ? 1 : 0);
        result = 31 * result + (hidden ? 1 : 0);
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (subreddit_id != null ? subreddit_id.hashCode() : 0);
        result = 31 * result + (edited != null ? edited.hashCode() : 0);
        result = 31 * result + (link_flair_css_class != null ? link_flair_css_class.hashCode() : 0);
        result = 31 * result + (author_flair_css_class != null ? author_flair_css_class.hashCode()
                : 0);
        result = 31 * result + downs;
        result = 31 * result + (saved ? 1 : 0);
        result = 31 * result + (is_self ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (permalink != null ? permalink.hashCode() : 0);
        result = 31 * result + (stickied ? 1 : 0);
        result = 31 * result + (created != +0.0f ? Float.floatToIntBits(created) : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (author_flair_text != null ? author_flair_text.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (created_utc != +0.0f ? Float.floatToIntBits(created_utc) : 0);
        result = 31 * result + ups;
        result = 31 * result + num_comments;
        result = 31 * result + (visited ? 1 : 0);
        result = 31 * result + num_reports;
        return result;
    }

    @Override
    public String toString() {
        return "Data_{" +
                "domain='" + domain + '\'' +
                ", bannedBy='" + bannedBy + '\'' +
                ", media_embed=" + media_embed +
                ", subreddit='" + subreddit + '\'' +
                ", selftext_html='" + selftext_html + '\'' +
                ", selftext='" + selftext + '\'' +
                ", secure_media=" + secure_media +
                ", secure_media_embed=" + secure_media_embed +
                ", link_flair_text='" + link_flair_text + '\'' +
                ", id='" + id + '\'' +
                ", gilded=" + gilded +
                ", clicked=" + clicked +
                ", author='" + author + '\'' +
                ", media=" + media +
                ", score=" + score +
                ", approved_by='" + approved_by + '\'' +
                ", over_18=" + over_18 +
                ", hidden=" + hidden +
                ", thumbnail='" + thumbnail + '\'' +
                ", subreddit_id='" + subreddit_id + '\'' +
                ", edited=" + edited +
                ", link_flair_css_class='" + link_flair_css_class + '\'' +
                ", author_flair_css_class='" + author_flair_css_class + '\'' +
                ", downs=" + downs +
                ", saved=" + saved +
                ", is_self=" + is_self +
                ", name='" + name + '\'' +
                ", permalink='" + permalink + '\'' +
                ", stickied=" + stickied +
                ", created=" + created +
                ", url='" + url + '\'' +
                ", author_flair_text='" + author_flair_text + '\'' +
                ", title='" + title + '\'' +
                ", created_utc=" + created_utc +
                ", ups=" + ups +
                ", num_comments=" + num_comments +
                ", visited=" + visited +
                ", num_reports=" + num_reports +
                '}';
    }
}
