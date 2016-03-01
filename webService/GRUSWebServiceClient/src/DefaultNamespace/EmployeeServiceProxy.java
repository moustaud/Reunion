package DefaultNamespace;

public class EmployeeServiceProxy implements DefaultNamespace.EmployeeService {
  private String _endpoint = null;
  private DefaultNamespace.EmployeeService employeeService = null;
  
  public EmployeeServiceProxy() {
    _initEmployeeServiceProxy();
  }
  
  public EmployeeServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeServiceProxy();
  }
  
  private void _initEmployeeServiceProxy() {
    try {
      employeeService = (new DefaultNamespace.EmployeeServiceServiceLocator()).getEmployeeService();
      if (employeeService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeService != null)
      ((javax.xml.rpc.Stub)employeeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.EmployeeService getEmployeeService() {
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService;
  }
  
  public boolean verifyEmployee(java.lang.String url, java.lang.String db_login, java.lang.String db_mdp, java.lang.String equivalent_userName, java.lang.String equivalent_mdp, java.lang.String userName, java.lang.String mdp) throws java.rmi.RemoteException{
    if (employeeService == null)
      _initEmployeeServiceProxy();
    return employeeService.verifyEmployee(url, db_login, db_mdp, equivalent_userName, equivalent_mdp, userName, mdp);
  }
  
  
}