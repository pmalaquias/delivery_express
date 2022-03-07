import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:get/get.dart';

import '../l10n/strings/app_localizations.dart';
import '../ui/theme/theme.dart';
import 'factories/factories.dart';

class DeliveryExpressApp extends StatelessWidget {
  const DeliveryExpressApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: 'Delivery Express',
      localizationsDelegates: const [
        AppLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
      ],
      supportedLocales: const [
        Locale('en', ''), // English, no country code
        Locale('pt', ''), // Portuguese, no country code
      ],
      theme: AppTheme.lightThemeData,
      debugShowCheckedModeBanner: false,
      initialRoute: '/auth',
      getPages: [
        GetPage(
          name: '/auth',
          page: makeLoginPageFactory,
        ),
      ],
    );
  }
}
