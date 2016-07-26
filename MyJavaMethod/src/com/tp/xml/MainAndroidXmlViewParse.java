package com.tp.xml;

import java.util.List;

import com.tp.xml.tool.ViewXmlParse;

import tp.model.StringUtls;

/**
 * 功能： 解决 xml 中 很多view  不想 敲的情况。 很烦这个
 * 
 * 可以为您将xml 中所有定义的 id 用驼峰标识的方式 产生 定义 和  与view 绑定的 代码
 * 
 * 
 * @author tp
 *
 */
public class MainAndroidXmlViewParse {
	
	static String xmlFilePath ="C:\\Users\\tp\\Desktop\\我的收益\\slices";
	
	static List<ViewModel> viewModels ;
	public static void main(String[] args) throws Exception {
		viewModels =  ViewXmlParse.parseXml(xmlFilePath);
		System.out.println();
		System.out.println("----------生产成员变量----");
		createMember();
		
		System.out.println("----------生产findViewById----------");
		createFindView();
	}
	
	
	/**
	 * 创建成员变量
	 * @throws Exception
	 */
	public static void createMember() throws Exception{
		if (viewModels == null) {
			throw new Exception("参数不合法");
		}
		
		for (int i = 0; i < viewModels.size(); i++) {
			 ViewModel viewModel = viewModels.get(i);
			 
			 String name =  viewModel.getId().replace("@+id/", "");
			 
			 name = StringUtls.parseFristLowParamName(name);
			 
			 System.out.println("private " + viewModel.getTypeName() +" " + name +" ;");
			 
		}
		
	}
	
	public static void createFindView() throws Exception{
		if (viewModels == null) {
			throw new Exception("参数不合法");
		}
		
		for (int i = 0; i < viewModels.size(); i++) {
			 ViewModel viewModel = viewModels.get(i);
			 
			 
			 String name =  viewModel.getId().replace("@+id/", "");
			 name = StringUtls.parseFristLowParamName(name);
			 
			 String id =  viewModel.getId().replace("@+id/", "");
			 System.out.println( name +" = ("+viewModel.getTypeName()+")findViewById(R.id." + id +");" );
			 
		}
	}
	
}
