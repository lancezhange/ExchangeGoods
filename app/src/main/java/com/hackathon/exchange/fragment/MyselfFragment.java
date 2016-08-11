package com.hackathon.exchange.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.exchange.R;

/**
 * description：
 * ===============================
 * creator：JiaCheng Wang
 * create time：2016/8/11.
 * ===============================
 * reasons for modification：
 * Modifier：
 * Modify time：
 */
public class MyselfFragment extends HomeBaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_myself, container, false);
        return mView;
    }

    @Override
    public void OnFragmentSelectedChanged(boolean isSelected) {
        if (isViewInitFinished()) {
            if (isSelected) {

            }
        }
    }
}
