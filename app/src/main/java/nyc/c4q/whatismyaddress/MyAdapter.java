package nyc.c4q.whatismyaddress;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by MarckemX on 11/21/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<Object> myList;

    public MyAdapter(ArrayList<Object>myList){
        this.myList = myList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_for_recycler,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(myList.get(position));
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
}
