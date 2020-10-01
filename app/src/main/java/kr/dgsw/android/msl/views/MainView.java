package kr.dgsw.android.msl.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.List;

import kr.dgsw.android.msl.R;
import kr.dgsw.android.msl.databinding.ActivityMainBinding;
import kr.dgsw.android.msl.utils.StoreListAdapter;
import kr.dgsw.android.msl.utils.StoreListItem;
import kr.dgsw.android.msl.viewmodels.LoginViewModel;
import kr.dgsw.android.msl.viewmodels.MainViewModel;

public class MainView extends AppCompatActivity {

    ActivityMainBinding binding;
    private StoreListAdapter mAdapter;
    ObservableArrayList<StoreListItem> items;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mAdapter = new StoreListAdapter(mainViewModel.getItems());
        binding.recycle.setAdapter(mAdapter);
        binding.setMainViewModel(mainViewModel);

        mainViewModel.getItems().add(new StoreListItem("hi", "hi2"));
        mainViewModel.getItems().add(new StoreListItem("hi3", "hi4"));

    }

}