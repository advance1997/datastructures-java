package com.advance.datastructures.sparsearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * 稀疏数组
 * 	将二维数组的有效数值保存，即不为0的数据进行保存
 *  格式：稀疏数组的第一行保存原数组的数据信息 分别为：row（行） col（列） sum（有效数据总数）
 *  	稀疏数组的其他行保存原数组的数据信息 分别为：row（行） col（列） val（数据）
 *  
 *  如：
 *  	row col sum
 *    0	 11  11  3
 *    	row col val
 *    1  1   6   3
 *    2  3   3   5
 *    2  4   7   8
 * 
 * @author advance
 *
 */
public class SparseArray {
	
	private static final int[][] arrs = new int[11][12];
	private static int[][] sparseArr;
	private static final String fileName = "D://dataStructure/sparseArr.sar";
	
	
	static{
		//初始化二维数组并打印
		arrs[1][6] = 3;
		arrs[3][3] = 5;
		arrs[6][7] = 8;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//接收用户输入
		char key = ' '; 
		boolean loop = true;
		while(loop){
			System.out.println("o(origin): 打印原始二维数组");
			System.out.println("c(change): 原始二维数组转换为稀疏数组");
			System.out.println("p(print): 打印稀疏数组");
			System.out.println("f(format): 将稀疏数组转化为二维数组并打印");
			System.out.println("s(save): 保存稀疏数组至文件中");
			System.out.println("r(read): 从文件中读出稀疏数组");
			System.out.println("e(exit): 退出程序");
			System.out.print("请选择命令：");
			//接收一个输入字符
			key = scanner.nextLine().charAt(0); 
			switch(key){
				case 'o':
					printOriArr(); break;
				case 'c':
					changeSparseArr(); break;
				case 'p':
					printSparseArr(); break;
				case 'f':
					format(); break;
				case 's':
					saveSparseArr(); break;
				case 'r':
					readSparseArr(); break;
				case 'e':
					loop = false; break;
				default:break;
			}
		}
		System.out.println("退出~~");
		
	}
	
	/**
	 * 打印初始数组
	 */
	private static void printOriArr(){
		System.out.println();
		for(int[] row : arrs){
			for(int data : row){
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * 将二维数组转换为稀疏数组
	 */
	private static void changeSparseArr(){
		//统计二维数组行数
		int rownum = 0;
		//统计二维数组列数
		int colnum = 0;
		//统计二维数组有效数值
		int sum = 0;
		for(int[] row : arrs){
			rownum++;
			colnum = 0;
			for(int data : row){
				colnum++;
				if(data != 0){
					sum++;
				}
			}
		}
		//初始化稀疏数组  列数稳定是三，行数跟sum+1数据一致
		sparseArr = new int[sum+1][3];
		sparseArr[0][0] = rownum;
		sparseArr[0][1] = colnum;
		sparseArr[0][2] = sum;
		int n = 1;
		for(int i = 0 ; i < arrs.length ; i++){
			for(int j = 0 ; j < arrs[0].length; j++){
				if(arrs[i][j] != 0){
					sparseArr[n][0] = i;
					sparseArr[n][1] = j;
					sparseArr[n][2] = arrs[i][j];
					n++;
				}
			}
		}
		System.out.println("二维数组已成功转换为稀疏数组~~");
	}
	
	/**
	 * 打印稀疏数组
	 */
	private static void printSparseArr(){
		System.out.println();
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
		}
	}
	
	/**
	 * 将稀疏数组转化为二维数组
	 */
	private static void format(){
		int row = sparseArr[0][0];
		int col = sparseArr[0][1];
		int[][] temp = new int[row][col];
		for(int i = 1; i < sparseArr.length ; i++){
			temp[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		for(int[] rowData : temp){
			for(int data : rowData){
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * 将稀疏数组保存至文件中
	 */
	private static void saveSparseArr(){
		FileWriter write = null;
		File file;
		try{
			file = new File(fileName);
			if (!file.exists()) {
			    file.createNewFile();
			}
			write = new FileWriter(file);
			for(int[] row : sparseArr){
				for(int data : row){
					write.write(data+"\t");
				}
				write.write("\r\n");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				write.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 读取稀疏数组文件并打印出来
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	private static void readSparseArr(){
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(new File(fileName)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  //
		String line;  //一行数据
		int row=0;
		int[][] arr2 = new int[sparseArr.length][3];
		//逐行读取，并将每个数组放入到数组中
		try {
			while((line = in.readLine()) != null){
				String[] temp = line.split("\t"); 
				for(int j=0;j<temp.length;j++){
					arr2[row][j] = Integer.parseInt(temp[j]);
				}
				row++;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int[] rowData : arr2){
			for(int data : rowData){
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
