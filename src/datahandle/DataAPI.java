package datahandle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import API.*;
import entities.DataItem;
import entities.Market;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import entities.*;

public class DataAPI {

    private ApiCoinMarket apiCoinMarket;
    private static final String apiKey = "2eb6903c-5421-4c55-82f5-4b034647e300";
    private List<DataItem> listDataItem;

    public DataAPI() {
        this.apiCoinMarket = ApiCoinMarket.apiCoinMarket;
    }
   public void getListCoin(){
	   listDataItem = new ArrayList<DataItem>();
	   fetchMarketData(new DataCallback<List<DataItem>>() {
			@Override
			public void onSuccess(List<DataItem> data) {
				listDataItem.addAll(data);
				System.out.println(listDataItem.toString());
				
			}
			
			@Override
			public void onFailure(String error) {
				// TODO Auto-generated method stub
				
			}
	   });
   }
  
   
    public void fetchMarketData(final DataCallback<List<DataItem>> callback) {
        Call<Market> call = apiCoinMarket.convertMarket(apiKey, "market_cap", 1, 10, "all", "USD");
        call.enqueue(new Callback<Market>() {
            @Override
            public void onResponse(Call<Market> call, Response<Market> response) {
                if (response.isSuccessful()) {
                    Market marketData = response.body();
                    if (marketData != null && marketData.getData() != null) {
                        List<DataItem> listDataItem = new ArrayList<>(marketData.getData());
         
                        callback.onSuccess(listDataItem);
                    } else {
                        System.out.println("Không có dữ liệu");
                        callback.onFailure("Không có dữ liệu");
                    }
                } else {
                    System.out.println("Lỗi: " + response.errorBody());
                    callback.onFailure("Lỗi: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Market> call, Throwable t) {
                callback.onFailure(t.getMessage());
            }
        });
    }
   

    

}