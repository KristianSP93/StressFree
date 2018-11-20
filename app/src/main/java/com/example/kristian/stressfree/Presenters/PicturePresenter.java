package com.example.kristian.stressfree.Presenters;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.kristian.stressfree.Views.PictureActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class PicturePresenter {
    private PicturePresenter.Context view;
    private Uri tUri;
    private FirebaseAuth mAuth;
    private String PICTUREPRESENTER = "PICTURE PRESENTER";
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private StorageReference storageRef;
    private Uri[] naturePicArray;
    private Uri tempUri;
    private String[] NatureURIarray, AnimalURIarray;

    // Constructor
    public PicturePresenter(PicturePresenter.Context view) {
        this.view = view;
        mAuth = FirebaseAuth.getInstance();
        storageRef = storage.getReference();

        //region String Arrays
        NatureURIarray = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2F1.jpg?alt=media&token=777ecaa1-4ba3-4e95-af2c-4a2347ffc49e",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2F2.jpg?alt=media&token=72edfd5b-5d48-43dd-8b00-dbbb4c098888",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2F3.jpg?alt=media&token=a19e3f04-2bfa-4ca8-be98-5dd801275227",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2F4.jpg?alt=media&token=8f47431d-6684-40a4-9d92-202b06ceb9eb",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2F5.jpg?alt=media&token=9bac7899-e0b6-4420-a821-b717ce51a329",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2F6.jpg?alt=media&token=ec9bdd45-1fd4-49f8-b100-6be8e0c089ab",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2F7.jpg?alt=media&token=1cd8fb00-f282-4e72-9b21-318eb1532a12",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2F8.jpg?alt=media&token=262d2363-e765-453a-b51f-f2af6c5aa0b6",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2F9.jpg?alt=media&token=56c750d0-6405-4ffb-872e-5be4c96c3364",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureNature%2F10.jpg?alt=media&token=9c3313c7-7199-421f-af67-6815f9c87aefm"
        };

        AnimalURIarray = new String[]{
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureAnimal%2F1.jpg?alt=media&token=27390594-9144-4d63-897d-447ef90eb049",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureAnimal%2F2.jpg?alt=media&token=0a737656-d3b4-4fd6-8126-97b488d48940",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureAnimal%2F3.jpg?alt=media&token=a5ef826e-870a-42f5-b407-580ca860a762",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureAnimal%2F4.jpg?alt=media&token=f630d2c9-dc83-46da-85f1-b31a51f1377c",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureAnimal%2F5.jpg?alt=media&token=5b70f547-3628-4354-9982-66a74fe643f7",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureAnimal%2F6.jpg?alt=media&token=98843b63-2b4d-43f3-a74d-f58a092aa667",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureAnimal%2F7.jpg?alt=media&token=ee315d64-dd84-4273-b34d-ed68febf2ad1",
                "https://firebasestorage.googleapis.com/v0/b/stressfree-d7977.appspot.com/o/PictureAnimal%2F8.jpg?alt=media&token=9c286448-c495-4882-8a2d-0dd06c85b97a"
        };
        //endregion
    }

    public String[] getAnimalURIarray(){
        return AnimalURIarray;
    }

    public String[] getNatureURIarray(){
        return NatureURIarray;
    }

    //region Firebase getURI methods - Implemented a different way
    public Uri getPictureURI() {
        storageRef.child("PictureNature/1.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                tUri = uri;

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.d(PICTUREPRESENTER, exception.toString());
            }
        });
        return tUri;
    }


    public Uri[] getAllNaturePictures() {
        naturePicArray = new Uri[10];
        for (int i = 1; i < naturePicArray.length; i++) {
            storageRef.child("PictureNature/" + i + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    tempUri = uri;
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Log.d(PICTUREPRESENTER, exception.toString());
                }
            });
            naturePicArray[i] = tempUri;
        }
        return naturePicArray;
    }


    public void getPictures() throws IOException {
        StorageReference picturesRef = storageRef.child("PictureNature/beautiful_green_forest_background.png");
        File localFile = File.createTempFile("images", "png");
        picturesRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Successfully downloaded data to local file
                        // ...

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle failed download
                        // ...
                    }
                });
    }

    //endregion


    // Interface to the methods in PictureActivity
    public interface Context {

    }
}
