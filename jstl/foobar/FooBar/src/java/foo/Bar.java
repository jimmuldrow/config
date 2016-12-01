package foo;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;


public class Bar implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String now = (new java.util.Date()).toString();
        String zot = noNull(request.getParameter("zot"));
        HashMap<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("zot", zot);
        
        if(zot.equals("")){            
            return new ModelAndView("PageOne", "model", myModel);
        }
        else{
            myModel.put("now", now);
            return new ModelAndView("PageTwo", "model", myModel);
        }       
    }

    private String noNull(String s){return (s == null) ? "" : s.trim();}
}


