package kr.dgsw.android.msl.utils;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class FirestoreData {
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static void getStoreList(ObservableArrayList<StoreListItem> items){
        db.collection("store").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        StoreListItem item  = document.toObject(StoreListItem.class);
                        items.add(item);
                    }
                } else {
                    Log.w("e", "Error getting documents.", task.getException());
                }
            }
        });
    }

}
