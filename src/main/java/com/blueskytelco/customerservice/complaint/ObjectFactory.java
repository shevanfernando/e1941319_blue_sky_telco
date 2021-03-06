//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.03.26 at 09:33:40 PM IST 
//


package com.blueskytelco.customerservice.complaint;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.blueskytelco.customerservice.complaint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.blueskytelco.customerservice.complaint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetComplainByIdRequest }
     * 
     */
    public GetComplainByIdRequest createGetComplainByIdRequest() {
        return new GetComplainByIdRequest();
    }

    /**
     * Create an instance of {@link GetComplainByIdResponse }
     * 
     */
    public GetComplainByIdResponse createGetComplainByIdResponse() {
        return new GetComplainByIdResponse();
    }

    /**
     * Create an instance of {@link Complaint }
     * 
     */
    public Complaint createComplaint() {
        return new Complaint();
    }

    /**
     * Create an instance of {@link NewComplaintRequest }
     * 
     */
    public NewComplaintRequest createNewComplaintRequest() {
        return new NewComplaintRequest();
    }

    /**
     * Create an instance of {@link GetStatusRequest }
     * 
     */
    public GetStatusRequest createGetStatusRequest() {
        return new GetStatusRequest();
    }

    /**
     * Create an instance of {@link GetStatusResponse }
     * 
     */
    public GetStatusResponse createGetStatusResponse() {
        return new GetStatusResponse();
    }

    /**
     * Create an instance of {@link UpdateStatusRequest }
     * 
     */
    public UpdateStatusRequest createUpdateStatusRequest() {
        return new UpdateStatusRequest();
    }

    /**
     * Create an instance of {@link NewComplaintResponse }
     * 
     */
    public NewComplaintResponse createNewComplaintResponse() {
        return new NewComplaintResponse();
    }

    /**
     * Create an instance of {@link UpdateStatusResponse }
     * 
     */
    public UpdateStatusResponse createUpdateStatusResponse() {
        return new UpdateStatusResponse();
    }

}
