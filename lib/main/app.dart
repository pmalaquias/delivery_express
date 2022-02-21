import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';

import '../l10n/strings/app_localizations.dart';
import '../ui/pages/pages..dart';
import '../ui/theme/theme.dart';

class DeliveryExpressApp extends StatelessWidget {
  const DeliveryExpressApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Delivery Express',
      localizationsDelegates: const [
        AppLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
      ],
      supportedLocales: const [
        Locale('en', ''), // English, no country code
        Locale('pt', ''), // Spanish, no country code
        //Locale('es', ''), // Spanish, no country code
      ],
      theme: AppTheme.lightThemeData,
      debugShowCheckedModeBanner: false,
      home: const LoginPage(),
    );
  }
}
