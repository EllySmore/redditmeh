package ellysmore.redditmeh.ui.models;

public enum ListingType {

    HOT("hot"),
    RISING("rising"),
    NEW("new"),
    CONTROVERSIAL("controversial"),
    TOP("top"),
    GILDED("gilded"),
    PROMOTED("ads");

    private final String path;

    ListingType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    public static ListingType getType(String value) {
        for (ListingType type : values()) {
            if (type.toString().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No such type with value: " + value);
    }

}
