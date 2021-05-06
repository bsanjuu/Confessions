package mgit.memes.confessions;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class Detail extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    private static final int ACTIVITY_DETAIL_LAYOUT = R.layout.activity_detail;

    private static final int TOOLBAR_ID = R.id.toolbar;
    private static final int COLLAPSING_TOOLBAR_ID = R.id.collapsing_toolbar;
    private static final int VIEW_MESSAGE_ID = R.id.view_message;
    private static final int CIRCULAR_PROGRESS_DETAIL_ID = R.id.circular_progress_detail;
    private static final int IMAGE_ID = R.id.image;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ACTIVITY_DETAIL_LAYOUT);

        Toolbar toolbar = findViewById(TOOLBAR_ID);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(view -> {
            //startActivity(new Intent(getApplicationContext(), DashBoard.class));
            onSupportNavigateUp();
        });


        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                findViewById(COLLAPSING_TOOLBAR_ID);
        // Set title of Detail page
        collapsingToolbar.setTitle(" ");

        Bundle bundle = getIntent().getExtras();

        int position = bundle.getInt(EXTRA_POSITION);
        String text, imagePath;
        text = bundle.getString("Text");
        imagePath = bundle.getString("ImagePath");

        TextView message = findViewById(VIEW_MESSAGE_ID);
        message.setText(text);

        ProgressBar circular_progress = findViewById(CIRCULAR_PROGRESS_DETAIL_ID);

        ImageView image = findViewById(IMAGE_ID);
        //Progressing
        circular_progress.setVisibility(View.VISIBLE);
        //Loading image from Glide library.
        if (imagePath != null) {
            Glide.with(Detail.this).load(imagePath).into(image);
            circular_progress.setVisibility(View.INVISIBLE);
        } else {
            image.setImageResource(R.color.colorPrimary);
            circular_progress.setVisibility(View.INVISIBLE);
        }

    }
}
