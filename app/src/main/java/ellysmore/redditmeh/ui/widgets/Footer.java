package ellysmore.redditmeh.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ellysmore.redditmeh.R;

public class Footer extends RelativeLayout {

    @BindView(R.id.progress_bar)
    protected ProgressBar mProgressBar;

    @BindView(R.id.idle_image)
    protected ImageView mImage;

    public Footer(Context context) {
        this(context, null);
    }

    public Footer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Footer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.row_footer, this);
        ButterKnife.bind(this);
    }

    public void showLoading() {
        mProgressBar.setVisibility(VISIBLE);
        mImage.setVisibility(INVISIBLE);
    }

    public void hideLoading() {
        mProgressBar.setVisibility(INVISIBLE);
        mImage.setVisibility(VISIBLE);
    }

}
