package com.ssm.util;

import java.util.UUID;

  
/**        
 * Title: ����UUID    
 * @author rico       
 * @created 2017��7��4�� ����5:13:16    
 */      
public class CodecUtil {
    
    public static String createUUID(){
        return UUID.randomUUID().toString();
    }
}
