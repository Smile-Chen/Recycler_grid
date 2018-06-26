package co.example.hp.qwe.mvp.presenter;

import android.util.Log;

import co.example.hp.qwe.base.BasePresenter;
import co.example.hp.qwe.mvp.model.HomeBean;
import co.example.hp.qwe.mvp.model.HomeModel;
import co.example.hp.qwe.mvp.view.iview.IView;


/**
 * Created by hp on 2018/6/25.
 */

public class HomePresenter extends BasePresenter<IView> {
          protected HomeModel homeModel;
    private static final String TAG = "HomePresenter";
    public HomePresenter(IView view) {
        super(view);
    }

    @Override
    protected void onModel() {
        homeModel=new HomeModel();
    }

    public void homes(){
              homeModel.homes(new HomeModel.InClient() {
                  @Override
                  public void getSuccess(HomeBean homeBean) {
                      if (view!=null){
                         view.getSuccess(homeBean);
                          Log.d(TAG, "getSuccess: sssssssssss=========="+homeBean);
                      }
                  }

                  @Override
                  public void getError(String error) {
                      if (view!=null){
                          view.getError(error);
                      }
                  }
              });

    }


}
