package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*------Intercept----
 * 
 * 截取数据中正常的流量数据
 * 
 * */

public class Intercept {

	public static String readFile(String inpath){
		
		StringBuilder content = new StringBuilder("");
		int j = 0;
		try{
			File file = new File(inpath);
			if (file.isFile() && file.exists()){
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));
				BufferedReader br = new BufferedReader(read);
				String lineText = null;
				while( ((lineText = br.readLine()) != null)){
					content.append(lineText);
					content.append("\r\n");
					j++;
				}
				System.out.println(j);
				read.close();
			}else{
				System.out.println("找不到指定的文件");
			}
		}catch (Exception e){
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return content.toString();
	}
	
	public static void writeFile(String content){
		BufferedWriter bw = null;
		try{
			File file = new File("D:/new.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		
		String content = Intercept.readFile("E:/HadoopWorkPlat/ans.txt");
		Intercept.writeFile(content);
	}
}
