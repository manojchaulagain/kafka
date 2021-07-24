import java.util.Properties;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class ConsumerGroup {
   public static void main(String[] args) throws Exception {

      String topic = IKafkaConstants.TOPIC_NAME;
      String group = IKafkaConstants.GROUP_ID_CONFIG;
      Properties props = new Properties();
      props.put("bootstrap.servers", IKafkaConstants.KAFKA_BROKERS);
      props.put("group.id", group);
      props.put("enable.auto.commit", "true");
      props.put("auto.commit.interval.ms", "1000");
      props.put("session.timeout.ms", "30000");
      props.put("key.deserializer",          
         "org.apache.kafka.serializer.StringDecoder");
      props.put("value.deserializer", 
         "org.apache.kafka.serializer.StringDecoder");
      KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
      
      consumer.subscribe(Arrays.asList(topic));
      System.out.println("Subscribed to topic " + topic);
      int i = 0;
         
      while (true) {
         ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
               System.out.printf("offset = %d, key = %s, value = %s\n", 
               record.offset(), record.key(), record.value());
      }     
   }  
}
