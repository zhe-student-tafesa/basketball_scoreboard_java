package com.example.score;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;

    private int aTeamBackUp = 0;
    private int bTeamBackUp = 0;

    public MutableLiveData<Integer> getaTeamScore() {
        if (aTeamScore == null) {
            aTeamScore = new MutableLiveData<>();
            aTeamScore.setValue(0);
        }
        return aTeamScore;
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (bTeamScore == null) {
            bTeamScore = new MutableLiveData<>();
            bTeamScore.setValue(0);
        }
        return bTeamScore;
    }

    public void aTeamAdd(int s) {
        aTeamBackUp = aTeamScore.getValue();
        bTeamBackUp = bTeamScore.getValue();
        aTeamScore.setValue(aTeamScore.getValue() + s);
    }

    public void bTeamAdd(int s) {
        aTeamBackUp = aTeamScore.getValue();
        bTeamBackUp = bTeamScore.getValue();
        bTeamScore.setValue(bTeamScore.getValue() + s);
    }

    public void undo() {
        aTeamScore.setValue(aTeamBackUp);
        bTeamScore.setValue(bTeamBackUp);
    }

    public void reset() {
        aTeamBackUp = aTeamScore.getValue();
        bTeamBackUp = bTeamScore.getValue();
        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }

}
