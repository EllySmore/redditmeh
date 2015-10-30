package ellysmore.redditmeh.api.models.Listing;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ellysmore.redditmeh.api.models.BaseModel;

public class Children extends BaseModel {

    private String modhash;

    @SerializedName("children")
    private List<Post> data;

    private String after;

    private String before;

    public String getModhash() {
        return modhash;
    }

    public List<Post> getPosts() {
        return data;
    }

    public String getAfter() {
        return after;
    }

    public String getBefore() {
        return before;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Children children = (Children) o;

        if (after != null ? !after.equals(children.after) : children.after != null) {
            return false;
        }
        if (before != null ? !before.equals(children.before) : children.before != null) {
            return false;
        }
        if (data != null ? !data.equals(children.data) : children.data != null) {
            return false;
        }
        if (modhash != null ? !modhash.equals(children.modhash) : children.modhash != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = modhash != null ? modhash.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (after != null ? after.hashCode() : 0);
        result = 31 * result + (before != null ? before.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "modhash='" + modhash + '\'' +
                ", children=" + data +
                ", after='" + after + '\'' +
                ", before='" + before + '\'' +
                '}';
    }
}