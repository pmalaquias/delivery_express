import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart';
import '../../../theme/theme.dart';

class RadioButtonCustom extends StatefulWidget {
  const RadioButtonCustom({Key? key}) : super(key: key);

  @override
  State<RadioButtonCustom> createState() => _RadioButtonCustomState();
}

class _RadioButtonCustomState extends State<RadioButtonCustom> {
  int value = 1;

  Widget CustomRadioButton(String title, String text, int index) {
    return InkWell(
      onTap: () {
        setState(() {
          value = index;
        });
      },
      child: Card(
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
        elevation: (value == index) ? 4 : 0,
        color: (value == index) ? AppColors.primaryRed : Colors.white,
        child: SizedBox(
          width: double.infinity,
          height: 70,
          child: Column(
            children: [
              Text(
                title,
                style: TextStyle(
                  color: (value == index) ? Colors.white : Colors.black,
                  fontWeight: FontWeight.bold,
                ),
                textAlign: TextAlign.center,
              ),
              const SizedBox(height: 8),
              Text(
                text,
                style: TextStyle(
                  color: (value == index) ? Colors.white : Colors.black,
                ),
                textAlign: TextAlign.center,
              ),
            ],
          ),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: <Widget>[
        CustomRadioButton(
          AppLocalizations.of(context)!.deleverymanLabel,
          AppLocalizations.of(context)!.deliverymanText,
          1,
        ),
        CustomRadioButton(
          AppLocalizations.of(context)!.clientLabel,
          AppLocalizations.of(context)!.clientText,
          2,
        ),
      ],
    );
  }
}
