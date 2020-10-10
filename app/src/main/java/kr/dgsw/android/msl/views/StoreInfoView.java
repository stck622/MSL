package kr.dgsw.android.msl.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import kr.dgsw.android.msl.R;
import kr.dgsw.android.msl.databinding.ActivityStoreInfoBinding;
import kr.dgsw.android.msl.utils.FirestoreData;
import kr.dgsw.android.msl.utils.Review;
import kr.dgsw.android.msl.utils.ReviewListAdapter;
import kr.dgsw.android.msl.utils.Store;
import kr.dgsw.android.msl.utils.StoreInfoModelFactory;
import kr.dgsw.android.msl.viewmodels.StoreInfoViewModel;

public class StoreInfoView extends AppCompatActivity {

    ActivityStoreInfoBinding binding;
    StoreInfoViewModel infoViewModel;
    ReviewListAdapter mAdapter;

    Store item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_store_info);
        binding.setLifecycleOwner(this);

        item = (Store) getIntent().getSerializableExtra("item");

        infoViewModel = new ViewModelProvider(this, new StoreInfoModelFactory(item)).get(StoreInfoViewModel.class);

        mAdapter = new ReviewListAdapter(infoViewModel.getItems());
        binding.recycle.setAdapter(mAdapter);
        binding.recycle.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        FirestoreData.getReviewList(infoViewModel.getItems(), item.getPlaceId());

        binding.setStoreInfoViewModel(infoViewModel);

        ((Button) findViewById(R.id.test)).setOnClickListener(v -> {
            Intent intent = new Intent(this, ReviewWriteView.class);
            intent.putExtra("id", item.getPlaceId());
            startActivityForResult(intent, 1);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                Review review = (Review) data.getSerializableExtra("review");
                FirestoreData.addReview(infoViewModel.getItems(), review, item);
            }
        }
    }
}