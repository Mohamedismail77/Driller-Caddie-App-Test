package com.mit_technologies.drillercaddie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements KeyView, ModeView, TimerView {

    private Spinner mode;
    private Spinner key;
    private Spinner period;
    private Spinner toolNum;
    private ImageView modeIcon;
    private ProgressBar periodProgress;
    private Button start;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolNum = findViewById(R.id.tool);
        mode = findViewById(R.id.mode);
        key = findViewById(R.id.key);
        period = findViewById(R.id.period);

        modeIcon = findViewById(R.id.image);

        start = findViewById(R.id.start);
        reset = findViewById(R.id.reset);

        periodProgress = findViewById(R.id.timer);


    }

    @Override
    public void onKeyChanged() {

        // Change Data in period dropdown to match key
        //Update period adapter by new list

    }

    @Override
    public void onModeChanged() {

        //Change Image view to match the mode Image

    }

    @Override
    public void onTimerStart() {

        // Disable Key and period selector
        period.setEnabled(false);
        key.setEnabled(false);

        // show timer progress
        periodProgress.setVisibility(View.VISIBLE);

    }

    @Override
    public void onTimerProgress(int progress) {

        //update progress
        periodProgress.setProgress(progress);

    }

    @Override
    public void onTimerFinish() {
        // Enable Key and period selector
        period.setEnabled(true);
        key.setEnabled(true);

        // show timer progress
        periodProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onTimerReset() {

        // Enable Key and period selector
        period.setEnabled(true);
        key.setEnabled(true);

        // show timer progress
        periodProgress.setVisibility(View.INVISIBLE);

        //reset progress
        periodProgress.setProgress(0);

    }
}
