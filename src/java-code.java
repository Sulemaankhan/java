Logical
-------

//reverse string
=================	
	return IntStream.range(0, str.length())
				.mapToObj(i->str.charAt(str.length()-1-i))
				.map(String::valueOf)
				.collect(Collectors.joining());	
//reverse sentance
==================
		String[] strArr = str.split(" "); // split on single space
		StringBuilder result = new StringBuilder();
		for (int i = strArr.length - 1; i >= 0; i--) {
			result.append(strArr[i]);
			if (i != 0) {
				result.append(" "); //
			}
			// add space
		}
		System.out.println("Input: " + str);
		return result.toString();
		
		java8:
		Stream.of(str.split(" ")).reduce((a,b)-> b+ " "+a).orElse("");
			
//sort string
=============
	Stream.of(str.split("")).sorted()..collect(Collectors.joining());
	sort.chars()
        .sorted().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining())
		
	Sort Words given List:
	----------------------
	List<String> sstList=Arrays.asList("bpple","Zadt","aqwrt");
        System.out.println(sstList.stream()
        		.map(s->s.toLowerCase()).
        		sorted().collect(Collectors.toList()));
	

//remove dup from the string
==============================
		Stream.of(str.split("")) //convert str to Stream(String) //['a','f','y'] etc.
				 .distinct()  //return distinct uniques
				 .map(Object::toString) //map convert unique char to string
				 .collect(Collectors.joining()); //join one by one
				 
		str.chars().
				mapToObj(c->String.valueOf((char)c))
				.distinct()
				.collect(Collectors.joining());
		
		str=str.toLowerCase();
		char [] ch=str.toArray();
		String result="";
		for(int i; i<ch.length;i++){
			if(ch[i]!=' '){
				for(int j=i+1; j<ch.length;i++){
					if(ch[i]==ch[j]){
						ch[j]=' ';
					}
				}
				if(ch[i]!=' '){
					result+=ch[i];
				}
			}
		}
	
//first non rep seq
======================
	claas A{
	for (char c : s.toCharArray()) {
			if (s.indexOf(c) == s.lastIndexOf(c)) {
				return c;
			}
		}
		throw new RuntimeException("Envalid............");
	}	
	String result1=Stream.of(s.split("")) //split every possition ->//["S","u","l","e"];
		.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
		.entrySet().stream().filter(value->value.getValue()==1)
		.map(Map.Entry::getKey) //mapped with key only
		.findFirst().orElse(null); //find first key. return as string

	// time complexity o(n)
		//space complexity o(n)
		//work for nay set or unicode
		Map<Character, Integer> map=new HashMap<>();
		str = str.replaceAll("[^A-Za-z0-9]", "");
		for (char c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c,0)+1); //freq of char
			
			//map.getOrDefault(c,0)
			//if c already in map,take current value
			//if not take 0
			//add +1
			//map.put(c,value)
			//put it back map
		}
		for(char c:str.toCharArray()) {
			if(map.get(c)==1) { // k=c, val=1
				return c;
			}
		}

		throw new RuntimeException("Envalid............");
	}

//Display consicutive sequence of earch char:
==========================================
		input=input.toLowerCase();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			} else {
				Integer val=map.get(str.charAt(i)); //count duplicate.
				map.put(str.charAt(i), val + 1);
			}
		}
		Using java8:
		-----------
		Map<String, Long> output = Stream.of(str.split("")).map(s -> s.toLowerCase())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println("7. CountSequenceOfChar ::Output using java8 : " + output);
		
		fasted:
		-----
		int[] arr=new int[256]; //index rande 0 to 255
		all element initialzied 0 by default
		
		for(char c:s.toCharArray()){
			arr[c]++;
		}
	
//sub arr based on target
=========================	
	static void creatSumArrTrg(int[] arrs, int target) {

		HashSet<Integer> set = new HashSet<>();
		String result = "";
		for (int num : arrs) {

			int temp = target - num;  //target always>=num
			if (set.contains(temp)) { //if set==temp go inside the cond else 
				//add to set
				result = "pair is:" + num + "," + temp + "=" + target;
				System.out.println(result);
				return;
			}
			set.add(num);
		}

	}

//two max sum no
===================
	private static int sumofTwoLargesNumber(int[] arr) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		//flow
		//max1->max2
		//num->max1
		//num->max2
		for (int num : arr) {
			if (num > max1) { //num always >max1 and max2 
				max2 = max1; 
				max1 = num; //assign num max1
			} else if (num > max2) {
				max2 = num;
			}
		}
		return max1 + max2;
		
	}

//move zero to right
======================
	int j=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[i]; //using swap
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		return arr;
	fast approach:
	------------
		int index=0; //0(n)
		//move non zer elements forword.
		for(int num:arr) {
			if(num!=0) {
				arr[index++]=num; 
			}
		}
		//fill remaining positions with zero
		//add number of zero based on the index count
		while(index<arr.length) {
			arr[index++]=0;
		}
		return arr;

//n sorted list merge to one sorted list 
		
	LeetCode:
	=========
	
	Problem-21:sorted list merge to one sorted list
	----------------------------------------------
	class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null ){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        //ccase 1
        if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }

    }
}
		
Diff ways dec:
-----------------
			String str="jhfhjjhgf";
			//Stream<String> s=Stream.of(str);
			//Stream<String> ss=Stream.of(str.split(""));
			//Stream<String> ssss=Arrays.stream(str.split(""));
			
			//Arrays.stream() only application for ,non string array all type wrapper
				Ex:
				Integer[] arr= {4,3,4};
				Stream<Integer> sss=Arrays.stream(arr);			
				
