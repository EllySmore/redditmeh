package ellysmore.redditmeh.ui.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ellysmore.redditmeh.R;

public class FlatButton extends RelativeLayout {

    @BindView(R.id.icon)
    protected ImageView mIcon;

    @BindView(R.id.text)
    protected TextView mText;

    public FlatButton(Context context) {
        this(context, null);
    }

    public FlatButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlatButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.button, this);
        ButterKnife.bind(this);
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.FlatButton, 0, 0);
        int iconResId = attributes.getResourceId(R.styleable.FlatButton_leftIcon, 0);
        ColorStateList textColorResId = attributes.getColorStateList(
                R.styleable.FlatButton_textColor);
        int backgroundResId = attributes.getResourceId(R.styleable.FlatButton_backgroundColor,
                getResources().getColor(android.R.color.transparent));

        //If there is no icon
        if (iconResId != 0) {
            mIcon.setVisibility(View.VISIBLE);
            mIcon.setImageDrawable(getResources().getDrawable(iconResId));
        } else {
            mIcon.setVisibility(View.GONE);
        }

        if (textColorResId != null) {
            mText.setTextColor(textColorResId);
        }

        setBackgroundResource(backgroundResId);

        attributes.recycle();
    }

    public void setText(String text) {
        mText.setText(text);
    }

}
