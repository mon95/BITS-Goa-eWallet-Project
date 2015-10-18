package e_wallet;

/**
 *
 * @author Sam
 */
public class Login {
	
	String bits_id;
	String password;
	boolean result=false;
	
    /**
     *
     * @param bits_id
     * @param password
     */
    public Login(String bits_id, String password){
		this.bits_id=bits_id;
		this.password=password;
		
	}
	
    /**
     *
     * @return
     */
    public boolean resultStudent(){
		try{
		Student student = Controller.db.getStudent(bits_id);
		if(Controller.db.verifyPassword(student, password)){
			result = true;
		}
		}catch(NullPointerException e){
			return false;
		}
		return result;
	}
	
    /**
     *
     * @return
     */
    public boolean resultVendor(){
		try{
		Vendor vendor = Controller.db.getVendor(bits_id);
		if(Controller.db.verifyPassword(vendor, password)){
			result = true;
		}
		}catch(NullPointerException e){
			return false;
		}
		return result;
	}
	
    /**
     *
     * @return
     */
    public String getStudentName(){
		Student student = Controller.db.getStudent(bits_id);
		return student.name;
	}
	
    /**
     *
     * @return
     */
    public String getVendorName(){
		Vendor vendor = Controller.db.getVendor(bits_id);
		return vendor.name;
	}
}
