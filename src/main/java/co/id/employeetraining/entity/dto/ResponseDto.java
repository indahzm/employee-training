package co.id.employeetraining.entity.dto;

//@Component
//@AllArgsConstructor
//@Data
//@Builder
//@Component
public class ResponseDto {
	private Integer code;
	private Object data;
	private String status;
	
	public ResponseDto (String status, Object data, Integer code){
		this.code = code;
		this.data = data;
		this.status = status;
//		Map<String, Object> map = new HashMap<>();
//		map.put("status", status);
//		map.put("data", data);
//		map.put("code", code);
//		return map;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}