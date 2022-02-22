package com.epson.epos2_printer.utils;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatSpinner;

public class OwnSpinner extends AppCompatSpinner {
    OnItemSelectedListener listener;

    public OwnSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void processSelection(int position) {
        boolean sameSelected = position == getSelectedItemPosition();
        final OnItemSelectedListener listener = getOnItemSelectedListener();
        if (sameSelected && listener != null) {
            // Spinner does not call the OnItemSelectedListener if the same item is selected, so do it manually now
            listener.onItemSelected(this, getSelectedView(), position, getSelectedItemId());
        }
    }

    @Override
    public void setSelection(int position) {
        processSelection(position);
        super.setSelection(position);
    }

    @Override
    public void
    setSelection(int position, boolean animate) {
        processSelection(position);
        super.setSelection(position, animate);
    }

    @Override
    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        // hack for initial listener call
        setSelection(0, false);
        super.setOnItemSelectedListener(listener);
    }
}
