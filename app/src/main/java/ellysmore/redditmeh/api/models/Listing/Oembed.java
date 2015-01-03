package ellysmore.redditmeh.api.models.Listing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ellysmore.redditmeh.api.models.BaseModel;

public class Oembed extends BaseModel {

    @SerializedName("provider_url")
    @Expose
    private String providerUrl;

    @Expose
    private String description;

    @Expose
    private String title;

    @SerializedName("thumbnail_width")
    @Expose
    private int thumbnailWidth;

    @Expose
    private int height;

    @Expose
    private int width;

    @Expose
    private String html;

    @Expose
    private String version;

    @SerializedName("provider_name")
    @Expose
    private String providerName;

    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;

    @Expose
    private String type;

    @SerializedName("thumbnail_height")
    @Expose
    private int thumbnailHeight;

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(int thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(int thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Oembed oembed = (Oembed) o;

        if (height != oembed.height) {
            return false;
        }
        if (thumbnailHeight != oembed.thumbnailHeight) {
            return false;
        }
        if (thumbnailWidth != oembed.thumbnailWidth) {
            return false;
        }
        if (width != oembed.width) {
            return false;
        }
        if (description != null ? !description.equals(oembed.description)
                : oembed.description != null) {
            return false;
        }
        if (html != null ? !html.equals(oembed.html) : oembed.html != null) {
            return false;
        }
        if (providerName != null ? !providerName.equals(oembed.providerName)
                : oembed.providerName != null) {
            return false;
        }
        if (providerUrl != null ? !providerUrl.equals(oembed.providerUrl)
                : oembed.providerUrl != null) {
            return false;
        }
        if (thumbnailUrl != null ? !thumbnailUrl.equals(oembed.thumbnailUrl)
                : oembed.thumbnailUrl != null) {
            return false;
        }
        if (title != null ? !title.equals(oembed.title) : oembed.title != null) {
            return false;
        }
        if (type != null ? !type.equals(oembed.type) : oembed.type != null) {
            return false;
        }
        if (version != null ? !version.equals(oembed.version) : oembed.version != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = providerUrl != null ? providerUrl.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + thumbnailWidth;
        result = 31 * result + height;
        result = 31 * result + width;
        result = 31 * result + (html != null ? html.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (providerName != null ? providerName.hashCode() : 0);
        result = 31 * result + (thumbnailUrl != null ? thumbnailUrl.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + thumbnailHeight;
        return result;
    }

    @Override
    public String toString() {
        return "Oembed{" +
                "providerUrl='" + providerUrl + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", thumbnailWidth=" + thumbnailWidth +
                ", height=" + height +
                ", width=" + width +
                ", html='" + html + '\'' +
                ", version='" + version + '\'' +
                ", providerName='" + providerName + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", type='" + type + '\'' +
                ", thumbnailHeight=" + thumbnailHeight +
                '}';
    }
}
