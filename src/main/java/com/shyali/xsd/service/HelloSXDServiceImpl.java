package com.shyali.xsd.service;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.cxf.annotations.SchemaValidation;
import org.apache.cxf.annotations.SchemaValidation.SchemaValidationType;
import org.jboss.ws.api.annotation.WebContext;

@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
@WebService(
        serviceName = "HelloXSDService",
        portName = "HelloXSDPort",
        endpointInterface = "com.shyali.xsd.service.HelloXSD",
        targetNamespace = "http://service.shyali.com",
        wsdlLocation = "META-INF/wsdl/HelloXSD.wsdl")
@WebContext(contextRoot = "/shyali/GradleSoapTopDownXSD", urlPattern = "HelloService")
@SchemaValidation(type = SchemaValidationType.NONE)
@Stateless
@Startup
public class HelloSXDServiceImpl implements HelloXSD {

    @Override
    public SayHelloResponse helloName(SayHelloRequest parameters) {
        SayHelloResponse res = new SayHelloResponse();
        res.setNameReturn("Hello a " + parameters.getName() + " welcome");
        return res;
    }

}
