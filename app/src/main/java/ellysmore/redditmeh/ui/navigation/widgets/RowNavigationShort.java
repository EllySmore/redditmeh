package ellysmore.redditmeh.ui.navigation.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import ellysmore.redditmeh.R;
import ellysmore.redditmeh.ui.navigation.models.NavItems;

public class RowNavigationShort extends RelativeLayout {

    @InjectView(R.id.icon)
    protected ImageView mIcon;

    public RowNavigationShort(Context context) {
        this(context, null);
    }

    public RowNavigationShort(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RowNavigationShort(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.row_navigation_short, this);
        ButterKnife.inject(this);

    }

    public void updateUI(NavItems navItems) {

    }


}
