package com.hong.hi_fragex;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class listviewAdapter extends BaseAdapter {

    public ArrayList<Model> wearhousingList;
    Activity activity;

    public listviewAdapter(Activity activity, ArrayList<Model> wearhousingList) {
        super();
        this.activity = activity;
        this.wearhousingList = wearhousingList;
    }

    @Override
    public int getCount() {
        return wearhousingList.size();
    }

    @Override
    public Object getItem(int position) {
        return wearhousingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView mLabelNo;
        TextView mMaterialNm;
        TextView mMaterialCd;
        TextView mMaterialWh;
        TextView mMaterialEa;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_row, null);
            holder = new ViewHolder();
            holder.mLabelNo = (TextView) convertView.findViewById(R.id.labelNo);
            holder.mMaterialNm = (TextView) convertView.findViewById(R.id.materialNm);
            holder.mMaterialCd = (TextView) convertView.findViewById(R.id.materialCd);
            holder.mMaterialWh = (TextView) convertView.findViewById(R.id.materialWh);
            holder.mMaterialEa = (TextView) convertView.findViewById(R.id.materialEa);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Model item = wearhousingList.get(position);
        holder.mLabelNo.setText(item.getlabelNo().toString());
        holder.mMaterialNm.setText(item.getmaterialNm().toString());
        holder.mMaterialCd.setText(item.getmaterialCd().toString());
        holder.mMaterialWh.setText(item.getmaterialWh().toString());
        holder.mMaterialEa.setText(item.getMaterialEa().toString());

        return convertView;
    }
}
