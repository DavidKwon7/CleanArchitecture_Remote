package com.example.myapplicationcleanremote.feature.main

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetUserUseCase
import com.example.myapplicationcleanremote.model.PresentationUser
import com.example.myapplicationcleanremote.model.PresentationUser.Companion.toPresentation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _githubList = MutableLiveData<List<PresentationUser>>()
    val githubList: LiveData<List<PresentationUser>>
        get() = _githubList

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable>
        get() = _error

    @SuppressLint("CheckResult")
    fun getGithubRepositories(owner: String) {
        getUserUseCase.execute(owner)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ repo ->
                _githubList.value = repo.map { toPresentation(it) }
            }, {
                _error.value = Throwable("에러 발생")
            }).addTo(compositeDisposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
