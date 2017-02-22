# ViewPagerFg
- 切入、淡出动画

![动画1](https://github.com/snowluliang/ViewPagerFg/blob/master/app/src/main/res/screens/GIF1.gif)
![动画2](https://github.com/snowluliang/ViewPagerFg/blob/master/app/src/main/res/screens/GIF2.gif)

```
//淡出
mPager.setPageTransformer(true, new DepthPageTransformer());
//缩放
mPager.setPageTransformer(true, new ZoomOutPageTransformer());
```
