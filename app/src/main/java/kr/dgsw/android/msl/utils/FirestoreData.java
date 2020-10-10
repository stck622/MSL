package kr.dgsw.android.msl.utils;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class FirestoreData {
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static void getStoreList(ObservableArrayList<Store> items) {
        db.collection("store").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Store item = document.toObject(Store.class);
                        items.add(item);
                    }
                } else {
                    Log.w("e", "Error getting documents.", task.getException());
                }
            }
        });
    }

    public static void getReviewList(ObservableArrayList<Review> items, String id) {
        db.collection("store").document(id).collection("review").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Review item = document.toObject(Review.class);
                        Log.e("essas", item.getContext());
                        items.add(item);
                    }
                } else {
                    Log.w("e", "Error getting documents.", task.getException());
                }
            }
        });
    }

    public static void addReview(ObservableArrayList<Review> items, Review review, Store store) {

        db.collection("store").document(store.getPlaceId()).collection("review")
                .add(review)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        db.collection("store").document(store.getPlaceId()).update("starTotal", review.getStar() + store.getStarTotal());
                        db.collection("store").document(store.getPlaceId()).update("starCounter", store.getStarCounter() + 1);
                        items.add(review);
                    }
                });
    }

}
