package snow.com.viewpagerfragment;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

/**
 * Created by snow on 2017/2/22.
 *      缩放型淡出动画
 */

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;
    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();

        if (position < -1) {
            //这一页是最左边屏幕页
            page.setAlpha(0);

        } else if (position <= 1) {
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                page.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                page.setTranslationX(-horzMargin + vertMargin / 2);
            }

            //开始根据缩放系数变化,(在MIN_SCALE 和1之间变化)
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

            //根据大小 变化透明度实现淡化页面的效果
            page.setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                            (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else {
            //最右边的屏幕页
            page.setAlpha(0);

        }
    }
}
