package protocol_http;

/**
 * Created by airbag on 1/12/15.
 */
public enum AvailableURIs {
    LOGIN (1, "login.jsp"),
    LOGOUT (2, "logout.jsp"),
    LIST (3, "list.jsp"),
    CREATE_GROUP (4, "create_group.jsp"),
    SEND (5, "send.jsp"),
    ADD_USER (6, "add_user.jsp"),
    REMOVE_USER (7, "remove_user.jsp"),
    QUEUE (8, "queue.jsp"),
    NA (-1, "N/A");

    private final int _code;
    private final String _URI;

    AvailableURIs(int code, String URI) {
        _code = code;
        _URI = URI;
    }

    /**
     *
     * @param URI String representing request URI
     * @return requested URI if URI is available, "N/A" otherwise.
     */
    public static AvailableURIs getURI (String URI) {
        for(AvailableURIs u : AvailableURIs.values())
            if (u._URI.equals(URI))
                return u;
        return NA;
    }
}
