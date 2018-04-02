package com.example.rehaab.myapplication;


import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.content.Context;

public class Data extends RecyclerView.Adapter <Data.NumberViewHolder> {
    Cursor cursor;
    Context context;


    public Data(Cursor cursor, Context context) {
        this.cursor = cursor;
        this.context = context;
    }


    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.desig;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToPerentImmediatly = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToPerentImmediatly);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        if (!cursor.moveToPosition(position))
            return;
if (cursor!=null&& cursor.getCount()>0){
    String kind = cursor.getString(cursor.getColumnIndex(FoundedContract.foundedEntry.COLUMN_KIND));
    String numberNow = cursor.getString(cursor.getColumnIndex(FoundedContract.foundedEntry.COLUMN_KIND));
    long id = cursor.getLong(cursor.getColumnIndex(FoundedContract.foundedEntry._ID));
    holder.data.setText(kind);
    holder.number.setText(numberNow);
}


    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (cursor != null) cursor.close();
        cursor = newCursor;
        if (newCursor != null) {
            this.notifyDataSetChanged();
        }
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView data;
        TextView number;

        public NumberViewHolder(View itemView) {
            super(itemView);

            data = (TextView) itemView.findViewById(R.id.a);
            number = (TextView) itemView.findViewById(R.id.b);

        }

    }
}


