import 'package:flutter/material.dart';

import '../../../../ui/pages/pages.dart' show LoginPage;
import 'login.dart';

Widget makeLoginPageFactory() {
  return LoginPage(presenter: makeGetxLoginPresenter());
}
