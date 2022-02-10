package com.infa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DSAlgo {

	// find common elements in 2 sorted arrays

	public static void main(String args[]) throws Exception{
	//	findCommonElements2Arrays();
	//	findCommonElements3Arrays();
	//	findDuplicateCharsInString();
		findDuplicateWordInSentence();
		findSubstringInString();

	}

	private static void findSubstringInString() {
		String str1 = "Arrests";
		String str2 = "rest";
	}

	private static void findDuplicateWordInSentence() throws IOException {
		String file = "C:\\Sample.txt";
		File f = new File(file);
		FileReader fr = new FileReader(f);
		BufferedReader bf = new BufferedReader(fr);
		String line=bf.readLine();
		List<String> ll= new ArrayList<String>();
		while(line!=null) {
			String arr[] =line.split(" ");
			
	        Collections.addAll(ll, arr);
	        line=bf.readLine();
		}
		
		//logic 1
		Map<String,Integer> m = new HashMap<String,Integer>();
		ll.forEach(str-> 
		{
			if(m.containsKey(str)) {
				int i= m.get(str);
				m.put(str, i + 1);
			}else{
				m.put(str, 1);
			}
		});
		//System.out.println(m);	
		System.out.println(m.entrySet().stream().filter(entry->entry.getValue()>1).collect(Collectors.toList()));
		System.out.println(m.entrySet().stream().filter(entry->entry.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)));
		bf.close();
		
		//logic2
		
		Object arr[] = ll.toArray();
		Set<String> set =new HashSet<String>();
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i].equals(arr[j])) {
					set.add((String)arr[i]);
				}
			}
		}
		System.out.println(set);
	}

	public static void findCommonElements2Arrays() {

		int i1[] = { 1, 5, 10, 20, 40, 80 };
		int i2[] = { 6, 7, 20, 80, 100 };

		for (int i = 0; i < i1.length; i++) {
			for (int j = 0; j < i2.length; j++) {
				if (i1[i] == i2[j]) {
					//System.out.println("i1 : " + i1[i] + "i2 : " + i2[j]);
					System.out.println("Common elements : " + i1[i]);
				}
			}
		}
	}
	
	public static void findCommonElements3Arrays() {

		int i1[] = { 1, 5, 10, 20, 40, 80 };
		int i2[] = { 6, 7, 20, 80, 100 };
		int i3[] = {3,4,15,20,30,70,80,120};
		List<Integer> cEle = new ArrayList<Integer>();
		boolean common = false;

		for (int i = 0; i < i1.length; i++) {
			for (int j = 0; j < i2.length; j++) {
				if (i1[i] == i2[j]) {
					//System.out.println("i1 : " + i1[i] + "i2 : " + i2[j]);
				//	System.out.println("Common elements : " + i1[i]);
					cEle.add(i1[i]);
					common= true;
				}
			}
			
			for (int k = 0; k < i3.length; k++) {
				if (i1[i] == i3[k]) {
					//System.out.println("i1 : " + i1[i] + "i2 : " + i2[j]);
					//System.out.println("Common elements : " + i1[i]);
					if(!cEle.contains(i1[i])) {
						cEle.add(i1[i]);
						
					}
				}
			}
		}
		System.out.println(cEle);
	}
	
	public static void findDuplicateCharsInString() {
		String str = "aakiranni";
		char[] chars = str.toCharArray();
		for (int i=0;i<chars.length;i++) {
			for(int j=i+1;j<chars.length;j++) {
				if(chars[i]==chars[j]) {
					System.out.print(chars[i]);
					
				}
				
			}
			
		}
	}
}
