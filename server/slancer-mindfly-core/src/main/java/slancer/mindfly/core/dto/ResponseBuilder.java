package slancer.mindfly.core.dto;

import slancer.mindfly.core.dto.response.DataResponse;
import slancer.mindfly.core.dto.response.VoidResponse;

/**
 * @author Amos Xia
 * @date 2018/4/24
 */
public class ResponseBuilder {

    public static <T> DataResponse<T> build(Object obj, Class<T> retClass) {
        T data = retClass.cast(obj);
        return build(data);
    }

    /**
     *
     * @param data response data
     * @param <T> Data Type
     * @return DataResponse
     */
    public static <T> DataResponse<T> build(T data) {
        DataResponse<T> response = new DataResponse<>();
        response.setData(data);
        return response;
    }

    /**
     *
     * @return VoidResponse
     */
    public static VoidResponse nothing() {
        return new VoidResponse();
    }
}
