package ellysmore.redditmeh.api.events;


public class BaseEvent {

    private String mError;

    private boolean mIsSuccess;


    // Source ID of the object, i.e:  Sale ID / Lot Id, etc.
    private String mSourceId;

    public BaseEvent(boolean isSuccess) {
        mIsSuccess = isSuccess;
    }

    public BaseEvent(String error) {
        mIsSuccess = false;
        mError = error;
    }

    public BaseEvent(String sourceId, boolean isSuccess) {
        mSourceId = sourceId;
        mIsSuccess = isSuccess;
    }

    public BaseEvent(String sourceId, String error) {
        mIsSuccess = false;
        mSourceId = sourceId;
        mError = error;
    }

    public BaseEvent() {
    }

    public boolean isSuccess() {
        return mIsSuccess;
    }

    // Helper to quickly get error message from error object.
    public String getErrorMsg() {
        String errorMessage = null;
        if (mError != null) {
            errorMessage = mError;
        }
        return errorMessage;
    }

    public String getError() {
        return mError;
    }

    public String getSourceId() {
        return mSourceId;
    }
}