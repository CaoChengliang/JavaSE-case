package charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main {

	
	
	/**
	 * 学会自己进行文字的编码和解码，为以后的场景做准备
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String string = "aaa我爱张明珠";
		
		//byte[] bytes =  string.getBytes(); //已默认字符集进行编码
		byte[] bytes =  string.getBytes("GBK");//以自定义指定编码
		System.out.println(bytes.length);
		System.out.println(Arrays.toString(bytes));
		
		//解码
		//String rs = new String(bytes);//默认解码
		String rs = new String(bytes,"GBK");
		System.out.println(rs);

	}

}
