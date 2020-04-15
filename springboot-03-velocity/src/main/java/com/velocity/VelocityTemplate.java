package com.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;


import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

public class VelocityTemplate {
	


	private Template template =  null;
	
	public VelocityTemplate() {
		super();
	}
	
	public VelocityTemplate(String templateSrc) {
		try {
			Properties p = new Properties();
			p.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			p.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
	        p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
	        p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8"); 
			Velocity.init(p);
			try {
				template = Velocity.getTemplate(templateSrc);
			} catch (ResourceNotFoundException rnfe) {
				System.out.println("Example : error : cannot find template " + templateSrc);
			} catch (ParseErrorException pee) {
				System.out.println("Example : Syntax error in template " + templateSrc + ":" + pee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String merge(VelocityContext context){
		String msg=null;
		StringWriter sw=null;
		try {
			sw=new StringWriter();
			if (template!=null){
		        template.merge(context, sw);
		        msg = sw.toString();
			}
			sw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(sw!=null){
				sw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	    return msg;
	}	
	
	
	


}
