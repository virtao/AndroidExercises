/**
 * Created by Virtao on 15/9/12.
 */

package org.virtao.customuiwidget.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.virtao.customuiwidget.R;

public class TitleLayout extends LinearLayout {

    private Button mButtonBack;
    private Button mButtonEdit;
    private TextView mTextViewTitle;

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.widget_title, this);

        this.mButtonBack = (Button) this.findViewById(R.id.widget_title_btn_back);
        this.mButtonEdit = (Button) this.findViewById(R.id.widget_title_btn_edit);
        this.mTextViewTitle = (TextView) this.findViewById(R.id.widget_title_textview_title);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WidgetTitle);
        String title = a.getString(R.styleable.WidgetTitle_TitleText);
        float textSize = a.getDimension(R.styleable.WidgetTitle_TitleSize, 12);
        int rightButtonType = a.getInt(R.styleable.WidgetTitle_RightButtonType, 0);

        this.setTitle(title);
        this.setTitleSize(textSize);
        this.setRightButtonType(rightButtonType);

        a.recycle();
    }

    public void setBackButtonClickListener(OnClickListener l) {
        this.mButtonBack.setOnClickListener(l);

    }

    public void setEditButtonClickListener(OnClickListener l) {
        this.mButtonEdit.setOnClickListener(l);
    }

    public void setTitle(String title) {
        this.mTextViewTitle.setText(title);
    }

    public void setTitleSize(float size) {
        this.mTextViewTitle.setTextSize(size);
    }

    public void setRightButtonType(int type) {
        switch (type) {
            case 0:
                this.mButtonEdit.setText("Edit");
                break;
            case 1:
                this.mButtonEdit.setText("Del");
                break;
        }


    }
}
