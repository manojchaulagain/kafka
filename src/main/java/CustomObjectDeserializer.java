import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class CustomObjectDeserializer<T> implements Deserializer {

    public Class<T> type;

    public CustomObjectDeserializer( Class type ) {
        this.type = type;
    }

    @Override
    public void configure( Map map, boolean b ) {

    }

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

    @Override
    public void close() {
    }
}