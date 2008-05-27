package other.test;

 class Test {

}
 
 class Parent {
	 int test(){
		 return 0;
	 }
 }
 
 class Child extends Parent {
	 
	 short test(){ // type compatible, not only assign compatible.
		 return 0;
	 }
	 
	 void test2(){
		 int a = 1;
		 short b = 10;
		 a = b; // auto covert.
		
		 
		 
	 }
 }
