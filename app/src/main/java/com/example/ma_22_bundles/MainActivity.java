package com.example.ma_22_bundles;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Lifecycle";
    private static final int DEFAULT_VALUE = 0;

    private int valueThatMustSurviveDestruction = DEFAULT_VALUE;
    private static final String VTMSD_NAME = "valueThatMustSurviveDestruction";

    TextView tv_vtmbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_vtmbs = (TextView) findViewById(R.id.tv_vtmbs);
        Log.d(TAG, "before check bundle onCreate, valueThatMustSurviveDestruction=" + Integer.toString(valueThatMustSurviveDestruction));

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            valueThatMustSurviveDestruction = savedInstanceState.getInt(VTMSD_NAME);
            Log.d(TAG, "there was ating VTMSD, valueThatMustSurviveDestruction=" + Integer.toString(valueThatMustSurviveDestruction));
        }

        //increment default value
        valueThatMustSurviveDestruction++;
        tv_vtmbs.setText(Integer.toString(valueThatMustSurviveDestruction));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    /**
     * The following 2 are for handling rotations
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState, i=" + Integer.toString(valueThatMustSurviveDestruction));

        outState.putInt(VTMSD_NAME, valueThatMustSurviveDestruction);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState, i=" + Integer.toString(valueThatMustSurviveDestruction));
        tv_vtmbs.setText(Integer.toString(valueThatMustSurviveDestruction));
    }

    public void doClick(View view) {
    }
}