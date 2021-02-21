package com.zinftech.priyaspicsumapp.viewmodel;

import com.zinftech.priyaspicsumapp.model.AuthorModel;
import com.zinftech.priyaspicsumapp.network.APIService;
import com.zinftech.priyaspicsumapp.network.RetroInstance;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorListViewModel extends ViewModel
{
    private MutableLiveData<List<AuthorModel>> authorList;

    public AuthorListViewModel()
    {
        authorList = new MutableLiveData<>();
    }

    public MutableLiveData<List<AuthorModel>> getAuthorListObserver()
    {
        return authorList;
    }

    public void makeApiCall()
    {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<AuthorModel>> call = apiService.getAuthorList();
        call.enqueue(new Callback<List<AuthorModel>>() {
            @Override
            public void onResponse(Call<List<AuthorModel>> call, Response<List<AuthorModel>> response) {
                authorList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<AuthorModel>> call, Throwable t) {
                authorList.postValue(null);
            }
        });
    }

}
