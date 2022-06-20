import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;
import '../../pages.dart';

class SignUpButton extends StatelessWidget {
  final LoginPresenter presenter;

  const SignUpButton({
    Key? key,
    required this.presenter,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(AppLocalizations.of(context)!.signUpMessage),
        TextButton(
          onPressed: () {
            showDialog(
              context: context,
              builder: (context) {
                return AlertDialog(
                  title: Text(AppLocalizations.of(context)!.signupPopUpLabel),
                  content: RadioButtonCustom(presenter: presenter),
                  scrollable: true,
                  actions: [
                    TextButton(
                      onPressed: () => Navigator.canPop(context),
                      child: Text(AppLocalizations.of(context)!.cancelButton.toUpperCase()),
                    ),
                    TextButton(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => const SignUpDeliveryMan(),
                          ),
                        );
                      },
                      child: Text(AppLocalizations.of(context)!.continueButton.toUpperCase()),
                    ),
                  ],
                );
              },
            );
          },
          child: Text(AppLocalizations.of(context)!.signUpButton),
        )
      ],
    );
  }
}
