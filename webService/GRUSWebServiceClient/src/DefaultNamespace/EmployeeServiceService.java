/**
 * EmployeeServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface EmployeeServiceService extends javax.xml.rpc.Service {
    public java.lang.String getEmployeeServiceAddress();

    public DefaultNamespace.EmployeeService getEmployeeService() throws javax.xml.rpc.ServiceException;

    public DefaultNamespace.EmployeeService getEmployeeService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
