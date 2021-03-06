/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2015 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 * 
 * Copied and modified from Apache's HTTPClient implementation (APL2 license):
 * org.apache.http.entity.AbstractHttpEntity
 */
package httpurlconnection;

import java.io.IOException;
import java.io.OutputStream;

import okio.BufferedSink;

public abstract class Entity {
    protected String contentType;
    protected String contentEncoding;
    
    public Entity() {
    	
    }
    
    public String getContentType() {
        return this.contentType;
    }
    
    public String getContentEncoding() {
        return this.contentEncoding;
    }
    
    public void setContentType(final String contentType) {
        this.contentType = contentType;
    }
    
    public void setContentEncoding(final String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }
    
    public abstract void writeTo(OutputStream out) throws IOException;

}
