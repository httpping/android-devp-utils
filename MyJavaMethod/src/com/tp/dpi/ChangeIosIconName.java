package com.tp.dpi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 
 * 工具类 当你与到很坑爹的 多个dpi 需要改名字的时候咋办
 * 
 * @author tp
 * 
 */
public class ChangeIosIconName {

	// 文件夹路径
	static String filePath = "C:\\Users\\tp\\Desktop\\slices\\xxdpi";

	// 改名称后移动到
	static String newFilePath;// = "D:/Personal/ydxs/ydxsb/res";

	// 原来的名称
	static String oldName = "common_sort_press_up.png";

	// 新名称
	static String newName ;//= "common_share_friends.png";

	public static void main(String[] args) {
		
		newFilePath = filePath;
		if (newName == null) {
			newName = oldName;
		}
		File root = new File(filePath);

		if (!root.exists() || !root.isDirectory()) {
			System.out.println("目录不对");
			return;
		}

		// 多个文件夹
		File[] files = root.listFiles();

		System.out.println("开始了");
		
		
		for (int i = 0; i < files.length; i++) {
			File curFile = files[i];

			String curFileName = curFile.getName();
			
			String[] names  = curFileName.split("@");
			if (names.length <=1) {
				continue;
			}
			newName = names[0] +".png";
			oldName = curFileName;
			
			File newFileD = new File(filePath, newName);
			//newFileD.mkdirs();

			File oldFile = new File(filePath, oldName);
			System.out.println("文件处理开始：" + oldName);
			if (oldFile != null) { // 存在
				System.out.println("处理：" + oldFile.getPath());
				
				File newFile = new File(filePath, newName.toLowerCase());
				 
				System.out.println("处理 new ：" + newFile.getPath());

				oldFile.renameTo(newFile);
				//fileChannelCopy(oldFile,newFile);
			}
			System.out.println("文件处理结束：" + oldName);
		}

		System.out.println("搞定了");

	}

	/**
	 * 查找文件
	 * 
	 * @param root
	 * @param fileName
	 * @return
	 */
	public static File getFileByFileName(File root, String fileName) {

		// 多个文件夹
		File[] files = root.listFiles();

		for (int i = 0; i < files.length; i++) {
			File curFile = files[i];
			if (curFile.getName().equals(fileName)) {
				return curFile;
			}
		}

		return null;
	}

	/**
	 * 
	 * 使用文件通道的方式复制文件
	 * 
	 * 
	 * 
	 * @param s
	 * 
	 *            源文件
	 * 
	 * @param t
	 * 
	 *            复制到的新文件
	 */

	public static void fileChannelCopy(File s, File t) {

		FileInputStream fi = null;

		FileOutputStream fo = null;

		FileChannel in = null;

		FileChannel out = null;

		try {

			fi = new FileInputStream(s);

			fo = new FileOutputStream(t);

			in = fi.getChannel();// 得到对应的文件通道

			out = fo.getChannel();// 得到对应的文件通道

			in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
			fo.flush();
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {
				
				fi.close();
				in.close();

				fo.close();

				out.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

}
