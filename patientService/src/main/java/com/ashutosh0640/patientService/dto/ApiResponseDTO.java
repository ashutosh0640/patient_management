package com.ashutosh0640.patientService.dto;

public class ApiResponseDTO<T> {
	private boolean success;
	private String message;
	private T data;
	
	public ApiResponseDTO() {
		super();
	}

	public ApiResponseDTO(boolean success, String message, T data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ApiResponseDTO [success=" + success + ", message=" + message + ", data=" + data + "]";
	}
	
}
