package com.ssm.util;

import java.util.Collection;

  
/**        
 * Title: Collection ������    
 * Description: 
 * @author rico       
 * @created 2017��7��4�� ����5:14:01    
 */      
public class CollectionUtil {
    public static boolean isNotEmpty(Collection<?> c){
        if (c != null && c.size() != 0 ) {
            return true;
        }
        return false;
    }
}
