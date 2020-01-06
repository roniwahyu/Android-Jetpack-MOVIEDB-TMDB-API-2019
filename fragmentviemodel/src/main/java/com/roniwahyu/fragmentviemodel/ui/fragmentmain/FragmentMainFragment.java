package com.roniwahyu.fragmentviemodel.ui.fragmentmain;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roniwahyu.fragmentviemodel.R;

public class FragmentMainFragment extends Fragment {

    private FragmentMainViewModel mViewModel;

    public static FragmentMainFragment newInstance() {
        return new FragmentMainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentMainViewModel.class);
        // TODO: Use the ViewModel
    }

}
