import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

public class ProducerRunner {

    public static void main( String[] args ) {
        runProducer();
    }

    static void runProducer() {
        org.apache.kafka.clients.producer.Producer<Long, User> producer = ProducerCreator.createProducer();
        for ( int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++ ) {
            User user = new User( "Manoj" + index, index + "@gmail.com", index );
            ProducerRecord<Long, User> record = new ProducerRecord<>( IKafkaConstants.TOPIC_NAME,
                                                                      user );
            try {
                RecordMetadata metadata = producer.send( record ).get();
                System.out.println( "Record sent with key " + index + " to partition " + metadata.partition()
                                    + " with offset " + metadata.offset() );
            } catch ( ExecutionException | InterruptedException e ) {
                System.out.println( "Error in sending record" );
                System.out.println( e );
            }
        }
    }
}
