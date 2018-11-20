package com.mit_technologies.drillercaddie;

public class ToolPresenter {

    private Tool[] tools;

    public ToolPresenter(){

        //Create new Tool Array to used in Tool DropDown list

        tools = new Tool[]{new ToolNumOne(), new ToolNumTwo(), new ToolNumThree()};
    }

    /* getToolsNumbers: Provide the DropDown list with string array of available tools  */
    public String[] getToolsNumbers(){

        // create string array to hold tools number
        String[] toolsNumber = new String[tools.length];

        // Iterate over tools array
        for(int i = 0 ; i < tools.length ; i++){
            toolsNumber[i] = String.valueOf(tools[i].toolNumber);
        }

        return toolsNumber;

    }


}
