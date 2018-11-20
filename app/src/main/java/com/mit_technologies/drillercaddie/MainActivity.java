package com.mit_technologies.drillercaddie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements KeyView, ModeView, TimerView {

    public Spinner mode;
    private Spinner key;
    private Spinner period;
    public Spinner toolNum;
    public ImageView modeIcon;
    private ProgressBar periodProgress;
    private Button start;
    private Button reset;

    DropDownAdapter mToolsAdapter;
    DropDownAdapter mModeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolNum = findViewById(R.id.tool);
        mode = findViewById(R.id.mode);
        key = findViewById(R.id.key);
        period = findViewById(R.id.period);

        modeIcon = findViewById(R.id.mode_icon);

        start = findViewById(R.id.start);
        reset = findViewById(R.id.reset);

        periodProgress = findViewById(R.id.timer);

        // Initiate ToolPresenter
        ToolPresenter toolPresenter = new ToolPresenter();
        // Create ToolAdapter
        mToolsAdapter = new DropDownAdapter(this,toolPresenter.getToolsNumbers());
        // Set ToolNumber Adapter
        toolNum.setAdapter(mToolsAdapter);

        // Initiate ModePresenter
        final ModePresenter modePresenter = new ModePresenter(this);
        // Create ModeAdapter
        mModeAdapter = new DropDownAdapter(this,modePresenter.getModeTitles());
        // Set Mode Adapter
        mode.setAdapter(mModeAdapter);

        // Set mode on select listener
        mode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                modePresenter.setModeIcon(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onKeyChanged() {

        // Change Data in period dropdown to match key
        //Update period adapter by new list

    }

    @Override
    public void onModeChanged(int modeIconResource) {
        //Change Image view to match the mode Image
        modeIcon.setImageDrawable(getResources().getDrawable(modeIconResource));
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
