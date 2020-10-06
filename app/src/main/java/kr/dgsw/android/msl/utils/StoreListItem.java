package kr.dgsw.android.msl.utils;

import java.io.Serializable;

public class StoreListItem implements Serializable {

    private String address;
    private String name;
    private String placeId;
    private String reson;
    private Long starCounter;
    private Long starTotal;
    private String thumbnail;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getReson() {
        return reson;
    }

    public void setReson(String reson) {
        this.reson = reson;
    }

    public Long getStarCounter() {
        return starCounter;
    }

    public void setStarCounter(Long starCounter) {
        this.starCounter = starCounter;
    }

    public Long getStarTotal() {
        return starTotal;
    }

    public void setStarTotal(Long starTotal) {
        this.starTotal = starTotal;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
