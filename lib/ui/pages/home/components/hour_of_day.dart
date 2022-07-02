import 'package:flutter/material.dart';

import '../../../extension/extension.dart';

class HourOfDay extends StatelessWidget {
  final int hourOfDay = DateTime.now().hour;

  HourOfDay({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    if (isNigth) {
      return Text(context.loc.goodNigth);
    } else if (isAfternoon) {
      return Text(context.loc.goodAfternoon);
    } else {
      return Text(context.loc.goodMornig);
    }
  }

  bool get isAfternoon => hourOfDay >= 12 && hourOfDay < 18;

  bool get isNigth => hourOfDay >= 18 && hourOfDay < 6;
}
