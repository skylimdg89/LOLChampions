package edu.mnstate.mg0483fp.lollogin;

public class Champion {
    protected String champName;
    protected int imageResId;

    public Champion(String champName, int imageResId) {
        this.champName = champName;
        this.imageResId = imageResId;
    }

    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
