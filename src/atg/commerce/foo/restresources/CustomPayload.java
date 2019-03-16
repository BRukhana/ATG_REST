package atg.commerce.foo.restresources;

import atg.nucleus.GenericService;

public class CustomPayload  extends GenericService{

	
	String mErrorCode;
	
	String mMessage;
	
	String mContentItem;

	public String getContentItem() {
		return mContentItem;
	}

	public void setContentItem(String mContentItem) {
		this.mContentItem = mContentItem;
	}

	public String getErrorCode() {
		return mErrorCode;
	}

	public void setErrorCode(String mErrorCode) {
		this.mErrorCode = mErrorCode;
	}

	public String getMessage() {
		return mMessage;
	}

	public void setMessage(String mMessage) {
		this.mMessage = mMessage;
	}
	
	
}
