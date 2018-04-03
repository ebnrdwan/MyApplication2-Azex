package com.example.rehaab.myapplication;

import android.provider.BaseColumns;

/**
 * Created by SARA on 30/03/2018.
 */
public class FoundedContract {

    public static class foundedEntry implements BaseColumns {
        public static final String TABLE_NAME = "founded";
        public static final String COLUMN_KIND = "kindName";
        public static final String COLUMN_NUMBERNOW ="current";  //there was a space after the word --> "numberNow " this is
        public static final String COLUMN_NUMBERLOW = "minimum";
        public static final String NOMBER_PHONE= "pnone";


    }
}