Find the number from the string and sum:
=======================================
	//First approch
		int sumTot = str.chars(). //convert string to stream
				filter(Character::isDigit) //filter digit from charector
				.map(c -> c - '0') //convert char to number
				.sum(); //sum all numbers
		
		//second approch
		int sum=0;
		for (char c : str.toCharArray()) {
			if(Character.isDigit(c)) {
				sum+=c-'0';
			}
		}
		
		
Largest number.
==============
		Integer[] arr= {4,3,4};
		Stream<Integer> sss=Arrays.stream(arr);
		//Stream<Integer> in=Stream.of(2,4,6,6,5);
		//System.out.println(in.reduce(Integer.MIN_VALUE,Integer::max));
		System.out.println(in.max(Comparator.comparing(Integer::intValue)).get());
		
		
Sum of even number:
===================	
	int[] arr = { 3, 4, 6, 13, 8 };
		long ss = Arrays.stream(arr). // IntStream
				filter(q -> q % 2 == 0).mapToLong(q -> q).sum();
	Stream<Integer> st = Stream.of(2, 4, 3, 7, 8);
		int sumOfEvenNum = st.filter(s -> s % 2 == 0).mapToInt(i -> i).sum();
		
//binary search
===================
	int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			// find mid num
			int mid = left + (right - left) / 2;

			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) { 
				left = mid + 1; //left to right
			} else {
				right = mid - 1; //move right to left
			}
		} 
		return -1;
	}

//lenior search
//number palindrom	
=================
	int  reverse = 0;
		boolean check=false;
		int number = 454;// It is the number variable to be checked for palindrome

		int temp = number;
		while (number > 0) {
			int rem = number % 10; // getting remainder
			reverse = reverse * 10 + rem;
			number = number / 10; // quicent
		}
		if (temp == reverse) {
			check=true;
		}
		return check;

				
Custom sorting
=============
	employees.stream().
		sorted(Comparator.comparing(Employee::getAge))
			.collect(Collectors.toList());	
FlatMap
=======	
	List<List<Integer>> to list using flatMap:
	System.out.println("=====");
		List<List<Integer>> list=List.of(List.of(2,4,6,3), List.of(23,14,65,2),List.of(20,47,67,53));
		List<Integer> result=list.stream().flatMap(Collection::stream).
		sorted().distinct()
		.collect(Collectors.toList());	
								
	LRU cache:
	==========
	
	Longest String without repeating a charector
	===========================================
	
	using sliding window.
		
	//thread safe counter:
	======================
		private AtomicInteger count=new AtomicInteger(0);
			public void increment(){
		count.incrementAndGet();
		}
		public int get(){
			return count.get();
		}
		
	//Producer and Consumer using BlockingQueue:
	
	
		//find the salary <40000
			List<Employee> resultSal=list.stream().filter(sal->
			sal.getSalary()<48000).collect(Collectors.toList());
			System.out.println("find the salary <3800 :\n"+resultSal);
			
			
			//find the employee start with A or Z
			List<Employee> resultStart=list.stream().filter(s->s.getEname().startsWith("A")
					|| s.getEname().startsWith("Z"))
					.collect(Collectors.toList());
			System.out.println("\nfind the employee start with A or Z :\n"+resultStart);
			
			//Find the department group by
			Map<String, Long> mapGroupBy=list.stream().
					collect(Collectors.groupingBy(Employee::getDepartment
							,Collectors.counting()));
			System.out.println("\n Count department group by :\n"+mapGroupBy);
			
			//avg sal by department
			Map<String, Double> deptAvgBySal=list.stream().
					collect(Collectors.groupingBy(Employee::getDepartment,
							Collectors.averagingDouble(Employee::getSalary)));
			System.out.println("\navg sal by department :\n"+deptAvgBySal);
			
			//Increase sal for MAC department
			List<Employee> incSalMacDept=list.stream().filter(
					dept->dept.getDepartment().equalsIgnoreCase("mac"))
					.peek(inc->inc.setSalary(inc.getSalary()*1.5))
					.collect(Collectors.toList());
			System.out.println("\nIncrease sal for MAC department :\n"+incSalMacDept);
			
			//Find first emp with 4000 sal
			//		Optional<Double> findFirstEmp=list.stream().filter(sal->sal.getSalary()<4000)
			//				.findFirst()
			//				.map(Employee::getSalary);
			Employee findFirstEmp=list.stream().filter(sal->sal.getSalary()<4000)
					.findFirst()
					.orElse(null);
			System.out.println("\nFind first emp with 4000 sal :\n"+findFirstEmp);
			
			
			//find the min sal employee obj.
			Employee micSal=list.stream().min(Comparator.comparing(Employee::getSalary)).orElse(null);
			System.out.println("\nfind the min sal employee obj  :\n"+micSal);
			
			//find emp name max sal.
			String nameMaxSal=list.stream().max(Comparator.comparing(Employee::getSalary))
					.map(Employee::getEname).orElse(null);
			
			System.out.println("\nfind emp name max sal :\n"+nameMaxSal);
			
			Employee findAny=list.stream().filter(sal->sal.getSalary()<2000)
			.findAny().orElse(null);
			System.out.println("\nfind any emp sal->sal.getSalary()<2000 sal :\n"+findAny);
			
			boolean nameAnymatch=list.stream().anyMatch(name->name.getEname().equalsIgnoreCase("Afroz"));
			System.out.println("\nEmployee any match  :\n"+nameAnymatch);
			
			boolean nameAllMatch=list.stream().allMatch(name->name.getEname().equalsIgnoreCase("Afroz"));
			System.out.println("\n Employee all match :\n"+nameAllMatch);
			
			boolean nameNoneMatch=list.stream().noneMatch(name->name.getEname().equalsIgnoreCase("dsjg"));
			System.out.println("\n Employee none match :\n"+nameNoneMatch);
