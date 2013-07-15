package ch1_3;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class _14_ArrayQueueTest {

  @Test
  public void enqueue() {
    _14_ArrayQueue<String> q = new _14_ArrayQueue<String>(5);
    assertEquals(q.depth(), 0);
    q.enqueue("foo");
    assertThat(q.front(), equalTo("foo"));
    assertThat(q.rear(), equalTo("foo"));
    assertEquals(q.depth(), 1);

    q.enqueue("bar");
    assertThat(q.front(), equalTo("foo"));
    assertThat(q.rear(), equalTo("bar"));
    assertEquals(q.depth(), 2);

    q.enqueue("calloo callay");
    assertThat(q.front(), equalTo("foo"));
    assertThat(q.rear(), equalTo("calloo callay"));
    assertEquals(q.depth(), 3);

  }
  @Test
  public void enqueueResize()
  {
    _14_ArrayQueue<Integer> q = new _14_ArrayQueue<Integer>(5);
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);
    q.enqueue(5);
    assertThat(q.front(), equalTo(1));
    assertThat(q.rear(), equalTo(5));

    // queue capacity should grow
    q.enqueue(6);
    assertThat(q.front(), equalTo(1));
    assertThat(q.rear(), equalTo(6));
    assertEquals(q.depth(), 6);

  }
  @Test
  public void dequeue()
  {
    _14_ArrayQueue<Integer> q = new _14_ArrayQueue<Integer>(5);
    q.enqueue(42);
    assertThat(q.front(), equalTo(42));
    assertEquals(q.depth(), 1);

    assertThat(q.dequeue(), equalTo(42));
    assertEquals(q.depth(), 0);
    assertEquals(q.isEmpty(), true);

    q.enqueue(12);
    q.enqueue(13);
    q.enqueue(14);

    assertThat(q.front(), equalTo(12));
    assertThat(q.rear(), equalTo(14));
    assertEquals(q.depth(), 3);

    assertThat(q.dequeue(), equalTo(12));
    assertThat(q.front(), equalTo(13));
    assertThat(q.rear(), equalTo(14));
    assertEquals(q.depth(), 2);

    assertThat(q.dequeue(), equalTo(13));
    assertThat(q.front(), equalTo(14));
    assertThat(q.rear(), equalTo(14));
    assertEquals(q.depth(), 1);

  }
  @Test
  public void dequeuePastUpperBound()
  {
    _14_ArrayQueue<Integer> q = new _14_ArrayQueue<Integer>(5);
    q.enqueue(200);
    assertThat(q.rear(), equalTo(200));
    assertThat(q.dequeue(), equalTo(200));
    assertEquals(q.isEmpty(), true);

    q.enqueue(201);
    assertThat(q.rear(), equalTo(201));
    assertThat(q.dequeue(), equalTo(201));
    assertEquals(q.isEmpty(), true);

    q.enqueue(202);
    assertThat(q.rear(), equalTo(202));
    assertThat(q.dequeue(), equalTo(202));
    assertEquals(q.isEmpty(), true);

    q.enqueue(203);
    assertThat(q.rear(), equalTo(203));
    assertThat(q.dequeue(), equalTo(203));
    assertEquals(q.isEmpty(), true);

    q.enqueue(101);
    assertThat(q.rear(), equalTo(101));
    assertThat(q.dequeue(), equalTo(101));
    assertEquals(q.isEmpty(), true);

    q.enqueue(102);
    assertThat(q.rear(), equalTo(102));
    assertThat(q.dequeue(), equalTo(102));
    assertEquals(q.isEmpty(), true);

    q.enqueue(103);
    assertThat(q.rear(), equalTo(103));
    assertThat(q.dequeue(), equalTo(103));
    assertEquals(q.isEmpty(), true);

  }
  @Test
  public void dequeuePastUpperBound2()
  {
    _14_ArrayQueue<Integer> q = new _14_ArrayQueue<Integer>(5);
    q.enqueue(200);
    q.enqueue(201);
    q.enqueue(202);
    q.enqueue(203);
    q.enqueue(204);

    assertThat(q.dequeue(), equalTo(200));
    assertThat(q.front(), equalTo(201));
    assertThat(q.rear(), equalTo(204));

    assertThat(q.dequeue(), equalTo(201));
    assertThat(q.front(), equalTo(202));
    assertThat(q.rear(), equalTo(204));

    assertThat(q.dequeue(), equalTo(202));
    assertThat(q.front(), equalTo(203));
    assertThat(q.rear(), equalTo(204));

    assertThat(q.dequeue(), equalTo(203));
    assertThat(q.front(), equalTo(204));
    assertThat(q.rear(), equalTo(204));

    assertThat(q.dequeue(), equalTo(204));
    assertEquals(q.isEmpty(), true);

    q.enqueue(102);
    assertThat(q.rear(), equalTo(102));
    q.enqueue(103);
    assertThat(q.front(), equalTo(102));
    assertThat(q.rear(), equalTo(103));

    assertThat(q.dequeue(), equalTo(102));
    assertThat(q.rear(), equalTo(103));
    assertThat(q.dequeue(), equalTo(103));
    assertEquals(q.isEmpty(), true);

  }
}
