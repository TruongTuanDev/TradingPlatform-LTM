package datahandle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import API.*;
import model.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import socket.SocketHandle;
import views.MarketView;
import views.OrderView;

public class DataAPI {

    private ApiCoinMarket apiCoinMarket;
    private static final String apiKey = "2eb6903c-5421-4c55-82f5-4b034647e300";
    private List<DataItem> listDataItem;
    private SocketHandle  socketHandle;

    public DataAPI() {
        this.apiCoinMarket = ApiCoinMarket.apiCoinMarket;
    }
    
    private String[][] processDataItems(List<DataItem> dataItems) {
        String[][] processedData = new String[dataItems.size()][4];

        for (int i = 0; i < dataItems.size(); i++) {
            DataItem item = dataItems.get(i);
            processedData[i][0] = item.getId();
            processedData[i][1] = item.getSymbol();
            processedData[i][2] = String.format("%.7f", item.getQuote().getUsd().getPrice());
            processedData[i][3] = String.format("%.2f", item.getQuote().getUsd().getPercent_change_24h())+"%";
//            processedData[i][4] = String.format("%.2f", item.getSymbol());
        }

        return processedData;
    }
    private String[][] processMyToken(List<Token> dataItems) {	
        String[][] processedData = new String[dataItems.size()][4];
        for (int i = 0; i < dataItems.size(); i++) {
        	Token item = dataItems.get(i);
        	
            processedData[i][0] = item.getToken_id();
            processedData[i][1] = item.getSymbol();
            processedData[i][2] = String.format("%.7f", item.getCurrent_price());
            processedData[i][3] = String.format("%.2f", item.getCurrent_price())+"%";
//            processedData[i][4] = String.format("%.2f", item.getSymbol());
        }

        return processedData;
    }
    public void getListCoinTop(MarketView marketView) {
        fetchMarketDataCoinTop(new DataCallback<List<DataItem>>() {
            @Override
            public void onSuccess(List<DataItem> data) {
                String[][] hotCoinsData = processDataItems(data);
                marketView.updateHotCoinsTable(hotCoinsData);
            }

            @Override
            public void onFailure(String error) {
                // Xử lý lỗi nếu cần
            }
        });
    }
    public void getListCoinTopOrther(OrderView orderview) {
        fetchMarketDataCoinTop(new DataCallback<List<DataItem>>() {
            @Override
            public void onSuccess(List<DataItem> data) {
                String[][] hotCoinsData = processDataItems(data);
                orderview.updateHotCoinsTable(hotCoinsData);
            }
            @Override
            public void onFailure(String error) {
                // Xử lý lỗi nếu cần
            }
        });
    }
    public void getListMyCoin(MarketView marketView) {   	
    	
    	 List<Token> listTokens = SocketHandle.receivedTokenList;
         String[][] myCoinsData = processMyToken(listTokens);
         marketView.updateMyCoinsTable(myCoinsData);
    }
    public void getListNewCoin(MarketView marketView) {
        fetchMarketDataNewCoin(new DataCallback<List<DataItem>>() {
            @Override
            public void onSuccess(List<DataItem> data) {
                String[][] newCoinsData = processDataItems(data);
                marketView.updateNewListingTable(newCoinsData);
            }

            @Override
            public void onFailure(String error) {
                // Xử lý lỗi nếu cần
            }
        });
    }
    public void getListGainerCoin(MarketView marketView) {
        fetchMarketDataTopGainer(new DataCallback<List<DataItem>>() {
            @Override
            public void onSuccess(List<DataItem> data) {
                String[][] gainerCoinsData = processDataItems(data);
                marketView.updateTopGainerTable(gainerCoinsData);
            }

            @Override
            public void onFailure(String error) {
                // Xử lý lỗi nếu cần
            }
        });
    }
    public void getListVolumeCoin(MarketView marketView) {
        fetchMarketDataTopLoser(new DataCallback<List<DataItem>>() {
            @Override
            public void onSuccess(List<DataItem> data) {
                String[][] volumeData = processDataItems(data);
                marketView.updateTopVolumeTable(volumeData);
            }

            @Override
            public void onFailure(String error) {
                // Xử lý lỗi nếu cần
            }
        });
    }
    
    
  
   
   public void fetchMarketData(String endpoint, String apiKey, final DataCallback<List<DataItem>> callback) {
	    Call<Market> call;

	    switch (endpoint) {
	        case "coinTop":
	            call = apiCoinMarket.convertMarket(apiKey, "market_cap", 1, 40, "all", "USD");
	            break;
	        case "newListing":
	            call = apiCoinMarket.getCoinNewListing(apiKey, "date_added", "desc", 1, 40, "all", "USD");
	            break;
	        case "topGainer":
	            call = apiCoinMarket.convertGainer(apiKey, "percent_change_24h", 1, 40, "all", "USD");
	            break;
	        case "topLoser":
	            call = apiCoinMarket.convertLoser(apiKey, "percent_change_24h", "asc", 1, 40, "all", "USD");
	            break;
	        default:
	            callback.onFailure("Invalid endpoint");
	            return;
	    }

	    call.enqueue(new Callback<Market>() {
	        @Override
	        public void onResponse(Call<Market> call, Response<Market> response) {
	            if (response.isSuccessful()) {
	                Market marketData = response.body();
	                if (marketData != null && marketData.getData() != null) {
	                    callback.onSuccess(new ArrayList<>(marketData.getData()));
	                } else {
	                    callback.onFailure("Không có dữ liệu");
	                }
	            } else {
	                callback.onFailure("Lỗi: " + response.errorBody());
	            }
	        }

	        @Override
	        public void onFailure(Call<Market> call, Throwable t) {
	            callback.onFailure(t.getMessage());
	        }
	    });
	}

	// Các phương thức riêng biệt giờ có thể gọi phương thức chung
	public void fetchMarketDataCoinTop(final DataCallback<List<DataItem>> callback) {
	    fetchMarketData("coinTop", apiKey, callback);
	}

	public void fetchMarketDataNewCoin(final DataCallback<List<DataItem>> callback) {
	    fetchMarketData("newListing", apiKey, callback);
	}

	public void fetchMarketDataTopGainer(final DataCallback<List<DataItem>> callback) {
	    fetchMarketData("topGainer", apiKey, callback);
	}

	public void fetchMarketDataTopLoser(final DataCallback<List<DataItem>> callback) {
	    fetchMarketData("topLoser", apiKey, callback);
	}
   

    

}