package com.example.instantexg.domains;

import android.util.Log;

public abstract class dropDownOptions {

    private static final String TAG = "dropDownOptions";


    public static String dropMenu(int option) {
        String optionDropMenu = "";

        try {
            switch(option)
            {
                case 1:
                    optionDropMenu = "USD";
                    break;
                case 2:
                    optionDropMenu = "USDT";
                    break;
                case 3:
                    optionDropMenu = "CAD";
                    break;
                case 4:
                    optionDropMenu = "EUR";
                    break;
                case 5:
                    optionDropMenu = "GBP";
                    break;
                case 6:
                    optionDropMenu = "ARS";
                    break;
                case 7:
                    optionDropMenu = "BTC";
                    break;
                case 8:
                    optionDropMenu = "LTC";
                    break;
                case 9:
                    optionDropMenu = "JPY";
                    break;
                case 10:
                    optionDropMenu = "CHF";
                    break;
                case 11:
                    optionDropMenu = "AUD";
                    break;
                case 12:
                    optionDropMenu = "CNY";
                    break;
                case 13:
                    optionDropMenu = "ILS";
                    break;
                case 14:
                    optionDropMenu = "ETH";
                    break;
                case 15:
                    optionDropMenu = "XRP";
                    break;
            }

        } catch (Exception ex){
            Log.e(TAG, "onFailure: ");
        }

        return optionDropMenu;
    }



}
