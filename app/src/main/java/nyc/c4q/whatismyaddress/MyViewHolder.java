package nyc.c4q.whatismyaddress;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MarckemX on 11/21/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public MyViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(Object object){
        String stringObject = object.toString();
        TextView textView = itemView.findViewById(R.id.text_item);
        textView.setText(stringObject);
    }
}
