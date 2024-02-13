import 'package:flutter/material.dart';

import '../../../../ui/pages/pages.dart' show SignUpClientPage, SignUpDeliveryMan;
import 'singup.dart';

Widget makeSignUpClientPageFactory() => SignUpClientPage(
      presenter: makeGetxSingUpPresenterFactory(),
    );

Widget makeSignUpDeliveryManPageFactory() => SignUpDeliveryMan(
      presenter: makeGetxSingUpPresenterFactory(),
    );
