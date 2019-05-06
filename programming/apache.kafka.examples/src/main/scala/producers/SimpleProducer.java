package producers;
import java.util.*;
import org.apache.kafka.clients.producer.*;
public class SimpleProducer {

    public static void main(String[] args) throws Exception{

        String topicName = "test3";
        String key = "de44";
        String value = "This is a test string 45";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer <>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(topicName,key,value);
        producer.send(record);
        producer.close();

        System.out.println("SimpleProducer Completed.");
    }
}
