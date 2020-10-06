package kr.dgsw.android.msl.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import kr.dgsw.android.msl.R;
import kr.dgsw.android.msl.utils.StoreListItem;

public class StoreInfoView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_info);

        StoreListItem item = (StoreListItem) getIntent().getSerializableExtra("item");
        Toast.makeText(this,item.getName() + " / " + item.getReson(),Toast.LENGTH_SHORT).show();

    }
}