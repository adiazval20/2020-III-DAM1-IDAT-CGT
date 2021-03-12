package edu.idat.semana6.api;

import java.util.List;

public class ResponseListApi<T> {
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
