/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2015 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 * 
 */
package ti.okhttp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiBlob;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.util.TiConvert;

import android.os.Build;

@Kroll.proxy(creatableInModule=OkhttpModule.class, propertyAccessors = {
	TiC.PROPERTY_FILE,
	OkhttpModule.PROPERTY_ONSENDSTREAM,
	OkhttpModule.PROPERTY_ONLOAD,
	OkhttpModule.PROPERTY_ONERROR,
	OkhttpModule.PROPERTY_ONREADYSTATECHANGE,
	OkhttpModule.PROPERTY_ONDATASTREAM
})
public class OkhttpclientProxy extends KrollProxy {

	public static final String PROPERTY_SECURITY_MANAGER = "securityManager";
	private TiOkhttpclient client;


	public OkhttpclientProxy()
	{
		super();
		this.client = new TiOkhttpclient(this);
	}

	public OkhttpclientProxy(TiContext tiContext)
	{
		this();
	}
	
	public void handleCreationDict(KrollDict dict)
	{
		super.handleCreationDict(dict);

		if (hasProperty(TiC.PROPERTY_TIMEOUT)) {
			client.setTimeout(TiConvert.toInt(getProperty(TiC.PROPERTY_TIMEOUT),0));
		}

		if (hasProperty(TiC.PROPERTY_AUTO_REDIRECT)) {
			client.setAutoRedirect(TiConvert.toBoolean((getProperty(TiC.PROPERTY_AUTO_REDIRECT)),true));
		}

		if (hasProperty(TiC.PROPERTY_AUTO_ENCODE_URL)) {
			client.setAutoEncodeUrl(TiConvert.toBoolean((getProperty(TiC.PROPERTY_AUTO_ENCODE_URL)),true));
		}

	}
	
	@Kroll.method
	public void abort()
	{
		client.abort();
	}

	@Kroll.getProperty @Kroll.method
	public String getAllResponseHeaders()
	{
		return client.getAllResponseHeaders();
	}

	@Kroll.getProperty @Kroll.method
	public int getReadyState()
	{
		return client.getReadyState();
	}

	@Kroll.getProperty @Kroll.method
	public TiBlob getResponseData()
	{
		return client.getResponseData();
	}

	@Kroll.method
	public String getResponseHeader(String header)
	{
		return client.getResponseHeader(header);
	}

	@Kroll.getProperty @Kroll.method
	public String getResponseText()
	{
		return client.getResponseText();
	}
	
	@Kroll.getProperty @Kroll.method
	public int getStatus()
	{
		return client.getStatus();
	}

	@Kroll.getProperty @Kroll.method
	public String getStatusText()
	{
		return client.getStatusText();
	}
	
	@Kroll.method
	public void open(String method, String url)
	{
		client.open(method, url);
	}

	@Kroll.method
	public void send(@Kroll.argument(optional=true) Object data) 
		throws IOException
	{
		client.send(data);
	}

	@Kroll.method
	public void setRequestHeader(String header, String value)
	{
		client.setRequestHeader(header, value);
	}
	
	@Kroll.setProperty @Kroll.method
	public void setTimeout(int millis)
	{
		client.setTimeout(millis);
	}
	
	@Kroll.getProperty @Kroll.method
	public String getLocation()
	{
		return client.getLocation();
	}

	@Kroll.getProperty @Kroll.method
	public String getConnectionType()
	{
		return client.getConnectionType();
	}
	

	@Kroll.getProperty @Kroll.method
	public boolean getAutoEncodeUrl()
	{
		return client.getAutoEncodeUrl();
	}

	@Kroll.setProperty @Kroll.method
	public void setAutoEncodeUrl(boolean value)
	{
		client.setAutoEncodeUrl(value);
	}

	@Kroll.getProperty @Kroll.method
	public boolean getAutoRedirect()
	{
		return client.getAutoRedirect();
	}

	@Kroll.setProperty @Kroll.method
	public void setAutoRedirect(boolean value)
	{
		client.setAutoRedirect(value);
	}

	@Kroll.setProperty @Kroll.method
	public void setDomain(String value)
	{
		this.setProperty(TiC.PROPERTY_DOMAIN, value);
	}

	@Kroll.getProperty @Kroll.method
	public String getDomain()
	{
		if (this.hasProperty(TiC.PROPERTY_DOMAIN)) {
			return TiConvert.toString(this.getProperty(TiC.PROPERTY_DOMAIN));
		}
		return null;
	}

	@Override
	public String getApiName()
	{
		return "Ti.Network.HTTPClient";
	}

}
