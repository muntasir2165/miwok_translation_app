package com.example.android.miwok;

/**
 * Miwok word and default translation encapsulating data structure - Word - representing a Miwok
 * word that the user wants to learn
 */
public class Word {

    // Miwok translation
    private String mMiwokTranslation;

    // Default (in this case English) word
    private String mDefaultTranslation;

    // Associated image resource id
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    // Associated audio resource id
    private int mAudioResourceId;

    /**
     * Constructs a new Word with Miwok and default translations and an associated image resource id
     *
     * @param defaultTranslation the default transation of a word
     *
     * @param miwokTranslation the Miwok translation of a word
     *
     * @param audioResourceId the word's associated audio resource id
     *
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mAudioResourceId = audioResourceId;
    }

    /**
     * Constructs a new Word with Miwok and default translations and associated image and audio resource ids
     *
     * @param defaultTranslation the default transation of a word
     *
     * @param miwokTranslation the Miwok translation of a word
     *
     * @param imageResourceId the word's associated image resource id
     *
     * @param audioResourceId the word's associated audio resource id
     *
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResourceId = imageResourceId;
        this.mAudioResourceId = audioResourceId;
    }


    /**
     * Gets the Miwok translation
     *
     * @return the Miwok translation.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Gets the default (in this case English) translation
     *
     * @return the default translation.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Gets the associated image resource id
     *
     * @return the image resource id.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != -1;
    }

    /**
     * Gets the associated audio resource id
     *
     * @return the audio resource id.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    /**
     * Returns the string representation of the {@link Word} object.
     */
    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}