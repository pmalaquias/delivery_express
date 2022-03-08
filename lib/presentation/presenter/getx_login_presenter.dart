import 'package:get/get.dart';

import '../../domain/helpers/helpers.dart';
import '../../domain/usecases/usecases.dart';
import '../../ui/helpers/helpes.dart';
import '../../ui/pages/pages.dart';
import '../protocols/protocols.dart';

class GetxLoginPresenter extends GetxController implements LoginPresenter {
  final Validation validation;
  final FireAuthUseCase authentication;

  String _email = '';
  String _password = '';

  final Rx<UIError> _emailError = Rx<UIError>(UIError.NO_ERROR);
  final Rx<UIError> _passwordError = Rx<UIError>(UIError.NO_ERROR);
  final Rx<UIError> _mainError = Rx<UIError>(UIError.NO_ERROR);
  final Rx<String> _navigateTo = Rx<String>('');
  final Rx<int> _loginType = Rx<int>(1);
  final RxBool _isFormValid = false.obs;
  final RxBool _isLoading = false.obs;

  GetxLoginPresenter({
    required this.validation,
    required this.authentication,
  });

  @override
  Stream<UIError> get emailErrorStream => _emailError.stream;
  @override
  Stream<UIError> get mainErrorStream => _mainError.stream;
  @override
  Stream<UIError> get passwordErrorStream => _passwordError.stream;
  @override
  Stream<String> get navigateToStream => _navigateTo.stream;
  @override
  Stream<bool> get isFormValidStream => _isFormValid.stream;
  @override
  Stream<bool> get isLoadingStream => _isLoading.stream;
  @override
  Stream<int> get signUpTypeStream => _loginType.stream;

  set navigateTo(String value) => _navigateTo.subject.add(value);
  set isFormValid(bool value) => _isFormValid.subject.add(value);
  set isLoading(bool value) => _isLoading.subject.add(value);

  @override
  Future<void> auth() async {
    try {
      _mainError.value = UIError.NO_ERROR;
      isLoading = true;
      await authentication.call(
        params: FireAuthUseCaseParams(
          email: _email,
          password: _password,
        ),
      );
      /* final account = await //authentication.auth(
       AuthenticationParams(email: _email, password: _password),
      ); */
      //await saveCurrentAccount.save(account);
      navigateTo = '/profile';
    } on DomainError catch (error) {
      switch (error) {
        case DomainError.INVALID_CREDENTIALS:
          _mainError.value = UIError.INVALID_CREDENTIALS;
          break;
        default:
          _mainError.value = UIError.UNEXPECTED;
      }
      isLoading = false;
    }
  }

  @override
  void goToForgotPassword() {
    // TODO: implement goToForgotPassword
  }

  @override
  void goToSignUp() {
    // TODO: implement goToSignUp
    print('tido do login ${_loginType.value}');

    if (_loginType.value == 1) {
      navigateTo = '/signup_deleveryman';
    } else if (_loginType.value == 2) {
      navigateTo = '/signup_clent';
    }
  }

  @override
  void selectTypeSignUp(int type) {
    _loginType.value = type;
    print('tipo: ${_loginType.value}');
  }

  @override
  void validateEmail(String email) {
    _email = email;
    _emailError.value = _validateField('email');
    _validateForm();
  }

  @override
  void validatePassword(String password) {
    _password = password;
    _passwordError.value = _validateField('password');
    _validateForm();
  }

  UIError _validateField(String field) {
    final formData = {
      'email': _email,
      'password': _password,
    };

    final error = validation.validate(field: field, input: formData);

    switch (error) {
      case ValidationError.INVALID_FIELD:
        return UIError.INVALID_FIELD;
      case ValidationError.REQUIRED_FIELD:
        return UIError.REQUIRED_FIELD;
      default:
        return UIError.NO_ERROR;
    }
  }

  void _validateForm() {
    isFormValid = _emailError.value == UIError.NO_ERROR &&
        _passwordError.value == UIError.NO_ERROR &&
        _email.isNotEmpty &&
        _password.isNotEmpty;
  }
}
