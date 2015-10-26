package google.material.com.listview;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rohit on 10/26/15.
 */
public class FriendAdapter extends ArrayAdapter<Friend> {
    // View lookup cache
    Context ctx;



    private static class ViewHolder {
        TextView name;
        TextView phonenumber;
        ImageView image;

    }

    public FriendAdapter(Context context, ArrayList<Friend> users) {
        super(context, R.layout.contact_detail, users);
        ctx =context;
    }

    @Override
    public int getPosition(Friend item) {
        return super.getPosition(item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Friend friend = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            if (position==0){convertView = inflater.inflate(R.layout.contact_detail_first, parent, false);} else{convertView = inflater.inflate(R.layout.contact_detail, parent, false);}

            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.phonenumber = (TextView) convertView.findViewById(R.id.phonenumber);
            viewHolder.image=(ImageView)convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.name.setText(friend.name);
        viewHolder.phonenumber.setText(friend.phonenumber);

        int resId = ctx.getResources().getIdentifier(friend.image, "drawable", ctx.getPackageName());
        viewHolder.image.setImageResource(resId);

        // Return the completed view to render on screen
        return convertView;
    }
}

