import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
    public static void main(String[] args) {
        // 运行测试类
        Result result = JUnitCore.runClasses(MyHashMapTest.class);

        // 打印测试结果
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // 打印测试是否成功
        System.out.println("All tests passed: " + result.wasSuccessful());
    }
}
