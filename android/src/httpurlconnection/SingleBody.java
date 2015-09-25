/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2015 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 * 
 * Copied and modified from Apache's HTTPClient implementation (APL2 license):
 * org.apache.james.mime4j.message.SingleBody
 */

package httpurlconnection;

import java.io.IOException;
import java.io.OutputStream;

import okio.BufferedSink;

public abstract class SingleBody implements Body {

    private Entity parent = null;

    /**
     * Sole constructor.
     */
    protected SingleBody() {
    }

    /**
     * @see org.apache.james.mime4j.message.Body#getParent()
     */
    public Entity getParent() {
        return parent;
    }

    /**
     * @see org.apache.james.mime4j.message.Body#setParent(org.apache.james.mime4j.message.Entity)
     */
    public void setParent(Entity parent) {
        this.parent = parent;
    }

    /**
     * Writes this single body to the given stream.
     * 
     * @param out
     *            the stream to write to.
     * @throws IOException
     *             in case of an I/O error
     */
    public abstract void writeTo(OutputStream out) throws IOException;
    
}