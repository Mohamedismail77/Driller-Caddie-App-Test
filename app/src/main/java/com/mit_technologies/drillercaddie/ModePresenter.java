package com.mit_technologies.drillercaddie;

public class ModePresenter {

    private Mode[] mModes;
    private ModeView mModeView;

    public ModePresenter(ModeView modeView){

        //Create new Mode Array to used in Mode DropDown list
        this.mModes = new Mode[]{new HomeMode(),new BypassMode(),
                new DualFlowMode(), new IsolationMode()};
        this.mModeView = modeView;
    }

    /* getModeTitles: Provide the DropDown list with string array of available tools  */
    public String[] getModeTitles(){
        // create string array to hold Modes titles
        String[] mModesTitles = new String[mModes.length];

        // Iterate over Modes array
        for(int i = 0 ; i < mModes.length ; i++){
            mModesTitles[i] = mModes[i].title;
        }

        return mModesTitles;
    }


    /* setModeIcon: return selected mode icon through modeView interface
       @params: modeIndex => Selected Mode Position from dropDown list
     */
    public void setModeIcon(int modeIndex){
        this.mModeView.onModeChanged(mModes[modeIndex].icon);
    }





}
