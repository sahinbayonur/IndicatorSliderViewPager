package com.sahinbay.sounds;

public class Item {
    int play;
    int image;
    int id;
    boolean isPlaying;
    boolean isLocked;

    public Item(int id, int play, int image, boolean isPlaying, boolean isLocked) {
        this.image = image;
        this.id = id;
        this.play = play;
        this.isPlaying = isPlaying;
        this.isLocked = isLocked;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public int getPlay() {
        return play;
    }

    public void setisPlaying(boolean isplay) {
        this.isPlaying = isplay;
    }

    public boolean getisPLaying() {
        return isPlaying;
    }

    public void setisLocked(boolean isLock) {
        this.isLocked = isLock;
    }

    public boolean getisLocked() {
        return isLocked;
    }

}
