package ellysmore.redditmeh.api.models.Listing;

import com.google.gson.annotations.Expose;

import ellysmore.redditmeh.api.models.BaseModel;

public class SecureMediaEmbed extends BaseModel {

    @Expose
    private String content;

    @Expose
    private int width;

    @Expose
    private boolean scrolling;

    @Expose
    private int height;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SecureMediaEmbed that = (SecureMediaEmbed) o;

        if (height != that.height) {
            return false;
        }
        if (scrolling != that.scrolling) {
            return false;
        }
        if (width != that.width) {
            return false;
        }
        if (content != null ? !content.equals(that.content) : that.content != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + width;
        result = 31 * result + (scrolling ? 1 : 0);
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "SecureMediaEmbed{" +
                "content='" + content + '\'' +
                ", width=" + width +
                ", scrolling=" + scrolling +
                ", height=" + height +
                '}';
    }
}