package com.github.rodrigohenriques.dagger2sample;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.edittext_tv_show) EditText mEditTextTvShow;
    @Bind(R.id.edittext_season) EditText mEditTextSeason;
    @Bind(R.id.recyclerview) RecyclerView mRecyclerView;

    BackendService mBackendService;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mBackendService = new BackendService();
    }

    @OnClick(R.id.button_query)
    public void queryData() {
        if (mEditTextTvShow.getText().toString().isEmpty() || mEditTextSeason.getText().toString().isEmpty())
            return;

        mProgressDialog = ProgressDialog.show(this, "Aguarde", "Carregando lista de episódios...");

        String tvShow = mEditTextTvShow.getText().toString();
        int season = Integer.parseInt(mEditTextSeason.getText().toString());

        mBackendService.getTvShow(tvShow, season, new Callback<QueryResult>() {
            @Override
            public void onResponse(final Response<QueryResult> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    mRecyclerView.setAdapter(new EpisodeAdapter(response.body().episodes));
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
                }
                mProgressDialog.dismiss();
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("Retrofit", t.getMessage(), t);
                Snackbar.make(mRecyclerView, "shit happened: " + t.getMessage(), Snackbar.LENGTH_LONG).show();
                mProgressDialog.dismiss();
            }
        });
    }
}
