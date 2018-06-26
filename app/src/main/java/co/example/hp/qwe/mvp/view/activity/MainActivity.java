package co.example.hp.qwe.mvp.view.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import co.example.hp.qwe.R;
import co.example.hp.qwe.base.BaseActivity;
import co.example.hp.qwe.mvp.model.HomeBean;
import co.example.hp.qwe.mvp.presenter.HomePresenter;
import co.example.hp.qwe.mvp.view.adapter.HomeAdapter;
import co.example.hp.qwe.mvp.view.adapter.MyAdapter;
import co.example.hp.qwe.mvp.view.iview.IView;

public class MainActivity extends BaseActivity<HomePresenter> implements IView {
    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    public List<HomeBean.DataBeanX.DataBean> list=new ArrayList<>();
    private HomeAdapter homeAdapter;
    @Override
    protected HomePresenter onpresenter() {
        return new HomePresenter(this) ;
    }

    @Override
    protected int getonPrenterId() {
        return R.layout.activity_main;
    }

    @Override
    protected void intView() {
        recyclerView = findViewById(R.id.recycler_view);
        Log.d(TAG, "intView: aaaaaa====="+recyclerView);
    }

    @Override
    protected void initLisenter() {
    }
    @Override
    protected void initData() {
        prenter.homes();
    }
    @Override
    public Context context() {
        return context();
    }

    @Override
    public void getSuccess(HomeBean homeBean) {
        Log.d(TAG, "getSuccess: ccccccccccccccccccc=========="+homeBean);
        List<HomeBean.DataBeanX.DataBean> jsonBeans = homeBean.getData().getData();
        list.addAll(jsonBeans);
        HomeAdapter homeAdapter = new HomeAdapter(list);
        //MyAdapter myAdapter = new MyAdapter(list);
        Log.d(TAG, "getSuccess: cdddddddddddddd=========="+list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);


        recyclerView.setAdapter(homeAdapter);
        Log.d(TAG, "getSuccess: addda=========="+homeAdapter);

    }

    @Override
    public void getError(String error) {
        Log.d(TAG, "getError: "+error);
    }

}
