package com.getmeseva.bean;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import flexjson.JSONSerializer;

public class JsonView extends AbstractView {


/** (non-Javadoc)
* @see org.springframework.web.servlet.view.AbstractView#renderMergedOutputModel(java.util.Map, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
*/
@Override
protected void renderMergedOutputModel(Map map, HttpServletRequest request,

HttpServletResponse response) throws Exception {
//log.info("Resolving ajax request view -"+map); 
//JSONSerializer serializer = new JSONSerializer(); 
String jsonString = new JSONSerializer().deepSerialize(map );
String callbackStr = request.getParameter("callback");
String resultString = (callbackStr != null)? callbackStr + "(" + jsonString + ")":jsonString; 
response.setContentType( "application/json; charset=UTF-8" );
//response.getOutputStream().write( jsonString.getBytes() );
response.getOutputStream().write( resultString.getBytes() );
}


}
