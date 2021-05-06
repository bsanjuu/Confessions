package mgit.memes.confessions;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AboutFragment extends AppCompatActivity {

    private static final int FRAGMENT_ABOUT_LAYOUT = R.layout.fragment_about;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(FRAGMENT_ABOUT_LAYOUT);
    }
}
