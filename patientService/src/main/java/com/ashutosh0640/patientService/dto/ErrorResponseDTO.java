package com.ashutosh0640.patientService.dto;

import java.time.LocalDateTime;

public class ErrorResponseDTO {
	
	private String message;
	private int status;
	private String error;
	private LocalDateTime timestamp;
	
	public ErrorResponseDTO() {
		super();
	}

	public ErrorResponseDTO(String message, int status, String error, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.status = status;
		this.error = error;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ErrorResponseDTO [message=" + message + ", status=" + status + ", error=" + error + ", timestamp="
				+ timestamp + "]";
	}

}
