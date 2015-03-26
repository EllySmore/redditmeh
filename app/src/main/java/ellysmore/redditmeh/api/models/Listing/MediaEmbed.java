package ellysmore.redditmeh.api.models.Listing;

import ellysmore.redditmeh.api.models.BaseModel;

public class MediaEmbed extends BaseModel {

    private String content;

    private int width;

    private boolean scrolling;

    private int height;

    public String getContent() {
        return content;
    }

    public int getWidth() {
        return width;
    }

    public boolean isScrolling() {
        return scrolling;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MediaEmbed that = (MediaEmbed) o;

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
        return "MediaEmbed{" +
                "content='" + content + '\'' +
                ", width=" + width +
                ", scrolling=" + scrolling +
                ", height=" + height +
                '}';
    }
}