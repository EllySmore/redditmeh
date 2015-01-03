package ellysmore.redditmeh.ui.navigation.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.navigation.models.NavItems;

public class RowNavigationExpanded extends RelativeLayout {

    @InjectView(R.id.icon)
    protected ImageView mIcon;

    @InjectView(R.id.title)
    protected TextView mTitle;

    private NavItems mNavItem;

    public RowNavigationExpanded(Context context) {
        this(context, null);
    }

    public RowNavigationExpanded(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RowNavigationExpanded(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.row_navigation_expanded, this);
        ButterKnife.inject(this);
    }

    public void updateUI(NavItems navItem) {
        mIcon.setImageDrawable(getResources().getDrawable(navItem.getIconResId()));
        mTitle.setText(getResources().getString(navItem.getTitleResId()));
    }


}
