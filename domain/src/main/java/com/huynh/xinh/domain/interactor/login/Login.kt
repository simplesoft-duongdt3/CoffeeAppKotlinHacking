package com.huynh.xinh.domain.interactor.login

import com.huynh.xinh.domain.executor.PostExecutionThread
import com.huynh.xinh.domain.executor.ThreadExecutor
import com.huynh.xinh.domain.interactor.UseCase
import com.huynh.xinh.domain.repositories.user.UserRepository
import com.huynh.xinh.domain.repositories.user.login.LoginParam
import com.huynh.xinh.domain.repositories.user.login.LoginResult
import com.huynh.xinh.domain.validation.ValidationResult
import com.huynh.xinh.domain.validation.errors.ValidationError
import com.huynh.xinh.domain.validation.validators.EmailValidator
import com.huynh.xinh.domain.validation.validators.PasswordValidator
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Create by Mr.X on 1/25/19
 */
class Login
@Inject constructor(
    threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
    private val repository: UserRepository
) : UseCase<LoginResult, LoginParam>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(param: LoginParam?): Observable<LoginResult> {
        val emailValidator = EmailValidator(param?.email)
        val passwordValidator = PasswordValidator(param?.password)

        val emailValidationResults = emailValidator.validate()
        val passwordValidationResults = passwordValidator.validate()

        val isValid = emailValidator.isValid() && passwordValidator.isValid()

        if (!isValid) {
            return Observable.error(getLoginValidationError(emailValidationResults, passwordValidationResults))

        }
        return repository.login(param!!)
    }

    private fun getLoginValidationError(
        emailValidationResults: List<ValidationResult>,
        passwordValidationResults: List<ValidationResult>
    ): LoginValidationException {
        return LoginValidationException(
            getValidationError(emailValidationResults),
            getValidationError(passwordValidationResults)
        )
    }

    private fun getValidationError(validationResults: List<ValidationResult>): List<ValidationError> {
        return validationResults.filter { !it.isValid }.map { it.error }
    }
}
