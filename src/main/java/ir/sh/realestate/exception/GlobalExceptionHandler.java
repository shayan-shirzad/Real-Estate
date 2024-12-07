package ir.sh.realestate.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.MessageFormat;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResourceBundle bundle= ResourceBundle.getBundle("message",new Locale("fa","IR"));
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<CustomErrorResponse> handleAlreadyExistsException(AlreadyExistsException alreadyExistsException) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.CONFLICT.value(), alreadyExistsException.getMessage());
        String message=bundle.getString(alreadyExistsException.getMessage());
        message=MessageFormat.format(message,alreadyExistsException.getParams()) ;
        customErrorResponse.setErrorMessage(message );
        return ResponseEntity.badRequest().body(customErrorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleNotFoundException(NotFoundException notFoundException) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(), notFoundException.getMessage());
        return ResponseEntity.badRequest().body(customErrorResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CustomErrorResponse> handleNullPointerException(NullPointerException nullPointerException) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(), nullPointerException.getMessage());
        return ResponseEntity.badRequest().body(customErrorResponse);
    }

//    @ExceptionHandler(BindException.class)
//    public ResponseEntity handleNullPointerException(BindException bindException) {
//        return ResponseEntity.badRequest().body(bindException.getAllErrors());
//    }

//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity<List<CustomErrorResponse>> handleException(MethodArgumentNotValidException e) {
//        return ResponseEntity.badRequest().body(processErrors(e));
//    }
//
//    private List<CustomErrorResponse> processErrors(MethodArgumentNotValidException e) {
//        List<CustomErrorResponse> validationErrorModels = new ArrayList<>();
//        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
//            CustomErrorResponse vm=new CustomErrorResponse();
//            try {
//                vm.setErrorMessage(bundle.getString(fieldError.getCode()));
//                break;
//            }catch (Exception ex){
//
//            }
//            validationErrorModels.add(vm);
//        }
//        return validationErrorModels;
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, bundle.getString(errorMessage));
        });
        return errors;
    }

}
