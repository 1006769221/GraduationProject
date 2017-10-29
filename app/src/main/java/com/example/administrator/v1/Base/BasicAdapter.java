package com.example.administrator.v1.Base;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.v1.R;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 */

public class BasicAdapter extends RecyclerView.Adapter<BasicAdapter.VH> {

    //数据
    List<UserData> data;

    recharge rechargeEx;


    public BasicAdapter(recharge recharge) {
        rechargeEx=recharge;
        data = new ArrayList<>();
        data.add(buildData("1","辽A10001", "车主：张三", "余额：100元",1));
        data.add(buildData("2","辽A10002", "车主：李四", "余额：99元",2));
        data.add(buildData("3","辽A10003", "车主：王五", "余额：103元",1));
        data.add(buildData("4","辽A10004", "车主：赵六", "余额：1元",2));
    }

    UserData buildData(String num,String carID, String carUser, String carBalance,int type) {
        UserData data = new UserData();
        data.num = num;
        data.carID = carID;
        data.carUser = carUser;
        data.carBalance = carBalance;
        data.type=type;
        return data;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new VH(v);

    }

    @Override
    public void onBindViewHolder(VH v, int position) {
        UserData datas = data.get(position);
        v.num.setText(datas.num);
        v.carID.setText(datas.carID);
        v.carUser.setText(datas.carUser);
        v.carBalance.setText(datas.carBalance);
        int ResourceID=0;
        switch(datas.type){
            case 1:
                ResourceID=R.drawable.bc;
                break;
            case 2:
                ResourceID=R.drawable.zh;
                break;
            case 3:
                ResourceID=R.drawable.bmw;
                break;
            case 4:
                ResourceID=R.drawable.mzd;
                break;
                default:
                    break;
        }
        v.carImg.setImageResource(ResourceID);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }




    class VH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView num, carID, carUser, carBalance;
        ImageView carImg;
        Button recharge;
        public VH(View itemView) {
            super(itemView);
            num = itemView.findViewById(R.id.num);
            carID = itemView.findViewById(R.id.carId);
            carUser = itemView.findViewById(R.id.carUser);
            carBalance = itemView.findViewById(R.id.carBalance);
            carImg = itemView.findViewById(R.id.img);
            recharge = itemView.findViewById(R.id.carRecharge);
            recharge.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.carRecharge:
                    rechargeEx.clickCharge();
                    break;
            }
        }
    }
}
