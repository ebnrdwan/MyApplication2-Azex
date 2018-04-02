package com.wafaaelm3andy.pronote;

import android.provider.BaseColumns;

/**
 * Created by wafaa on 2/15/2018.
 */

public class NoteContract {
    public static final class NotelistEntry implements BaseColumns {

        //table name and each of the db columns
    public static final String TABLE_NAME = "Notelist";
    public static final String COLUMN_TITle= "title";
    public static final String COLUMN_DETAILS = "details";
    public static final String COLUMN_PURITY = "purity";
        }


}
