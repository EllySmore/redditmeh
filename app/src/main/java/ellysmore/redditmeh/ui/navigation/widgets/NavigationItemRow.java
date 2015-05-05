package ellysmore.redditmeh.ui.navigation.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.navigation.models.NavItems;

public class NavigationItemRow extends RelativeLayout implements Checkable {

    @InjectView(R.id.icon)
    protected ImageView mIcon;

    @InjectView(R.id.title)
    protected TextView mTitle;

    private NavItems mNavItem;

    public NavigationItemRow(Context context) {
        this(context, null);
    }

    public NavigationItemRow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NavigationItemRow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.row_navigation, this);
        ButterKnife.inject(this);
    }

    public void updateUI(NavItems navItem) {
        mIcon.setImageDrawable(getResources().getDrawable(navItem.getIconResId()));
        mTitle.setText(getResources().getString(navItem.getTitleResId()));
    }

    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public void setChecked(boolean checked) {
        if (checked) {
            setBackgroundColor(getResources().getColor(R.color.c1_2));
        } else {
            setBackgroundColor(getResources().getColor(R.color.c1_3));
        }
    }

    @Override
    public void toggle() {
        //noop
    }
}
