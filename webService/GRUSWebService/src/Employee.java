
import java.io.Serializable;
 
public class Employee implements Serializable{
 
    private static final long serialVersionUID = -5577579081118070434L;
     
    private String firstName;
    private String lastName;
    private String userName;
    private String mdp;

    public String getfirstName() {
        return firstName;
    }
    
    public String getlastName() {
        return lastName;
    }
    
    public String getlogin() {
        return userName;
    }
    public String getmdp() {
        return mdp;
    }

    
    
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setuserName(String userName) {
        this.userName = userName;
    }
    
    public void setmdp(String mdp) {
        this.mdp = mdp;
    }    
    
    /*public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
     */
}