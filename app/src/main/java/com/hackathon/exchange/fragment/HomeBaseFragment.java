package com.hackathon.exchange.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public abstract class HomeBaseFragment extends BaseFragment {
    private boolean isViewInitFinished = false;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewInitFinished = true;
    }

    public boolean isViewInitFinished() {
        return isViewInitFinished;
    }

    public abstract void OnFragmentSelectedChanged(boolean isSelected);

    public void finish(){
        if(getActivity() != null){
            getActivity().finish();
        }
    }
}