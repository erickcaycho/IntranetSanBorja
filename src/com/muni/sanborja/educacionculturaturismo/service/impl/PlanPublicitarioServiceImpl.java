package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.PlanPublicitarioDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.PlanPublicitarioDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.PlanPublicitario;
import com.muni.sanborja.educacionculturaturismo.service.PlanPublicitarioService;

public class PlanPublicitarioServiceImpl implements Serializable,PlanPublicitarioService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(PlanPublicitarioServiceImpl.class);
	private PlanPublicitarioDao planPubicitarioDao = new PlanPublicitarioDaoImpl();
	
	@Override
	public boolean createPlanPublicitario(PlanPublicitario planPublicitario) {
		
//		   String destination="D:\\tmp\\";		
//		UploadedFile uploadedPhoto=getFile();
////		UploadedFile uploadedFile = event.getFile();
////	    String fileName = uploadedFile.getFileName();
////	    String contentType = uploadedFile.getContentType();
////	    byte[] contents = uploadedFile.getContents(); // Or getInputStream()
////	    // ... Save it, now!
//		File archivo = new File("/tmp/muni/uploads/" + file.getFileName());
//		
//		OutputStream out = new FileOutputStream(archivo);
//	    out.write(file.getContents());
//	    out.close();
//	    
//	    FacesContext.getCurrentInstance().addMessage(
//	               null, new FacesMessage("Upload completo", 
//	               "O arquivo " + uploadedPhoto.getFileName() + " foi salvo!"));
//	    
//		 if(file != null) {
//			 
//	            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
//	            FacesContext.getCurrentInstance().addMessage(null, message);
//	        }
		
		return planPubicitarioDao.createPlanPublicitario(planPublicitario);
	}

	@Override
	public PlanPublicitario obtener(int idPlanificacion) {
		return planPubicitarioDao.obtener(idPlanificacion);		
	}	
}
