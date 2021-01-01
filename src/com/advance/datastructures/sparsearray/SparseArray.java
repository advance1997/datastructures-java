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
 * ϡ������
 * 	����ά�������Ч��ֵ���棬����Ϊ0�����ݽ��б���
 *  ��ʽ��ϡ������ĵ�һ�б���ԭ�����������Ϣ �ֱ�Ϊ��row���У� col���У� sum����Ч����������
 *  	ϡ������������б���ԭ�����������Ϣ �ֱ�Ϊ��row���У� col���У� val�����ݣ�
 *  
 *  �磺
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
		//��ʼ����ά���鲢��ӡ
		arrs[1][6] = 3;
		arrs[3][3] = 5;
		arrs[6][7] = 8;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//�����û�����
		char key = ' '; 
		boolean loop = true;
		while(loop){
			System.out.println("o(origin): ��ӡԭʼ��ά����");
			System.out.println("c(change): ԭʼ��ά����ת��Ϊϡ������");
			System.out.println("p(print): ��ӡϡ������");
			System.out.println("f(format): ��ϡ������ת��Ϊ��ά���鲢��ӡ");
			System.out.println("s(save): ����ϡ���������ļ���");
			System.out.println("r(read): ���ļ��ж���ϡ������");
			System.out.println("e(exit): �˳�����");
			System.out.print("��ѡ�����");
			//����һ�������ַ�
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
		System.out.println("�˳�~~");
		
	}
	
	/**
	 * ��ӡ��ʼ����
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
	 * ����ά����ת��Ϊϡ������
	 */
	private static void changeSparseArr(){
		//ͳ�ƶ�ά��������
		int rownum = 0;
		//ͳ�ƶ�ά��������
		int colnum = 0;
		//ͳ�ƶ�ά������Ч��ֵ
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
		//��ʼ��ϡ������  �����ȶ�������������sum+1����һ��
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
		System.out.println("��ά�����ѳɹ�ת��Ϊϡ������~~");
	}
	
	/**
	 * ��ӡϡ������
	 */
	private static void printSparseArr(){
		System.out.println();
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
		}
	}
	
	/**
	 * ��ϡ������ת��Ϊ��ά����
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
	 * ��ϡ�����鱣�����ļ���
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
	 * ��ȡϡ�������ļ�����ӡ����
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
		String line;  //һ������
		int row=0;
		int[][] arr2 = new int[sparseArr.length][3];
		//���ж�ȡ������ÿ��������뵽������
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
