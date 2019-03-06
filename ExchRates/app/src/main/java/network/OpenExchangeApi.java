package network;

import dto.RatesResponseDTO;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenExchangeApi {

    @GET("api/historical/{date}.json?app_id=adf70a3975d74eb2ade5072f708a3df3")
    Single<RatesResponseDTO> getYesterdaysRates(@Path("date") String dateTime,
                                                @Query("base") String currencyCode);

    @GET("api/latest.json?app_id=adf70a3975d74eb2ade5072f708a3df3")
    Single<RatesResponseDTO> getRates(@Query("base") String currencyCode);
}
