package com.example.instantexg.domains;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.instantexg.MainActivity;
import com.example.instantexg.Utils.TaskManager;
import com.example.instantexg.models.coin;
import com.example.instantexg.webservice.api;
import com.example.instantexg.webservice.apiConfig;
import com.google.gson.Gson;

import org.json.JSONObject;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class apiAcess {

    private static final String TAG = "apiAcess";

    private MainActivity mActivity;

    public apiAcess(MainActivity mActivity) {
        this.mActivity = mActivity;
    }

    public void getCoin(String moeda) {
        try {

            String qtd = mActivity.editTextNumberDecimal.getText().toString();

            if (!qtd.isEmpty()) {
                TaskManager.getINSTANCE().createTask(() -> {
                    final api getCoin = apiConfig.createService(api.class);

                    Call<ResponseBody> callApi = getCoin.typeCoinAll(String.format("%s-BRL", moeda));

                    callApi.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()) {
                                try {
                                    JSONObject obj = new JSONObject(response.body().string());

                                    coin c = new Gson().fromJson(obj.getJSONObject(moeda).toString(), coin.class);

                                    new Handler(Looper.getMainLooper()).post(() -> {
                                        mActivity.textView_result_total.setText(String.format("R$: %.2f", sumValues(c.getBid(), Double.parseDouble(qtd))));
                                    });

                                } catch (Exception ex) {
                                    Log.e(TAG, "createTask: ", ex);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Log.e(TAG, "onFailure: ", t);
                        }
                    });
                });
            } else {
                Toast.makeText(mActivity, "Nenhum valor inserido!", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Log.e(TAG, "getCoin: ", ex);
        }
    }

    private Double sumValues(Double coin, Double qtd) {
        try {
            return coin + qtd;
        } catch (Exception ex) {
            Log.e(TAG, "sumValues: ", ex);
            return 0.0;
        }
    }
}
