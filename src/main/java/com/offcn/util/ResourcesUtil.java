package com.offcn.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 资源文件加载类
*/
public class ResourcesUtil {

	   public static List getKeyList(String filename){
		   List list=new ArrayList();
		   ResourceBundle bundle = ResourceBundle.getBundle(filename);
		   Enumeration<String> keys = bundle.getKeys();
		   while(keys.hasMoreElements()){
			   String nextElement = keys.nextElement();
			   list.add(nextElement);
		   }
		   return list;
	   }
	
}
