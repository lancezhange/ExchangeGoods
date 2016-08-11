package com.hackathon.exchange.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;


public class UIUtils {

	/**
	 * Drawable转换成Bitmap
	 * @param drawable	{@link Drawable}
	 * @return	{@link Bitmap}
     */
	public static Bitmap drawableToBitmap(Drawable drawable)
	{
		int width = drawable.getIntrinsicWidth();
		int height = drawable.getIntrinsicHeight();
		Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888: Bitmap.Config.RGB_565;
		Bitmap bitmap = Bitmap.createBitmap(width, height, config);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, width, height);
		drawable.draw(canvas);
		return bitmap;
	}

	/**
	 * 获取自定义属性的资源ID
	 * @param context	上下文
	 * @param attrRes	自定义属性
     * @return	resourceId
     */
	public static int getResourceId(Context context, int attrRes)
	{
		TypedValue typedValue = new TypedValue();
		context.getTheme().resolveAttribute(attrRes, typedValue, true);
		return typedValue.resourceId;
	}

	/**
	 * 获取颜色类自定义属性的颜色值
	 * @param context	上下文
	 * @param attrRes	自定义属性
	 * @return	A single color value in the form 0xAARRGGBB
	 */
	/*public static int getAttrColor(Context context, int attrRes)
	{
		return App.getAppContext().getResources().getColor(getResourceId(context, attrRes));
	}*/

	/**
	 * 获取Drawable类自定义属性的drawable
	 * @param context	上下文
	 * @param attrRes	自定义属性
     * @return	Drawable An object that can be used to draw this resource.
     */
	public static Drawable getAttrDrawable(Context context, int attrRes)
	{
		return ContextCompat.getDrawable(context,getResourceId(context,attrRes));
	}



	public static float dp2sp(Context context, float dipValue) {
		float pxValue = dp2px(context, dipValue);
		return px2sp(context, pxValue);
	}

	public static float sp2dp(Context context, float spValue) {
		float pxValue = sp2px(context, spValue);
		return px2dp(context, pxValue);
	}

	public static float px2dp(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale);
	}

	public static float dp2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale);
	}

	public static float px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale);
	}

	public static float sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (spValue * fontScale);
	}



}
