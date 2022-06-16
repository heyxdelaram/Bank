package Controller;

public class StandardResponse {
    private StatusResponse statusResponse;
    private String message;
    public StandardResponse(StatusResponse statusResponse){
        this.statusResponse=statusResponse;
    }
    public StandardResponse(StatusResponse statusResponse,String message){
        this.statusResponse=statusResponse;
        this.message=message;
    }
    public StatusResponse getStatusResponse() {
        return statusResponse;
    }

    public void setStatusResponse(StatusResponse statusResponse) {
        this.statusResponse = statusResponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}