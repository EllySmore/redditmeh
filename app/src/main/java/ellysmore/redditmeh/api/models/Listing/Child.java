package ellysmore.redditmeh.api.models.Listing;

import com.google.gson.annotations.Expose;

import ellysmore.redditmeh.api.models.BaseModel;

public class Child extends BaseModel {

    @Expose
    private String kind;

    @Expose
    private Data_ data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data_ getData() {
        return data;
    }

    public void setData(Data_ data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Child child = (Child) o;

        if (data != null ? !data.equals(child.data) : child.data != null) {
            return false;
        }
        if (kind != null ? !kind.equals(child.kind) : child.kind != null) {
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
