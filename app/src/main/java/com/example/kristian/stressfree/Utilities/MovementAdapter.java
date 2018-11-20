package com.example.kristian.stressfree.Utilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kristian.stressfree.Models.Exercise;
import com.example.kristian.stressfree.R;

import java.util.List;

public class MovementAdapter extends ArrayAdapter<Exercise> {
    private Context mContext;
    private List<Exercise> le;

    public MovementAdapter(Context context, List<Exercise> itemList) {
        super(context, 0, itemList);
        this.mContext = context;
        this.le = itemList;
    }

    public int getCount() {
        return le.size();
    }

    public Exercise getItem(int position) {
        return le.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.movement_item, parent, false);
        }

        Exercise currentEx = le.get(position);
        TextView name = v.findViewById(R.id.twName);
        name.setText(currentEx.getExerciseName());
        TextView difficulty = v.findViewById(R.id.twDifficulty);
        difficulty.setText(currentEx.getExerciseDifficulty().toString());


        if (currentEx.getExerciseDifficulty() == 1)
            difficulty.setBackgroundResource(R.color.yellow);
        else if (currentEx.getExerciseDifficulty() == 2)
            difficulty.setBackgroundResource(R.color.orange);
        else
            difficulty.setBackgroundResource(R.color.red);


        return v;
    }
}
