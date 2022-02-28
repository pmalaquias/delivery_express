abstract class LoginPresenter {
  Stream<bool> get isFormValidStream;
  Stream<bool> get isLoadingStream;

  void validateEmail(String email);
  void validatePassword(String password);
  void goToSignUp();
  void auth();
  void goToForgotPassword();
}
