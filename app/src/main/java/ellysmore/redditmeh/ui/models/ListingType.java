package ellysmore.redditmeh.ui.models;

public enum ListingType {

    HOT, RISING, NEW, CONTROVERSIAL, TOP, GILDED, WIKI, PROMOTED;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
