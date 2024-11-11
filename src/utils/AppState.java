package utils;

import model.DataItem;

public class AppState {
    private static AppState instance;
    private DataItem selectedCoin;

    // Private constructor để ngăn tạo đối tượng bên ngoài
    private AppState() {}

    public static AppState getInstance() {
        if (instance == null) {
            instance = new AppState();
        }
        return instance;
    }

    public DataItem getSelectedCoin() {
        return selectedCoin;
    }

    public void setSelectedCoin(DataItem selectedCoin) {
        this.selectedCoin = selectedCoin;
    }
}
