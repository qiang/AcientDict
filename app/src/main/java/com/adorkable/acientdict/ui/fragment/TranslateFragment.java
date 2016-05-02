package com.adorkable.acientdict.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.adorkable.acientdict.R;

/**
 * Created by liuqiang on 15/11/20.
 * <p/>
 * 翻译页
 */
public class TranslateFragment extends Fragment implements View.OnClickListener {

    private static int TITLE_MAX_SIZE_LIMITED = 15;    //输入框最大字数限制

    private Context mContext;

    private View rootView;    //整个布局文件的根
    private ImageView clearInputBtn;    //清空输入的翻译文字
    private EditText transInput;    //翻译输入框
    private LinearLayout transCommitBtn;    //
    private TextView textFanYi;    //翻译那两个字
    private ImageView startTransArrow;    //翻译的箭头


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.mContext = getContext();

        rootView = inflater.inflate(R.layout.fragment_translate, container, false);

        initView();
        initData();
        bindEvent();

        return rootView;
    }


    private void initView() {
        clearInputBtn = (ImageView) rootView.findViewById(R.id.iv_clear_trans_input);
        transInput = (EditText) rootView.findViewById(R.id.et_trans_input);

        transCommitBtn = (LinearLayout) rootView.findViewById(R.id.ll_trans_commit_btn);
        textFanYi = (TextView) rootView.findViewById(R.id.tv_text_fan_yi);
        startTransArrow = (ImageView) rootView.findViewById(R.id.iv_start_trans_arrow);

    }

    private void initData() {

    }

    private void bindEvent() {
        clearInputBtn.setOnClickListener(this);

        transInput.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String content = transInput.getText().toString();
                if (content.length() > TITLE_MAX_SIZE_LIMITED) {
                    //editText.setText(content.substring(0, 15));
                    //editText.setSelection(editText.getText().toString().length());
                    //设置字数限制提示

                } else {
                    if (content.length() > 1) {
                        startTransArrow.setImageResource(R.drawable.bg_translate_go);
                        transCommitBtn.setClickable(true);
                        textFanYi.setTextColor(0xff4e4c4a);
                    } else {
                        startTransArrow.setImageResource(R.drawable.trans_go_icon_disable);
                        transCommitBtn.setClickable(false);
                        textFanYi.setTextColor(mContext.getResources().getColor(R.color.gray_d5));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public String toString() {
        return "翻译";
    }

    @Override
    public void onClick(View v) {
        //处理点击事件

        switch (v.getId()) {
            case R.id.iv_clear_trans_input:    //清空翻译输入框
                transInput.setText("");
                break;

            case R.id.ll_trans_commit_btn:    //开始翻译
                Toast.makeText(getContext(), "开始翻译", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }
}
