package com.example.Mvp.mvp;

import com.example.Mvp.model.Responcedetails;
import java.util.List;

public interface Mvp {
    interface main {
        void main();
    }

    interface mainactity {
        void success(List<Responcedetails> responcedetails);
        void fail(String error);
    }
}
