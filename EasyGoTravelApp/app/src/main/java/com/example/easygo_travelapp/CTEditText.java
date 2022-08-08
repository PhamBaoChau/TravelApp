package com.example.easygo_travelapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.easygo_travelapp.R;

import java.text.AttributedCharacterIterator;

public class CTEditText extends LinearLayout {
    private TextView tvTitle;
    private EditText edtInput;

    public CTEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initComponents(context);
//        showAttribute(context,attrs);
    }

    private void showAttribute(Context context, AttributeSet atr) {
        TypedArray typedArray = context.obtainStyledAttributes(atr, R.styleable.CTEditText);
        int count = typedArray.getIndexCount();

        try {
            for (int i = 0; i < count; i++) {
                int attr = typedArray.getIndex(i);
                if (attr == R.styleable.CTEditText_title) {
                    setTitle(typedArray.getString(attr));
                }
                if (attr == R.styleable.CTEditText_placeholderText) {
                    setInput(typedArray.getString(attr));
                }
            }
        } finally {
            typedArray.recycle();
        }

    }

    private void initComponents(Context context) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.ctv_edit_text, null);
        tvTitle = findViewById(R.id.title);
        edtInput = findViewById(R.id.content);

    }

    public String getTitle() {
        return tvTitle.getText().toString();
    }

    public void setTitle(String title) {
        this.edtInput.setText(title);
    }

    public String getInput() {
        return tvTitle.getText().toString();
    }

    public void setInput(String input) {
        this.edtInput.setText(input);
    }
}
