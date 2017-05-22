/*
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package com.huawei.iom.component.httpclient.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huawei.iom.component.httpclient.exception.HttpExceptionEnum;
import com.huawei.iom.component.httpclient.exception.HttpRequestException;
import com.huawei.iom.component.httpclient.exception.HttpResponseException;

public class HttpUtil
{
    public final static String HTTPGET = "GET";

    public final static String HTTPPUT = "PUT";

    public final static String HTTPPOST = "POST";

    public final static String HTTPDELETE = "DELETE";

    public final static String HTTPACCEPT = "Accept";

    public final static String CONTENT_LENGTH = "Content-Length";

    public final static String CHARSET_UTF8 = "UTF-8";

    private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);

    public static HttpResponse doPost(String url, Map<String, String> headerMap,
            StringEntity stringEntity) throws HttpResponseException
    {
        HttpPost request = new HttpPost(url);
        addRequestHeader(request, headerMap);

        request.setEntity(stringEntity);

        return executeHttpRequest(request);
    }

    public static HttpResponse doPost(String url, Map<String, String> headerMap,
            InputStream inStream) throws HttpResponseException
    {
        HttpPost request = new HttpPost(url);
        addRequestHeader(request, headerMap);

        request.setEntity(new InputStreamEntity(inStream));

        return executeHttpRequest(request);
    }

    public static HttpResponse doPostJson(String url,
            Map<String, String> headerMap, String content)
                    throws HttpResponseException
    {
        HttpPost request = new HttpPost(url);
        addRequestHeader(request, headerMap);

        request.setEntity(
                new StringEntity(content, ContentType.APPLICATION_JSON));

        return executeHttpRequest(request);
    }

    public static String doPostJsonForString(String url,
            Map<String, String> headerMap, String content)
                    throws HttpResponseException
    {
        HttpPost request = new HttpPost(url);
        addRequestHeader(request, headerMap);

        request.setEntity(
                new StringEntity(content, ContentType.APPLICATION_JSON));

        HttpResponse response = executeHttpRequest(request);
        if (null == response)
        {
            log.error("The response body is null.");
            throw new HttpResponseException(
                    HttpExceptionEnum.HTTP_RESPONSE_BODY_IS_NULL);
        }
        
        return ((StreamClosedHttpResponse) response).getContent();
    }
    
    private static List<NameValuePair> paramsConverter(Map<String, String> params)
    {
        List<NameValuePair> nvps = new LinkedList<NameValuePair>();
        Set<Map.Entry<String, String>> paramsSet = params.entrySet();
        for (Map.Entry<String, String> paramEntry : paramsSet)
        {
            nvps.add(new BasicNameValuePair(paramEntry.getKey(),
                    paramEntry.getValue()));
        }

        return nvps;
    }
    
    public static String doPostFormUrlEncodedForString(String url, Map<String, String> formParams)
                    throws HttpResponseException, UnsupportedEncodingException
    {
        HttpPost request = new HttpPost(url);

        request.setEntity(new UrlEncodedFormEntity(paramsConverter(formParams)));

        HttpResponse response = HttpUtil.executeHttpRequest(request);
        if (null == response)
        {
            log.error("The response body is null.");
            throw new HttpResponseException(
                    HttpExceptionEnum.HTTP_RESPONSE_BODY_IS_NULL);
        }

        return ((StreamClosedHttpResponse) response).getContent();
    }
    
    public static HttpResponse doPut(String url, Map<String, String> headerMap,
            InputStream inStream) throws HttpResponseException
    {
        HttpPut request = new HttpPut(url);
        addRequestHeader(request, headerMap);

        request.setEntity(new InputStreamEntity(inStream));

        return executeHttpRequest(request);
    }

    public static HttpResponse doPutJson(String url,
            Map<String, String> headerMap, String content)
                    throws HttpResponseException
    {
        HttpPut request = new HttpPut(url);
        addRequestHeader(request, headerMap);

        request.setEntity(new StringEntity(content, ContentType.APPLICATION_JSON));

        return executeHttpRequest(request);
    }
    
    public static String doPutJsonForString(String url,
            Map<String, String> headerMap, String content)
                    throws HttpResponseException
    {
        HttpResponse response = doPutJson(url, headerMap, content);
        if (null == response)
        {
            log.error("The response body is null.");
            throw new HttpResponseException(
                    HttpExceptionEnum.HTTP_RESPONSE_BODY_IS_NULL);
        }

        return ((StreamClosedHttpResponse) response).getContent();
    }

    public static HttpResponse doGet(String url, Map<String, String> headerMap)
            throws HttpResponseException
    {
        HttpGet request = new HttpGet(url);
        addRequestHeader(request, headerMap);

        return executeHttpRequest(request);
    }
    
    public static HttpResponse doGetWithParas(String url, Map<String, String> queryParams, Map<String, String> headerMap)
            throws HttpResponseException, HttpRequestException, URISyntaxException
    {
        HttpGet request = new HttpGet();
        addRequestHeader(request, headerMap);
        
        URIBuilder builder;
        try
        {
            builder = new URIBuilder(url);
        }
        catch (URISyntaxException e)
        {
            log.error("URISyntaxException: {}", e);
            throw new HttpRequestException(HttpExceptionEnum.HTTP_URI_INVALID);
        }
        
        if (queryParams != null && !queryParams.isEmpty())
        {
            builder.setParameters(paramsConverter(queryParams));
        }
        request.setURI(builder.build());

        return executeHttpRequest(request);
    }
    
    public static String doGetWithParasForString(String url, Map<String, String> queryParams, Map<String, String> headerMap)
            throws HttpResponseException, HttpRequestException, URISyntaxException
    {
        HttpResponse response = doGetWithParas(url, queryParams, headerMap);
        if (null == response)
        {
            log.error("The response body is null.");
            throw new HttpResponseException(HttpExceptionEnum.HTTP_RESPONSE_BODY_IS_NULL);
        }

        return ((StreamClosedHttpResponse) response).getContent();
    }

    public static HttpResponse doDelete(String url,
            Map<String, String> headerMap) throws HttpResponseException
    {
        HttpDelete request = new HttpDelete(url);
        addRequestHeader(request, headerMap);

        return executeHttpRequest(request);
    }
    
    public static String doDeleteForString(String url,
            Map<String, String> headerMap) throws HttpResponseException
    {
        HttpResponse response = doDelete(url, headerMap);
        if (null == response)
        {
            log.error("The response body is null.");
            throw new HttpResponseException(
                    HttpExceptionEnum.HTTP_RESPONSE_BODY_IS_NULL);
        }

        return ((StreamClosedHttpResponse) response).getContent();
    }

    private static void addRequestHeader(HttpUriRequest request,
            Map<String, String> headerMap)
    {
        if (headerMap == null)
        {
            return;
        }

        for (String headerName : headerMap.keySet())
        {
            if (CONTENT_LENGTH.equalsIgnoreCase(headerName))
            {
                continue;
            }

            String headerValue = headerMap.get(headerName);
            request.addHeader(headerName, headerValue);
        }
    }

    private static HttpResponse executeHttpRequest(HttpUriRequest request)
            throws HttpResponseException
    {
        HttpResponse response = null;
        CloseableHttpClient httpclient = null;

        try
        {
            httpclient = HttpClients.createDefault();
            response = httpclient.execute(request);
        }
        catch (Exception e)
        {
            log.error("executeHttpRequest failed.");
            throw new HttpResponseException(
                    HttpExceptionEnum.HTTP_REQUEST_FAILED);
        }
        finally
        {
            try
            {
                // 获取流中内容，并关闭连接
                response = new StreamClosedHttpResponse(response);
                httpclient.close();
            }
            catch (IOException e)
            {
                log.error("IOException: " + e.getMessage());
            }
        }

        return response;
    }

    public static String getHttpResponseBody(HttpResponse response)
            throws UnsupportedOperationException, IOException
    {
        if (response == null)
        {
            return null;
        }
        
        String body = null;

        if (response instanceof StreamClosedHttpResponse)
        {
            body = ((StreamClosedHttpResponse) response).getContent();
        }
        else
        {
            HttpEntity entity = response.getEntity();
            if (entity != null && entity.isStreaming())
            {
                String encoding = entity.getContentEncoding() != null
                        ? entity.getContentEncoding().getValue() : null;
                body = StreamUtil.inputStream2String(entity.getContent(),
                        encoding);
            }
        }

        return body;
    }
}
