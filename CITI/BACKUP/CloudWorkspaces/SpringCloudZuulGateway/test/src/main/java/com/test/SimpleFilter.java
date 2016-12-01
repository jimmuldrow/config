package com.test;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);
  
  /*
    Filter Types:
    pre filters are executed before the request is routed,

    routing filters can handle the actual routing of the request,

    post filters are executed after the request has been routed, and

    error filters execute if an error occurs in the course of handling the request.
    


    filterType() returns a String that stands for the type of the filter---in this case, pre, or it could be route for a routing filter.

    filterOrder() gives the order in which this filter will be executed, relative to other filters.

    shouldFilter() contains the logic that determines when to execute this filter (this particular filter will always be executed).

    run() contains the functionality of the filter.    
   */

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();

    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

    return null;
  }

}
