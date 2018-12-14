package com.adorkable.acientdict.ui.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.adorkable.acientdict.R;
import com.adorkable.acientdict.ui.base.BaseActivity;

import java.util.List;

import butterknife.BindView;

public class SearchActivity extends BaseActivity {

    @BindView(R.id.et_search_input)
    EditText searchInput;
    @BindView(R.id.iv_search_btn)
    ImageView searchBtn;
    @BindView(R.id.iv_search_input_clear)
    ImageView searchInputClearBtn;    //

    private List<String> searchHistroyData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initEvent();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_search;
    }

    private void initEvent() {
        searchInput.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String content = searchInput.getText().toString();
                if (content.length() > 1) {
                    searchBtn.setImageResource(R.drawable.icon_dict_search_normal);
                    searchInputClearBtn.setVisibility(View.VISIBLE);
                } else {
                    searchBtn.setImageResource(R.drawable.icon_dict_search_disable);
                    searchInputClearBtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        searchInputClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchInput.setText("");
            }
        });
    }

}
