import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ContactAdapter extends CursorAdapter {
    public ContactAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView phoneTextView = view.findViewById(R.id.phoneTextView);

        String contactName = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String phoneNumber = cursor.getString(cursor.getColumnIndexOrThrow("phone_number"));

        nameTextView.setText(contactName);
        phoneTextView.setText(phoneNumber);
    }
}