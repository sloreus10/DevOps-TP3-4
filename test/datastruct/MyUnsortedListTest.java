package datastruct;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyUnsortedListTest {
	UnsortedList<Integer> testList;
	
	//Ali etaient là
	@Before
	public void geList() {
		testList = MyUnsortedList.of(1, 2, 3, 4);
	}
	
	@Test
	public void emptyTest_with_Empty_List() {
		UnsortedList<Integer> voidList = MyUnsortedList.of();
		assertFalse("empty_test", testList.isEmpty());
	}
	
	@Test
	public void emptyTest_with_Not_Empty_List() {
		UnsortedList<Integer> voidList = MyUnsortedList.of();
		assertTrue("empty_test", voidList.isEmpty());
	}
	
	
	@Test
	public void sizeTest_with_rightSize() {
		assertTrue("size_test", testList.size()==4);
	}
	
	@Test
	public void sizeTest_with_wrongSize() {
		assertFalse("size_test", testList.size()!=4);
	}
	
	@Test
	public void prependTest() {
		testList.prepend(4);
		assertEquals(testList, MyUnsortedList.of(4, 1, 2, 3, 4));
	}
	
	@Test
	public void appendTest() {
		testList.append(10);
		assertEquals(testList,  MyUnsortedList.of(1, 2, 3, 4, 10));
		
	}
	
	@Test
	public void insertTest() {
		testList.insert(12, 2);
		UnsortedList<Integer> assertList = MyUnsortedList.of(1, 2, 12, 3, 4);
		assertEquals(testList, assertList);
	}
	
	@Test(expected =IndexOutOfBoundsException.class)
	public void insertTest_negativeIndex() throws Exception{
		testList.insert(10, -1);
	}
	
	@Test(expected =IndexOutOfBoundsException.class)
	public void insertTest_offSizeIndex() throws Exception{
		testList.insert(10, 12);
	}
	
	@Test
	public void popTest() {
		testList.pop();
		assertEquals(testList, MyUnsortedList.of(2, 3, 4));
	}
	
	
	@Test(expected = EmptyListException.class )
	public void PopExceptionTest() throws Exception{
		UnsortedList<Integer> exceptionList = MyUnsortedList.of();
		exceptionList.pop();
	}
	
	@Test
	public void removeTest_zeroIndex() throws Exception{
		testList.remove(0);
		assertEquals(MyUnsortedList.of(2, 3, 4), testList);
	}
	
	@Test
	public void removeTest() throws Exception{
		testList.remove(3);
		assertEquals(MyUnsortedList.of(1, 2, 3), testList);
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeExceptionTest_overSize() throws Exception{
		testList.remove(10);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeExceptionTest_negativeIndex() throws Exception{
		testList.remove(-5);
	}
	
	
	@Test
	public void popLastTest() {
		testList.popLast();
		assertEquals(testList, MyUnsortedList.of(1, 2, 3));
	}
	
	@Test(expected = EmptyListException.class)
	public void PopLastExcetionTest() throws Exception{
		UnsortedList<Integer> emptyList = MyUnsortedList.of();
		emptyList.popLast();
	}
	
	@Test
	public void equalsTest_null() {
		UnsortedList<Integer> testListN = null;
		assertTrue("equalsTest", !testList.equals(testListN));
	}
	
	@Test
	public void equalsTest_differentSize() {
		UnsortedList<Integer> testList1 = MyUnsortedList.of(1, 2, 3, 4, 5);
		assertFalse("equalsTest", testList.equals(testList1));
	}
	
	@Test
	public void equalsTest_nullObject() {
		UnsortedList<Integer> testList2 = MyUnsortedList.of();
		assertFalse("equalsTest", testList.equals(testList2));
	}

	
	@Test
	public void equalsTest_differentObjects() {
		UnsortedList<Integer> testList2 = MyUnsortedList.of(1, 2, 3, 4);
		UnsortedList<Integer> testList3 = MyUnsortedList.of(1, 2, 3, 5);
		assertTrue("equalsTest", testList.equals(testList2));
		assertFalse("equalsTest", testList.equals(testList3));
	}
	
	@Test
	public void equalsTest_oneElement() {
		UnsortedList<Integer> testList2 = MyUnsortedList.of();
		UnsortedList<Integer> testList3 = MyUnsortedList.of(1);
		assertFalse("equalsTest", testList2.equals(testList3));
	}
	
	
	@Test
	public void toStringTest() {
		String testListString1 = "MyUnsortedList { size = 4, [1, 2, 3, 4] }";
		String testListString2 = "MyUnsortedList { size = 2, [1, 2, 3, 4] }";
		String testListString3 = "MyUnsortedList { size = 4, [1, 2, 3, 0] }";
		assertEquals(testList.toString(), testListString1);
		assertNotEquals(testList.toString(), testListString2);
		assertNotEquals(testList.toString(), testListString3);
	}
	
}
