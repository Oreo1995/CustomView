package com.trance.customview.customCombine;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.trance.customview.R;

public class TitleBar extends RelativeLayout {

    private ImageView iv_titleBar_left;
    private ImageView iv_titleBar_right;
    private TextView tv_titleBar_title;
    private RelativeLayout layout_titleBar_rootLayout;
    private int mColor = Color.BLUE;
    private int mTextColor = Color.WHITE;
    private String titleName = "";

    public TitleBar(Context context) {
        super(context);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        mColor = mTypedArray.getColor(R.styleable.TitleBar_title_bg, Color.BLUE);
        mTextColor = mTypedArray.getColor(R.styleable.TitleBar_title_text_color, Color.WHITE);
        titleName = mTypedArray.getString(R.styleable.TitleBar_title_text);
        mTypedArray.recycle();
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context) {
        LayoutInflater.from(context)
                .inflate(R.layout.view_custom_title, this, true);
        iv_titleBar_left = findViewById(R.id.iv_titleBar_left);
        iv_titleBar_right = findViewById(R.id.iv_titleBar_right);
        tv_titleBar_title = findViewById(R.id.tv_titleBar_title);
        layout_titleBar_rootLayout = findViewById(R.id.layout_titleBar_rootLayout);
        //设置背景色
        layout_titleBar_rootLayout.setBackgroundColor(mColor);
        tv_titleBar_title.setTextColor(mTextColor);
        tv_titleBar_title.setText(titleName);
    }

    public void setTitle(String titleName) {
        if (!TextUtils.isEmpty(titleName)) {
            tv_titleBar_title.setText(titleName);
        }
    }

    public void setLeftListener(OnClickListener onClickListener) {
        iv_titleBar_left.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener) {
        iv_titleBar_right.setOnClickListener(onClickListener);
    }
}
