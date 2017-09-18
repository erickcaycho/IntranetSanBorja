package com.muni.sanborja.educacionculturaturismo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
@ManagedBean(name="cabecera")
public class HeaderManagedBean {

	public void onTimeout(){  
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Chuck Norris Mato la session!",null));  
    }
}
