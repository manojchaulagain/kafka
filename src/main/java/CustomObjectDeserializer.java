import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * Custom object Deserialization from json to java object for kafka data transmission
 *
 * @param <T> The class the data is to be deserialized into.
 */
public class CustomObjectDeserializer<T> implements Deserializer {

    public Class<T> type;

    /**
     * Creates a Custom Deserailizable object
     *
     * @param type The type of object the the data needs to deserialized into.
     */
    public CustomObjectDeserializer( Class type ) {
        this.type = type;
    }

    /**
     *
     * @param map
     * @param b
     */
    @Override
    public void configure( Map map, boolean b ) {

    }

    /**
     *
     * @param topic
     * @param data
     * @return
     */
    @Override
    public T deserialize( String topic, byte[] data ) {
        ObjectMapper mapper = new ObjectMapper();
        T object = null;
        try {
            object = mapper.readValue( data, type );
        } catch ( Exception exception ) {
            System.out.println( "Error in deserializing bytes " + exception );
        }
        return object;
    }

    /**
     *
     */
    @Override
    public void close() {
    }
}