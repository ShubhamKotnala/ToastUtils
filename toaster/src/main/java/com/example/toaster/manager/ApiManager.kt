package com.example.toaster.manager

import com.example.toaster.model.ResponseLogin
import com.example.toaster.network.APIs
import com.example.toaster.network.NetworkManager
import com.example.toaster.view.UpdateUI
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiManager {

   /* fun getCountriesStats(): Observable<ResponseLogin> {
        return APIs.loginusingRx()
    }
*/

    companion object {
        fun callSignInApi() {
            val apiInterface = NetworkManager.getApiClient().login()
            //apiInterface.enqueue( Callback<List<Movie>>())
            apiInterface.enqueue(object : Callback<ResponseLogin> {
                override fun onFailure(call: Call<ResponseLogin>, t: Throwable?) {
                    // liveAction.postValue(null)
                }

                override fun onResponse(
                    call: Call<ResponseLogin>,
                    response: Response<ResponseLogin>
                ) {
                    // if(response != null)
                    //   liveAction.postValue(response.body())
                }
            })
        }

        fun callSinInApiRx(updateUI: UpdateUI) {
            updateUI.showProgress()
            NetworkManager.getApiClient().loginusingRx()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ResponseLogin> {
                    override fun onNext(countriesStats: ResponseLogin) {
                        updateUI.onSuccess(countriesStats)
                    }

                    override fun onError(e: Throwable) {
                        updateUI.hideProgress()
                    }

                    override fun onComplete() {
                        updateUI.hideProgress()
                    }

                    override fun onSubscribe(d: Disposable) {
                    }
                })
        }
    }
}