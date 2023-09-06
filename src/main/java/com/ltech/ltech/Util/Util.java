package com.ltech.ltech.Util;

import com.ltech.ltech.Dto.ResponseDto;

public class Util {
    public static ResponseDto getResponse(boolean success, String mensaje, Object data) {
		ResponseDto response = new ResponseDto();
		String cod = (!success) ? Constante.CODE_FAILED : Constante.CODE_SUCCES;
		response.setCodigo(cod);
		response.setMensaje(mensaje);
		response.setData(data);
		return response;
	}
}
