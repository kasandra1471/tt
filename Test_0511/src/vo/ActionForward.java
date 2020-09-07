package vo;

public class ActionForward {
	private boolean isRedirect = false;
	// 주소 이동 여부
	// membercontroller 에서 
	private String path = null;
	// 어느 주소로 갈지 주소경로

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
