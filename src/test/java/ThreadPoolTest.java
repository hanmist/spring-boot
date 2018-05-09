import com.hmx.config.thread.AsyncTask;
import org.junit.Test;
import org.springframework.core.task.TaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * @author hanmingxiang 2018-05-07 20:12
 */
public class ThreadPoolTest extends BaseTest{

    @Resource
    private TaskExecutor taskExecutor;
    @Resource
    private AsyncTask asyncTask;

    @Test
    public void testThread() throws InterruptedException {
        Future<Long> future = asyncTask.asyncSend("Hello World!");
        while (true){
            if (future.isDone()){
                System.out.println("Async complete!");
                break;
            }
            System.out.println("Async not complete!");
            Thread.sleep(20);
        }
        System.out.println(System.currentTimeMillis());
        Thread.sleep(5000);
    }

}
