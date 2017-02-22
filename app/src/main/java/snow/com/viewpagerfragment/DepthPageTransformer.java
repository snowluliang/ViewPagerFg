package snow.com.viewpagerfragment;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 *
 * Created by snow on 2017/2/22.
 */

public class DepthPageTransformer implements ViewPager.PageTransformer{

    private static final float MIN_SCAle = 0.75f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        if (position < -1) {
            //表示最左边的屏幕页
            page.setAlpha(1);

        } else if (position <= 0) {
            //向左滑屏使用默认的过渡动画
            page.setAlpha(1);
            page.setTranslationX(0);
            page.setScaleX(1);
            page.setScaleY(1);
        } else if (position <= 1) {
            //淡出页面
            page.setAlpha(1 - position);

            //抵消默认的整页过度
            page.setTranslationX(pageWidth * -position);
            float scaleFactor = MIN_SCAle +
                    (1 - MIN_SCAle) * (1 - Math.abs(position));
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

        } else {
            //左后一页
            page.setAlpha(0);

        }

    }
}
