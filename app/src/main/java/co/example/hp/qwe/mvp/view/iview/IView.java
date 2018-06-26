package co.example.hp.qwe.mvp.view.iview;


import co.example.hp.qwe.base.BaseIView;
import co.example.hp.qwe.mvp.model.HomeBean;

/**
 * Created by hp on 2018/6/25.
 */

public interface IView extends BaseIView {
           void getSuccess(HomeBean homeBean);
           void getError(String error);


}
