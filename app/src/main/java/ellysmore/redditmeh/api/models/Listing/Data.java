package ellysmore.redditmeh.api.models.Listing;

import java.util.ArrayList;
import java.util.List;

import ellysmore.redditmeh.api.models.BaseModel;

public class Data extends BaseModel {

    private String modhash;

    private List<Child> children = new ArrayList<Child>();

    private String after;

    private String before;

    public String getModhash() {
        return modhash;
    }

    public List<Child> getChildren() {
        return children;
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

        Data data = (Data) o;

        if (after != null ? !after.equals(data.after) : data.after != null) {
            return false;
        }
        if (before != null ? !before.equals(data.before) : data.before != null) {
            return false;
        }
        if (children != null ? !children.equals(data.children) : data.children != null) {
            return false;
        }
        if (modhash != null ? !modhash.equals(data.modhash) : data.modhash != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = modhash != null ? modhash.hashCode() : 0;
        result = 31 * result + (children != null ? children.hashCode() : 0);
        result = 31 * result + (after != null ? after.hashCode() : 0);
        result = 31 * result + (before != null ? before.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "modhash='" + modhash + '\'' +
                ", children=" + children +
                ", after='" + after + '\'' +
                ", before='" + before + '\'' +
                '}';
    }
}