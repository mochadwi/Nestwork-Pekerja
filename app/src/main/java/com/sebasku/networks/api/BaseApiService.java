package com.sebasku.networks.api;

import com.sebasku.networks.apimodel.RequestCutiForm;
import com.sebasku.networks.apimodel.LoginForm;
import com.sebasku.networks.apimodel.RequestGajiForm;
import com.sebasku.networks.apimodel.RequestPresentForm;
import com.sebasku.networks.apimodel.ResponseAjukanCuti;
import com.sebasku.networks.apimodel.ResponseAjukanSlipGaji;
import com.sebasku.networks.apimodel.ResponseLogin;
import com.sebasku.networks.apimodel.ResponsePresent;
import com.sebasku.networks.apimodel.ResponseProfile;
import com.sebasku.networks.apimodel.ResponseRiwayatCuti;
import com.sebasku.networks.apimodel.ResponseRiwayatGaji;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by fadil on 3/30/18.
 */

public interface BaseApiService {

    @POST("api/auth/login")
    Call<ResponseLogin> addLogin(@Body LoginForm login);

/*    @PATCH("api/users/:id}")
    Call<ResponseLogin> editProfile(@Path("id") String id);*/

    @GET("api/users/Profile")
    Call<ResponseProfile>getProfile(@Header("Authorization") String Authorization);

    @POST("api/cuti/ajukanCuti")
    Call<ResponseAjukanCuti> addCuti(@Header("Authorization") String Authorization,@Body RequestCutiForm cuti);

    @GET("api/cuti/getOneCuti/{email}")
    Call<List<ResponseRiwayatCuti>> getOneCuti(@Header("Authorization") String Authorization, @Path("email") String email);

    @GET("api/slipGaji/getAllSlipGaji")
    Call<List<ResponseRiwayatGaji>> getAllGaji(@Header("Authorization") String Authorization);

    @POST("api/slipGaji/ajukanSlipGaji")
    Call<ResponseAjukanSlipGaji> addGaji(@Header("Authorization") String Authorization, @Body RequestGajiForm gaji);

    @POST("api/present/addPresent")
    Call<ResponsePresent> addPresent(@Header("Authorization") String Authorization, @Body RequestPresentForm present);

}
