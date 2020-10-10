package kr.dgsw.android.msl.viewmodels;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

import kr.dgsw.android.msl.utils.FirestoreData;
import kr.dgsw.android.msl.utils.Store;


public class MainViewModel extends ViewModel {

    ObservableArrayList<Store> items;
    ObservableField<String> title = null;

    public ObservableArrayList<Store> getItems() {
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

    public void setItems(ObservableArrayList<Store> items) {
        this.items = items;
    }

    public MainViewModel() {
        FirestoreData.getStoreList(getItems());
        getTitle().set(FirebaseAuth.getInstance().getCurrentUser().getDisplayName()+"님 반갑습니다");
    }

}

