abstract class SignUpPresenter {
  Stream<String> get navigateToStream;

  void cancelSignUp();

  void goToHomeClient();
  void goToHomeDeliveryMan();
}
