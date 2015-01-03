package ellysmore.redditmeh.ui.navigation.models;

import ellysmore.redditmeh.R;

public enum NavItems {

    FRONT_PAGE(R.string.front_page, R.drawable.nav_front_page),
    AWW(R.string.aww, R.drawable.nav_cat),
    FUNNY(R.string.funny, R.drawable.nav_funny),
    PICS(R.string.pics, R.drawable.nav_pics),
    PROGRAMMING(R.string.programming, R.drawable.nav_programming),
    SHOWER_THOUGHTS(R.string.shower_thoughts, R.drawable.nav_shower_thoughts),;

    private int mTitleResId;

    private int mIconResId;

    NavItems(int stringResId, int iconResId) {
        this.mTitleResId = stringResId;
        this.mIconResId = iconResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getIconResId() {
        return mIconResId;
    }
}
