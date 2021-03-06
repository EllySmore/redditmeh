package ellysmore.redditmeh.api.models.Listing;

import ellysmore.redditmeh.api.models.BaseModel;

public class Post extends BaseModel {

    private String kind;

    private PostData data;

    public String getKind() {
        return kind;
    }

    public PostData getData() {
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

        Post post = (Post) o;

        if (data != null ? !data.equals(post.data) : post.data != null) {
            return false;
        }
        if (kind != null ? !kind.equals(post.kind) : post.kind != null) {
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
        return "Child{" +
                "kind='" + kind + '\'' +
                ", data=" + data +
                '}';
    }
}
