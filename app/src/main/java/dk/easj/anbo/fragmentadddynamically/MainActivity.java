package dk.easj.anbo.fragmentadddynamically;

import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        showFragmentDynamically();
    }

    // Lee page 74
    private void showFragmentDynamically() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //WindowManager windowManager = getWindowManager();
        // Display display = windowManager.getDefaultDisplay();
        //if (display.getWidth() > display.getHeight()) { // Deprecated
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // http://stackoverflow.com/questions/5112118/how-to-detect-orientation-of-android-device
            Fragment1 fragment1 = new Fragment1();
            Bundle parameters = new Bundle();
            parameters.putString(Fragment1.MESSAGE, "Hello Anders");
            fragment1.setArguments(parameters);
            fragmentTransaction.replace(android.R.id.content, fragment1);
        } else {
            Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.replace(android.R.id.content, fragment2);
        }
        fragmentTransaction.commit();
    }
}