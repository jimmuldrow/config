/*
 * An XML document type.
 * Localname: ping
 * Namespace: http://test.com
 * Java type: com.test.PingDocument
 *
 * Automatically generated - do not modify.
 */
package com.test.impl;
/**
 * A document containing one ping(@http://test.com) element.
 *
 * This is a complex type.
 */
public class PingDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.test.PingDocument
{
    private static final long serialVersionUID = 1L;
    
    public PingDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PING$0 = 
        new javax.xml.namespace.QName("http://test.com", "ping");
    
    
    /**
     * Gets the "ping" element
     */
    public com.test.PingDocument.Ping getPing()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.test.PingDocument.Ping target = null;
            target = (com.test.PingDocument.Ping)get_store().find_element_user(PING$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ping" element
     */
    public void setPing(com.test.PingDocument.Ping ping)
    {
        generatedSetterHelperImpl(ping, PING$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "ping" element
     */
    public com.test.PingDocument.Ping addNewPing()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.test.PingDocument.Ping target = null;
            target = (com.test.PingDocument.Ping)get_store().add_element_user(PING$0);
            return target;
        }
    }
    /**
     * An XML ping(@http://test.com).
     *
     * This is a complex type.
     */
    public static class PingImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.test.PingDocument.Ping
    {
        private static final long serialVersionUID = 1L;
        
        public PingImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FIRST$0 = 
            new javax.xml.namespace.QName("http://test.com", "first");
        private static final javax.xml.namespace.QName LAST$2 = 
            new javax.xml.namespace.QName("http://test.com", "last");
        private static final javax.xml.namespace.QName STREETADDRESSONE$4 = 
            new javax.xml.namespace.QName("http://test.com", "streetAddressOne");
        private static final javax.xml.namespace.QName STREETADDRESSTWO$6 = 
            new javax.xml.namespace.QName("http://test.com", "streetAddressTwo");
        private static final javax.xml.namespace.QName CITY$8 = 
            new javax.xml.namespace.QName("http://test.com", "city");
        private static final javax.xml.namespace.QName STATE$10 = 
            new javax.xml.namespace.QName("http://test.com", "state");
        private static final javax.xml.namespace.QName ZIP$12 = 
            new javax.xml.namespace.QName("http://test.com", "zip");
        
        
        /**
         * Gets the "first" element
         */
        public java.lang.String getFirst()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FIRST$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "first" element
         */
        public org.apache.xmlbeans.XmlString xgetFirst()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FIRST$0, 0);
                return target;
            }
        }
        
        /**
         * Tests for nil "first" element
         */
        public boolean isNilFirst()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FIRST$0, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "first" element
         */
        public boolean isSetFirst()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(FIRST$0) != 0;
            }
        }
        
        /**
         * Sets the "first" element
         */
        public void setFirst(java.lang.String first)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FIRST$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FIRST$0);
                }
                target.setStringValue(first);
            }
        }
        
        /**
         * Sets (as xml) the "first" element
         */
        public void xsetFirst(org.apache.xmlbeans.XmlString first)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FIRST$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FIRST$0);
                }
                target.set(first);
            }
        }
        
        /**
         * Nils the "first" element
         */
        public void setNilFirst()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(FIRST$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(FIRST$0);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "first" element
         */
        public void unsetFirst()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(FIRST$0, 0);
            }
        }
        
        /**
         * Gets the "last" element
         */
        public java.lang.String getLast()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LAST$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "last" element
         */
        public org.apache.xmlbeans.XmlString xgetLast()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LAST$2, 0);
                return target;
            }
        }
        
        /**
         * Tests for nil "last" element
         */
        public boolean isNilLast()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LAST$2, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "last" element
         */
        public boolean isSetLast()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(LAST$2) != 0;
            }
        }
        
        /**
         * Sets the "last" element
         */
        public void setLast(java.lang.String last)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LAST$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LAST$2);
                }
                target.setStringValue(last);
            }
        }
        
        /**
         * Sets (as xml) the "last" element
         */
        public void xsetLast(org.apache.xmlbeans.XmlString last)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LAST$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LAST$2);
                }
                target.set(last);
            }
        }
        
        /**
         * Nils the "last" element
         */
        public void setNilLast()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LAST$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LAST$2);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "last" element
         */
        public void unsetLast()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(LAST$2, 0);
            }
        }
        
        /**
         * Gets the "streetAddressOne" element
         */
        public java.lang.String getStreetAddressOne()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STREETADDRESSONE$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "streetAddressOne" element
         */
        public org.apache.xmlbeans.XmlString xgetStreetAddressOne()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STREETADDRESSONE$4, 0);
                return target;
            }
        }
        
        /**
         * Tests for nil "streetAddressOne" element
         */
        public boolean isNilStreetAddressOne()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STREETADDRESSONE$4, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "streetAddressOne" element
         */
        public boolean isSetStreetAddressOne()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(STREETADDRESSONE$4) != 0;
            }
        }
        
        /**
         * Sets the "streetAddressOne" element
         */
        public void setStreetAddressOne(java.lang.String streetAddressOne)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STREETADDRESSONE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STREETADDRESSONE$4);
                }
                target.setStringValue(streetAddressOne);
            }
        }
        
        /**
         * Sets (as xml) the "streetAddressOne" element
         */
        public void xsetStreetAddressOne(org.apache.xmlbeans.XmlString streetAddressOne)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STREETADDRESSONE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(STREETADDRESSONE$4);
                }
                target.set(streetAddressOne);
            }
        }
        
        /**
         * Nils the "streetAddressOne" element
         */
        public void setNilStreetAddressOne()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STREETADDRESSONE$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(STREETADDRESSONE$4);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "streetAddressOne" element
         */
        public void unsetStreetAddressOne()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(STREETADDRESSONE$4, 0);
            }
        }
        
        /**
         * Gets the "streetAddressTwo" element
         */
        public java.lang.String getStreetAddressTwo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STREETADDRESSTWO$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "streetAddressTwo" element
         */
        public org.apache.xmlbeans.XmlString xgetStreetAddressTwo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STREETADDRESSTWO$6, 0);
                return target;
            }
        }
        
        /**
         * Tests for nil "streetAddressTwo" element
         */
        public boolean isNilStreetAddressTwo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STREETADDRESSTWO$6, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "streetAddressTwo" element
         */
        public boolean isSetStreetAddressTwo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(STREETADDRESSTWO$6) != 0;
            }
        }
        
        /**
         * Sets the "streetAddressTwo" element
         */
        public void setStreetAddressTwo(java.lang.String streetAddressTwo)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STREETADDRESSTWO$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STREETADDRESSTWO$6);
                }
                target.setStringValue(streetAddressTwo);
            }
        }
        
        /**
         * Sets (as xml) the "streetAddressTwo" element
         */
        public void xsetStreetAddressTwo(org.apache.xmlbeans.XmlString streetAddressTwo)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STREETADDRESSTWO$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(STREETADDRESSTWO$6);
                }
                target.set(streetAddressTwo);
            }
        }
        
        /**
         * Nils the "streetAddressTwo" element
         */
        public void setNilStreetAddressTwo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STREETADDRESSTWO$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(STREETADDRESSTWO$6);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "streetAddressTwo" element
         */
        public void unsetStreetAddressTwo()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(STREETADDRESSTWO$6, 0);
            }
        }
        
        /**
         * Gets the "city" element
         */
        public java.lang.String getCity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CITY$8, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "city" element
         */
        public org.apache.xmlbeans.XmlString xgetCity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CITY$8, 0);
                return target;
            }
        }
        
        /**
         * Tests for nil "city" element
         */
        public boolean isNilCity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CITY$8, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "city" element
         */
        public boolean isSetCity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(CITY$8) != 0;
            }
        }
        
        /**
         * Sets the "city" element
         */
        public void setCity(java.lang.String city)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CITY$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CITY$8);
                }
                target.setStringValue(city);
            }
        }
        
        /**
         * Sets (as xml) the "city" element
         */
        public void xsetCity(org.apache.xmlbeans.XmlString city)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CITY$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CITY$8);
                }
                target.set(city);
            }
        }
        
        /**
         * Nils the "city" element
         */
        public void setNilCity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CITY$8, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CITY$8);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "city" element
         */
        public void unsetCity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(CITY$8, 0);
            }
        }
        
        /**
         * Gets the "state" element
         */
        public java.lang.String getState()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STATE$10, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "state" element
         */
        public org.apache.xmlbeans.XmlString xgetState()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STATE$10, 0);
                return target;
            }
        }
        
        /**
         * Tests for nil "state" element
         */
        public boolean isNilState()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STATE$10, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "state" element
         */
        public boolean isSetState()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(STATE$10) != 0;
            }
        }
        
        /**
         * Sets the "state" element
         */
        public void setState(java.lang.String state)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(STATE$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(STATE$10);
                }
                target.setStringValue(state);
            }
        }
        
        /**
         * Sets (as xml) the "state" element
         */
        public void xsetState(org.apache.xmlbeans.XmlString state)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STATE$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(STATE$10);
                }
                target.set(state);
            }
        }
        
        /**
         * Nils the "state" element
         */
        public void setNilState()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(STATE$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(STATE$10);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "state" element
         */
        public void unsetState()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(STATE$10, 0);
            }
        }
        
        /**
         * Gets the "zip" element
         */
        public java.lang.String getZip()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZIP$12, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "zip" element
         */
        public org.apache.xmlbeans.XmlString xgetZip()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ZIP$12, 0);
                return target;
            }
        }
        
        /**
         * Tests for nil "zip" element
         */
        public boolean isNilZip()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ZIP$12, 0);
                if (target == null) return false;
                return target.isNil();
            }
        }
        
        /**
         * True if has "zip" element
         */
        public boolean isSetZip()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ZIP$12) != 0;
            }
        }
        
        /**
         * Sets the "zip" element
         */
        public void setZip(java.lang.String zip)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ZIP$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ZIP$12);
                }
                target.setStringValue(zip);
            }
        }
        
        /**
         * Sets (as xml) the "zip" element
         */
        public void xsetZip(org.apache.xmlbeans.XmlString zip)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ZIP$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ZIP$12);
                }
                target.set(zip);
            }
        }
        
        /**
         * Nils the "zip" element
         */
        public void setNilZip()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ZIP$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ZIP$12);
                }
                target.setNil();
            }
        }
        
        /**
         * Unsets the "zip" element
         */
        public void unsetZip()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ZIP$12, 0);
            }
        }
    }
}
