import 'package:flutter/material.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;
import '../../../theme/theme.dart';
import '../../pages.dart';

class SignUpButton extends StatefulWidget {
  final LoginPresenter presenter;

  const SignUpButton({
    Key? key,
    required this.presenter,
  }) : super(key: key);

  @override
  State<SignUpButton> createState() => _SignUpButtonState();
}

class _SignUpButtonState extends State<SignUpButton> {
  int value = 1;

  Widget customRadioButton(String title, String text, int index) {
    return StreamBuilder<Object>(
        stream: widget.presenter.signUpTypeStream,
        builder: (context, snapshot) {
          return InkWell(
            onTap: () {
              setState(() {
                value = index;
                widget.presenter.selectTypeSignUp(value);
              });
            },
            child: Card(
              shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
              elevation: (value == index) ? 4 : 0,
              color: (value == index) ? AppColors.primaryRed : Colors.white.withAlpha(200),
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
        });
  }

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
                  //content: RadioButtonCustom(presenter: presenter),
                  content: Column(
                    children: <Widget>[
                      customRadioButton(
                        AppLocalizations.of(context)!.deleverymanLabel,
                        AppLocalizations.of(context)!.deliverymanText,
                        1,
                      ),
                      customRadioButton(
                        AppLocalizations.of(context)!.clientLabel,
                        AppLocalizations.of(context)!.clientText,
                        2,
                      ),
                    ],
                  ),
                  scrollable: true,
                  actions: [
                    TextButton(
                      onPressed: () => Navigator.canPop(context),
                      child: Text(AppLocalizations.of(context)!.cancelButton.toUpperCase()),
                    ),
                    TextButton(
                      onPressed: () {
                        if (value == 1) {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => const SignUpDeliveryMan(),
                            ),
                          );
                        } else {
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) => const SignUpClientPage(),
                            ),
                          );
                        }
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
