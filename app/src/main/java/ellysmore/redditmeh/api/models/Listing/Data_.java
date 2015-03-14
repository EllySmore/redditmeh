package ellysmore.redditmeh.api.models.Listing;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ellysmore.redditmeh.api.models.BaseModel;

public class Data_ extends BaseModel {

    @Expose
    private String domain;

    @Expose
    private String bannedBy;

    @SerializedName("media_embed")
    @Expose
    private MediaEmbed mediaEmbed;

    @Expose
    private String subreddit;

    @SerializedName("selftext_html")
    @Expose
    private String selftextHtml;

    @Expose
    private String selftext;

    @SerializedName("secure_media")
    @Expose
    private SecureMedia secureMedia;


    @SerializedName("secure_media_embed")
    @Expose
    private SecureMediaEmbed secureMediaEmbed;

    @SerializedName("link_flair_text")
    @Expose
    private String linkFlairText;

    @Expose
    private String id;

    @Expose
    private int gilded;

    @Expose
    private boolean clicked;

    @Expose
    private String author;

    @Expose
    private Media media;

    @Expose
    private int score;

    @SerializedName("approved_by")
    @Expose
    private String approvedBy;

    @SerializedName("over_18")
    @Expose
    private boolean over18;

    @Expose
    private boolean hidden;

    @Expose
    private String thumbnail;

    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;

    @Expose
    private JsonElement edited;

    @SerializedName("link_flair_css_class")
    @Expose
    private String linkFlairCssClass;

    @SerializedName("author_flair_css_class")
    @Expose
    private String authorFlairCssClass;

    @Expose
    private int downs;

    @Expose
    private boolean saved;

    @SerializedName("is_self")
    @Expose
    private boolean isSelf;

    @Expose
    private String name;

    @Expose
    private String permalink;

    @Expose
    private boolean stickied;

    @Expose
    private float created;

    @Expose
    private String url;

    @SerializedName("author_flair_text")
    @Expose
    private String authorFlairText;

    @Expose
    private String title;

    @SerializedName("created_utc")
    @Expose
    private float createdUtc;

    @Expose
    private int ups;

    @SerializedName("num_comments")
    @Expose
    private int numComments;

    @Expose
    private boolean visited;

    @SerializedName("num_reports")
    @Expose
    private int numReports;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getBannedBy() {
        return bannedBy;
    }

    public void setBannedBy(String bannedBy) {
        this.bannedBy = bannedBy;
    }

    public MediaEmbed getMediaEmbed() {
        return mediaEmbed;
    }

    public void setMediaEmbed(MediaEmbed mediaEmbed) {
        this.mediaEmbed = mediaEmbed;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getSelftextHtml() {
        return selftextHtml;
    }

    public void setSelftextHtml(String selftextHtml) {
        this.selftextHtml = selftextHtml;
    }

    public String getSelftext() {
        return selftext;
    }

    public void setSelftext(String selftext) {
        this.selftext = selftext;
    }

    public SecureMedia getSecureMedia() {
        return secureMedia;
    }

    public void setSecureMedia(SecureMedia secureMedia) {
        this.secureMedia = secureMedia;
    }

    public SecureMediaEmbed getSecureMediaEmbed() {
        return secureMediaEmbed;
    }

    public void setSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
        this.secureMediaEmbed = secureMediaEmbed;
    }

    public String getLinkFlairText() {
        return linkFlairText;
    }

