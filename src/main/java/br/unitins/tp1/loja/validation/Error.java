package br.unitins.tp1.loja.validation;

public class Error {

    private String code;
    private String message;

    public Error(String code, String message){
        
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
