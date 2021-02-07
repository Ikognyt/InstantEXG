package com.example.instantexg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.instantexg.Utils.TaskManager;
import com.example.instantexg.domains.apiAcess;
import com.example.instantexg.domains.dropDownOptions;
import com.example.instantexg.webservice.api;
import com.example.instantexg.webservice.apiConfig;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public Spinner spinner;
    public EditText editTextNumberDecimal;
    public TextView textView_result_total;

    private MainActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Conversor de Moedas");
        setContentView(R.layout.activity_main);

        try {

            mActivity = this;

            setComponents();
            setComponentsValues();

        } catch (Exception ex) {
            Log.e(TAG, "onCreate: ", ex);
        }
    }

    private void setComponents() {
        spinner = findViewById(R.id.spinner);
        editTextNumberDecimal = findViewById(R.id.editTextNumberDecimal);
        textView_result_total = findViewById(R.id.textView_result_total);
    }

    private void setComponentsValues() {
        try {

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position != 0) {
                        new apiAcess(mActivity).getCoin(dropDownOptions.dropMenu(position));
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        } catch (Exception ex) {
            Log.e(TAG, "setComponentsValues: ", ex);
        }
    }

}