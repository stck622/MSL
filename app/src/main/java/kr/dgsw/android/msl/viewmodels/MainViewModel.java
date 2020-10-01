package kr.dgsw.android.msl.viewmodels;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import kr.dgsw.android.msl.utils.StoreListItem;


public class MainViewModel extends ViewModel {

    ObservableArrayList<StoreListItem> items;

    public ObservableArrayList<StoreListItem> getItems() {
        if(items == null){
            items = new ObservableArrayList<>();
        }
        return items;
    }

    public void setItems(ObservableArrayList<StoreListItem> items) {
        this.items = items;
    }
}

