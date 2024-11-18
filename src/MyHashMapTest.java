import org.junit.Test;
import static org.junit.Assert.*;

public class MyHashMapTest {
    @Test
    public void testInsertAndGet() {
        MyHashMap map = new MyHashMap();
        for (int i = 0; i < 100; i++) {
            map.put("刘华强" + i, "你这瓜保熟吗？" + i);
        }
        assertEquals(100, map.getSize());
        for (int i = 0; i < 100; i++) {
            assertEquals("你这瓜保熟吗？" + i, map.get("刘华强" + i));
        }
    }

    @Test
    public void testKeyOverride() {
        MyHashMap map = new MyHashMap();
        map.put("刘华强1", "哥们，你这瓜保熟吗？");
        map.put("刘华强1", "你这瓜熟我肯定要啊！");
        assertEquals("你这瓜熟我肯定要啊！", map.get("刘华强1"));
    }
}
