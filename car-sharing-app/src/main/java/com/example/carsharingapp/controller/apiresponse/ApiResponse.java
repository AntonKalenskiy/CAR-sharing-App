package com.example.carsharingapp.controller.apiresponse;

import java.util.Collections;
import java.util.List;

public class ApiResponse<T> {
    private List<T> data;

    public ApiResponse(T data) {
        if (data instanceof List) {
            this.data = (List<T>) data;
        } else {
            this.data = Collections.singletonList(data);
        }
    }

    public List<T> getData() {
        return data;
    }
}
