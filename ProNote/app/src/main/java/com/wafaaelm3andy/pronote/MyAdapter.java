package com.wafaaelm3andy.pronote;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wafaa on 1/30/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.NoteHolder> {
     Cursor cursor ;
    Context context ;

    final private ListItemClickListener listItemClickListener  ;




    /**
     * The interface that receives onClick messages.
     */
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
    public MyAdapter(Cursor cursor ,Context context, ListItemClickListener listener){
        this.cursor=cursor;
        listItemClickListener = listener ;
        this.context=context ;
    }


    @Override
    public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
        int layoutIdForListItem = R.layout.list_item ;
        LayoutInflater inflater =LayoutInflater.from(context);
        boolean shouldAttachToPerentImmediatly =false ;
        View view =inflater.inflate(layoutIdForListItem,parent,shouldAttachToPerentImmediatly);
        NoteHolder noteHolder = new NoteHolder(view);
        //noteHolder.titleView.setText("ViewHolder index: ");
        return noteHolder;

    }

    @Override
    public void onBindViewHolder(NoteHolder holder, int position) {
        if (!cursor.moveToPosition(position))
            return;
        String title= cursor.getString(cursor.getColumnIndex(NoteContract.NotelistEntry.COLUMN_TITle));
        String details= cursor.getString(cursor.getColumnIndex(NoteContract.NotelistEntry.COLUMN_DETAILS));
        String purity= cursor.getString(cursor.getColumnIndex(NoteContract.NotelistEntry.COLUMN_PURITY));
        long id = cursor.getLong(cursor.getColumnIndex(NoteContract.NotelistEntry._ID));
        holder.titleView.setText(title);
        holder.detaliesView.setText(details+"\n"+purity);
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (cursor != null) cursor.close();
        cursor = newCursor;
        if (newCursor != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }}

    public  class  NoteHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        TextView titleView ;
        TextView detaliesView ;

        public NoteHolder(View itemView){
            super(itemView);
            titleView =(TextView)itemView.findViewById(R.id.title );
            detaliesView=(TextView)itemView.findViewById(R.id.details);
            itemView.setOnClickListener(this);

        }




        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            listItemClickListener.onListItemClick(clickedPosition);

        }
        }
    }
