package com.example.hw4_2_2_a;

import android.widget.Button;

public class ItemData {
    private int imageId;
    private String title;
    private String subtitle;
    private Button button;

    public ItemData(int imageId, String title, String subtitle, Button button) {
        this.imageId = imageId;
        this.title = title;
        this.subtitle = subtitle;
        this.button = button;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
