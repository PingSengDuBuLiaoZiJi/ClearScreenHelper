package com.arno.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.arno.cslibrary.AClearEvent;
import com.arno.cslibrary.ClearScreenHelper;
import com.arno.cslibrary.IClearRootView;
import com.arno.cslibrary.View.RelativeRootView;

public class SampleFirRActivity extends AppCompatActivity {
    private IClearRootView mClearRootLayout;
    private ClearScreenHelper mClearScreenHelper;
    private Button mLeftBottomBtn;
    private Button mRightBottomBtn;
    private Button mCenterBtn;
    private Button mBindBtn;
    private Button mUnBindBtn;
    private TextView mRightTopTextV;
    private TextView mInfoTextV;
    private TextView mFansTextV;
    private TextView mShowTextV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_fir_r);
        initView();
        initListener();

        /**
         *  ClearScreenHelper API Usage:
         */
        mClearRootLayout = (RelativeRootView) findViewById(R.id.sample_clear_root_layout);
        mClearScreenHelper = new ClearScreenHelper(this, mClearRootLayout);
        mClearScreenHelper.bind(mLeftBottomBtn, mRightBottomBtn, mRightTopTextV, mFansTextV, mInfoTextV);
        mClearScreenHelper.setIClearEvent(new AClearEvent() {
            @Override
            public void onClearEnd() {
                Toast.makeText(SampleFirRActivity.this, "Clear End...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRecovery() {
                Toast.makeText(SampleFirRActivity.this, "Recovery Now...", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initView() {
        this.mBindBtn = findViewById(R.id.sample_bind_btn);
        this.mUnBindBtn = findViewById(R.id.sample_unbind_btn);
        this.mLeftBottomBtn = findViewById(R.id.sample_left_bottom_btn);
        this.mRightBottomBtn = findViewById(R.id.sample_right_bottom_btn);
        this.mCenterBtn = findViewById(R.id.sample_center_btn);
        this.mRightTopTextV = findViewById(R.id.sample_right_top_text);
        this.mFansTextV = findViewById(R.id.sample_person_fans);
        this.mShowTextV = findViewById(R.id.sample_text_show);
        this.mInfoTextV = findViewById(R.id.sample_person_info);
    }

    private void initListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == mBindBtn.getId()) {
                    mClearScreenHelper.bind(mShowTextV);
                    mClearScreenHelper.bind(mCenterBtn);
                } else if (view.getId() == mUnBindBtn.getId()) {
                    mClearScreenHelper.unbind(mShowTextV);
                    mClearScreenHelper.unbind(mCenterBtn);
                } else if (view.getId() == mCenterBtn.getId()) {
                    Toast.makeText(SampleFirRActivity.this, "Triggers the click event.", Toast.LENGTH_SHORT).show();
                }
            }
        };
        mBindBtn.setOnClickListener(listener);
        mUnBindBtn.setOnClickListener(listener);
        mCenterBtn.setOnClickListener(listener);
    }

}
