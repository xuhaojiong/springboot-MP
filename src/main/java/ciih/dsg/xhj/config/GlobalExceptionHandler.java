package ciih.dsg.xhj.config;

import ciih.dsg.xhj.util.ServiceResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zhy
 * @Description:
 * @Date: 2020-03-11 9:23
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final List<Object> emptyList = new ArrayList<>();

    @ExceptionHandler(Exception.class)
    public ServiceResult handler(Exception e, HttpServletRequest request) {
        return ServiceResult.failure(emptyList, e.getMessage(), request);
    }
}
