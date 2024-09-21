package datahandle;

import java.util.List;

import entities.DataItem;

// Định nghĩa interface callback
public interface DataCallback<T> {
    void onSuccess(T data);
    void onFailure(String error);
}
