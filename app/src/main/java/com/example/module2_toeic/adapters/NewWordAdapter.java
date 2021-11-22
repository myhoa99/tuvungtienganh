package com.example.module2_toeic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.module2_toeic.R;
import com.example.module2_toeic.models.NewWordModel;
import com.example.module2_toeic.models.TopicModel;

import java.util.HashMap;
import java.util.List;

public class NewWordAdapter extends BaseAdapter {
    List<NewWordModel> newWordModels;

    HashMap<String, List<NewWordModel>> NewWordModelHashMap;

    public NewWordAdapter(List<NewWordModel> newWordModels, Context context, HashMap<String, List<NewWordModel>> newWordModelHashMap) {
        this.newWordModels = newWordModels;
        NewWordModelHashMap = newWordModelHashMap;
    }

    @Override
    public int getCount() {
        return newWordModels.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_new_word,parent,false);
        NewWordModel newWordModel = newWordModels.get(position);
        TextView tvEnglish = convertView.findViewById(R.id.tv_english);
        TextView tvVietnamese = convertView.findViewById(R.id.tv_vietnamese);
        tvEnglish.setText(newWordModel.getWord());
        tvVietnamese.setText(newWordModel.getVietnamese());
        return convertView;
    }
}
