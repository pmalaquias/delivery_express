import 'package:get/get.dart';

import '../../ui/pages/pages.dart' show SignUpPresenter;

class GetxSignUpPresenter extends GetxController implements SignUpPresenter {
  final Rx<String> _navigateTo = Rx<String>('');

  @override
  Stream<String> get navigateToStream => _navigateTo.stream;

  set navigateTo(String value) => _navigateTo.subject.add(value);

  @override
  void goToHomeClient() {
    navigateTo = '/home/client';
  }

  @override
  void goToHomeDeliveryMan() {
    navigateTo = '/home/deliveryMan';
  }

  @override
  void cancelSignUp() {
    navigateTo = '/auth';
  }
}
