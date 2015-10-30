package ellysmore.redditmeh.ui.models;

import ellysmore.redditmeh.R;

public enum SubredditType {

    FRONT_PAGE("", R.drawable.nav_front_page, R.string.front_page),
    AWW("r/aww", R.drawable.nav_cat, R.string.aww),
    FUNNY("r/funny", R.drawable.nav_funny, R.string.funny),
    PICS("r/pics", R.drawable.nav_pics, R.string.pics),
    PROGRAMMING("r/programming", R.drawable.nav_programming, R.string.programming),
    SHOWER_THOUGHTS("r/showerthoughts", R.drawable.nav_shower_thoughts, R.string.shower_thoughts),;

    private final int mTitleResId;

    private String path;

    private int mIconResId;

    SubredditType(String path, int iconResId, int titleResId) {
        this.path = path;
        this.mIconResId = iconResId;
        this.mTitleResId = titleResId;
    }

    public String getPath() {
        return path;
    }

    public int getIconResId() {
        return mIconResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    public static SubredditType getType(String value) {
        for (SubredditType type : values()) {
            if (type.toString().equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No such type with value: " + value);
    }

    public String getFormattedUrl(ListingType type){
        return String.format("%s/%s", getPath(), type.toString());
    }
}
