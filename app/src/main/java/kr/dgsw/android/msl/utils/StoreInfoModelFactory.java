package kr.dgsw.android.msl.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import kr.dgsw.android.msl.viewmodels.StoreInfoViewModel;

public class StoreInfoModelFactory implements ViewModelProvider.Factory {

    Store store;

    public StoreInfoModelFactory(Store store) {
        this.store = store;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new StoreInfoViewModel(store.getName(),store.getAddress(), store.getStarTotal(), store.getStarCounter(), store.getReson());
    }
}
