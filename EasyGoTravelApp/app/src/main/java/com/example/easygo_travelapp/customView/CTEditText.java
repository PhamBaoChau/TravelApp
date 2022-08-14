package com.example.easygo_travelapp.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.easygo_travelapp.R;

import java.text.AttributedCharacterIterator;

public class CTEditText extends LinearLayout {
    private TextView tvTitle;
    private EditText edtInput;

    private String title,content;

    public CTEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initComponents(context);
        showAttribute(context,attrs);
    }

    private void showAttribute(Context context, AttributeSet atr) {
        TypedArray typedArray = context.obtainStyledAttributes(atr, R.styleable.CTEditText);
        try {
            title=typedArray.getString(R.styleable.CTEditText_title);
            content=typedArray.getString(R.styleable.CTEditText_placeholderText);
            setTitle(title);
            setInput(content);
        }
        finally {
            typedArray.recycle();
        }
    }

    private void initComponents(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.ctv_edit_text, this,true);
        tvTitle = view.findViewById(R.id.title);
        edtInput = view.findViewById(R.id.content);

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

    public void setInput(String content) {
        this.edtInput.setText(content);
    }
}
