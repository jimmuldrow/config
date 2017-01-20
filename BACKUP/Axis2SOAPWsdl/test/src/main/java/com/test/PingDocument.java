/*
 * An XML document type.
 * Localname: ping
 * Namespace: http://test.com
 * Java type: com.test.PingDocument
 *
 * Automatically generated - do not modify.
 */
package com.test;


/**
 * A document containing one ping(@http://test.com) element.
 *
 * This is a complex type.
 */
public interface PingDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(PingDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s62F5E758F61FAFE4454DC8C6D32A0287").resolveHandle("ping7562doctype");
    
    /**
     * Gets the "ping" element
     */
    com.test.PingDocument.Ping getPing();
    
    /**
     * Sets the "ping" element
     */
    void setPing(com.test.PingDocument.Ping ping);
    
    /**
     * Appends and returns a new empty "ping" element
     */
    com.test.PingDocument.Ping addNewPing();
    
    /**
     * An XML ping(@http://test.com).
     *
     * This is a complex type.
     */
    public interface Ping extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Ping.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s62F5E758F61FAFE4454DC8C6D32A0287").resolveHandle("ping0794elemtype");
        
        /**
         * Gets the "first" element
         */
        java.lang.String getFirst();
        
        /**
         * Gets (as xml) the "first" element
         */
        org.apache.xmlbeans.XmlString xgetFirst();
        
        /**
         * Tests for nil "first" element
         */
        boolean isNilFirst();
        
        /**
         * True if has "first" element
         */
        boolean isSetFirst();
        
        /**
         * Sets the "first" element
         */
        void setFirst(java.lang.String first);
        
        /**
         * Sets (as xml) the "first" element
         */
        void xsetFirst(org.apache.xmlbeans.XmlString first);
        
        /**
         * Nils the "first" element
         */
        void setNilFirst();
        
        /**
         * Unsets the "first" element
         */
        void unsetFirst();
        
        /**
         * Gets the "last" element
         */
        java.lang.String getLast();
        
        /**
         * Gets (as xml) the "last" element
         */
        org.apache.xmlbeans.XmlString xgetLast();
        
        /**
         * Tests for nil "last" element
         */
        boolean isNilLast();
        
        /**
         * True if has "last" element
         */
        boolean isSetLast();
        
        /**
         * Sets the "last" element
         */
        void setLast(java.lang.String last);
        
        /**
         * Sets (as xml) the "last" element
         */
        void xsetLast(org.apache.xmlbeans.XmlString last);
        
        /**
         * Nils the "last" element
         */
        void setNilLast();
        
        /**
         * Unsets the "last" element
         */
        void unsetLast();
        
        /**
         * Gets the "streetAddressOne" element
         */
        java.lang.String getStreetAddressOne();
        
        /**
         * Gets (as xml) the "streetAddressOne" element
         */
        org.apache.xmlbeans.XmlString xgetStreetAddressOne();
        
        /**
         * Tests for nil "streetAddressOne" element
         */
        boolean isNilStreetAddressOne();
        
        /**
         * True if has "streetAddressOne" element
         */
        boolean isSetStreetAddressOne();
        
        /**
         * Sets the "streetAddressOne" element
         */
        void setStreetAddressOne(java.lang.String streetAddressOne);
        
        /**
         * Sets (as xml) the "streetAddressOne" element
         */
        void xsetStreetAddressOne(org.apache.xmlbeans.XmlString streetAddressOne);
        
        /**
         * Nils the "streetAddressOne" element
         */
        void setNilStreetAddressOne();
        
        /**
         * Unsets the "streetAddressOne" element
         */
        void unsetStreetAddressOne();
        
        /**
         * Gets the "streetAddressTwo" element
         */
        java.lang.String getStreetAddressTwo();
        
        /**
         * Gets (as xml) the "streetAddressTwo" element
         */
        org.apache.xmlbeans.XmlString xgetStreetAddressTwo();
        
        /**
         * Tests for nil "streetAddressTwo" element
         */
        boolean isNilStreetAddressTwo();
        
        /**
         * True if has "streetAddressTwo" element
         */
        boolean isSetStreetAddressTwo();
        
        /**
         * Sets the "streetAddressTwo" element
         */
        void setStreetAddressTwo(java.lang.String streetAddressTwo);
        
        /**
         * Sets (as xml) the "streetAddressTwo" element
         */
        void xsetStreetAddressTwo(org.apache.xmlbeans.XmlString streetAddressTwo);
        
        /**
         * Nils the "streetAddressTwo" element
         */
        void setNilStreetAddressTwo();
        
        /**
         * Unsets the "streetAddressTwo" element
         */
        void unsetStreetAddressTwo();
        
        /**
         * Gets the "city" element
         */
        java.lang.String getCity();
        
        /**
         * Gets (as xml) the "city" element
         */
        org.apache.xmlbeans.XmlString xgetCity();
        
        /**
         * Tests for nil "city" element
         */
        boolean isNilCity();
        
        /**
         * True if has "city" element
         */
        boolean isSetCity();
        
        /**
         * Sets the "city" element
         */
        void setCity(java.lang.String city);
        
        /**
         * Sets (as xml) the "city" element
         */
        void xsetCity(org.apache.xmlbeans.XmlString city);
        
        /**
         * Nils the "city" element
         */
        void setNilCity();
        
        /**
         * Unsets the "city" element
         */
        void unsetCity();
        
        /**
         * Gets the "state" element
         */
        java.lang.String getState();
        
        /**
         * Gets (as xml) the "state" element
         */
        org.apache.xmlbeans.XmlString xgetState();
        
        /**
         * Tests for nil "state" element
         */
        boolean isNilState();
        
        /**
         * True if has "state" element
         */
        boolean isSetState();
        
        /**
         * Sets the "state" element
         */
        void setState(java.lang.String state);
        
        /**
         * Sets (as xml) the "state" element
         */
        void xsetState(org.apache.xmlbeans.XmlString state);
        
        /**
         * Nils the "state" element
         */
        void setNilState();
        
        /**
         * Unsets the "state" element
         */
        void unsetState();
        
        /**
         * Gets the "zip" element
         */
        java.lang.String getZip();
        
        /**
         * Gets (as xml) the "zip" element
         */
        org.apache.xmlbeans.XmlString xgetZip();
        
        /**
         * Tests for nil "zip" element
         */
        boolean isNilZip();
        
        /**
         * True if has "zip" element
         */
        boolean isSetZip();
        
        /**
         * Sets the "zip" element
         */
        void setZip(java.lang.String zip);
        
        /**
         * Sets (as xml) the "zip" element
         */
        void xsetZip(org.apache.xmlbeans.XmlString zip);
        
        /**
         * Nils the "zip" element
         */
        void setNilZip();
        
        /**
         * Unsets the "zip" element
         */
        void unsetZip();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.test.PingDocument.Ping newInstance() {
              return (com.test.PingDocument.Ping) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.test.PingDocument.Ping newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.test.PingDocument.Ping) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.test.PingDocument newInstance() {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.test.PingDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.test.PingDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.test.PingDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.test.PingDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.test.PingDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.test.PingDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.test.PingDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.test.PingDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.test.PingDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.test.PingDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.test.PingDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.test.PingDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.test.PingDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.test.PingDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.test.PingDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.test.PingDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.test.PingDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.test.PingDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
