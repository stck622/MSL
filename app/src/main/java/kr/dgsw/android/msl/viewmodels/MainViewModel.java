package kr.dgsw.android.msl.viewmodels;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import kr.dgsw.android.msl.utils.FirestoreData;
import kr.dgsw.android.msl.utils.StoreListItem;
import kr.dgsw.android.msl.utils.profile;


public class MainViewModel extends ViewModel {

    ObservableArrayList<StoreListItem> items;
    ObservableField<String> title = null;

    public ObservableArrayList<StoreListItem> getItems() {
        if (items == null) {
            items = new ObservableArrayList<>();
        }
        return items;
    }

    public ObservableField<String> getTitle() {
        if (title == null) {
            title = new ObservableField<>();
        }
        return title;
    }

    public void setItems(ObservableArrayList<StoreListItem> items) {
        this.items = items;
    }

    public MainViewModel() {
        FirestoreData.getStoreList(getItems());
        getTitle().set(profile.name+"님 반갑습니다");
    }

}

