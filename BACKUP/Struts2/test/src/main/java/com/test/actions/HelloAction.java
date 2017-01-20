package com.test.actions;



import org.apache.struts2.convention.annotation.*;
import com.test.base.Struts2Action;
import com.test.base.UserForm;

@Namespace("/bank")
@ResultPath(value="/")
public class HelloAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	
	private UserForm userForm = new UserForm();

	public UserForm getUserForm() {
		return userForm;
	}

	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}

	@Action(value="citi", results={
			@Result(name="citi",location="/jsps/input-form.jsp")
		})
    public String citi() {
		userForm.setUserName("Fred");
        return "citi";
    }
}