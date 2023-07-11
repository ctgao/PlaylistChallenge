package io.zipcoder;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        Integer forwards = selection(startIndex, selection, true);
        Integer backwards = selection(startIndex, selection, false);
        return forwards < backwards ? forwards : backwards;
    }

    public Integer selection(Integer startIndex, String selection, boolean goingForward){
        Integer counter = 0;
        int index = startIndex;
        while(counter < playList.length){
            // comparison here
            if(selection.equals(playList[index])){
                break;
            }
            counter++;

            // increment/decrement at the end AND let it wrap around
            index = goingForward ? (index + 1) : (index - 1);
            if(index < 0){
                index = playList.length - 1;
            }
            else if(index >= playList.length){
                index = 0;
            }
        }
        return counter;
    }
}
