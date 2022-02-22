package com.epson.epos2_printer.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.epson.epos2_printer.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.shashank.sony.fancytoastlib.FancyToast;



public class UniversalImageLoader {

    private static final int defaultImage = R.drawable.checked_icon;
    private Context mContext;

    private static final String TAG = "UniversalImageLoader";

    public UniversalImageLoader(Context context) {
        mContext = context;
    }

    public ImageLoaderConfiguration getConfig() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(defaultImage)
                .showImageForEmptyUri(defaultImage)
                .considerExifParams(true)
                .showImageOnFail(defaultImage)
                .cacheOnDisk(true).cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        return new ImageLoaderConfiguration.Builder(mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100 * 1024 * 1024).build();
    }

    /**
     * this method can be used to set images that are static. It can't be used if the images
     * are being changed in the fragment activity or if they are being set in a
     * * gridview
     *
     * @param imgURL
     * @param image
     * @param mProgressBar
     * @param append
     */
    public static void setImage(Uri imgURL, ImageView image, final ProgressBar mProgressBar, String append, Context mContext) {
        try {
            //imgURL = "/storage/CA5A-11EC/DCIM/Camera/20170107_132109.jpg"
            Log.d(TAG, "setImage: imgurk us " + imgURL);

            ImageLoader imageLoader = ImageLoader.getInstance();
            ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(mContext));
            imageLoader.displayImage(imgURL + "", image, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View v) {
                    if (mProgressBar != null) {
                        mProgressBar.setVisibility(View.VISIBLE);

                    }
                }

                @Override
                public void onLoadingFailed(String imageUri, View v, FailReason failReason) {
                    if (mProgressBar != null) {
                        mProgressBar.setVisibility(View.GONE);

                    }

                }

                @Override
                public void onLoadingComplete(String imageUri, View v, Bitmap loadedImage) {
                    if (mProgressBar != null) {
                        mProgressBar.setVisibility(View.GONE);

                    }

                }

                @Override
                public void onLoadingCancelled(String imageUri, View v) {
                    if (mProgressBar != null) {
                        mProgressBar.setVisibility(View.GONE);

                    }

                }
            });
        } catch (IllegalStateException e) {
            Log.d(TAG, "setImage: IllegalStateException " + e.getMessage());
        }
    }

    public static void setImage(Uri imgURL, ImageView image, final ImageView mClose, final ProgressBar mProgressBar, String append, final Context mContext) {
        try {
            //imgURL = "/storage/CA5A-11EC/DCIM/Camera/20170107_132109.jpg"
            Log.d(TAG, "setImage: imgurk us " + imgURL);
            mClose.setVisibility(View.GONE);
            ImageLoader imageLoader = ImageLoader.getInstance();
            ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(mContext));
            imageLoader.displayImage(imgURL + "", image, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View v) {
                    if (mProgressBar != null) {
                        mProgressBar.setVisibility(View.VISIBLE);

                    }
                }

                @Override
                public void onLoadingFailed(String imageUri, View v, FailReason failReason) {
                    if (mProgressBar != null) {
                        mProgressBar.setVisibility(View.GONE);
                        Log.d(TAG, "onLoadingComplete: failed " + failReason + imageUri);
                        FancyToast.makeText(mContext, "فشل تحميل الصورة. أعد تحميل الصورة", FancyToast.LENGTH_SHORT,
                                FancyToast.ERROR, false).show();
                        mClose.setVisibility(View.VISIBLE);
                    }

                }

                @Override
                public void onLoadingComplete(String imageUri, View v, Bitmap loadedImage) {
                    if (mProgressBar != null) {
                        mProgressBar.setVisibility(View.GONE);
                        mClose.setVisibility(View.VISIBLE);
                    }

                }

                @Override
                public void onLoadingCancelled(String imageUri, View v) {
                    if (mProgressBar != null) {
                        mProgressBar.setVisibility(View.GONE);

                    }

                }
            });
        } catch (IllegalStateException e) {
            Log.d(TAG, "setImage: IllegalStateException " + e.getMessage());
        }
    }


    public static void setImageSrc(String imgURL, ImageView image, final ProgressBar mProgressBar, String append, final Context mContext) {
        try {
            //imgURL = "/storage/CA5A-11EC/DCIM/Camera/20170107_132109.jpg"
            Log.d(TAG, "setImage: imgurk us " + imgURL);

            ImageLoader imageLoader = ImageLoader.getInstance();
            ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(mContext));
            imageLoader.displayImage(append + imgURL, image, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View v) {
                    if (mProgressBar != null) {
                        mProgressBar.setVisibility(View.VISIBLE);

                    }
                }

                @Override
                public void onLoadingFailed(String imageUri, View v, FailReason failReason) {
                    if (mProgressBar != null) {
                        mProgressBar.setVisibility(View.GONE);
                        Log.d(TAG, "onLoadingFailed: ");
                        FancyToast.makeText(mContext, "فشل تحميل الصورة. أعد تحميل الصورة", FancyToast.LENGTH_SHORT,
                                FancyToast.ERROR, false).show();
                    }

                }

                @Override
                public void onLoadingComplete(String imageUri, View v, Bitmap loadedImage) {
                    if (mProgressBar != null) {
                        Log.d(TAG, "onLoadingComplete: ");
                        mProgressBar.setVisibility(View.GONE);

                    }

                }

                @Override
                public void onLoadingCancelled(String imageUri, View v) {
                    if (mProgressBar != null) {
                        mProgressBar.setVisibility(View.GONE);

                    }

                }
            });
        } catch (IllegalStateException e) {
            Log.d(TAG, "setImage: IllegalStateException " + e.getMessage());
        }
    }


}
