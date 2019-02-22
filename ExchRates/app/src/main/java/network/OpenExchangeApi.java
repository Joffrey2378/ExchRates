package network;

import dto.RatesResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OpenExchangeApi {

    @GET("api/latest.json?app_id=adf70a3975d74eb2ade5072f708a3df3&base={code}&callback=someCallbackFunction")
    Call<RatesResponseDTO> getRates(@Path("code") String currencyCode);
}
