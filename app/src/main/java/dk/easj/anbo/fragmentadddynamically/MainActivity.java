package dk.easj.anbo.fragmentadddynamically;

import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        showFragmentDynamically();
    }

    // Lee page 74
    private void showFragmentDynamically() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // http://stackoverflow.com/questions/5112118/how-to-detect-orientation-of-android-device
            MySimpleFragment fragment = new MySimpleFragment();
            fragmentTransaction.replace(android.R.id.content, fragment);
            // android.R.id.content root element of the view
            // https://stackoverflow.com/questions/7776768/android-what-is-android-r-id-content-used-for
        } else {
            MyAdvancedFragment fragment = new MyAdvancedFragment();
            Bundle parameters = new Bundle();
            parameters.putString(MyAdvancedFragment.MESSAGE, "Hello Anders");
            fragment.setArguments(parameters);
            fragmentTransaction.replace(android.R.id.content, fragment);
        }
        fragmentTransaction.commit();
    }
}