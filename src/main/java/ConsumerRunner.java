import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.time.Duration;

/**
 * A consumer runner for the testing purposes
 */
public class ConsumerRunner {

    public static void main( String[] args ) {
        runConsumer();
    }

    /**
     * Runs the kafka consumer.
     */
    private static void runConsumer() {
        Consumer<Long, User> consumer = ConsumerCreator.createConsumer();
        int noMessageFound = 0;
        while ( true ) {
            ConsumerRecords<Long, User> consumerRecords = consumer.poll( Duration.ofMillis( 1000 ) );
            // 1000 is the time in milliseconds consumer will wait if no record is found at broker.
            if ( consumerRecords.count() == 0 ) {
                noMessageFound++;
                if ( noMessageFound > IKafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT )
                // If no message found count is reached to threshold exit loop.
                {
                    break;
                } else {
                    continue;
                }
            }
            //print each record.
            consumerRecords.forEach( record -> {
                System.out.println( "Record Key " + record.key() );
                System.out.println( "Record value: " + record.value() );
                System.out.println( "Name: " + record.value().getName() );
                System.out.println( "Email: " + record.value().getEmail() );
                System.out.println( "Id: " + record.value().getId() );
                System.out.println( "Record partition " + record.partition() );
                System.out.println( "Record offset " + record.offset() );
            } );
            // commits the offset of record to broker.
            consumer.commitAsync();
        }
        consumer.close();
    }
}
