package co.example.hp.qwe.mvp.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import co.example.hp.qwe.R;
import co.example.hp.qwe.app.MyApp;
import co.example.hp.qwe.mvp.model.HomeBean;


/**
 * Created by hp on 2018/6/25.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.One>{

            public List<HomeBean.DataBeanX.DataBean>list;

           private static final String TAG = "HomeAdapter";

    public HomeAdapter(List<HomeBean.DataBeanX.DataBean> list) {
        this.list = list;
        Log.d(TAG, "onBindViewHolder: "+list.size());
    }

    @Override
    public One onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.one, parent, false);
        One one = new One(itemView);

        Log.d(TAG, "onCreateViewHolder: vvvvvvvv==========="+itemView);
        return one;
    }

    @Override
    public void onBindViewHolder(One holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+list.size());
        Log.d(TAG, "onBindViewHolder: "+list.get(position).getTitle());
        holder.oneTvName.setText(list.get(position).getTitle());
        holder.oneTvPrice.setText((int) list.get(position).getViews()+"");
        String p1 = "http://365jia.cn/uploads/"+list.get(position).getPics().get(0);

        ImageLoader.getInstance().displayImage(p1,holder.oneIvImage, MyApp.getOptions());
    }

   /* @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }*/

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    //加载布局
    public class One extends RecyclerView.ViewHolder {
        private final TextView oneTvPrice;
        private final TextView oneTvName;
        private final ImageView oneIvImage;
        public One(View itemView) {
            super(itemView);
            oneTvPrice = itemView.findViewById(R.id.one_tv_price);
            oneTvName = itemView.findViewById(R.id.ont_tv_name);
            oneIvImage = itemView.findViewById(R.id.one_iv_image);
        }
    }

}
