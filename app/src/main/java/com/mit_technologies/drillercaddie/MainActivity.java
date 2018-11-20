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

    private DropDownAdapter mToolsAdapter;
    private DropDownAdapter mModeAdapter;
    private DropDownAdapter mKeyAdapter;
    private DropDownAdapter mPeriodAdapter;

    private KeyPresenter keyPresenter;
    private ModePresenter modePresenter;

    private Bundle savedInstances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        savedInstances = savedInstanceState;

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
        modePresenter = new ModePresenter(this);
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

        // Initiate ModePresenter
        keyPresenter = new KeyPresenter(this,this);
        // Create ModeAdapter
        mKeyAdapter = new DropDownAdapter(this,keyPresenter.getKeyTitles());
        // Set Mode Adapter
        key.setAdapter(mKeyAdapter);

        // Set mode on select listener
        key.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                keyPresenter.setPeriodList(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPresenter.startTimer(key.getSelectedItemPosition(),period.getSelectedItemPosition());
            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPresenter.stopTimer();
            }
        });

        // Retrieve Saved state
        if(savedInstanceState != null){
            if(savedInstanceState.getBoolean("isProgress")){
                periodProgress.setVisibility(View.VISIBLE);
                keyPresenter.continueTimer(key.getSelectedItemPosition(),savedInstanceState.getInt("period"),savedInstances.getInt("progress"));
            }
        }

    }


    @Override
    public void onKeyChanged(String[] keyPeriods) {

        // Change Data in period dropdown to match key
        //Update period adapter by new list

        //check if period adapter is initialized
        if(mPeriodAdapter != null){
            // Update Data
            mPeriodAdapter.updateData(keyPeriods);
            mPeriodAdapter.notifyDataSetChanged();
        } else {
            // Create mPeriod Adapter
            mPeriodAdapter = new DropDownAdapter(this,keyPeriods);
            period.setAdapter(mPeriodAdapter);

        }

        // Retrieve Saved state
        if(savedInstances!= null){
            period.setSelection(savedInstances.getInt("period"));
            savedInstances = null;
        }


    }

    @Override
    public void onModeChanged(int modeIconResource) {
        //Change Image view to match the mode Image
        modeIcon.setImageDrawable(getResources().getDrawable(modeIconResource));
    }

    @Override
    public void onTimerStart(int interval) {

        // Disable Key and period selector
        period.setEnabled(false);
        key.setEnabled(false);
        mode.setEnabled(false);
        toolNum.setEnabled(false);

        // show timer progress
        periodProgress.setMax(interval);
        periodProgress.setVisibility(View.VISIBLE);

    }

    @Override
    public void onTimerProgress(int progress) {

        //update progress
        periodProgress.setProgress(progress);

    }

    @Override
    public void onTimerReset() {

        // Enable ToolNumber, Mode, Key and period selector
        period.setEnabled(true);
        key.setEnabled(true);
        mode.setEnabled(true);
        toolNum.setEnabled(true);


        // show timer progress
        periodProgress.setVisibility(View.INVISIBLE);

        //reset progress
        periodProgress.setProgress(0);

    }


    @Override
    protected void onDestroy() {
        modePresenter.onDestroy();
        keyPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("progress",periodProgress.getProgress());
        outState.putBoolean("isProgress",periodProgress.getVisibility()==View.VISIBLE);
        outState.putInt("period",period.getSelectedItemPosition());
        super.onSaveInstanceState(outState);
    }
}
