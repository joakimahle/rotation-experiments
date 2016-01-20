package skitsamma.rotationexperiments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentC extends Fragment implements View.OnClickListener {

    private final String TAG = "Fragment C";

    private String explicitlySavedObjectForCreate;
    private String explicitlySavedObjectForView;

    private String implicitlySavedPrimitiveObject;
    private ComplexObject implicitlySavedComplexObject;

    private boolean retainInstance = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(retainInstance);
        if(savedInstanceState == null) {
            Log.d(TAG, "OnCreate called. SavedInstanceState is null");
            explicitlySavedObjectForCreate = "Fragment C's explicity saved Object for the creation";
        } else {
            Log.d(TAG, "OnCreate called. SavedInstanceState is NOT null");
            explicitlySavedObjectForCreate = savedInstanceState.getString("create") + " from bundle";
        }

        Log.d(TAG, "Retain instance = " + retainInstance);

        implicitlySavedPrimitiveObject = "Fragment C's implicitly saved primitive object";
        implicitlySavedComplexObject = new ComplexObject("Fragment C");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(savedInstanceState == null) {
            Log.d(TAG, "onCreateView called. SavedInstanceState is null");
            explicitlySavedObjectForView = "Fragment C's explicity saved Object for the view";
        } else {
            Log.d(TAG, "onCreateView called. SavedInstanceState is NOT null");
            explicitlySavedObjectForView = savedInstanceState.getString("view") + " from bundle";
        }

        View view = inflater.inflate(R.layout.fragment_base, container, false);
        TextView name = (TextView) view.findViewById(R.id.fragment_name);
        name.setText("Fragment C");
        Button next = (Button) view.findViewById(R.id.next);
        next.setOnClickListener(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "On Resume");
        Log.d(TAG, "Printing objects: ");
        Log.d(TAG, "explicitlySavedObjectForCreate: " + explicitlySavedObjectForCreate);
        Log.d(TAG, "explicitlySavedObjectForView: " + explicitlySavedObjectForView);
        Log.d(TAG, "implicitlySavedPrimitiveObject: " + implicitlySavedPrimitiveObject);
        if(implicitlySavedComplexObject != null) {
            Log.d(TAG, "implicitlySavedComplexObject: " + implicitlySavedComplexObject.toString());
        } else {
            Log.d(TAG, "implicitlySavedComplexObject: Completely NULL");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "On Pause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "On Save Instance State");
        outState.putString("create", explicitlySavedObjectForCreate);
        outState.putString("view", explicitlySavedObjectForView);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "On Detach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "On Destroy");
    }

    @Override
    public void onClick(View v) {
        MainActivity activiy = (MainActivity) getActivity();
        activiy.addNextFragment();
    }
}
