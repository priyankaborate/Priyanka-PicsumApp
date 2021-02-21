package com.zinftech.priyaspicsumapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.zinftech.priyaspicsumapp.adapter.AuthorListAdapter;
import com.zinftech.priyaspicsumapp.model.AuthorModel;
import com.zinftech.priyaspicsumapp.viewmodel.AuthorListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<AuthorModel> authorModelList;
    private AuthorListAdapter adapter;
    private AuthorListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView noResult = findViewById(R.id.noResult);

        LinearLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter= new AuthorListAdapter(this,authorModelList);
        recyclerView.setAdapter(adapter);


        viewModel = ViewModelProviders.of(this).get(AuthorListViewModel.class);
        viewModel.getAuthorListObserver().observe(this, new Observer<List<AuthorModel>>() {
            @Override
            public void onChanged(List<AuthorModel> authorModels) {
                if(authorModels != null)
                {
                    authorModelList = authorModels;
                    adapter.setAuthorList(authorModels);
                    noResult.setVisibility(View.GONE);
                }
                else
                {
                    noResult.setVisibility(View.VISIBLE);
                }
            }
        });
        viewModel.makeApiCall();
    }
}