/**
 * Test runner for heapsort
 *
 * @author Brian
 * @version homework3
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

import java.util.*;

public class TestRunner{

	public static void main(String[] args){
		FileUtil util = new FileUtil("test.txt");
		ArrayList<String> stringList = new ArrayList<String>();
		ArrayList<StringUtil> utilList = new ArrayList<StringUtil>();
		stringList = util.fileToArray();
		for(int i = 0; i < stringList.size(); i++){
			//System.out.println(stringList.get(i));
			StringUtil test = new StringUtil(stringList.get(i));
			utilList.add(test);
		}
		HeapSort heap = new HeapSort(utilList);
		ArrayList<StringUtil> heapified = heap.getSorted();
		System.out.print("Sorted list");
		ArrayList<String> stringArr = new ArrayList<String>();
		for(int i = 0; i < heapified.size(); i++){
			System.out.println(heapified.get(i));
			stringArr.add(heapified.get(i).getStr());
		}
		util.arrayToFile(stringArr);
		System.out.println("Sorted output: out.txt");
	}

}
