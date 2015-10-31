package ellysmore.redditmeh.api.models.Listing;

import com.google.gson.annotations.SerializedName;

import ellysmore.redditmeh.api.models.BaseModel;

/**
 * Top parent data
 */
public class Listing extends BaseModel {

    private String kind;

    @SerializedName("data")
    private Children children;

    public String getKind() {
        return kind;
    }

    public Children getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Listing listing = (Listing) o;

        if (children != null ? !children.equals(listing.children) : listing.children != null) {
            return false;
        }
        if (kind != null ? !kind.equals(listing.kind) : listing.kind != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = kind != null ? kind.hashCode() : 0;
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "kind='" + kind + '\'' +
                ", data=" + children +
                '}';
    }
}
