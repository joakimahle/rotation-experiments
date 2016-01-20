package skitsamma.rotationexperiments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "Activity";

    private boolean addToBackStack = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Before super.onCreate");
        super.onCreate(savedInstanceState);
        Log.d(TAG, "After super.onCreate");

        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            Log.d(TAG, "SavedInstanceState is null");
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if(addToBackStack) {
                ft.addToBackStack(null);
            }
            ft.replace(R.id.container, new FragmentA(), "A");
            ft.commit();
        } else {
            Log.d(TAG, "SavedInstanceState is NOT null");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        Log.d(TAG, "onSaveInstanceState");
    }

    /*
    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.d(TAG, "popping backstack");
            fm.popBackStack();
        } else {
            Log.d(TAG, "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }*/

    public void addNextFragment() {
        if(getSupportFragmentManager().findFragmentByTag("C") != null) {
            Log.d(TAG, "All Fragments in FragmentManager already");
        } else if(getSupportFragmentManager().findFragmentByTag("B") != null) {
            Log.d(TAG, "Found B. Adding C");
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if(addToBackStack) {
                ft.addToBackStack(null);
            }
            ft.replace(R.id.container, new FragmentC(), "C");
            ft.commit();
        } else if(getSupportFragmentManager().findFragmentByTag("A") != null) {
            Log.d(TAG, "Found A. Adding B");
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if(addToBackStack) {
                ft.addToBackStack(null);
            }
            ft.replace(R.id.container, new FragmentB(), "B");
            ft.commit();
        } else {
            Log.d(TAG, "No Fragments in FragmentManager");
        }
    }
}
