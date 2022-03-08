import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;

class ForgotPasswordButton extends StatelessWidget {
  const ForgotPasswordButton({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.end,
      children: [
        Text(AppLocalizations.of(context)!.forgotPasswordMenssage),
        TextButton(
          onPressed: () {},
          child: Text(AppLocalizations.of(context)!.forgotPasswordButton),
        ),
      ],
    );
  }
}
