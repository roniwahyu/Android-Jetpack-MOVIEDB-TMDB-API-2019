package com.roniwahyu.fragmentviemodel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.roniwahyu.fragmentviemodel.ui.fragmentmain.FragmentMainFragment;

public class FragmentMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FragmentMainFragment.newInstance())
                    .commitNow();
        }
    }
}