    public void setLinkFlairText(String linkFlairText) {
        this.linkFlairText = linkFlairText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGilded() {
        return gilded;
    }

    public void setGilded(int gilded) {
        this.gilded = gilded;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public boolean isOver18() {
        return over18;
    }

    public void setOver18(boolean over18) {
        this.over18 = over18;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
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

    public void setEdited(JsonElement edited) {
        this.edited = edited;
    }

    public String getLinkFlairCssClass() {
        return linkFlairCssClass;
    }

    public void setLinkFlairCssClass(String linkFlairCssClass) {
        this.linkFlairCssClass = linkFlairCssClass;
    }

    public String getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    public void setAuthorFlairCssClass(String authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    public int getDowns() {
        return downs;
    }

    public void setDowns(int downs) {
        this.downs = downs;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isSelf() {
        return isSelf;
    }

    public void setSelf(boolean isSelf) {
        this.isSelf = isSelf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public boolean isStickied() {
        return stickied;
    }

    public void setStickied(boolean stickied) {
        this.stickied = stickied;
    }

    public float getCreated() {
        return created;
    }

    public void setCreated(float created) {
        this.created = created;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(String authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(float createdUtc) {
        this.createdUtc = createdUtc;
    }

    public int getUps() {
        return ups;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }

    public int getNumComments() {
        return numComments;
    }

    public void setNumComments(int numComments) {
        this.numComments = numComments;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getNumReports() {
        return numReports;
    }

    public void setNumReports(int numReports) {
        this.numReports = numReports;
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
        if (Float.compare(data_.createdUtc, createdUtc) != 0) {
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
        if (isSelf != data_.isSelf) {
            return false;
        }
        if (numComments != data_.numComments) {
            return false;
        }
        if (numReports != data_.numReports) {
            return false;
        }
        if (over18 != data_.over18) {
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
        if (approvedBy != null ? !approvedBy.equals(data_.approvedBy) : data_.approvedBy != null) {
            return false;
        }
        if (author != null ? !author.equals(data_.author) : data_.author != null) {
            return false;
        }
        if (authorFlairCssClass != null ? !authorFlairCssClass.equals(data_.authorFlairCssClass)
                : data_.authorFlairCssClass != null) {
            return false;
        }
        if (authorFlairText != null ? !authorFlairText.equals(data_.authorFlairText)
                : data_.authorFlairText != null) {
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
        if (linkFlairCssClass != null ? !linkFlairCssClass.equals(data_.linkFlairCssClass)
                : data_.linkFlairCssClass != null) {
            return false;
        }
        if (linkFlairText != null ? !linkFlairText.equals(data_.linkFlairText)
                : data_.linkFlairText != null) {
            return false;
        }
        if (media != null ? !media.equals(data_.media) : data_.media != null) {
            return false;
        }
        if (mediaEmbed != null ? !mediaEmbed.equals(data_.mediaEmbed) : data_.mediaEmbed != null) {
            return false;
        }
        if (name != null ? !name.equals(data_.name) : data_.name != null) {
            return false;
        }
        if (permalink != null ? !permalink.equals(data_.permalink) : data_.permalink != null) {
            return false;
        }
        if (secureMedia != null ? !secureMedia.equals(data_.secureMedia)
                : data_.secureMedia != null) {
            return false;
        }
        if (secureMediaEmbed != null ? !secureMediaEmbed.equals(data_.secureMediaEmbed)
                : data_.secureMediaEmbed != null) {
            return false;
        }
        if (selftext != null ? !selftext.equals(data_.selftext) : data_.selftext != null) {
            return false;
        }
        if (selftextHtml != null ? !selftextHtml.equals(data_.selftextHtml)
                : data_.selftextHtml != null) {
            return false;
        }
        if (subreddit != null ? !subreddit.equals(data_.subreddit) : data_.subreddit != null) {
            return false;
        }
        if (subredditId != null ? !subredditId.equals(data_.subredditId)
                : data_.subredditId != null) {
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
        result = 31 * result + (mediaEmbed != null ? mediaEmbed.hashCode() : 0);
        result = 31 * result + (subreddit != null ? subreddit.hashCode() : 0);
        result = 31 * result + (selftextHtml != null ? selftextHtml.hashCode() : 0);
        result = 31 * result + (selftext != null ? selftext.hashCode() : 0);
        result = 31 * result + (secureMedia != null ? secureMedia.hashCode() : 0);
        result = 31 * result + (secureMediaEmbed != null ? secureMediaEmbed.hashCode() : 0);
        result = 31 * result + (linkFlairText != null ? linkFlairText.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + gilded;
        result = 31 * result + (clicked ? 1 : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (media != null ? media.hashCode() : 0);
        result = 31 * result + score;
        result = 31 * result + (approvedBy != null ? approvedBy.hashCode() : 0);
        result = 31 * result + (over18 ? 1 : 0);
        result = 31 * result + (hidden ? 1 : 0);
        result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
        result = 31 * result + (subredditId != null ? subredditId.hashCode() : 0);
        result = 31 * result + (edited != null ? edited.hashCode() : 0);
        result = 31 * result + (linkFlairCssClass != null ? linkFlairCssClass.hashCode() : 0);
        result = 31 * result + (authorFlairCssClass != null ? authorFlairCssClass.hashCode() : 0);
        result = 31 * result + downs;
        result = 31 * result + (saved ? 1 : 0);
        result = 31 * result + (isSelf ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (permalink != null ? permalink.hashCode() : 0);
        result = 31 * result + (stickied ? 1 : 0);
        result = 31 * result + (created != +0.0f ? Float.floatToIntBits(created) : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (authorFlairText != null ? authorFlairText.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (createdUtc != +0.0f ? Float.floatToIntBits(createdUtc) : 0);
        result = 31 * result + ups;
        result = 31 * result + numComments;
        result = 31 * result + (visited ? 1 : 0);
        result = 31 * result + numReports;
        return result;
    }

    @Override
    public String toString() {
        return "Data_{" +
                "domain='" + domain + '\'' +
                ", bannedBy='" + bannedBy + '\'' +
                ", mediaEmbed=" + mediaEmbed +
                ", subreddit='" + subreddit + '\'' +
                ", selftextHtml='" + selftextHtml + '\'' +
                ", selftext='" + selftext + '\'' +
                ", secureMedia=" + secureMedia +
                ", secureMediaEmbed=" + secureMediaEmbed +
                ", linkFlairText='" + linkFlairText + '\'' +
                ", id='" + id + '\'' +
                ", gilded=" + gilded +
                ", clicked=" + clicked +
                ", author='" + author + '\'' +
                ", media=" + media +
                ", score=" + score +
                ", approvedBy='" + approvedBy + '\'' +
                ", over18=" + over18 +
                ", hidden=" + hidden +
                ", thumbnail='" + thumbnail + '\'' +
                ", subredditId='" + subredditId + '\'' +
                ", edited=" + edited +
                ", linkFlairCssClass='" + linkFlairCssClass + '\'' +
                ", authorFlairCssClass='" + authorFlairCssClass + '\'' +
                ", downs=" + downs +
                ", saved=" + saved +
                ", isSelf=" + isSelf +
                ", name='" + name + '\'' +
                ", permalink='" + permalink + '\'' +
                ", stickied=" + stickied +
                ", created=" + created +
                ", url='" + url + '\'' +
                ", authorFlairText='" + authorFlairText + '\'' +
                ", title='" + title + '\'' +
                ", createdUtc=" + createdUtc +
                ", ups=" + ups +
                ", numComments=" + numComments +
                ", visited=" + visited +
                ", numReports=" + numReports +
                '}';
    }
}
