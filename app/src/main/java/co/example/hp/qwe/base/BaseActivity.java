package co.example.hp.qwe.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hp on 2018/6/25.
 */

public abstract class BaseActivity<P extends BasePresenter>extends AppCompatActivity {
      protected P prenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getonPrenterId());
        prenter=onpresenter ();
        intView();
        initLisenter();
        initData();
    }

    protected abstract void initData();
    protected abstract void initLisenter();
    protected abstract void intView();
    protected abstract P onpresenter();
    protected abstract int getonPrenterId();



}
