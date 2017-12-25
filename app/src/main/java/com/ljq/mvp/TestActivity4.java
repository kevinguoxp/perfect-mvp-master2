package com.ljq.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ljq.mvp.demo4.RequestPresenter4;
import com.ljq.mvp.demo4.RequestView4;
import com.ljq.mvp.demo4.base.AbstractMvpActivity;
import com.ljq.mvp.demo4.base.AbstractMvpPersenter4;
import com.ljq.mvp.request.WeatherBean;
import com.ljq.mvp.util.FieldView;
import com.ljq.mvp.util.ViewFind;

/**
 * author:  Thomas
 * e-mail:  Cross.Guo@newpostech.com
 * date:	2017/12/11 11:25
 * describe:
 */

public class TestActivity4 extends AbstractMvpActivity implements RequestView4 {

    private RequestPresenter4 mRequestPresenter4;
    @FieldView(R.id.tv_text)
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRequestPresenter4.attachMvpView(this);
        ViewFind.bind(this);
    }

    //点击事件
    public void request(View view) {
        Log.e("perfect-mvp","点击事件");
        mRequestPresenter4.clickRequest("101010100");
    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        mRequestPresenter4.detachMvpView();
    }

    @Override
    protected AbstractMvpPersenter4 createPresenter() {
        mRequestPresenter4 = new RequestPresenter4();
        return mRequestPresenter4;
    }

    @Override
    public void requestLoading() {
        textView.setText("请求中,请稍后...");
    }

    @Override
    public void resultSuccess(WeatherBean result) {
        //成功
        textView.setText(result.getWeatherinfo().toString());
    }

    @Override
    public void resultFailure(String result) {
        //失败
        textView.setText(result);
    }
}
