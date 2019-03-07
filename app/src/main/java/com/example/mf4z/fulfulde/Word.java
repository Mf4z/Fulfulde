package com.example.mf4z.fulfulde;

/**
 * Created by mf4z on 9/8/18.
 */

public class Word {

    //Satic Final Variable used to check image availability
    private static final int NO_IMAGE_PROVIDED = -1;

    //Member variable, saves Fulfulde value
    private String mfulfuldeTranslation;

    //Member variable, saves English value
    private String mdefLangTranslation;

    //Member variable, saves Image Value. Assigned to NO_IMAGE_PROVIDED
    private int mimgId = NO_IMAGE_PROVIDED;

    public int getMwordSound() {
        return mwordSound;
    }

    private int mwordSound;


    //Word constructor that takes in 2 parameters
    public Word(String fulN, String defN) {

        mfulfuldeTranslation = fulN;
        mdefLangTranslation = defN;

    }


    //Word constructor that takes in 3 parameters. This is called contructor overloading
    public Word(String fulN, String defN, int mwordSoundN) {

        mfulfuldeTranslation = fulN;
        mdefLangTranslation = defN;
        mwordSound = mwordSoundN;

    }

    public Word(String mfulfuldeTranslation, String mdefLangTranslation, int mimgId, int mwordSound) {
        this.mfulfuldeTranslation = mfulfuldeTranslation;
        this.mdefLangTranslation = mdefLangTranslation;
        this.mimgId = mimgId;
        this.mwordSound = mwordSound;
    }

    //Getters,used to get values of instance variables of the class

    public String getFulfuldeTranslation() {
        return mfulfuldeTranslation;
    }

    public String getDefLangTranslation() {
        return mdefLangTranslation;
    }

    public int getMimgId() {
        return mimgId;
    }


    @Override
    public String toString() {
        return "Word{" +
                "mdefLangTranslation='" + mdefLangTranslation + '\'' +
                ", mfulfuldeTranslation='" + mfulfuldeTranslation + '\'' +
                ", mimgId=" + mimgId +
                ", mwordSound=" + mwordSound +
                '}';
    }

    //Method to check if image is available or not
    public boolean hasImage() {
        return mimgId != NO_IMAGE_PROVIDED;
    }
}
