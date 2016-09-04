package ka.gws.barchr.client.me;

import java.io.IOException;
import java.util.concurrent.Executor;

import com.fasterxml.jackson.databind.ObjectMapper;

import ka.gws.barchr.common.to.AbstractTO;
import ka.gws.barchr.common.to.ServiceResult;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * RetrofitClient.
 */
public class RetrofitClient {

    private final Retrofit retrofit;

    /**
     * RetrofitClient constructor
     *
     * @param retrofit
     */
    public RetrofitClient(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    /**
     * @param serviceClass
     * @param <T>
     * @return
     */
    public <T> T getService(final Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }

    /**
     * Get Response
     *
     * @param serviceCall
     * @param <TO>
     * @return
     */
    public <TO extends AbstractTO> TO execute(Call<ServiceResult<TO>> serviceCall) {
        try {
            Response<ServiceResult<TO>> response = serviceCall.execute();
            ServiceResult<TO> result = response.body();
            return result.getTO();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Builder
     */
    public static final class Builder {

        private String baseUrl;
        private ObjectMapper objectMapper;
        private Executor callbackExecutor;

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder objectMapper(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
            return this;
        }

        public Builder callbackExecutor(Executor executor) {
            this.callbackExecutor = executor;
            return this;
        }

        public RetrofitClient build() {
            Retrofit.Builder builder = new Retrofit.Builder();
            builder = builder.baseUrl(baseUrl);
            if (this.objectMapper == null) {
                this.objectMapper = new ObjectMapper();
            }
            builder.addConverterFactory(JacksonConverterFactory.create(objectMapper));
            if (this.callbackExecutor != null) {
                builder.callbackExecutor(this.callbackExecutor);
            }
            Retrofit retrofit = builder.build();
            return new RetrofitClient(retrofit);
        }
    }
}
