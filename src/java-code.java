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
	Stream.of(str.split("")).sorted().collect(Collectors.joining());
	sort.chars()
        .sorted().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining())
		
	Sort Words given List:
	----------------------
	List<String> sstList=Arrays.asList("bpple","Zadt","aqwrt");
        System.out.println(sstList.stream()
        		.map(s->s.toLowerCase()).
        		sorted().collect(Collectors.toList()));	

Longest String sentance
------------------------
	private static String longestString(String string) {
		return Stream.of(string.split(",")).max(Comparator.comparing(String::length))
		.map(String::toString).orElse("Not");
		//return null;
	}
	
non repeated Longest Sub-String
-------------------------------
	private static int longestSubstring(String str) {
	    if (str == null || str.length() == 0) return 0;
	    HashMap<Character, Integer> map = new HashMap<>();
	    int left = 0;
	    int max = 0;
	    for (int right = 0; right < str.length(); right++) {
	        char ch = str.charAt(right);
	        // If the character is already in the map and within our current window
	        if (map.containsKey(ch) && map.get(ch) >= left) {
	            left = map.get(ch) + 1;
	        }   
	        max = Math.max(max, right - left + 1);
	        map.put(ch, right); // Update or insert the character's latest index
	    } 
	    return max;
	}

Print the duplicate
====================	
private static Set<String> founDuplicateChar(String string) {
		// TODO Auto-generated method stub
		Set<String> set=new HashSet<>();
		return Stream.of(string.split(""))
				.filter(d->!set.add(d))
				.collect(Collectors.toSet());
	}
//remove dup from the string
==============================
		Stream.of(str.split("")) //convert str to Stream(String) //['a','f','y'] etc.
				 .distinct()  //return distinct uniques
				// .map(Object::toString) //map convert unique char to string
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
//Given String saparated number by , and Ex: John-ece
String str = "1:John:ece;2:Ram:cse;3:Sita:ece";
		Stream.of(str.split(";"))
				.map(s->s.split(":"))
				//.forEach(arr->System.out.println(arr[0]+","+arr[1]+"-"+ arr[2]));
				.map(arr->arr[0]+","+arr[1]+"-"+ arr[2])
				.collect(Collectors.toList()).forEach(System.out::println);
		
	
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

	//Best approch second
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
//Best approch one
================
	//but Brute force
		//only ASCII charector
		int[] arr = new int[256];
		// count frequency
		for (char c:s.toCharArray()) {
			arr[c]++;
		}
		// find non repeated.
		for (char c:s.toCharArray()) {
			if (arr[c] == 1) {
				return c;
			}
		}

//short approch
===============
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
	Using java8:
	-----------
		int maxSum=Arrays.stream(arr).
		boxed().sorted((a,b)->b-a)
		.limit(2).mapToInt(i->i)
		.sum();

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

		Using java8
		-----------	
		int[] intArr=IntStream.concat(
			Arrays.stream(arr).filter(i->i!=0), 
			Arrays.stream(arr).filter(i->i==0))
				.toArray();
				//boxed().collect(Collectors.toList())
			//Stream.concat(stream1,stream1);
			//Stream.concat(list1,list2);
findTheDuplicateNum
===================	
private static Set<Integer> findTheDuplicateNum(int[] arr) {
		Set<Integer> set=new HashSet<>();
		List<Integer> list=Arrays.asList(2,5,7,3,2,3);
		int firstDup=list.stream().filter(s->!set.add(s))
				.findFirst().orElse(0);
		System.out.println("first duplicate:"+firstDup);
		Set<Integer> noOfDup=list.stream().filter(d->!set.add(d)).collect(Collectors.toSet());
		return noOfDup;
	}
