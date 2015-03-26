package ellysmore.redditmeh.api.models.Listing;

import ellysmore.redditmeh.api.models.BaseModel;

public class Oembed extends BaseModel {

    private String provider_url;

    private String description;

    private String title;

    private int thumbnail_width;

    private int height;

    private int width;

    private String html;

    private String version;

    private String provider_name;

    private String thumbnail_url;

    private String type;

    private int thumbnail_height;

    public String getProviderUrl() {
        return provider_url;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getThumbnailWidth() {
        return thumbnail_width;
    }

    public int getWidth() {
        return width;
    }

    public String getHtml() {
        return html;
    }

    public String getVersion() {
        return version;
    }

    public String getProviderName() {
        return provider_name;
    }

    public String getThumbnailUrl() {
        return thumbnail_url;
    }

    public String getType() {
        return type;
    }

    public int getThumbnailHeight() {
        return thumbnail_height;
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
        if (thumbnail_height != oembed.thumbnail_height) {
            return false;
        }
        if (thumbnail_width != oembed.thumbnail_width) {
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
        if (provider_name != null ? !provider_name.equals(oembed.provider_name)
                : oembed.provider_name != null) {
            return false;
        }
        if (provider_url != null ? !provider_url.equals(oembed.provider_url)
                : oembed.provider_url != null) {
            return false;
        }
        if (thumbnail_url != null ? !thumbnail_url.equals(oembed.thumbnail_url)
                : oembed.thumbnail_url != null) {
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
        int result = provider_url != null ? provider_url.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + thumbnail_width;
        result = 31 * result + height;
        result = 31 * result + width;
        result = 31 * result + (html != null ? html.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (provider_name != null ? provider_name.hashCode() : 0);
        result = 31 * result + (thumbnail_url != null ? thumbnail_url.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + thumbnail_height;
        return result;
    }

    @Override
    public String toString() {
        return "Oembed{" +
                "provider_url='" + provider_url + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", thumbnail_width=" + thumbnail_width +
                ", height=" + height +
                ", width=" + width +
                ", html='" + html + '\'' +
                ", version='" + version + '\'' +
                ", provider_name='" + provider_name + '\'' +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", type='" + type + '\'' +
                ", thumbnail_height=" + thumbnail_height +
                '}';
    }
}
