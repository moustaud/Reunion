/**
 * EmployeeService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface EmployeeService extends java.rmi.Remote {
    public boolean verifyEmployee(java.lang.String url, java.lang.String db_login, java.lang.String db_mdp, java.lang.String equivalent_userName, java.lang.String equivalent_mdp, java.lang.String userName, java.lang.String mdp) throws java.rmi.RemoteException;
}
