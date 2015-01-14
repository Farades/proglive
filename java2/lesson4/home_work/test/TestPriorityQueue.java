import org.junit.Assert;
import org.junit.Test;
import ru.mtplab.PriorityQueue;

public class TestPriorityQueue {
    @Test
    public void getMaxTest() {
        System.out.print("Testing PriorityQueue.getMax()...");
        PriorityQueue<Integer, String> pq = new PriorityQueue<Integer, String>();
        pq.insert(32, "Value 32-1");
        pq.insert(19, "Value 19-1");
        pq.insert(22, "Value 22-1");
        pq.insert(1,  "Value  1-1");
        pq.insert(5,  "Value  5-1");
        pq.insert(19, "Value 19-2");
        pq.insert(83, "Value 83-1");

        Assert.assertEquals("Value 83-1", pq.getMax());
        Assert.assertEquals("Value 32-1", pq.getMax());
        Assert.assertEquals("Value 22-1", pq.getMax());
        Assert.assertEquals("Value 19-1", pq.getMax());
        Assert.assertEquals("Value 19-2", pq.getMax());
        Assert.assertEquals("Value  5-1", pq.getMax());
        Assert.assertEquals("Value  1-1", pq.getMax());

        System.out.println(" OK");
    }
}
