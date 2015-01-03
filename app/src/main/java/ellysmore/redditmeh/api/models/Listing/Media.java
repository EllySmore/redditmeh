package ellysmore.redditmeh.api.models.Listing;

import com.google.gson.annotations.Expose;

import ellysmore.redditmeh.api.models.BaseModel;

public class Media extends BaseModel {

    @Expose
    private String type;

    @Expose
    private Oembed oembed;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Oembed getOembed() {
        return oembed;
    }

    public void setOembed(Oembed oembed) {
        this.oembed = oembed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Media media = (Media) o;

        if (oembed != null ? !oembed.equals(media.oembed) : media.oembed != null) {
            return false;
        }
        if (type != null ? !type.equals(media.type) : media.type != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (oembed != null ? oembed.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Media{" +
                "type='" + type + '\'' +
                ", oembed=" + oembed +
                '}';
    }
}
