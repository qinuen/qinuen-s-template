package com.ssm.util;

  
/**        
 * Title: �ַ���������    
 * @author rico       
 * @created 2017��7��4�� ����5:15:29    
 */      
public class StringUtil {
      
    /**     
     * @description �����ַ����Ƿ�Ϊ�ջ�մ�
     * @author rico       
     * @created 2017��7��4�� ����5:15:46     
     * @param str
     * @return     
     */
    public static boolean isNotEmpty(String str) {
        if (str != null && str.length() != 0) {
            return true;
        }
        return false;
    }

    /**     
     * @description �����ַ����Ƿ�Ϊ�ջ�մ�
     * @author rico       
     * @created 2017��7��4�� ����5:15:46     
     * @param str
     * @return     
     */
    public static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }
}
