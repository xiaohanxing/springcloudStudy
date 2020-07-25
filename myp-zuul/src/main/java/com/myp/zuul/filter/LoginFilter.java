package com.myp.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
    /*
    *
    * 过滤器滤芯， pre route post error
    * */
    @Override
    public String filterType() {
        return "pre";
    }

    /*
    * 执行顺序，返回值越小，优先级越高
    *
    * */
    @Override
    public int filterOrder() {

        return 10;
    }
/*
* 是否执行run方法
*
* */
    @Override
    public boolean shouldFilter() {
        return true;
    }
/*
* 过滤器的业务逻辑
* */
    @Override
    public Object run() throws ZuulException {
        //初始化context上下文
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isBlank(token)){
            //拦截。不转发请求
            context.setSendZuulResponse(false);

            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            context.setResponseBody("requst error");
        }

        //返回值为Null，表示过滤器什么都不做
        return null;
    }
}
