package com.cst2335.att0011;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class ChatRoomActivity extends AppCompatActivity {

    public final static String TAG = "ChatRoomActivity";
    MyOpener myMessageOpener;
    SQLiteDatabase db;
    private ArrayList<Message> list = new ArrayList<>();
    Message newMessage;
    String message;
    String messageType;
    MyListAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
        Intent fromProfile = getIntent();

        myMessageOpener = new MyOpener( this );
        db = myMessageOpener.getWritableDatabase();

        Cursor messageResults = db.rawQuery( "Select * from " + MyOpener.TABLE_NAME + ";", null );
        printCursor(messageResults, db.getVersion());
        int idIndex = messageResults.getColumnIndex(MyOpener.COL_ID );
        int messageIndex = messageResults.getColumnIndex(MyOpener.COL_MESSAGE);
        int messageTypeIndex = messageResults.getColumnIndex(MyOpener.COL_MESSAGE_TYPE);
        while (messageResults.moveToNext() ) {
            int id = messageResults.getInt( idIndex );
            String message = messageResults.getString( messageIndex );
            String messageType = messageResults.getString( messageTypeIndex );

            Message loadMessage = new Message( message, messageType, id );
            list.add(loadMessage);
        }
        EditText messagePrompt = findViewById(R.id.chat);
        ListView myList = findViewById(R.id.list_msg);
        myAdapter = new MyListAdapter();
        myList.setAdapter(myAdapter);
        Button sendButton = findViewById(R.id.button_send);
        sendButton.setOnClickListener(click -> {
            message = messagePrompt.getText().toString();
            messageType = "SEND";
            ContentValues newMessageRow = new ContentValues();
            newMessageRow.put(MyOpener.COL_MESSAGE, message);
            newMessageRow.put(MyOpener.COL_MESSAGE_TYPE, messageType);
            long id = db.insert(MyOpener.TABLE_NAME, null, newMessageRow);
            newMessage = new Message(message, messageType, id);
            list.add(newMessage);
            myAdapter.notifyDataSetChanged();
            messagePrompt.setText("");
        });

        Button receiveButton = findViewById(R.id.button_rec);
        receiveButton.setOnClickListener(click -> {
            message = messagePrompt.getText().toString();
            messageType = "RECEIVE";
            ContentValues newMessageRow = new ContentValues();
            newMessageRow.put(MyOpener.COL_MESSAGE, message);
            newMessageRow.put(MyOpener.COL_MESSAGE_TYPE, messageType);
            long id = db.insert(MyOpener.TABLE_NAME, null, newMessageRow);
            newMessage = new Message(message, messageType, id);
            list.add(newMessage);
            myAdapter.notifyDataSetChanged();
            messagePrompt.setText("");
        });
        myList.setOnItemLongClickListener( (p, b, pos, id) -> {
            Message selectedContact = list.get(pos);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Do you want to delete this?")
                    .setMessage("The selected row is:"+ pos + "\n“The database id is:"+id)
                    .setPositiveButton("Yes", (click, arg) -> {
                        list.remove(pos);
                        myAdapter.notifyDataSetChanged();
                        db.delete(MyOpener.TABLE_NAME, MyOpener.COL_ID + "= ?", new String[] {Long.toString(selectedContact.getId())});
                    })
                    .setNegativeButton("No", (click, arg) -> { })
                    .create().show();
            return true;
        });
    }
    public void printCursor(Cursor c, int version) {
        Log.e(TAG, "Database Version Number: " + version);
        Log.e(TAG, "Number of Columns: " + c.getColumnCount());
        Log.e(TAG, "Column Names: " + MyOpener.COL_ID + ", " + MyOpener.COL_MESSAGE + ", " + MyOpener.COL_MESSAGE_TYPE);
        Log.e(TAG, "Number of rows: " + c.getCount());
        Log.e(TAG, "Printing out each Row...");
        int idIndex = c.getColumnIndex(MyOpener.COL_ID );
        int messageIndex = c.getColumnIndex(MyOpener.COL_MESSAGE);
        int messageTypeIndex = c.getColumnIndex(MyOpener.COL_MESSAGE_TYPE);
        while (c.moveToNext() ) {
            long id = c.getInt( idIndex );
            String message = c.getString( messageIndex );
            String messageType = c.getString( messageTypeIndex );
            Log.e(TAG, "ID: " + id + "  Message: " + message + "  Message Type: " + messageType);
        }
        c.moveToPosition(-1);
    }
    private class MyListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public Object getItem(int position) {
            return list.get(position);
        }
        @Override
        public long getItemId(int position) {
            return list.get(position).getId();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View newView = convertView;
            if (list.get(position).getMessageType().equals("SEND")) {
                newView = inflater.inflate(R.layout.row_send, parent, false);
                TextView sendMessage = newView.findViewById(R.id.sendMessage);
                sendMessage.setText(list.get(position).getMessage());
            }
            else if (list.get(position).getMessageType().equals("RECEIVE")) {
                newView = inflater.inflate(R.layout.row_receive, parent, false);
                TextView receiveMessage = newView.findViewById(R.id.receiveMessage);
                receiveMessage.setText(list.get(position).getMessage());
            }
            //}
            return newView;
        }

    }
    public class Message {
        String message;
        String messageType;
        long id;

        public Message(String message, String messageType, long _id) {
            this.message = message;
            this.messageType = messageType;
            this.id = _id;
        }

        public String getMessage() {
            return message;
        }

        public String getMessageType() {
            return messageType;
        }

        public long getId() {
            return id;
        }
    }
}