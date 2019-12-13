package webServices_SOAP;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class restapiHelper {
    
    private Header[] headersArray;
    
    private int statusCode;
    
    boolean useSecurityToken = false;
    
    private String token = "";
    
    public restapiHelper() throws ClientProtocolException, IOException
    {
        token = GetAuthToken();
    }
    
    public Header[] HeadersArray()
    {
        return this.headersArray;
    }
    
    public int StatusCode()
    {
        return this.statusCode;
    }
    

    public String GetAuthToken() throws ClientProtocolException, IOException
    {
        String url = ""; //hardcode the URL here as this is going to be static
        HashMap <String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Accept", "application/json");
        JSONObject restResponse = Get(url, headerMap);
        
        JSONObject data = restResponse.getJSONObject("data");
        String token = data.getString("access_token");
        return token;
    }

    public JSONObject Get(String url, HashMap <String, String> headerMap) throws ClientProtocolException, IOException
    {
        CloseableHttpClient httpClient = HttpClients.createDefault(); //create http client
        HttpGet httpGet = new HttpGet(url); //http get request
        
        //for headers
        for(Map.Entry<String, String> entry : headerMap.entrySet())
        {
            httpGet.addHeader(entry.getKey(), entry.getValue());
        }
        
        if(useSecurityToken)
        {
            httpGet.addHeader("Authorization", token);
        }
    
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet); //hit the get URL
        
        //get the status code
        statusCode = httpResponse.getStatusLine().getStatusCode();
        
        String response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        
        JSONObject responsejson = new JSONObject(response);
        System.out.println("The response JSON is " + responsejson);
        
        headersArray = httpResponse.getAllHeaders();
        
        HashMap <String, String> allHeaders = new HashMap <String, String> ();
        
        for(Header header : headersArray)
        {
            allHeaders.put(header.getName(), header.getValue());
        }
        
        return responsejson;
    }

   
    
    public JSONObject Post(String url, String body, HashMap <String, String> headerMap) throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(body));
        
        //for headers
        for(Map.Entry<String, String> entry : headerMap.entrySet())
        {
            httpPost.addHeader(entry.getKey(), entry.getValue());
        }
        
        if(useSecurityToken)
        {
            httpPost.addHeader("Authorization", token);
        }
        
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        
        String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        
        //get the status code
        statusCode = httpResponse.getStatusLine().getStatusCode();
        
        headersArray = httpResponse.getAllHeaders();
        
        HashMap <String, String> allHeaders = new HashMap <String, String> ();
        
        for(Header header : headersArray)
        {
            allHeaders.put(header.getName(), header.getValue());
        }
        
        JSONObject responseJson = new JSONObject(responseString);
        return responseJson;
    }
    
}