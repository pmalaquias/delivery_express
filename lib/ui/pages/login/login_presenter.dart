import '../../helpers/helpes.dart';

abstract class LoginPresenter {
  Stream<UIError> get emailErrorStream;
  Stream<UIError> get passwordErrorStream;
  Stream<UIError> get mainErrorStream;
  Stream<String> get navigateToStream;
  Stream<bool> get isFormValidStream;
  Stream<bool> get isLoadingStream;
  Stream<int> get signUpTypeStream;

  void validateEmail(String email);
  void validatePassword(String password);
  void selectTypeSignUp(int type);
  void goToSignUp();
  void auth();
  void goToForgotPassword();
}
