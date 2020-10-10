package kr.dgsw.android.msl.viewmodels;

import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

import kr.dgsw.android.msl.utils.Review;

public class StoreInfoViewModel extends ViewModel {

    public ObservableArrayList<Review> getItems() {
        if(items == null)
            items = new ObservableArrayList<>();
        return items;
    }

    public void setItems(ObservableArrayList<Review> items) {
        this.items = items;
    }

    ObservableArrayList<Review> items = new ObservableArrayList<>();

    public String name;
    public String address;
    public Long starTotal ;
    public Long starCounter;
    public String reason;

    public StoreInfoViewModel(String name, String address, Long starTotal, Long starCounter, String reason) {
        this.name = name;
        this.address = address;
        this.starTotal = starTotal;
        this.starCounter = starCounter;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getStarTotal() {
        return starTotal;
    }

    public void setStarTotal(Long starTotal) {
        this.starTotal = starTotal;
    }

    public Long getStarCounter() {
        return starCounter;
    }

    public void setStarCounter(Long starCounter) { this.starCounter = starCounter; }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
