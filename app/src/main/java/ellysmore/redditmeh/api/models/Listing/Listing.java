package ellysmore.redditmeh.api.models.Listing;

import ellysmore.redditmeh.api.models.BaseModel;

public class Listing extends BaseModel {

    //TODO: Some fields from response come back as different datatype.
    private String kind;

    private Data data;

    public String getKind() {
        return kind;
    }

    public Data getData() {
        return data;
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

        if (data != null ? !data.equals(listing.data) : listing.data != null) {
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
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "kind='" + kind + '\'' +
                ", data=" + data +
                '}';
    }
}
