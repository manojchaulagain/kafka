import java.io.Serializable;

/**
 * A user object to create the user object with properites name, email and id
 */
public class User implements Serializable {

    private String name;
    private String email;
    private int id;

    /**
     * Constructs the user object with the provided name, email and id
     *
     * @param name  The name of the user
     * @param email The email of the user
     * @param id    The id of the user
     */
    public User( String name, String email, int id ) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    /**
     * Only for Serialization and Deserialization purposes.
     */
    public User() {
    }

    /**
     * Gets the name of the user
     *
     * @return The name associated with the user
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the user
     *
     * @param name The name to be set for the user
     */
    public void setName( String name ) {
        this.name = name;
    }

    /**
     * Gets the email of the user
     *
     * @return The email associated with the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user
     *
     * @param email The email to be set for the user
     */
    public void setEmail( String email ) {
        this.email = email;
    }

    /**
     * Gets the Id of the user
     *
     * @return The id associated with the user.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the Id of the user
     *
     * @param id The id to be set for the user
     */
    public void setId( int id ) {
        this.id = id;
    }
}
