package kr.dgsw.android.msl.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.databinding.ObservableArrayList;

import kr.dgsw.android.msl.R;
import kr.dgsw.android.msl.utils.FacebookUtil;
import kr.dgsw.android.msl.utils.Review;

public class ReviewWriteView extends Activity {

    String id;

    String context;
    String img;
    String menu;
    String name;
    String owner;
    long star;

    Spinner star_sp;
    EditText context_ed;
    EditText menu_ed;

    ObservableArrayList<Review> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_review_write);

        id = getIntent().getStringExtra("id");

        star_sp = (Spinner) findViewById(R.id.setStar);
        context_ed = findViewById(R.id.reviewcontext);
        menu_ed = findViewById(R.id.recommendmenu);

        ArrayAdapter starAdapter = ArrayAdapter.createFromResource(this,
                R.array.star, android.R.layout.simple_spinner_item);
        starAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        star_sp.setAdapter(starAdapter);

    }

    public void clickWrite(View v) {

        star = star_sp.getSelectedItemPosition() + 1;
        owner = FacebookUtil.getUid();
        name = FacebookUtil.getName();
        menu = menu_ed.getText().toString();
        context = context_ed.getText().toString();
        img = null;

        Log.e("essas",String.valueOf(star));

        Review review = new Review(context, img, menu, name, owner, star);

        Intent intent = new Intent();
        intent.putExtra("review", review);
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();

    }

}