Second Highest num:
===================
private int secondMaxNum(int[] arrNum) {
		List<Integer> list=Arrays.stream(arrNum)
		.boxed().sorted().collect(Collectors.toList());
		System.out.println("\nsorted arr using jdk8:\n"+list+"\n");
		int max=Arrays.stream(arrNum)
		.boxed().sorted(Comparator.reverseOrder())
		.skip(1)
		.findFirst().orElse(0);
		return max;
}	
//Freq num based on K
==================	
private static void topReqKNum(int[] arr) {	
		Map<Integer, Integer> map=new HashMap<>();
		int k=2;
		for(int num:arr) {
			map.put(num,map.getOrDefault(num, 1)+1);
		}		
		 map.entrySet().stream().sorted((a,b)->a.getValue()-b.getValue())
		.limit(k)
		.forEach(s->System.out.println("Freq Nu based on K:"+s.getKey()));
		//.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));		
	}
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

			List<List<Employee>> list2=List.of(al,al2);
			List<Employee> flat= list2.stream().flatMap(Collection::stream).collect(Collectors.toList());
			System.out.println("=====flat :=======\n"+flat);
			
			//get each employee per department(distinct) emp list based on the dept 
			System.out.println("\n======get each employee per department(distinct)======");
			List<Employee> re=new ArrayList<> (list.stream().collect(Collectors.toMap(Employee::getDepartment, Function.identity(),
					(e1,e2)->e1
					))
					.values() //map.values()
					);
			re.forEach(System.out::println);	
	//partition high and low salary
			System.out.println("\n====High Sal====");
			Map<Boolean,List<Employee>> highSal=list.stream().collect(Collectors.partitioningBy(
					emp->emp.getSalary()>3000
					));
			highSal.get(true).forEach(System.out::println);
			
			System.out.println("\n=====Low sal====");
			highSal.get(false).forEach(System.out::println);
			
	System.out.println("\n=======find highest paid employee name each department========");
			Map<String,Optional<Employee>> highestPaid=list.stream().
				collect(Collectors.groupingBy( //collect 
						Employee::getDepartment, //distinct department
					Collectors.maxBy(Comparator.comparing(Employee::getSalary) //each department max sal
					)
					));
			highestPaid.forEach((k,v)->System.out.println(k+"->"+v));

		//find avg department and highest avg dept
		--------------------------------------------
			Map<String, Double> highAvgPaidDept=list.stream().collect(Collectors.groupingBy(Employee::getDepartment
					,Collectors.averagingDouble(Employee::getSalary)));
			System.out.println("avg each dept \n"
					+highAvgPaidDept);
			Map.Entry<String, Double> avg=highAvgPaidDept.entrySet().stream()
			.max(Map.Entry.comparingByValue())
			.orElse(null);
			System.out.println("find highest paid avg department,avg depart\n"
					+avg.getKey()+" : "+avg.getValue());
//Partition
----------
			List<Integer> numbers=List.of(3, 2, 6, 7, 10,2, 13, 55, 40,77, 81, 10);
			Map<Boolean, List<Integer>> evenList=numbers.stream().collect(Collectors.partitioningBy(
					even->even%2==0
					));
				System.out.println("Partition by even number: "+evenList.get(true));
				System.out.println("Partition by odd number: "+evenList.get(false));

			Top n result:
			============
				//Best approach top 2 numbers
				-----------------------------
					List<Integer> list1=List.of(90,4,6,6,84,22,23,56);
					PriorityQueue<Integer> pq=new PriorityQueue<>();
					for(Integer num:list1) {
						pq.offer(num);
						if(pq.size()>2) {
							pq.poll();
						}
					}
					List<Integer> listPQ=new ArrayList<>(pq);
					listPQ.sort(Comparator.reverseOrder());

				//Using stream and limit
				------------------------
					List<Employee> top3Sal=list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
					.limit(1).collect(Collectors.toList());
					System.out.println("=========================\n"+top3Sal);

				Using PriorityQueue
				------------------	
					PriorityQueue<Employee> pq=new PriorityQueue<>(
							Comparator.comparing(Employee::getSalary));
					for (Employee employee : list) {
						pq.offer(employee);
						if(pq.size()>1) {
							pq.poll();
						}
					}
					List<Employee> result=new ArrayList<>(pq);
					result.sort(Comparator.comparing(Employee::getSalary).reversed());
					System.out.println("===Using PR===\n"+result)

