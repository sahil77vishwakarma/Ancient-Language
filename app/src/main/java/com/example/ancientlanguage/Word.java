package com.example.ancientlanguage;

public class Word {

   private String DefaultTranslation;
    private String MiwokTranslation;
    private int mAudioResourceId;
    private int NO_image_provided = -1;
    private int mImageResourceId = NO_image_provided;

    public Word (String defaultTranslation ,String miwokTranslation,int AudioResourceId)
    {
        DefaultTranslation = defaultTranslation;
        MiwokTranslation = miwokTranslation;
        mAudioResourceId = AudioResourceId;

    }

    public Word(String defaultTranslation,String miwokTranslation,int image,int AudioResourceId)
    {
        DefaultTranslation = defaultTranslation;
        MiwokTranslation = miwokTranslation;
        mImageResourceId = image;
        mAudioResourceId = AudioResourceId;
    }

    public String getDefaultTranslation() {
        return DefaultTranslation;
    }

    public String getMiwokTranslation() {
        return MiwokTranslation;
    }

    public int getImageResourceId()
    {
            return mImageResourceId;
    }

public int getmAudioResourceId(){
        return mAudioResourceId;
}
    //returns whether or not there is image for this word
    public boolean hasImage()
    {
        return  mImageResourceId != NO_image_provided;
    }
}
