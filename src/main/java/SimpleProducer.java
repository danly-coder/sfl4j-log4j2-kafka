import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 生产者程序，输出各种级别的日志，根据log4j2.xml配置文件来选择的输出到console、文件、kafka中
 * @author shishanli
 * @date 2021年1月15日16:39:27
 */
public class SimpleProducer {
    private static Logger log = LogManager.getLogger(SimpleProducer.class);
    public static void main(String[] args) {
        for (int i = 10; i < 100; i++) {
            log.error("Hello---" + i);
            log.warn("Hello---" + i);
            log.info("Hello---" + i);
            log.debug("Hello---" + i);
            log.trace("Hello---" + i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                log.fatal(e.getMessage());
            }
        }
    }
}
