/*
 * An XML document type.
 * Localname: pingResponse
 * Namespace: http://test.com
 * Java type: com.test.PingResponseDocument
 *
 * Automatically generated - do not modify.
 */
package com.test.impl;
/**
 * A document containing one pingResponse(@http://test.com) element.
 *
 * This is a complex type.
 */
public class PingResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.test.PingResponseDocument
{
    private static final long serialVersionUID = 1L;
    
    public PingResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PINGRESPONSE$0 = 
        new javax.xml.namespace.QName("http://test.com", "pingResponse");
    
    
    /**
     * Gets the "pingResponse" element
     */
    public com.test.PingResponseDocument.PingResponse getPingResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.test.PingResponseDocument.PingResponse target = null;
            target = (com.test.PingResponseDocument.PingResponse)get_store().find_element_user(PINGRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "pingResponse" element
     */
    public void setPingResponse(com.test.PingResponseDocument.PingResponse pingResponse)
    {
        generatedSetterHelperImpl(pingResponse, PINGRESPONSE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "pingResponse" element
     */
    public com.test.PingResponseDocument.PingResponse addNewPingResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.test.PingResponseDocument.PingResponse target = null;
            target = (com.test.PingResponseDocument.PingResponse)get_store().add_element_user(PINGRESPONSE$0);
            return target;
        }
    }
    /**
     * An XML pingResponse(@http://test.com).
     *
     * This is a complex type.
     */
    public static class PingResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.test.PingResponseDocument.PingResponse
    {
        private static final long serialVersionUID = 1L;
        
        public PingResponseImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName RETURN$0 = 
            new javax.xml.namespace.QName("http://test.com", "return");
        
        
        /**
         * Gets the "return" element
         */
        public java.lang.String getReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RETURN$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "return" element
         */
        public org.apache.xmlbeans.XmlString xgetReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RETURN$0, 0);
                return target;
            }
        }
        
        /**
         * Tests for nil "return" element
         */
        public boolean isNilReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RETURN$0, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "return" element
         */
        public boolean isSetReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(RETURN$0) != 0;
            }
        }
        
        /**
         * Sets the "return" element
         */
        public void setReturn(java.lang.String xreturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RETURN$0);
                }
                target.setStringValue(xreturn);
            }
        }
        
        /**
         * Sets (as xml) the "return" element
         */
        public void xsetReturn(org.apache.xmlbeans.XmlString xreturn)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RETURN$0);
                }
                target.set(xreturn);
            }
        }
        
        /**
         * Nils the "return" element
         */
        public void setNilReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RETURN$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RETURN$0);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "return" element
         */
        public void unsetReturn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(RETURN$0, 0);
            }
        }
    }
}
