import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;

class HourOfDay extends StatelessWidget {
  final int hourOfDay = DateTime.now().hour;

  HourOfDay({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    if (isNigth) {
      return Text(AppLocalizations.of(context)!.goodNigth);
    } else if (isAfternoon) {
      return Text(AppLocalizations.of(context)!.goodAfternoon);
    } else {
      return Text(AppLocalizations.of(context)!.goodMornig);
    }
  }

  bool get isAfternoon => hourOfDay >= 12 && hourOfDay < 18;

  bool get isNigth => hourOfDay >= 18 && hourOfDay < 6;
}
