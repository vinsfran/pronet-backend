package py.com.aquipago.pronetbackend.utils;

public interface KeyMessageUtil {
    public static final String MALFORMED_JSON = "MalformedJSON";
    public static final String MALFORMED_FORM_DATA = "MalformedFormData";
    public static final String QUERY_NOT_ALLOWED = "QueryNotAllowed";
    public static final String INVALID_PARAMETERS = "InvalidParameters";
    public static final String MISSING_PARAMETERS = "MissingParameter";
    public static final String SUBSCRIBER_NOT_FOUND = "SubscriberNotFound";
    public static final String QUERY_NOT_PROCESSED = "QueryNotProcessed";
    public static final String NO_RESPONSE_FROM_HOST = "NoResponseFromHost";
    public static final String HOST_TRANSACTION_ERROR = "HostTransactionError";
    public static final String UNKNOWN_ERROR = "UnknownError";
    public static final String SUBSCRIBER_WITHOUT_DEBT = "SubscriberWithoutDebt";
    public static final String QUERY_PROCESSED = "QueryProcessed";
    public static final String OVER_DUE_INVOICE = "OverdueInvoice";
    public static final String PAYMENT_NOT_AUTHORIZED = "PaymentNotAuthorized";
    public static final String PAYMENT_PROCESSED = "PaymentProcessed";
    public static final String ALREADY_REVERSED = "AlreadyReversed";
    public static final String SUBSCRIBER_ID_NOT_CREATED = "SubscriberIdNotCreated";
    public static final String SUBSCRIBER_ID_CREATED = "SubscriberIdCreated";
    public static final String TRANSACTION_NOT_REVERSED = "TransactionNotReversed";
    public static final String TRANSACTION_REVERSED = "TransactionReversed";
    public static final String PERSIST_DATA_ERROR = "PersistDataError";
    public static final String DATA_NOT_FOUND = "DataNotFound";
    public static final String PERMISSION_NOT_FOUND = "PermissionNotFound";
    public static final String INVALID_DATA = "InvalidData";
}