Multithreading:
===============
	How many ways to create a thread?
	--------------------------------
		1. Using class extend with Thread
		--------------------------------
		class MyThread extends Thread{
			public void run(){
				sop("fkjgjk")
			}
		}
		TestClass{
				MyThread mt=new MyThread();
				mt.start() 
			}	
		}
		Using lemada:
			new Thread(()->{
				sysop("");
			}).start();
		2. Using class implement with Runnable interface
		---------------------------------------------
		class MyTask implement Runnable{
			public void run(){
				sop("")
			}
		}
		TestClass{
			MyTask m=new MyTask();
			Thread t=new Thread(m);
			t.start();
		}
		Using lemda
		Runnable r=()->{
			sop(sjjjj);
		}
		new Thread(r).start();
		3. Using Callable with FutureTask
		--------------------------------
		Callable<Integer> cal=()->100;
			FutureTask<Integer> ft=new FutureTask<Integer>(cal);
			new Thread(ft).start();
			try {
				System.out.println("Thread :"+ft.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		4. Callable with call()
		-----------------------
			Callable<Integer> task=()->{
				return 10+20;
			}
			Integer in=task.call();
			sop(in);
		5. Callable with ExecuterServcie
		--------------------------------
			//callable
			Callable<Integer> cal=()->100;
			//single thread executor
			ExecutorService ex=Executors.newSingleThreadExecutor();
			
			//future call and submit
			Future<Integer> future=ex.submit(cal);
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
ThreadPool:
============
		ExecutorService ex = Executors.newFixedThreadPool(3);
		ex.submit(() -> {
			checkBalance();
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		ex.submit(()->transferMony());
		ex.shutdown();
ProducerConsumer:
=================
	Producer:
	--------
	class Producer implements Runnable {
		private BlockingQueue<Integer> queue;
		public Producer(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}
		@Override
		public void run() {
			try {
				for (int i = 1; i <= 5; i++) {
					queue.put(i);
					System.out.println("Produced: " + i);
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
Consumer:
--------
	import java.util.concurrent.BlockingQueue;
	class Consumer implements Runnable {
		private BlockingQueue<Integer> queue;
		public Consumer(BlockingQueue<Integer> queue) {
			this.queue = queue;
		}
		@Override
		public void run() {
			try {
				while (true) {
					Integer item = queue.take();
					System.out.println("Consumed: " + item);
					Thread.sleep(1500);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
ProducerConsumerDemo:
----------------------
	BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));
		producer.start();
		consumer.start();

	//How it works
	-------------
		Producer adds data into the queue using put().
		Consumer removes data using take().
		If the queue is full, put() blocks until space is available.
		If the queue is empty, take() blocks until an item is produced.
	Real-world example
	-----------------	
		Producer: Order service generating orders.
		Consumer: Payment service processing orders.
		Queue: Message queue like Kafka or RabbitMQ.
		
CompletableFutute:
=================
		1:  ExecutorService executor = Executors.newFixedThreadPool(10);
		2:	CompletableFuture<Customer> customerFuture =
				CompletableFuture.supplyAsync( //return result
					() -> customerService.getCustomer(id),executor
				);
			CompletableFuture<List<Transaction>> txnFuture =
				CompletableFuture.supplyAsync( //return result
					() -> transactionService.getTransactions(id),executor
				);
			CompletableFuture<Loan> loanFuture =
				CompletableFuture.supplyAsync( //return result
					() -> loanService.getLoan(id),executor
				);
		3:	CompletableFuture.allOf( //wait for all task
				customerFuture,
				txnFuture,
				loanFuture
			).join();
		4:	DashboardResponse response = new DashboardResponse(
				customerFuture.join(),
				txnFuture.join(),
				loanFuture.join()
			):
			Exception:
			-------------
			CompletableFuture<Loan> loanFuture =
			CompletableFuture.supplyAsync(() -> loanService.getLoan(id),executor)
			.exceptionally(ex -> {
				System.out.println("Loan service failed");
			return null;

LRU Cache:
===========
	public class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;
    public SimpleLRUCache(int capacity) {
        // initialCapacity, loadFactor, accessOrder (true tracks access, false tracks insertion)
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // Automatically evicts the oldest entry when size exceeds capacity
        return size() > capacity;
    }
    public static void main(String[] args) {
        SimpleLRUCache<Integer, String> cache = new SimpleLRUCache<>(3);
        cache.put(1, "Value A");
        cache.put(2, "Value B");
        cache.put(3, "Value C");     
        System.out.println("Initial Cache: " + cache); // {1=Value A, 2=Value B, 3=Value C}
        // Accessing key 1 makes it the most recently used
        cache.get(1); 
        System.out.println("After accessing 1: " + cache); // {2=Value B, 3=Value C, 1=Value A}
        // Adding a 4th item triggers eviction of key 2 (least recently used)
        cache.put(4, "Value D");
        System.out.println("After adding 4: " + cache); // {3=Value C, 1=Value A, 4=Value D}
    }
}

//Freq num based on K
==================	
private static void topReqKNum(int[] arr) {	
		Map<Integer, Integer> map=new HashMap<>();
		int k=2;
		for(int num:arr) {
			map.put(num,map.getOrDefault(num, 1)+1);
		}		
		 map.entrySet().stream().sorted((a,b)->a.getValue()-b.getValue())
		.limit(k)
		.forEach(s->System.out.println("Freq Nu based on K:"+s.getKey()));
		//.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));		
	}	
//non repeated Longest Sub-String
-------------------------------
	private static int longestSubstring(String str) {
	    if (str == null || str.length() == 0) return 0;
	    HashMap<Character, Integer> map = new HashMap<>();
	    int left = 0;
	    int max = 0;
	    for (int right = 0; right < str.length(); right++) {
	        char ch = str.charAt(right);
	        // If the character is already in the map and within our current window
	        if (map.containsKey(ch) && map.get(ch) >= left) {
	            left = map.get(ch) + 1;
	        }   
	        max = Math.max(max, right - left + 1);
	        map.put(ch, right); // Update or insert the character's latest index
	    } 
	    return max;
	}
GetAllEmployee:
===============
			Controller
			----------
			@GetMapping("api/v1/employees")
			public ResponseEntity<Page<EmployeeResponseDto>> getAllEmployees(@RequestParam(defaultValue = "1") int page,
					@RequestParam(defaultValue = "3") int size, @RequestParam(defaultValue = "id") String sort,
					@RequestParam(defaultValue = "asc") String direction) {
				Page<EmployeeResponseDto> response = employeeService.getAllEmployees(page, size, sort, direction);
				return new ResponseEntity<Page<EmployeeResponseDto>>(response, HttpStatus.OK);
			}
			ServiceImpl
			-----------	
			@Override
			public Page<EmployeeResponseDto> getAllEmployees(int page, int size, String sort, String direction) {
				Sort sortGrid=direction.equalsIgnoreCase("desc")
						? Sort.by(sort).descending()
						: Sort.by(sort).ascending();		
				PageRequest pageable=PageRequest.of(page, size, sortGrid);
				Page<Employee> empPage=employeeRepo.findAll(pageable);
				return empPage.map(this::convertDto);
			}
CustomException:
==============
	ApiError:
	---------
		public record ApiError(
		Instant timestamp,
		int status,
		String error,
		String message,//example = "Employee already exists with rid: req-123
		String path) //example = "/api/v1/employees"
	//Advice Class:
	--------------
	@RestControllerAdvice
	public class GlobalExceptionHandler {
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<ApiError> handleResourceNotFound(
				ResourceNotFoundException ex, HttpServletRequest request) {
			return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
		}	
	//CustomException
	----------------	
	public class ResourceNotFoundException extends RuntimeException {
		public ResourceNotFoundException(String message) {
			super(message);
		}
	}	
SpringSecurity:
==============
	@EnableWebSecurity
	@Configuration
	public class WebSecurity {
		private static final String[] SWAGGER_PATHS = {
				"/swagger-ui.html",
				"/swagger-ui/**",
				"/v3/api-docs/**",
				"/swagger-resources/**",
				"/webjars/**"
		};
		@Bean
		SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http.csrf(csrf -> csrf.disable())
					.authorizeHttpRequests(auth -> auth
							.requestMatchers("/public").permitAll()
							.requestMatchers(SWAGGER_PATHS).permitAll()
							.requestMatchers("/user").hasRole("USER")
							.requestMatchers("/admin").hasRole("ADMIN")
							.requestMatchers("/api/v1/**").hasAnyRole("USER", "ADMIN")
							.anyRequest().authenticated())
					.httpBasic(Customizer.withDefaults());
			return http.build();
		}
		@Bean
		UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
			UserDetails user = User.builder()
					.username("user")
					.password(passwordEncoder.encode("user123"))
					.roles("USER")
					.build();
			UserDetails admin = User.builder()
					.username("admin")
					.password(passwordEncoder.encode("admin123"))
					.roles("ADMIN")
					.build();
			return new InMemoryUserDetailsManager(user, admin);
		}
		@Bean
		PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
	Key components
	==============
		SecurityConfig -What it defines (4 beans)
			1. securityFilterChain — core security rules
				Stateless — no HTTP sessions (STATELESS)
				CSRF disabled — typical for REST/JWT APIs
				JWT filter runs before username/password auth
				401/403 return JSON via custom handlers
			2. authenticationManager — 
				used at login to verify username/password
			3. userDetailsService — in-memory users:
				user / user123 → ROLE_USER
				admin / admin123 → ROLE_ADMIN
			4. passwordEncoder — BCrypt for password hashing
		JwtService — create/validate tokens
		JwtAuthenticationFilter — reads Bearer token on each request
		WebSecurity — rules + stateless config
		AuthController — login endpoint
			JSON 401/403 responses via entry point handlers
Api Idempotient:
================
	@RestController
	public class EmployeeController {
		private final EmployeeService employeeService;
		public EmployeeController(EmployeeService employeeService) {
			this.employeeService = employeeService;
		}
		@PostMapping("/api/v1/employees")
		public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeRequest request,
				@Parameter(name = "rid", description = "Request ID", required = true, in = ParameterIn.HEADER) @RequestHeader String rid) {
			return new ResponseEntity<>(employeeService.saveEmployee(request, rid), HttpStatus.CREATED);
	}
	
	@Service
	public class EmployeeServiceImpl implements EmployeeService {
		private final EmployeeRepo employeeRepo;
		public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
			this.employeeRepo = employeeRepo;
		}
		@Override
		public EmployeeResponse saveEmployee(EmployeeRequest request, String rid) {
			Optional<Employee> existing = employeeRepo.findByRid(rid);
			if (existing.isPresent()) {
				throw new RuntimeException("Already exist...");
			}
			Employee employee = new Employee();
			employee.setName(request.name());
			employee.setRid(rid);
			Employee saved = employeeRepo.save(employee);
			return new EmployeeResponse(saved.getId(), saved.getName(), saved.getRid());
		}
SQL:
====
	CREATE INDEX idx_create_date ON Transaction (create_date);
	Row_number:
		select id,name Row_number() over (partition by dept order by sal desc) as rownum from employee.
		select * from (select emp_id,name,salary,Row_number() over (order by salary desc) 
					as RN from employee)
						where RN=20;
	Basic Query:
	------------
		SELECT dept,avg(sal),as avg_sal
			FROM emp 
				where sal>=5000
					GROUP BY dept
						HAVING avg(sal)> 6500
							ORDER BY avg(sal) DESC;
	Third highest sal
	-----------------
		SELECT max(price) from products
			where price < (select max(price) from products
							where price < (select max(price) from products)
						);	
	Sql Injection:
	---------------
		-security vulnerbality where atacker insert sql code into application.
		ex:password='"+password+"';
		password:' OR '1'='1
			query ex:select * from users where username=admin AND password='' OR '1'='1';
				'1'='1' always true
		where id='1';		
				query ex:select * from users where id='1' OR '1'='1'	
		1' Delete from users --
			query ex:select * from users where id='1';
			Delete from users; --	
		How prevent:
			-PrepradeStatement best practice
				db treatthe input as data, not query sql code.
			ORM Fw
				Hibernate
				Spring data jpa
				Note:use paramemrized queries internally
				Valid user input.
				Avoid Sql type quires as much as possible.

React
=====
	Props:
		Props are used to pass data from a parent component to a child component. 
		To send props into a component, use the same syntax as HTML attributes:
	
	Components:
		Components are independent and reusable bits of code. 
		Components come in two types, 
			Class components, 
			Function components,
		It is now suggested to use Function components along with Hooks, 
			which were added in React 16.8. 
		class Car extends React.Component {
		  render() {
			return <h2>Hi, I am a Car!</h2>;
		  }
		}
		function Car() {
		  return <h2>Hi, I am a Car!</h2>;
		}
		Note:
			-Hooks are only designed for functional components
			If we try hooks inside the class components ,react throw error.
		
	JSX:
		JSX is JavaScript XML, which allows us to write HTML in React. 	
	Fregments:
		Fragments makes the code cleaner and readable.
	State-
	-----
		-muatable data managed by a react components.
	Life cycle methos:
	--------------------
		Mounting: Component is created and inserted into the DOM.
		Updating: Component re-denders bcoz of data change.
		Unmounting: Component is removed from the DOM.	
		
		DOM:Data Object Model
			-representation of html page.
			-As tree Object(content,structure and style) 
			DOM:
				-Created by browser
				-Repesent the actual page
			Virtual DOM:
				-Created by react
				-Light weight copy of DOM
		
		Clean up resource function returned by useEffect(()=>{},[])
	Hooks:
	------
		useState
			The current state.
			A function that updates the state.
			Ex:  
			  const [brand, setBrand] = useState("Ford");
			  const [model, setModel] = useState("Mustang");
			  const [year, setYear] = useState("1964");
			  const [color, setColor] = useState("red");
			  const[products,setProducts] = useState([]);
			  const [newProduct, setNewProduct] = useState({})
			  const [errorRes,setErrorMsg] = useState("")
		useMemo, 
		useRef.
		useContext
		useReducer
		useCallBack,
		useMemo,
		useCustom
		useEffect- run every rendar(clean up resource).	
	Controlled Components
		In Controlled components, the form's state is managed by the component himself. 
	Uncontrolled Components
		Uncontrolled components rely on the DOM to manage the form data. 	
	Event:
		React events are written in camelCase syntax:
			onClick instead of onclick.
			React event handlers are written inside curly braces:
			onClick={shoot}  instead of onclick="shoot()".
	Ex: List of Customer:
		-----------------
		import React, { useState, useEffect } from "react";
		export default function CustomerList() {
		  // 1. Initialize state to hold your data array
		  const [customers, setCustomers] = useState([]);
		  //const [loading, setLoading] = useState(true);
		  // 2. Fetch or load data when the component mounts
		  useEffect(() => {
			// Simulating an API call fetch request
			const sampleData = [
			  { id: 101, name: "Alice Johnson", email: "alice@example.com", status: "Active" },
			  { id: 102, name: "Bob Smith", email: "bob@example.com", status: "Inactive" },
			  { id: 103, name: "Charlie Brown", email: "charlie@example.com", status: "Active" },
			];
			setCustomers(sampleData);
			//setLoading(false);
		  }, []); // Empty array ensures this runs exactly once
		  //if (loading) return <p>Loading customers...</p>;
		  // 3. Render the list using .map()
		  return (
			<div style={{ padding: "20px" }}>
			  <h2>Customer Registry</h2>
			  <table border="1" cellPadding="10" style={{ width: "100%", textAlign: "left", borderCollapse: "collapse" }}>
				<thead>
				  <tr style={{ backgroundColor: "#f2f2f2" }}>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Status</th>
				  </tr>
				</thead>
				<tbody>
				  {customers.map((customer) => (
					<tr key={customer.id}>
					  <td>{customer.id}</td>
					  <td>{customer.name}</td>
					  <td>{customer.email}</td>
					  <td>{customer.status}</td>
					</tr>
				  ))}
				</tbody>
			  </table>
			</div>
		  );
		}
		//export default CustomerList;				
	
@SpringBootApplication:
==========================
		
			 		  	
		
Execution flow
----------------
	-When execute the main method
		it called SpringApplication.run();
			
	-run() read the configuration from the main class,
			identify the there key components due to @SpringBootApplication.
	-Components scanning finds all custom classes(controller,servic etc.) and register them as beans.
		-Auto-Configure inspects your project depdencies and automatically set required infrastructure 
			beans(database,pools,webserver,logging.)
	

	@Configuration:
			-This ann tags/marks the class as a source of bean defination.
			-It tells to spring container class contains one or more @bean methods,and spring should process it
				to generate bean definations and service req for those beans at run time.		
				
		@ComponentScan:
			-Discovers custom components(controllers,service and repo) in the relevent pack.
			-This ann enables automatic components dedection.
			-linking configuration.	
			-By default it tells Spring to scan the current pack, of the annotated class and all its sub-packages 
				for spring components.
			-It finds and registers classes annotated with stereotype anno like: @Servce, @Controller as spring beans in 
				application context.

		@EnableAutoConfiguration:
			-Auto configuration process based on classpath dependencies.
			-This is core of spring boot, it tells to spring boot to start configuring the app automatically based on the
				depdencies jars present on the classPath.
			
			-For ex: If you have the spring-web dependecny, it automatically configures and embeds a tomcat or jetty server,
					to setup the dispacher servlet.
				if have jpa dependency, it auto configures a data source and other necessary components.
			-it works by looking up auto-configuration cantidates list in Meta-INF/spring file within various.
		
		-All these beans are assembled into the ApplicationContext and application ready to run.

flow:
	Application Start.
		-@EnableAutoConfiguration.
				-Load auto config classes.
					-create beans if condetions match. 	
		
How auto configuration work:
============================
-based on the classPath,exsiting beans and application properties to configure spring beans.		
		
	@SpringBootAnnotation:
		-Combination of three anno
			1-@Configuration
			2-@EnableAutoConfiguration
			3-@ComponentScan
			
	@EnableAutoConfiguration:
		-Tell to spring boot enable auto config
		-internally import ->AutoConfigurationImportSelector
			
	AutoConfigurationImportSelector:
		-scan class path.
		-load auto config classes from
			-Meta-INF/spring/org.sf.boot.autoconfigure.AutoConfiguration.import
			
	Auto config classes activated based on the condetion.
		@CondetinalOnClass -Class exist on classPath
		@CondetionalOnBeans -bean already exist
		@CondetionalOnProperty -Property present/enabled
		@CondetionalOnWebapplication -webapp
		@CondetionsOnMissingBean anno -Beans not ready to defined
			
	Ex: Data Source Auto-Configuration
		-spring jdbc on class-path
		-database property exist
		-no custom datasource bean defined.
		-spring boot auto-create DataSource.

		@CondetionalonClass(DataSource.class)
		@CondetionsOnMissingBean(DataSource.class)
		class DataSourceAutoConfiguration{}
			
		these values are injected automatically
			-ds.url
			-uname
			-password

//Solid Princple
=================
		Single Responsibility Principle  -
		---------------------------------
			Every class must have a single,responsibility.
			Keep classes small and focused.
			Ex: Userservcie should not have email send logic, Create new EmailService and write email send logic.
		
		Open/Closed Principle   -
		--------------------	
			Capabable to add new behaviour without changing existing code.
			Software/Classes should be open for extension but closed for modification.
			Ex:Strategy design pattern;Add new payment method(UPI,Card,Wallet) and corrier servcie like-bluedart,fedex.
			
		Liskov Substitution Principle  -
		----------------------------	
			Child classes should be usable in place of parent classes,without breaking behavior.
			Avoid overriding parent method incorrectly.
			Ex:Bird has fly fun, but Penguim subclass not extend Bird since it cannot fly.
			1) Code Reusability
			2) Easier Maintenance
			3) Reduced Coupling
			
		Interface Segregation Principle  -
		--------------------------------	
			Do not force a class to implement unnecessary methods.
			Create small specific interface.
			
		Dependency Inversion Principle -
		--------------------------------	
			(high-level modules should not depend on low-level modules. 
			Depend on the abstraction not concreate implementation.

//Strategy Design pattren(OCP):-
==============================
	waht?
		A strategy pattern in java is a behavioral design pattern , behavior of an object to be selected at runtime. 
	How
	----
		*prefer compossion (has-a) relation over inheritance
		*always code with the interface never with implement with class.	
		*code should we open with extention and must be close for modification.
				
		Note:-
			if we implement stragy design pattern without using spring,we need to implement factory-design pattern manually
			where we need to create both main and dependent class obj and dependent obj inject to main obj.
					
			if we implement stragy design pattern using spring IOC container it self access factory-design-patren,
			so instantaion and injection taken care by IOC.		
	Features:
		Flexibility and Reusability:
		Separation of Concerns:
		Open for Extension and close for modification
		Loosely coupled	
			
//Fectory design pattern:
=======================
	What?
		Uesed to create the object without exposing obj creation logic to client.
	Why?
		avoid repeated object creation code.
		make the system flexible and lossly coupled.
		easly add object without modify client code.

	Advantages:
		-Certralized obj creation.
		-Loosely coupled.
		-Reduced if else in client.
		-Easy to test and maintain.
				
	Factory pattern in spring boot
		-BeanFacotry
		-ApplicationContext			
		
	Ex:
		Design for Report System



















	-----		
