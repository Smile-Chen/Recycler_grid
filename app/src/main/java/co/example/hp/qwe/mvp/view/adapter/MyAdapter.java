package co.example.hp.qwe.mvp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.example.hp.qwe.R;
import co.example.hp.qwe.mvp.model.HomeBean;

/**
 * Created by hp on 2018/6/26.
 */

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder>{
    private List<HomeBean.DataBeanX.DataBean> list;

    public MyAdapter(List<HomeBean.DataBeanX.DataBean> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =LayoutInflater.from(parent.getContext()).inflate(R.layout.one, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.oneTvName.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView oneTvPrice;
        private final TextView oneTvName;
        private final ImageView oneIvImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            oneTvPrice = itemView.findViewById(R.id.one_tv_price);
            oneTvName = itemView.findViewById(R.id.ont_tv_name);
            oneIvImage = itemView.findViewById(R.id.one_iv_image);
        }
    }
}
