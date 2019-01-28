package com.huynh.xinh.domain.interactor.register

import com.huynh.xinh.domain.executor.PostExecutionThread
import com.huynh.xinh.domain.executor.ThreadExecutor
import com.huynh.xinh.domain.interactor.UseCase
import com.huynh.xinh.domain.repositories.user.UserRepository
import com.huynh.xinh.domain.repositories.user.register.RegisterParam
import com.huynh.xinh.domain.repositories.user.register.RegisterResult
import com.huynh.xinh.domain.validation.ValidationResult
import com.huynh.xinh.domain.validation.errors.ValidationError
import com.huynh.xinh.domain.validation.rules.repassword.RePassword
import com.huynh.xinh.domain.validation.validators.EmailValidator
import com.huynh.xinh.domain.validation.validators.PasswordValidator
import com.huynh.xinh.domain.validation.validators.RePasswordValidator
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Create by Mr.X on 1/28/19
 */
class Register
@Inject constructor(
    threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
    private val repository: UserRepository
) : UseCase<RegisterResult, RegisterParam>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(param: RegisterParam?): Observable<RegisterResult> {
        val emailValidator = EmailValidator(param?.email)
        val passwordValidator = PasswordValidator(param?.password)
        val rePasswordValidator = RePasswordValidator(RePassword(param?.password, param?.rePassword))

        val emailValidationResults = emailValidator.validate()
        val passwordValidationResults = passwordValidator.validate()
        val rePasswordValidationResults = rePasswordValidator.validate()

        val isValid = emailValidator.isValid() && passwordValidator.isValid() && rePasswordValidator.isValid()

        if (!isValid) {
            return Observable.error(
                getRegisterValidationError(
                    emailValidationResults,
                    passwordValidationResults,
                    rePasswordValidationResults
                )
            )

        }
        return repository.register(param)
    }

    private fun getRegisterValidationError(
        emailValidationResults: List<ValidationResult>,
        passwordValidationResults: List<ValidationResult>,
        rePasswordValidationResults: List<ValidationResult>
    ): RegisterValidationException {
        return RegisterValidationException(
            getValidationError(emailValidationResults),
            getValidationError(passwordValidationResults),
            getValidationError(rePasswordValidationResults)
        )
    }

    private fun getValidationError(validationResults: List<ValidationResult>): List<ValidationError> {
        return validationResults.filter { !it.isValid }.map { it.error }
    }
}