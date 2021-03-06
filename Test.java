package com.lumingfeng.thinkinjava;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Experimental;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class Test {

	private static final String tree1
	="access_token=562949969514959-21f8e046ee7a8d4db6&app_key=ac5f34563a4344c4&op=1&sig=h18jBP3W7sjosDYuVdRmiowCsYw%3D";
	
	private static final String tree2
	="access_token=562949969514959-21f8e046ee7a8d4db6&app_key=ac5f34563a4344c4&op=2&sig=Nge4l0V6x1FDa0hzfnc78RY9ODY%3D";
	
	private static final String home1=
			"access_token=562949969514959-21f8e046ee7a8d4db6&love_space_id=844424935379536&task_type=1&sig=FnzY7OKEg8gZYfjQxc1WZUTuByQ%3D";
	private static final String home2=
			"access_token=562949969514959-21f8e046ee7a8d4db6&love_space_id=844424935379536&task_type=4&sig=PgSTOdUE3FnkaaDy6s2T1jCwQXI%3D";
	
	private static final String home3
	="access_token=562949969514959-21f8e046ee7a8d4db6&love_space_id=844424935379536&task_type=11&sig=HCowDg9I1KiG91/mnOCvA36xzh4%3D";
	
	private static final String home4
	="access_token=562949969514959-21f8e046ee7a8d4db6&love_space_id=844424935379536&task_type=5&sig=poyPHFgRGhFuvdpQuk8gJEcS/RA%3D";
	
	private static final String home5
	="access_token=562949969514959-21f8e046ee7a8d4db6&love_space_id=844424935379536&task_type=6&sig=NRm9/U32J2e4p5G2KB2nEXuq9gE%3D";
	
	private static final String home6=
			"access_token=562949969514959-21f8e046ee7a8d4db6&love_space_id=844424935379536&task_type=7&sig=AA0uqN0LhR6UX+AhmRtpki54KuY%3D";
	
	
	
//	private static final String pet1=
//			"access_token=562949969514959-21f8e046ee7a8d4db6&pet_id=20103&task_type=4&sig=te2/79fQ%2B1K3AhTlCulAd2yDxxw%3D";
//	
//	private static final String pet2=
	
	private static List<NameValuePair> changeParamsToList(String param){
		String[] params =param.split("&");
		List<NameValuePair> list =new ArrayList<NameValuePair>();
		for(String s :params){
			String[] kv =s.split("=");
			if(kv[1].endsWith("%3D")){
				String tmp =kv[1];
				kv[1]=tmp.substring(0, tmp.lastIndexOf("%"))+"=";
			}
			list.add(new BasicNameValuePair(kv[0],kv[1]));
		}
		return list;
	}
	
	public void test(){
		String param ="access_token=562949969514959-21f8e046ee7a8d4db6&app_key=ac5f34563a4344c4&op=1&sig=h18jBP3W7sjosDYuVdRmiowCsYw%3D";
		System.out.println(changeParamsToList(param));;
	}
	
	//335
	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
		String treeurl ="http://api.welove520.com/v1/game/tree/op";
		String homeUrl="http://api.welove520.com/v1/game/house/task";
		
		
		CloseableHttpClient httpClient =HttpClients.createDefault();
//		HttpClientBuilder h =HttpClientBuilder.create();
//		HttpPost post =new HttpPost(homeUrl);
		HttpPost post =new HttpPost(homeUrl);
		HttpPost treepost =new HttpPost(treeurl);
		post.setHeader("Content-Type","application/x-www-form-urlencoded");
		post.setHeader("Welove-UA","[Device:m2 note][OSV:5.1][CV:Android3.1.5][WWAN:0][en_US][platform:wandoujia][WSP:2]");
		post.setHeader("Accept-Language","en_US");
		post.setHeader("User-Agent","Dalvik/2.1.0 (Linux; U; Android 5.1; m2 note Build/LMY47D)");
		post.setHeader("Host","api.welove520.com");
		post.setHeader("Connection","Keep-Alive");
		post.setHeader("Accept-Encoding","gzip");
//		post.setHeader("Content-Length","112");
		
		String[] targets ={home1,home2,home3,home4,home5,home6};
		for(String s :targets){
			Thread.sleep(2000);
		List<NameValuePair> list =changeParamsToList(s);
		System.out.println(list);
		post.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
		
		String answer =invoke(httpClient, post);
		
		
		System.out.println("answer="+answer);
		}
		
		String[] treeTargets ={tree1,tree2};
		for(String s :treeTargets){
			Thread.sleep(2000);
		List<NameValuePair> list =changeParamsToList(s);
		System.out.println(list);
		post.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
		
		String answer =invoke(httpClient, treepost);
		
		
		System.out.println("answer="+answer);
		}
		
	}
	
	private static String invoke(CloseableHttpClient httpclient,  
            HttpUriRequest httpost) {  
          
        HttpResponse response = sendRequest(httpclient, httpost);  
        String body = paseResponse(response);  
          
        return body;  
    }  
	
	private static String paseResponse(HttpResponse response) {  
		  System.out.println("get response from http server..");  
        HttpEntity entity = response.getEntity();  
          
        System.out.println("response status: " + response.getStatusLine());  
        String charset = EntityUtils.getContentCharSet(entity);  
        System.out.println(charset);  
          
        String body = null;  
        try {  
            body = EntityUtils.toString(entity);  
            System.out.println(body);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
        return body;  
    }  
  
    private static HttpResponse sendRequest(CloseableHttpClient httpclient,  
            HttpUriRequest httpost) {  
    	  System.out.println("execute post...");  
        HttpResponse response = null;  
          
        try {  
            response = httpclient.execute(httpost);  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return response;  
    }  
}
