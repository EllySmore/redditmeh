package ellysmore.redditmeh.util;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

public class RoundedTransformation implements com.squareup.picasso.Transformation {

    private int mAllRadius;

    private int mTopCornerLeftRadius;

    private int mTopCornerRightRadius;

    private int mBottomCornerLeftRadius;

    private int mBottomCornerRightRadius;

    private int mMargin;

    /**
     * Specify radius in DP for all 4 corners and margin space between parent view
     * @param allRadius
     * @param margin
     */
    public RoundedTransformation(int allRadius, int margin) {
        mAllRadius = allRadius;
        mMargin = margin;
    }

    public RoundedTransformation(int topCornerLeftRadius, int topCornerRightRadius,
            int bottomCornerLeftRadius, int bottomCornerRightRadius, int margin) {
        mTopCornerLeftRadius = topCornerLeftRadius;
        mTopCornerRightRadius = topCornerRightRadius;
        mBottomCornerLeftRadius = bottomCornerLeftRadius;
        mBottomCornerRightRadius = bottomCornerRightRadius;
        mMargin = margin;
    }


    @Override
    public Bitmap transform(final Bitmap source) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        Bitmap output = Bitmap
                .createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        canvas.drawRoundRect(
                new RectF(mMargin, mMargin, source.getWidth() - mMargin,
                        source.getHeight() - mMargin),
                mAllRadius, mAllRadius, paint);

        if (source != output) {
            source.recycle();
        }

        return output;
    }

    @Override
    public String key() {
        return "rounded(mAllRadius=" + mAllRadius + ", mMargin=" + mMargin + ")";
    }
}