package ciih.dsg.xhj.util;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class ServiceResult<T> implements Serializable {
    private String status;
    private T data;
    private String token;
    private String text;

    private ServiceResult() {}

    public static <T> ServiceResult<T> success(T result, HttpServletRequest request) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.status = "1";
        item.data = result;
        item.token = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
        item.text = "";
        return item;
    }

    public static <T> ServiceResult<T> success(T result, String text, HttpServletRequest request) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.status = "1";
        item.data = result;
        item.token = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
        item.text = text;
        return item;
    }

    public static <T> ServiceResult<T> loginSuccess(T result, String token) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.status = "1";
        item.data = result;
        item.token = token;
        item.text = "";
        return item;
    }

    public static <T> ServiceResult<T> failure(T result, HttpServletRequest request) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.status = "0";
        item.data = result;
        item.token = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
        item.text = "数据处理异常！";
        return item;
    }

    public static <T> ServiceResult<T> failure(T result, String errorMsg, HttpServletRequest request) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.status = "0";
        item.data = result;
        item.token = request.getHeader("Authorization") == null ? "" : request.getHeader("Authorization");
        item.text = errorMsg;
        return item;
    }

    public String getStatus() {
        return status;
    }

    public boolean hasData() {
        return data != null;
    }

    public T getData() {
        return data;
    }

    public String getToken() {
        return token;
    }

    public String getText() {
        return text;
    }
}
