package com.example.kristian.stressfree.Views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kristian.stressfree.Presenters.MainPresenter;
import com.example.kristian.stressfree.Presenters.PicturePresenter;
import com.example.kristian.stressfree.R;
import com.example.kristian.stressfree.Utilities.FullscreenPicActivity;
import com.example.kristian.stressfree.Utilities.Globals;
import com.example.kristian.stressfree.Utilities.ImageAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class PictureActivity extends OptionsMenu implements PicturePresenter.Context{

    GridView gridview;
    private PicturePresenter presenter;
    private Button btAnimals, btNature;
    private String[] mNatureUris, mAnimalUris;
    private int flip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        //region String Arrays
        mNatureUris = new String[]{
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

        mAnimalUris = new String[]{
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

        presenter = new PicturePresenter(this);

        // Initialising widgets
        gridview = findViewById(R.id.gridViewPictures);
        btAnimals = findViewById(R.id.btPicAnimals);
        btNature = findViewById(R.id.btPicNature);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent fullScreenIntent = new Intent(PictureActivity.this, FullscreenPicActivity.class);
                if(flip == 1){
                    fullScreenIntent.putExtra("picURI", mAnimalUris[i]);
                    startActivity(fullScreenIntent);
                } else if (flip == 2){
                    fullScreenIntent.putExtra("picURI", mNatureUris[i]);
                    startActivity(fullScreenIntent);
                } else {
                Toast.makeText(PictureActivity.this, "Error", Toast.LENGTH_LONG).show();
                }

            }
        });

        btAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridview.setAdapter(new ImageAdapter(   PictureActivity.this, mAnimalUris));
                flip = 1;
            }
        });

        btNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gridview.setAdapter(new ImageAdapter(   PictureActivity.this, mNatureUris));
                flip = 2;
            }
        });
    }


}
