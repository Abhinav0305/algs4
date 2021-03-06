package ch1_3;

import util.Node;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ListUtilsTest {

  private Node<String> l;
  @Before
  public void setUp()
  {
    l = new Node<String>("tail");
    l = ListUtils.insert(l, "third");
    l = ListUtils.insert(l, "second");
    l = ListUtils.insert(l, "head");
  }
  @Test
  public void _21_findFirst()
  {
    assertEquals(true, ListUtils.find(l, "head"));
  }

  @Test
  public void _21_findLast()
  {
    assertEquals(true, ListUtils.find(l, "tail"));
  }

  @Test
  public void _21_findMiddle()
  {
    assertEquals(true, ListUtils.find(l, "second"));
  }

  @Test
  public void _21_findNone()
  {
    assertEquals(false, ListUtils.find(l, "Nerd Ball Pudding"));
  }

  @Test
  public void _24_removeAfterFirst()
  {
    ListUtils.removeAfter(l);
    assertEquals(false, ListUtils.find(l, "second"));
    assertThat(l.next.item, equalTo("third"));
  }

  @Test
  public void _24_removeAfterRemovesLast()
  {
    Node<Integer> head = new Node<Integer>(10);
    Node<Integer> middle = new Node<Integer>(20);
    Node<Integer> tail = new Node<Integer>(30);

    head.next = middle;
    middle.next = tail;

    ListUtils.removeAfter(middle);
    assertThat(middle.next, equalTo(null));
  }

  @Test
  public void _24_removeAfterMiddle()
  {
    Node<Integer> head = new Node<>(10);
    Node<Integer> middle = new Node<>(20);
    Node<Integer> third = new Node<>(25);
    Node<Integer> tail = new Node<>(30);

    head.next = middle;
    middle.next = third;
    third.next = tail;

    ListUtils.removeAfter(middle);
    assertThat(middle.next, equalTo(tail));
  }

  @Test
  public void _24_removeAfterLast()
  {
    Node<Integer> head = new Node<Integer>(1);
    Node<Integer> tail = new Node<Integer>(2);

    head.next = tail;

    ListUtils.removeAfter(tail);
    assertEquals(2, ListUtils.size(head));
  }

  @Test
  public void _24_removeAfterNullDoesNothing()
  {
    ListUtils.removeAfter(null);
  }

  @Test
  public void nodeForNullList()
  {
    Node<String> n = ListUtils.nodeFor(null, "");
    assertEquals(null, n);
  }

  @Test
  public void nodeForNoItemFound()
  {
    Node<String> n = ListUtils.nodeFor(l, "nothing here");
    assertEquals(null, n);
  }

  @Test
  public void nodeForFirstItem()
  {
    Node<String> n = ListUtils.nodeFor(l, "head");
    assertThat(n.item, equalTo("head"));
  }

  @Test
  public void nodeForLastItem()
  {
    Node<String> n = ListUtils.nodeFor(l, "tail");
    assertThat(n.item, equalTo("tail"));
  }

  @Test
  public void nodeForMiddleItem()
  {
    Node<String> n = ListUtils.nodeFor(l, "third");
    assertThat(n.item, equalTo("third"));
  }

  @Test
  public void nodeAtNullList()
  {
    Node<String> n = ListUtils.nodeAt(null, 0);
    assertEquals(null, n);
  }

  @Test
  public void nodeAtFirstIndex()
  {
    Node<String> n = ListUtils.nodeAt(l, 0);
    assertThat(n.item, equalTo("head"));
  }

  @Test
  public void nodeAtLastIndex()
  {
    Node<String> n = ListUtils.nodeAt(l, 3);
    assertThat(n.item, equalTo("tail"));
  }

  @Test
  public void nodeAtIndexOutOfRange()
  {
    Node<String> n = ListUtils.nodeAt(l, 4);
    assertEquals(null, n);
  }

  @Test
  public void nodeAtMiddleIndex()
  {
    Node<String> n = ListUtils.nodeAt(l, 2);
    assertThat(n.item, equalTo("third"));
  }

  @Test
  public void itemAtNullList()
  {
    assertEquals(null, ListUtils.itemAt(null, 0));
  }

  @Test
  public void itemAtFirstIndex()
  {
    assertThat(ListUtils.itemAt(l, 0), equalTo("head"));
  }

  @Test
  public void itemAtLastIndex()
  {
    assertThat(ListUtils.itemAt(l, 3), equalTo("tail"));
  }

  @Test
  public void itemAtIndexOutOfRange()
  {
    assertEquals(null, ListUtils.itemAt(l, 4));
  }

  @Test
  public void itemAtMiddleIndex()
  {
    assertThat(ListUtils.itemAt(l, 2), equalTo("third"));
  }

  @Test
  public void lastItemOfNullList()
  {
    assertEquals(null, ListUtils.lastItem(null));
  }

  @Test
  public void lastItemOfSingleItemList()
  {
    Node<Double> n = new Node<>(25.5);
    assertThat(ListUtils.lastItem(n), equalTo(25.5));
  }

  @Test
  public void lastItemOfMultiItemList()
  {
    assertThat(ListUtils.lastItem(l), equalTo("tail"));
  }


  @Test
  public void lastNodeOfNullList()
  {
    assertEquals(null, ListUtils.lastNode(null));
  }

  @Test
  public void lastNodeOfSingleItemList()
  {
    Node<Double> n = new Node<>(25.5);
    assertThat(ListUtils.lastNode(n).item, equalTo(25.5));
  }

  @Test
  public void lastNodeOfMultiItemList()
  {
    assertThat(ListUtils.lastNode(l).item, equalTo("tail"));
  }

  @Test
  public void _25_insertAfterNullList()
  {
    Node<Integer> n = new Node<>(0);
    ListUtils.insertAfter(null, n);
  }

  @Test
  public void _25_insertAfterWhenNewNodeIsNull()
  {
    ListUtils.insertAfter(l, null);
    assertEquals(4, ListUtils.size(l));
  }

  @Test
  public void _25_insertAfterSingleItemList()
  {
    Node<Integer> head = new Node<>(42);
    Node<Integer> n = new Node<>(43);

    ListUtils.insertAfter(head, n);
    assertEquals(2, ListUtils.size(head));
    assertThat(ListUtils.lastItem(head), equalTo(43));
  }

  @Test
  public void _25_insertAfterFirstOfMultiItemList()
  {
    Node<String> n = new Node<>("I'm the new guy!");
    ListUtils.insertAfter(l, n);
    assertEquals(5, ListUtils.size(l));
    assertThat(ListUtils.itemAt(l, 1), equalTo("I'm the new guy!"));
  }

  @Test
  public void _25_insertAfterMiddleItem()
  {
    Node<String> n = new Node<>("I'm the new guy!");
    ListUtils.insertAfter(ListUtils.nodeAt(l,1), n);
    assertEquals(5, ListUtils.size(l));
    assertThat(ListUtils.itemAt(l, 2), equalTo("I'm the new guy!"));
  }

  @Test
  public void _25_insertAfterLast()
  {
    Node<String> n = new Node<>("I'm the new guy!");
    ListUtils.insertAfter(ListUtils.lastNode(l), n);
    assertEquals(5, ListUtils.size(l));
    assertThat(ListUtils.lastItem(l), equalTo("I'm the new guy!"));
  }

  @Test
  public void _26_removAllFromNullList()
  {
    ListUtils.removeAll(null, 0);
  }

  @Test
  public void _26_removeAllFromSingleItemList()
  {
    Node<Integer> n = new Node<>(123);

    assertThat(ListUtils.removeAll(n, 123), equalTo(null));
  }

  @Test
  public void _26_removeAllNoMatchSingleItemList()
  {
    Node<String> n = new Node<>("foo");

    n = ListUtils.removeAll(n, "bar");

    assertEquals(1, ListUtils.size(n));
    assertThat(n.item, equalTo("foo"));
  }

  @Test
  public void _26_removeAllNoMatchMultipleItemList()
  {
    l = ListUtils.removeAll(l, "pudding");

    assertEquals(4, ListUtils.size(l));
  }

  @Test
  public void _26_removeAllMatchMultipleInMiddle()
  {
    Node<Integer> list = new Node<>(42);
    ListUtils.append(list, 12);
    ListUtils.append(list, 12);
    ListUtils.append(list, 13);
    ListUtils.append(list, 12);
    ListUtils.append(list, 23);

    list = ListUtils.removeAll(list, 12);
    assertEquals(3, ListUtils.size(list));
    assertEquals(false, ListUtils.find(list, 12));
  }

  @Test
  public void _26_removeAllMatchFirstAndLast()
  {
    Node<Double> list = new Node<>(12.3);
    ListUtils.append(list, 99.0);
    ListUtils.append(list, 24.2);
    ListUtils.append(list, 123099.34);
    ListUtils.append(list, 12.3);

    list = ListUtils.removeAll(list, 12.3);

    assertEquals(3, ListUtils.size(list));
    assertEquals(false, ListUtils.find(list, 12.3));
  }

  @Test
  public void _26_removeAllMatchAll()
  {
    Node<Double> list = new Node<>(99.0);
    ListUtils.append(list, 99.0);
    ListUtils.append(list, 99.0);
    ListUtils.append(list, 99.0);
    ListUtils.append(list, 99.0);

    list = ListUtils.removeAll(list, 99.0);

    assertEquals(0, ListUtils.size(list));
  }

  @Test
  public void removeFromEmpty()
  {
    assertThat(ListUtils.remove(null, "Foo"), equalTo(null));
  }

  @Test
  public void removeNotFound()
  {
    Node<String> list = new Node<>("Foo");
    list = ListUtils.remove(list, "Bar");
    assertThat(list.item, equalTo("Foo"));
    assertEquals(1, ListUtils.size(list));
  }

  @Test
  public void removeFromOne()
  {
    Node<String> list = new Node<>("Foo");
    list = ListUtils.remove(list, "Foo");
    assertEquals(0, ListUtils.size(list));
  }

  @Test
  public void removeFromBeginning()
  {
    Node<Double> list = new Node<>(13.901);
    ListUtils.append(list, 99.0);
    ListUtils.append(list, 99.0);
    ListUtils.append(list, 99.0);
    list = ListUtils.remove(list, 13.901);
    assertThat(list.item, equalTo(99.0));
    assertEquals(3, ListUtils.size(list));
  }

  @Test
  public void removeFromEnd()
  {
    Node<Double> list = new Node<>(13.901);
    ListUtils.append(list, 99.0);
    ListUtils.append(list, 99.0);
    ListUtils.append(list, 99.5);
    list = ListUtils.remove(list, 99.5);
    assertThat(ListUtils.lastItem(list), equalTo(99.0));
    assertEquals(3, ListUtils.size(list));
  }

  @Test
  public void removeFromMiddle()
  {
    Node<Double> list = new Node<>(13.901);
    ListUtils.append(list, 99.0);
    ListUtils.append(list, 19.0);
    ListUtils.append(list, 99.5);
    list = ListUtils.remove(list, 19.0);
    assertEquals(false, ListUtils.find(list, 19.0));
    assertEquals(3, ListUtils.size(list));
  }
}
