package com.wubeibei.leftdoor.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wubeibei.leftdoor.R;
import com.wubeibei.leftdoor.util.LogUtil;


public class ADFragment extends Fragment {
    private static final String TAG = "ADFragment";
    private View main;
    ImageView imageView;


    public ADFragment() {
    }

    public static ADFragment newInstance(int picRes) {
        ADFragment fragment = new ADFragment();

        // Activity 向 Fragment 传值
        Bundle args = new Bundle();
        args.putInt("picRes", picRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 回调方法，初始化UI,返回view对象，相当于fragment的布局文件对象
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 获取view对象，相当于fragment的布局文件对象
        main = inflater.inflate(R.layout.fragment_ad, container, false);
        imageView = main.findViewById(R.id.ad_imge);
        Bundle bundle = getArguments();
        if (bundle != null) {
            Glide.with(this).load(bundle.getInt("picRes")).into(imageView);
        }
        return main;
    }

    /**
     * 改变显示图片
     */

    public void setImge(final int res) {
        if(imageView == null)
            imageView = main.findViewById(R.id.ad_imge);
        imageView.setImageDrawable(null);
        Glide.with(ADFragment.this).load(res).into(imageView);
    }
}
