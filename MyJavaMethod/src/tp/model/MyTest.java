package tp.model;

public class MyTest {
	
	public static void main(String[] args) {
		
		byte len = -10 ;
		
		int i =0;
		if (len<0) {
			i = len +  256;
		}
		
		len = (byte)i;
		System.out.println(len);
		
		int result = len & 0xff;
		System.out.println( result);
		
		StringBuffer sb = new StringBuffer();
		sb.append(Integer.toHexString(len));
		sb.append(Integer.toHexString(19));
		System.out.println(sb);
		
		
		i =Integer.parseInt(Integer.toHexString(i), 16);
		System.out.println((byte)i);
		len = 0xfffffff6;
		/*System.out.println(0xf6);
		System.out.println(len)*/;
		
		pay();
	}
	
	public static void pay(){
		byte b[] ={-1,10,40,-10,40};
		int i;
		StringBuffer buf = new StringBuffer("");
        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0)
                i += 256;
            if (i < 16)
                buf.append("0");
            buf.append(Integer.toHexString(i));
        }
        System.out.println(buf);
	}

}
