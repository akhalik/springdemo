
package demo.spring.common;

/**
 *
 * @author akhalik
 */
public class BaseCommon {
    
    
    /**
     * 
    * This Method Joins the array elements with the specified separator.
     *
     */
	public static String join(String[] dataArray, String separator){
		StringBuffer	strBfr	= new StringBuffer();
		for (String arr : dataArray) 
		{
			strBfr.append(arr);
			strBfr.append(separator);
		}

		if (strBfr.length() > 0) {
			strBfr.deleteCharAt(strBfr.length() - 1);
		}
		return strBfr.toString();
	} 
}
