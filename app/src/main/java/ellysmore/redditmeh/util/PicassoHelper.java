package ellysmore.redditmeh.util;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.widget.ImageView;

import ellysmore.redditmeh.R;

public class PicassoHelper {

    private static final int placeHolderResId = R.drawable.redditplaceholder;

    public static void loadImage(ImageView iv, Context context, String url) {
        if (url == null || url.isEmpty()) {
            Picasso.with(context).load(placeHolderResId).transform(new RoundedTransformation(4, 0))
                    .fit().into(iv);
        } else {
            Picasso.with(context).load(url).transform(new RoundedTransformation(4, 0))
                    .fit().into(iv);
        }
    }

    public static void loadImage(ImageView iv, Context context, int drawableResId) {
        Picasso.with(context).load(drawableResId).transform(new RoundedTransformation(4, 0))
                .fit().into(iv);
    }
}
